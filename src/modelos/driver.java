
package modelos;


public class driver extends person {
    public driver(){
        super();
        busy = false;
        unit = "";
    }
    
    public driver(String name, String id){
        super(name, id);
        busy = false;
        unit = "";
    }
    
    public driver(String name, String id, String unit){
        super(name, id);
        this.unit = unit;
        if(!"none".equals(unit)){
            busy = true;
        }
    }
    
    public String unit(){
        return unit;
    }
    
    public boolean available(){
        return this.busy;
    }
    
    public void busy(String unit){
        this.unit = unit;
        this.busy = true;
    }
    
    public void notBusy(){
        this.busy = false;
    }
    
    public String getName(){
        return super.nombre();
    }
     
    @Override
    public String toString(){
        return super.toString();
    }
    
    private boolean busy;
    private String unit;
}
