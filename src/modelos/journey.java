
package modelos;

import gestores.gestorTicketes;

public class journey{
    
    //lista de pasajeros
    //lista de encomiendas
    public journey(){
        departure = "";
        arrival = "";
        distance = 0.0;
        date = "";
        dTime = "";
        aTime = "";
        price = 0;
        priceKilo = 0;
        b = null;
        tickets = null;
        passengers = new clientList();
        comissions = new comissionList();
        code = 0;
    }
    
    public journey(String departure, String arrival, double distance, String date, String dTime, String aTime,int price, int code, bus b) throws Exception{
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
        this.date = date;
        this.dTime = dTime;
        this.aTime = aTime;
        this.price = price;
        this.priceKilo = price/2;
        passengers = new clientList();
        comissions = new comissionList();
        this.code = code;
        this.b = b;
        tickets = new ticketList();
        tiquetes = new gestorTicketes();
        for(int i = 0; i < b.capacity(); i++){
             tickets.add(i+1, code, price); 
             ticket nuevoTiquete = new ticket(i+1, code,price);
             tiquetes.guardar(nuevoTiquete);
        }
       
    }
    
     public journey(String departure, String arrival, double distance, String date, String dTime, String aTime,int price, int code, bus b, ticketList tickets){
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
        this.date = date;
        this.dTime = dTime;
        this.aTime = aTime;
        this.price = price;
        this.priceKilo = price/2;
        passengers = new clientList();
        comissions = new comissionList();
        this.code = code;
        this.b = b;
        this.tickets = tickets;
    }
    
    public void addClient(client client){
        passengers.add(client);
    }
    
    public void addComission(double weight, String pDelivers, String pRecieves, String condition, journey J, String idClient){
        comissions.add(weight, pDelivers, pRecieves, condition, J, idClient);
    }
      
    public ticketList tickets(){
       return tickets;
   }
      
    public String getDeparture(){
        return departure;
    }
    
    public String getArrival(){
        return arrival;
    }
    
    public double getDistance(){
        return distance;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getDTime(){
        return dTime;
    }
    
    public String getATime(){
        return aTime;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getCode(){
        return code;
    }
    
    public static String[] Spaces(){
        return SPACES;
    }
    
    public clientList passengers(){
        return passengers;
    }
    
    public comissionList comissions(){
        return comissions;
    }
    
    public bus bus(){
        return b;
    }
    
    public double priceKilo(){
        return priceKilo;
    }
    
    public Object[] toArray(){
        Object[] x = new Object[9];
        x[0] = getCode();
        x[1] = getDate();
        x[2] = b.unit();
        x[3] = getDeparture();
        x[4] = getArrival();
        x[5] = getDistance();
        x[6] = getDTime();
        x[7] = getATime();
        x[8] = getPrice();
        return x;
    }
    
    private static final String [] SPACES = {"Codigo", "Fecha", "Numero de Unidad", "Lugar de Salida",
    "Lugar de Llegada", "Distancia (KM)", "Hora de Salida", "Hora de Llegada", "Precio del Tiquete"};
    private String departure;
    private String arrival;
    private double distance;
    private bus b;
    private String date;
    private String dTime;
    private String aTime;
    private int price;
    private int code;
    private double priceKilo;
    private ticketList tickets;
    private clientList passengers;
    private comissionList comissions;
    private gestorTicketes tiquetes;
}
