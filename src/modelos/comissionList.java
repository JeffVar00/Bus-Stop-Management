package modelos;



import java.util.ArrayList;

public class comissionList {
    
    public comissionList(){
        mails = new ArrayList<>();
    }
    
    public comission get(int j){
        return mails.get(j);
    }
    
    public int numComission(){
        return mails.size();
    }
    
    public void add(double weight, String pDelivers, String pRecieves, String condition, journey J, String idCliente){
        comission newMail = new comission(weight, pDelivers, pRecieves, condition, J, idCliente);
        mails.add(newMail);
    }
    
    public void addNewCom(double weight, String pDelivers, String pRecieves, String condition, String date, String dp, String ap, String dt, String at, String unit, int Code, Double priceW, String idClient, int own){
        comission newMail = new comission(weight, pDelivers, pRecieves, condition, date, dp, ap, dt,  at, unit, Code, priceW,  idClient, own);
        mails.add(newMail);
    }
    
    
    private ArrayList<comission> mails;
}
