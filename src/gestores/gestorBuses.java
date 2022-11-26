
package gestores;

import controladores.controlBus;
import controladores.controlDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.bus;
import modelos.driver;

public class gestorBuses  {


    public gestorBuses (controlBus controlBuses) {
        this.buses = controlBuses;
    }

    // CRUD: Create, Retrieve, Update, Delete
    // IMEC: Insertar, Modificar, Eliminar, Consultar
    // RETRIEVE
    public driver recuperar() {
       driver resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar(String state, String plate, String unit, int Capacity, int Codigo) throws Exception {
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
        stm.clearParameters();
       stm.setString(1, state);
       stm.setString(2, plate);
       stm.setString(3, unit);
       stm.setInt(4, Capacity);
       stm.setInt(5, Codigo);
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
    }
    
           // UPDATE
    public void actualizar(bus actual, String code) throws Exception {
    
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
        
        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_ACTUALIZAR);
       
        
        stm.setString(1, code);
        stm.setString(2, actual.unit());
        
        
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }
    
                 
        gestorBaseDatos.obtenerInstancia().cerrarConexion();    
      
    }
    //Consultar
    public void consultar(controlDriver drivers) throws Exception{                  
       
            Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
            
            Statement stm = cnx.createStatement();
            
            // Contiene los datos recuperados.
            ResultSet rs = stm.executeQuery(COMANDO_CONSULTAR);
        while(rs.next()) {
                String state =  rs.getString("state");
                String plate = rs.getString("plate");
                String unit = rs.getString("unit");
                int capacity = rs.getInt("capacity");
                int code = rs.getInt("codigo");
                driver auxDriver = new driver();
                
                for(int i = 0; i < drivers.size(); i++){
                    if(drivers.data().get(i).unit().equals(unit)){
                        auxDriver = drivers.data().get(i);
                    } 
                }
                
                buses.add(state, plate, unit, capacity, code, auxDriver);
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO buses "
            + "(state, plate, unit, capacity, codigo) "
            + "VALUES(?, ?, ?, ?, ?); ";

    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM buses; ";
    
        private static final String COMANDO_ACTUALIZAR =
            "UPDATE buses SET codigo=? WHERE unit=?; ";
    
    private controlBus buses;
}
    