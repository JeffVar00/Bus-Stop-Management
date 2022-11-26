
package controladores;

import modelos.comission;
import modelos.comissionList;
import modelos.journey;

public class comissionControl {

    public comissionControl(comissionList c){
        data = c;
    }

    public int size(){
        return data.numComission();
    }

    public comission get(int c){
        return data.get(c);
    }

    public void add(double weight, String pDelivers, String pRecieves, String condition, journey J, String idClient){
        data.add(weight, pDelivers, pRecieves, condition, J, idClient);
    }
    
    public void addNewCom(double weight, String pDelivers, String pRecieves, String condition, String date, String dp, String ap, String dt, String at, String unit, int Code, Double priceW, String idClient, int own){
        data.addNewCom(weight, pDelivers, pRecieves, condition, date, dp, ap, dt,  at, unit, Code, priceW,  idClient, own);
    }

    private comissionList data;

}