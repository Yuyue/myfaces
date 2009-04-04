/*
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package org.apache.myfaces.context;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;

import org.apache.myfaces.context.servlet.FacesContextImpl;
import org.apache.shale.test.base.AbstractJsfTestCase;

/**
 * Various tests for the faces context is rendered
 * util Methods!
 *
 * @author Werner Punz(latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class IsRenderedTest extends AbstractJsfTestCase {

    public IsRenderedTest() {
        super("IsRenderedTest");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * tests the basic render all mechanism,
     * no render all due to defaults
     * or a renderAll which
     */
    public void testRenderAll1() {
        FacesContext context = new FacesContextImpl(servletContext, request, response);
        
        PartialViewContext pprContext = context.getPartialViewContext();

        pprContext.setRenderAll(true);
        assertTrue("override should trigger no matter which condition we have", pprContext.isRenderAll());

        context = new FacesContextImpl(servletContext, request, response);
        pprContext.setRenderAll(false);
        assertFalse("override should trigger no matter which condition we have", pprContext.isRenderAll());
    }

   
}
