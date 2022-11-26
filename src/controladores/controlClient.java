
package controladores;

import modelos.client;
import modelos.clientList;
import modelos.ticket;
import modelos.ticketList;


public class controlClient {
    
    public controlClient(clientList clients){
        datos = clients;
    }
    
    public void add(String name, String id, ticket newTicket){
        client newClient = new client(name, id);
        newClient.assingTicket(newTicket);
        datos.add(newClient);
    }
     public void add(String name, String id, int idTicket, int code){
        client newClient = new client(name, id, idTicket, code);
        datos.add(newClient);
    }
     
     public void searchTicket(ticketList tickets){
         for(int i = 0; i < datos.clientsNum(); i++){
             for(int j = 0; j < tickets.ticketNum(); j++){
                 if(tickets.get(j).idClient().equals(datos.get(i).id())){
                     datos.get(i).assingTicket(tickets.get(j));
                     break;
                 }
             }
         }
     }
    
    public void departure(){
        datos.departure();
    }
    
    public client get(int i ){
        return datos.get(i);
    }
    
    public ticket myTicket(client client){
        return client.myTicket();
    }
    
    public int size(){
        return datos.clientsNum();
    }
    
    public client choose(String id){
        return datos.choose(id);
    }
    
    private clientList datos;
}
