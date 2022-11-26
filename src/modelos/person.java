
package modelos;
public class person {
    
    public person(){
        this.name = "";
        this.id = "";
    }
    
    public person(String name, String id){
        this.name = name;
        this.id = id;
    }
    
    public String nombre(){
        return name;
    }
   
    public String id(){
        return id;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + name + " ID: " + id;
    }
    
    private String id;
    private String name;
    
}

