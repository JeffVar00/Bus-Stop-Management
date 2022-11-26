
package modelos;

//import java.time.format.DateTimeFormatter;

public class ticket {
    public ticket(){
        fecha = "Sin asignar";
        id = (int)(Math.random()*10000+1);
        seat = 0;
        assing = false;
        idClient = "none";
        code = 0; //funcionar para identificar al cargar para cada viaje
        price = 0;
    }
     public ticket(int seat, int code, int price){
        fecha = "Sin asignar";
        id = (int)(Math.random()*10000+1);
        this.seat = seat;
        assing = false;
        idClient = "none";
        this.code = code;
        this.price = price;
    }
     
     public ticket(int seat, int code, int price, String fecha, int id, String idClient){
        this.fecha = fecha;
        this.id = id;
        this.seat = seat;
        this.idClient = idClient;
        this.code = code;
        this.price = price;
        assing = !"none".equals(idClient);
    }
     
     public String fecha(){
         return fecha;
     }
     
     public int price(){
         return price;
     }
     
     public String idClient(){
         return idClient;
     }
     
     public int id(){
         return id;
     }
     
     public int code(){
         return code;
     }
     
     public int seat(){
         return seat;
     }
     
     public boolean available(){
         return assing;
     }
     
     public void buy(String fecha, String idClient){
         this.fecha = fecha;
         this.idClient = idClient;
         assing = true;
     }
     
     public void refund(){
        this.fecha ="";
         this.idClient = "";
         assing = false;
    }
     
   //Crear una fecha
   //DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
   // dtf5.format(LocalDateTime.now())
     private int price;
    private int seat;
    private int id;
    private String fecha, idClient;
   private int code;
    private boolean assing;
}
