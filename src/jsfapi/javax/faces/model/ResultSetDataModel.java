/**
  * MyFaces - the free JSF implementation
  * Copyright (C) 2003, 2004  The MyFaces Team (http://myfaces.sourceforge.net)
  *
  * This library is free software; you can redistribute it and/or
  * modify it under the terms of the GNU Lesser General Public
  * License as published by the Free Software Foundation; either
  * version 2.1 of the License, or (at your option) any later version.
  *
  * This library is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  * Lesser General Public License for more details.
  *
  * You should have received a copy of the GNU Lesser General Public
  * License along with this library; if not, write to the Free Software
  * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
*/

package javax.faces.model;

/**
  * @author Thomas Spiegl (latest modification by $Author$)
  * @version $Revision$ $Date$
 * $Log$
 * Revision 1.6  2004/04/07 07:27:10  manolito
 * changed exception msg
 *
*/
public class ResultSetDataModel extends DataModel
{
    // FIELDS

    // CONSTRUCTORS
    public ResultSetDataModel()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public ResultSetDataModel(java.sql.ResultSet result)
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    // METHODS
    public int getRowCount()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public Object getRowData()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public int getRowIndex()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public Object getWrappedData()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public boolean isRowAvailable()
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public void setRowIndex(int rowIndex)
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

    public void setWrappedData(Object data)
    {
        //TODO
        throw new UnsupportedOperationException("Not yet implemented:" + this.getClass().getName());
    }

}
