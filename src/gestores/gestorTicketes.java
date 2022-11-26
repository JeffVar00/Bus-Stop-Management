
package gestores;

import controladores.comissionControl;
import controladores.controlBus;
import controladores.controlClient;
import controladores.journeyControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.bus;
import modelos.journey;
import modelos.ticket;
import modelos.ticketList;

public class gestorTicketes {
    
    private ticketList tickets;

    public gestorTicketes(ticketList tickets) {
        this.tickets = tickets;
    }

    public gestorTicketes() {
    }

    // CRUD: Create, Retrieve, Update, Delete
    // IMEC: Insertar, Modificar, Eliminar, Consultar
    // RETRIEVE
    public ticket recuperar() {
        ticket resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar(ticket nuevoTiquete) throws Exception {
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
       stm.clearParameters();
       stm.setInt(1, nuevoTiquete.code());
       stm.setString(2, nuevoTiquete.fecha());
       stm.setInt(3, nuevoTiquete.id());
       stm.setString(4, nuevoTiquete.idClient());
       stm.setInt(5, nuevoTiquete.price());
       stm.setInt(6, nuevoTiquete.seat());
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
    }
           // UPDATE
    public void actualizar(ticket actual, String idClient) throws Exception {
    
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
        
        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_ACTUALIZAR);
       
        
        stm.setString(1, idClient);
        stm.setInt(2, actual.id());
        
        
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
                int code = rs.getInt("code");
                int price = rs.getInt("price");
                int seat = rs.getInt("seat");
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                String idClient = rs.getString("idClient");
                
                tickets.add(seat, code, price, fecha, id, idClient);
                
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO tiquetes "
            + "(code, fecha, id, idClient, price, seat) "
            + "VALUES(?, ?, ?, ?, ?, ?); ";
   private static final String COMANDO_ACTUALIZAR =
            "UPDATE tiquetes SET idClient=? WHERE id=?; ";
    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM tiquetes; ";
}
