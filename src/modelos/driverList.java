
package modelos;

import java.util.ArrayList;


public class driverList {
        public driverList(){
        drivers = new ArrayList<>();
    }
    
    public void add(String name, String id){
        driver newDriver = new driver(name, id);
        drivers.add(newDriver);
    }
    
     public void add(String name, String id, String unit){
        driver newDriver = new driver(name, id, unit);
        drivers.add(newDriver);
    }
    
    public int driverNum(){
        return drivers.size();
    }
    
    public driver get(int i){
        return drivers.get(i);
    }
    
    public driver choose(String unit) {
         driver aux = new driver();
         for(int i=0; i < driverNum(); i++){
             if(drivers.get(i).available() == false){
                 aux = drivers.get(i);
                 drivers.get(i).busy(unit);
                 break;
             } else  {
                 aux = null;
             }
         }
         return aux;
    }
    
    private ArrayList<driver> drivers;
}
