
package modelos;

import javax.swing.table.AbstractTableModel;


public class comissionTable extends AbstractTableModel {

    public comissionTable(comissionList mails){
        this.mails = mails;
    }
    
    @Override
    public String getColumnName(int c){
        return comission.Spaces()[c];
    }
    
    @Override
    public int getRowCount() {
        return mails.numComission();
    }

    @Override
    public int getColumnCount() {
        return comission.Spaces().length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return mails.get(r).toArray()[c];
    }
    
    private comissionList mails;
}
