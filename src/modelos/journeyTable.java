
package modelos;

import javax.swing.table.AbstractTableModel;

public class journeyTable extends AbstractTableModel{
    
    public journeyTable(journeyList journeys){
        this.journeys = journeys;
    }
    
    @Override
    public String getColumnName(int c){
        return journey.Spaces()[c];
    }
    
    @Override
    public int getRowCount() {
        return journeys.numJourneys();
    }

    @Override
    public int getColumnCount() {
        return journey.Spaces().length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return journeys.get(r).toArray()[c];
    }
    
    private journeyList journeys;
}
