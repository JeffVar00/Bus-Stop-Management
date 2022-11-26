package modelos;


import java.util.ArrayList;

public class journeyList {
    
    public journeyList(){
        journeys = new ArrayList<>();
    }
    
    public journey get(int j){
        return journeys.get(j);
    }
    
    public int numJourneys(){
        return journeys.size();
    }
    
     public journey choose(int code) {
         journey aux = new journey();
         for(int i=0; i < numJourneys(); i++){
             if(journeys.get(i).getCode() == code){
                 aux = journeys.get(i);
                 break;
             } else  {
                 aux = null;
             }
         }
        return aux;
     }
         
    public void add(String departure, String arrival, double distance, String date, String dTime, String aTime, int price, int code, bus b) throws Exception{
        journey newJourney = new journey(departure, arrival, distance, date, dTime, aTime, price, code, b);
        journeys.add(newJourney);
    }
    
    public void addJourney(journey newJourney){
        journeys.add(newJourney);
    }
    
    private ArrayList<journey> journeys;
}
