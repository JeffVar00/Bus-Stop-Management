
package modelos;

public class bus {
    
    public bus(){
        state = ""; plate = "";  unit = "";
        capacity = 0;
        busDriver =null;
        codigo = -1;
    }
    
    public bus(String state, String plate, String unit, int capacity, driver BusDriver){
        this.state = state; this.plate = plate; 
        this.unit = unit; this.capacity = capacity;
        busDriver = BusDriver; 
        busy = false;
        codigo = -1;
    }
    
       public bus(String state, String plate, String unit, int capacity, int codigo, driver BusDriver){
        this.state = state; this.plate = plate; 
        this.unit = unit; this.capacity = capacity;
        busDriver = BusDriver; 
        this.codigo = codigo;
        if(codigo != -1){
            busy =true;
        }else{
            busy = false;
        }
    }
    
    
    public String unit(){
        return this.unit;
    }
    
    public String state(){
        return this.state;
    }
    public int capacity(){
        return this.capacity;
    }
    public String plate(){
        return this.plate;
    }
    
    @Override
    public String toString(){
        return "Estado: " + state + " Placa: " + plate + " Unidad: " + unit + " Capacidad: "+ Integer.toString(capacity); 
    }
    
    public boolean available(){ 
        return this.busy;
    }
    
    public int codigo(){ //agregar a control
        return this.codigo;
    }
    
    public void busy(int codigo){
        this.busy = true;
        this.codigo = codigo;
    }
    
    public void notBusy(){ //agregar al control que compare codigos
        this.busy = false;
        codigo = -1;
    }
    
    
    public void asignDriver(driver newDriver){
        this.busDriver = newDriver;
    }
   
    public driver driver(){
       return busDriver;
    }
   
    private boolean busy;
    private String state, plate, unit;
    private int codigo;
    private int capacity;
    private driver busDriver;
    
}
