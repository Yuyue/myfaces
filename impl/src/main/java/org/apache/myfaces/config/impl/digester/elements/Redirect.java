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

package org.apache.myfaces.config.impl.digester.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.myfaces.config.impl.digester.elements.ViewParam;

public class Redirect implements org.apache.myfaces.config.element.Redirect
{
    private Map<String,List<String>> viewParams = new HashMap<String,List<String>>();
    private boolean includeViewParams = true;
    
    
    public void addViewParam(ViewParam viewParam)
    {
        List<String> params = viewParams.get(viewParam.getName());
        if(params == null)
        {
            params = new ArrayList<String>();
        }

        params.add(viewParam.getValue());
        viewParams.put(viewParam.getName(), params);
    }
    
    public Map<String,List<String>> getViewParams()
    {
        return viewParams;
    }

    public void setIncludeViewParams(String includeViewParams)
    {
        this.includeViewParams = new Boolean (includeViewParams);
    }
    
    public boolean isIncludeViewParams()
    {
        return includeViewParams;
    }

}
