
package gestores;

import controladores.controlClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.bus;
import modelos.client;
import modelos.ticketList;

public class gestorPersonas {
    
    private controlClient  clients;

    public gestorPersonas(controlClient clients) {
        this.clients = clients;
    }

    // CRUD: Create, Retrieve, Update, Delete
    // IMEC: Insertar, Modificar, Eliminar, Consultar
    // RETRIEVE
    public client recuperar() {
        client resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar( client nuevoClient, int code) throws Exception {
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
       stm.clearParameters();
       stm.setString(1, nuevoClient.id());
       stm.setString(2, nuevoClient.nombre());
       stm.setInt(3, nuevoClient.myTicket().id());
       stm.setInt(4, code);
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
                String id = rs.getString("id");
                String name = rs.getString("name");
                int idTicket = rs.getInt("idTicket");
                int code = rs.getInt("code");
                
                clients.add(name,id,idTicket,code);
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO personas "
            + "(id, name, idTicket, code) "
            + "VALUES(?, ?, ?, ?); ";
    
    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM personas; ";

}
