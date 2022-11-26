
package controladores;

import modelos.bus;
import modelos.busList;
import modelos.driver;

public class controlBus {
    
    public controlBus(busList buses){
        datos = buses;
    }
    
    public void add(String state, String plate, String unit, int capacity, driver busDriver){
        datos.add(state, plate, unit, capacity, busDriver);
    }
    
        public void add(String state, String plate, String unit, int capacity, int code, driver busDriver){
        datos.add(state, plate, unit, capacity, code, busDriver);
    }
    
    public void assingDriver(bus bus, driver busDriver){
        bus.asignDriver(busDriver);
    }
    
    public driver driver(bus bus){
        return bus.driver();
    }
    
    public int size(){
        return datos.busNum();
    }
    
    public bus get(int i){
        return datos.get(i);
    }
    
    public bus choose(String unit, int codigo){
        return datos.choose(unit, codigo);
    }
    
    private busList datos;
}
