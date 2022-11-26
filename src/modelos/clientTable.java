
package modelos;

import javax.swing.table.AbstractTableModel;

public class clientTable extends AbstractTableModel{
    
    public clientTable(clientList c){
        this.clients = c;
    }
    
    @Override
    public String getColumnName(int c){
        return client.Spaces()[c];
    }
    
    @Override
    public int getRowCount() {
        return clients.clientsNum();
    }

    @Override
    public int getColumnCount() {
        return client.Spaces().length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return clients.get(r).toArray()[c];
    }
    
    private clientList clients;
}
