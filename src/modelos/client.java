
package modelos;

public class client extends person{
    public client(){
        super();
        myTicket = null;
    }
    
    public client(String name, String id){
        super(name, id);
        myTicket = null;
    }
    
    public client(String name, String id, int idTicket, int code){
        super(name, id);
        ticketID = idTicket;
        this.code = code;
    }
    
    public String getName(){
        return super.nombre();
    }
    
    public String getID(){
        return super.id();
    }
    
    public int getIDticket(){
        return ticketID;
    }
    
    public int getCode(){
        return code;
    }
    
    public void assingTicket(ticket newTicket){
        myTicket = newTicket;
    }
    
    public void departure(){
        myTicket = null;
    }
    
    public ticket myTicket(){
        return myTicket;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    public static String[] Spaces(){
        return SPACES;
    }
    
    public Object[] toArray(){
        Object[] x = new Object[4];
        x[0] = getName();
        x[1] = getID();
        x[2] = myTicket.id();
        x[3] = myTicket.seat();
        return x;
    }
    
    private static final String[] SPACES = {"NOMBRE", "ID", "ID TIQUETE","ASIENTO"};
    private ticket myTicket;
    private int ticketID;
    private int code;
}
