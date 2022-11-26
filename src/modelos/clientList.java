
package modelos;

import java.util.ArrayList;


public class clientList {
    
       public clientList(){
        clients = new ArrayList<>();
    }
    
    public void add(client newClient){
        clients.add(newClient);
    }
    
    public void departure(){
        for (int i = 0; i < clientsNum() ; i++){
            clients.get(i).departure();
        }
    }
    
    public int clientsNum(){
        return clients.size();
    }
    
    public client get(int i){
         return clients.get(i);
    }
    
    public client choose(String id) { //no se usa pendiente de ver si se borra o no
        client aux = new client();
         for(int i=0; i <clientsNum(); i++){
             if(clients.get(i).id().equals(id)){
                 aux = clients.get(i);
                 break;
             } else  {
                 aux = null;
             }
         }
         return aux;
    }
    
    private ArrayList<client> clients;
}
