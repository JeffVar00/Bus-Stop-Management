
package modelos;

public class comission{
    
    public comission(){
        weight = 0.0;
        code = 0;
        priceByWeight = 0;
        pDelivers = " ";
        pRecieves = " ";
        condition = " ";
        date = " ";
        idClient = "";
        dTime = " ";
         this.codigoPropio = (int)(Math.random()*10000+1);
    }
    
    public comission(double weight, String pDelivers, String pRecieves, String condition, String date, String dp, String ap, String dt, String at, String unit, int Code, Double priceW, String idClient, int own){
        this.weight = weight;
        this.code = Code;
        this.priceByWeight = priceW;
        this.pDelivers = pDelivers;
        this.pRecieves = pRecieves;
        this.date = date;
        this.dPlace = ap;
        this.aPlace = dp;
        this.dTime = dt;
        this.aTime = at;
        this.unit = unit;
        this.condition = condition;
        this.idClient = idClient;
        this.codigoPropio = own;
    }
    
    public comission(double weight, String pDelivers, String pRecieves, String condition, journey J, String idClient){
        this.weight = weight;
        this.code = J.getCode();
        this.priceByWeight = J.priceKilo();
        this.pDelivers = pDelivers;
        this.pRecieves = pRecieves;
        this.date = J.getDate();
        this.dPlace = J.getDeparture();
        this.aPlace = J.getArrival();
        this.dTime = J.getDTime();
        this.aTime = J.getATime();
        this.unit = J.bus().unit();
        this.condition = condition;
        this.idClient = idClient;
        this.codigoPropio = (int)(Math.random()*10000+1);
    }
    
    public String unit(){
        return unit;
    }
    
    public int codigoPropio(){
        return codigoPropio;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public int getCode(){
        return code;
    }
    
    public double getPriceByWeight(){
        return priceByWeight;
    }
    
    public String getPDelivers(){
        return pDelivers;
    } 
    
    public String getPRecieves(){
        return pRecieves;
    }
    public String getID(){
        return idClient;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getCondition(){
        return condition;
    }
    
    public String getDPlace(){
        return dPlace;
    }
    
    public String getAPlace(){
        return aPlace; 
    }
    
    public String getDTime(){
        return dTime;
    }
    
    public String getATime(){
        return aTime;
    }
    
    public String getDate(){
        return date;
    }
    
    public static String[] Spaces(){
        return SPACES;
    }
    
    public Object[] toArray(){
        Object[] x = new Object[12];
        x[0] = getCode();
        x[1] = getDate();
        x[2] = getUnit();
        x[3] = getWeight();
        x[4] = getPriceByWeight();
        x[5] = getCondition();
        x[6] = getDPlace();
        x[7] = getAPlace();
        x[8] = getDTime();
        x[9] = getATime();
        x[10] = getPDelivers();
        x[11] = getPRecieves();
        return x;
    }
    
    private static final String[] SPACES = {"Codigo", "Fecha", "Numero de Unidad", "Peso", "Precio x Peso", "Condicion", 
    "Lugar de Salida", "Lugar de llegada", "Hora de Salida", "Hora de Llegada", "Persona que entrega", "Persona que recibe"};    
    private double weight;
    private int code;
    private double priceByWeight;
    private String pDelivers;
    private String pRecieves;
    private String condition;
    private String unit;
    private String dPlace;
    private String aPlace;
    private String dTime;//departure time
    private String aTime;//arrival time
    private String date;
    private String idClient;
    private int codigoPropio;
}

