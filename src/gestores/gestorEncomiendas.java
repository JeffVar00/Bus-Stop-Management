
package gestores;

import controladores.comissionControl;
import controladores.controlClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelos.client;
import modelos.comission;
import modelos.journey;

public class gestorEncomiendas {
    
    private comissionControl encomiendas;

    public gestorEncomiendas(comissionControl encomiendas) {
        this.encomiendas = encomiendas;
    }

    public comission recuperar() {
        comission resultado = null;
        return resultado;
    }

    // CREATE
    public void guardar(double weight, String pDelivers, String pRecieves, String condition, journey J, String idClient) throws Exception {
        
        comission newComissions = new comission(weight, pDelivers, pRecieves, condition, J, idClient);
        
        Connection cnx =
                gestorBaseDatos.obtenerInstancia().obtenerConexion();

        PreparedStatement stm =
                cnx.prepareStatement(COMANDO_INSERTAR);
       stm.clearParameters();
       stm.setInt(1, newComissions.codigoPropio());
       stm.setDouble(2, newComissions.getWeight());
       stm.setString(3, newComissions.getPDelivers());
       stm.setString(4, newComissions.getPRecieves());
       stm.setString(5, newComissions.getCondition());
       stm.setString(6, newComissions.getDate());
       stm.setString(7, newComissions.getDPlace());
       stm.setString(8, newComissions.getAPlace());
       stm.setString(9, newComissions.getDTime());
       stm.setString(10, newComissions.getATime());
       stm.setString(11, newComissions.unit());
       stm.setString(12, newComissions.getID());
       stm.setInt(13, newComissions.getCode());
       stm.setDouble(14, newComissions.getPriceByWeight());
       
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
                Double weight = rs.getDouble("weight");
                String pDelivers = rs.getString("pDelivers");
                String pReceives = rs.getString("pReceives");
                String condition = rs.getString("condition");
                String date = rs.getString("date");
                String dPlace = rs.getString("dPlace");
                String aPlace = rs.getString("aPlace");
                String dTime = rs.getString("dTime");
                String aTime = rs.getString("aTime");
                String unit = rs.getString("unit");
                String idCliente = rs.getString("idClient");
                int code = rs.getInt("code");
                Double priceWeight = rs.getDouble("priceWeight");
                int ownCode = rs.getInt("ownCode");
                
                encomiendas.addNewCom(weight, pDelivers, pReceives, condition, date, dPlace, aPlace, dTime,  aTime, unit, code, priceWeight,  idCliente, ownCode);
            }
            

        gestorBaseDatos.obtenerInstancia().cerrarConexion();
     
     }
    
            
    // Comandos SQL
    private static final String COMANDO_INSERTAR =
            "INSERT INTO encomiendas "
            + "(ownCode, weight, pDelivers, pReceives, condition, date, dPlace, aPlace, dTime, aTime, unit, idClient, code, priceWeight) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    private static final String COMANDO_CONSULTAR =
            "SELECT * FROM encomiendas; ";

}