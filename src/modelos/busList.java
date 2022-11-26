
package modelos;

import java.util.ArrayList;

public class busList {
    
    public busList(){
        buses = new ArrayList<>();
    }
    
    public void add(String state, String plate, String unit, int capacity, driver BusDriver){
        bus newBus = new bus(state, plate, unit, capacity, BusDriver);
        //newBus.createSeats(capacity);
        buses.add(newBus);
    }
  
      public void add(String state, String plate, String unit, int capacity,  int code, driver BusDriver){
        bus newBus = new bus(state, plate, unit, capacity, code, BusDriver);
        buses.add(newBus);
    }
      
    public int busNum(){
        return buses.size();
    }
    
    public bus get(int j){
            return buses.get(j);
    }
    
    //falta un buscar por si acaso se necesita
    /*public bus get(){
        bus aux = new bus();
        for(int i = 0; i < busNum(); i++){
            if(buses.get(i).getBusy() == false){
                aux = buses.get(i);
            }
        }
        return aux;
    }*/
    
    public bus choose(String unit, int codigo) {
         bus aux = new bus();
         for(int i=0; i < busNum(); i++){
             if(buses.get(i).unit().equals(unit)){
                 aux = buses.get(i);
                 buses.get(i).busy(codigo);
                 break;
             } else  {
                 aux = null;
             }
         }
         return aux;
    }
    
    private ArrayList<bus> buses;
}
