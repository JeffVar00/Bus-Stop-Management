
package controladores;

import modelos.driver;
import modelos.driverList;


public class controlDriver {
    public controlDriver(driverList drivers){
        datos =drivers;
    }
    public void add(String name, String id){
        datos.add(name, id);
    }
    public void add(String name, String id, String unit){
        datos.add(name, id, unit);
    }
    public driverList data(){
        return datos;
    }
    
    public int size(){
        return datos.driverNum();
    }
    
    public driver choose(String unit){
        return datos.choose(unit);
    }
    
    private driverList datos;
}
