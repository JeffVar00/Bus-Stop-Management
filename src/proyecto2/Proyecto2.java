
package proyecto2;
import vistas.vistaPrincipal;

public class Proyecto2 {

    public static void main(String[] args){
        
        try {
            vistaPrincipal principal = new vistaPrincipal();
        principal.setVisible(true);
        }catch(Exception e){
            System.err.println("Ocurrió el siguiente error: " + e.getMessage());
        }
    }
    
}
