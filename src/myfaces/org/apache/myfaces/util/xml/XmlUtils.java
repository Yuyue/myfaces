package net.sourceforge.myfaces.util.xml;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.faces.FacesException;

/**
 * @author gem (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class XmlUtils
{
    private XmlUtils() {}

    public static String getElementText(Element elem)
    {
        StringBuffer buf = new StringBuffer();
        NodeList nodeList = elem.getChildNodes();
        for (int i = 0, len = nodeList.getLength(); i < len; i++)
        {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.TEXT_NODE)
            {
                buf.append(n.getNodeValue());
            }
            else
            {
                throw new FacesException("Unexpected node type " + n.getNodeType());
            }
        }
        return buf.toString();
    }

}
