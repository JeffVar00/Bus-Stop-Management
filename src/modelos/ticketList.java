
package modelos;

import java.util.ArrayList;

public class ticketList {
    public ticketList(){
        tickets = new ArrayList<>();
    }
    public void add(int seat, int code, int price){
        ticket newTicket = new ticket(seat, code, price);
        tickets.add(newTicket);
    }
    public void add(int seat, int code, int price, String fecha, int id, String idClient){
        ticket newTicket = new ticket(seat, code, price, fecha, id, idClient);
        tickets.add(newTicket);
    }
    
    public void add(ticket newTicket){
        tickets.add(newTicket);
    }
    
    public int ticketNum(){
        return tickets.size();
    }
    
    public ticket get(int i){
        return tickets.get(i);
    }
    
    public boolean assigned(int i){
        return tickets.get(i).available();
    }
    
    public ticket search(int seat) {
         ticket aux = new ticket();
         for(int i=0; i < ticketNum(); i++){
             if(tickets.get(i).seat() == seat && tickets.get(i).available() == false){
                 aux = tickets.get(i);
                 break;
             } else  {
                 aux = null;
             }
         }
         return aux;
    }
    
     //public void choose(int seat, String fecha, String idClient){
     //    tickets.get(seat).buy(fecha, idClient);
     //}
     
    private ArrayList<ticket> tickets;
}
