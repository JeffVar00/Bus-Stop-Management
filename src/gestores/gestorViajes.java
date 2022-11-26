
package gestores;

import controladores.comissionControl;
import controladores.controlBus;
import controladores.controlClient;
import controladores.journeyControl;
import modelos.journey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.bus;
import modelos.client;
import modelos.ticketList;


public class gestorViajes {
    
    private journeyControl journeys;

    public gestorViajes(journeyControl journeys) {
        this.journeys = journeys;
    }

    // CRUD: Create, Retrieve, Update, Delete
    // IMEC: Insertar, Modificar, Eliminar, Consultar
    // RETRIEVE
    public journey recuperar() {
        journey resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar(String departure, String arrival, double distance, String date, String dTime, String aTime, int price, int code) throws Exception {
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
       stm.clearParameters();
       stm.setInt(1, code);
       stm.setString(2, departure);
       stm.setString(3, arrival);
       stm.setDouble(4, distance);
       stm.setString(5, date);
       stm.setString(6, dTime);
       stm.setString(7, aTime);
       stm.setInt(8, price);
        if (stm.executeUpdate() != 1) {
            throw new Exception();
        }

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
    }

    
    //Consultar
    public void consultar(controlBus buses, controlClient clients, ticketList tickets) throws Exception{                  
            
            bus myBus = new bus();
            
            Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();
            
            Statement stm = cnx.createStatement();
            
            // Contiene los datos recuperados.
            ResultSet rs = stm.executeQuery(COMANDO_CONSULTAR);
        while(rs.next()) {
                int code = rs.getInt("code");
                int price = rs.getInt("price");
                String departure = rs.getString("departure");
                String arrival = rs.getString("arrival");
                Double distance= rs.getDouble("distance");
                String date = rs.getString("date");
                String dTime = rs.getString("dTime");
                String aTime = rs.getString("aTime");
                
                for(int i = 0; i < buses.size(); i++){
                    
                    if(buses.get(i).codigo() == code){
                        myBus = buses.get(i);
                        break;
                    }
                    
                }

                ticketList ticketsJourney = new ticketList();
                for(int i = 0;i<tickets.ticketNum();i++){
                    if(tickets.get(i).code() == code ){
                        ticketsJourney.add(tickets.get(i));
                    }
                }
                
                journey newJourney = new journey(departure,arrival,distance,date,dTime,aTime, price, code, myBus, ticketsJourney);
                
                 for(int i = 0; i < clients.size(); i++){
                    
                    if(clients.get(i).getCode() == code){
                        newJourney.addClient(clients.get(i));
                    }
                    
                }
                
                journeys.addJourney(newJourney);
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO journeys "
            + "(code, departure, arrival, distance, date, dTime, aTime, price) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?); ";
    
    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM journeys; ";
    
   

}
