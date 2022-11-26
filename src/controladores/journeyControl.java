
package controladores;

import modelos.bus;
import modelos.client;
import modelos.clientList;
import modelos.comission;
import modelos.comissionList;
import modelos.journeyList;
import modelos.journey;
import modelos.ticketList;

public class journeyControl {

    public journeyControl(journeyList j){
        data = j;
    }
    
    public void addJourney(journey newJourney){
        data.addJourney(newJourney);
    }
        public journeyControl(){
        data = null;
    }
    public void addClient(journey journey, client client){
        journey.addClient(client);
    }
    
    public clientList clients(journey journey){
        return journey.passengers();
    }
    
    public comissionList comissions(journey journey){
        return journey.comissions();
    }
    
    public void addComission(journey journey, double weight, String pDelivers, String pRecieves, String condition, journey J, String idClient){
        journey.addComission( weight, pDelivers, pRecieves,condition, J, idClient);
    }

    public int size(){
        return data.numJourneys();
    }
    
     public ticketList tickets(journey journey){
        return journey.tickets();
    }

    public journey get(int j){
        return data.get(j);
    }
    
    public journey choose(int code){
        return data.choose(code);
    }

    public void add(String departure, String arrival, double distance, String date, String dTime, String aTime, int price, int code, bus b) throws Exception{
        data.add(departure, arrival, distance, date, dTime, aTime, price, code, b);
    }

    private journeyList data;
}