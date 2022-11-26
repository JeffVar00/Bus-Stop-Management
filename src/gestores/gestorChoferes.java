
package gestores;
import controladores.controlDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.driver;


public class gestorChoferes {


    public gestorChoferes(controlDriver controlDrivers) {
        this.drivers = controlDrivers;
    }

    // CRUD: Create, Retrieve, Update, Delete
    // IMEC: Insertar, Modificar, Eliminar, Consultar
    // RETRIEVE
    public driver recuperar() {
       driver resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar(String nombre, String id) throws Exception {
        driver nuevoChofer = new driver(nombre, id, "none");
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
        stm.clearParameters();
       stm.setString(1, nuevoChofer.id());
       stm.setString(2, nuevoChofer.nombre());
       stm.setString(3, nuevoChofer.unit());
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
    }
        // UPDATE
    public void actualizar(driver actual, String unit) throws Exception {
    
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
        
        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_ACTUALIZAR);
       
        
        stm.setString(1, actual.nombre());
        stm.setString(2, unit);
        stm.setString(3, actual.id());
        
        
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }
    
                 
        gestorBaseDatos.obtenerInstancia().cerrarConexion();    
      
    }
    //Consultar
    public void consultar() throws Exception{                  
       
            Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
            
            Statement stm = cnx.createStatement();
            
            // Contiene los datos recuperados.
            ResultSet rs = stm.executeQuery(COMANDO_CONSULTAR);
        while(rs.next()) {
                String id =  rs.getString("id");
                String nombre = rs.getString("nombre");
                String unit = rs.getString("unit");
                
                drivers.add(nombre, id, unit);
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO choferes "
            + "(id, nombre, unit) "
            + "VALUES(?, ?, ?); ";

    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM choferes; ";
    
    private static final String COMANDO_ACTUALIZAR =
            "UPDATE choferes SET nombre=?, unit=? WHERE id=?; ";
    
    private controlDriver drivers;
    
}
