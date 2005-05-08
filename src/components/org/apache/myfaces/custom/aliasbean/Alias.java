/*
 * Copyright 2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.myfaces.custom.aliasbean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Sylvain Vieujot (latest modification by $Author$)
 * @version $Revision$ $Date$
 */

class Alias {
    static final Log log = LogFactory.getLog(Alias.class);
	
	private transient UIComponent _aliasComponent;
	private String _aliasBeanExpression;
    private String _valueExpression;
	private transient boolean _active = false;
	
	private transient Object evaluatedExpression = null;

	Alias(AliasBean aliasComponent){
		this._aliasComponent = aliasComponent;
	}
	
	void setAliasBeanExpression(String aliasBeanExpression){
		this._aliasBeanExpression = aliasBeanExpression;
	}
	
	void setValueExpression(String valueExpression){
		this._valueExpression = valueExpression;
	}
	
	String getValueExpression(){
		return _valueExpression;
	}
	
	boolean isActive(){
		return _active;
	}
	
	String[] saveState(){
		return new String[]{_aliasBeanExpression, _valueExpression};
	}
	
	void restoreState(Object state){
		String[] values = (String[]) state;
		_aliasBeanExpression = values[0];
		_valueExpression = values[1];
	}
	
	private void computeEvaluatedExpression(FacesContext facesContext){
		if( evaluatedExpression != null )
			return;
		
		ValueBinding valueVB = null;
        if (_valueExpression == null) {
            valueVB = _aliasComponent.getValueBinding("value");
            _valueExpression = valueVB.getExpressionString();
        }

        if( valueVB == null ){
            if( _valueExpression.startsWith("#{") ){
                valueVB = facesContext.getApplication().createValueBinding(_valueExpression);
				evaluatedExpression = valueVB.getValue(facesContext);
            }else{
				evaluatedExpression = _valueExpression;
            }
        }else{
			evaluatedExpression = valueVB.getValue(facesContext);
        }
	}
	
	void make(FacesContext facesContext){
		if( _active )
			return;

        ValueBinding aliasVB;
        if (_aliasBeanExpression == null) {
            aliasVB = _aliasComponent.getValueBinding("alias");
			if( aliasVB == null )
				return;
            _aliasBeanExpression = aliasVB.getExpressionString();
			if( _aliasBeanExpression == null )
				return;
        } else {
            aliasVB = facesContext.getApplication().createValueBinding(_aliasBeanExpression);
        }

		computeEvaluatedExpression( facesContext );
		
        aliasVB.setValue(facesContext, evaluatedExpression);
		_active = true;

        log.debug("makeAlias: " + _valueExpression + " = " + _aliasBeanExpression);
	}
	
	void remove(FacesContext facesContext){
		if( evaluatedExpression == null )
			return;

        log.debug("removeAlias: " + _valueExpression + " != " + _aliasBeanExpression);
        ValueBinding aliasVB = _aliasComponent.getValueBinding("alias");
        if( aliasVB != null )
			aliasVB.setValue(facesContext, null);
		_active = false;
	}
}