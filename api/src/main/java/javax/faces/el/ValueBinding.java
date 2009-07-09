/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package javax.faces.el;

import javax.faces.context.FacesContext;

/**
 * see Javadoc of <a href="http://java.sun.com/javaee/javaserverfaces/1.2/docs/api/index.html">JSF Specification</a>
 * 
 * @author Thomas Spiegl (latest modification by $Author$)
 * @version $Revision$ $Date$
 * @deprecated
 */
@Deprecated
public abstract class ValueBinding
{
    /**
     * @deprecated
     */
    @Deprecated
    public String getExpressionString()
    {
        return null;
    }

    /**
     * @deprecated
     */
    @Deprecated
    abstract public Class getType(FacesContext facesContext) throws EvaluationException, PropertyNotFoundException;

    /**
     * @deprecated
     */
    @Deprecated
    public abstract Object getValue(FacesContext facesContext) throws EvaluationException, PropertyNotFoundException;

    /**
     * @deprecated
     */
    @Deprecated
    public abstract boolean isReadOnly(FacesContext facesContext) throws EvaluationException, PropertyNotFoundException;

    /**
     * @deprecated
     */
    @Deprecated
    public abstract void setValue(FacesContext facesContext, Object value) throws EvaluationException,
        PropertyNotFoundException;
}
