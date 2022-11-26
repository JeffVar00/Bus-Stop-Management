
package vistas;

import controladores.comissionControl;
import controladores.controlBus;
import controladores.controlClient;
import controladores.controlDriver;
import controladores.journeyControl;
import gestores.gestorBuses;
import gestores.gestorChoferes;
import gestores.gestorEncomiendas;
import gestores.gestorPersonas;
import gestores.gestorTicketes;
import gestores.gestorViajes;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.busList;
import modelos.client;
import modelos.clientList;
import modelos.comission;
import modelos.comissionList;
import modelos.driverList;
import modelos.journey;
import modelos.journeyList;
import modelos.ticket;
import modelos.ticketList;


public class vistaPrincipal extends javax.swing.JFrame {
    
    private vistaPrincipal P = this;
    private comissionTableView viewComissions;
    private newBus agregarBus;
    private newDriver addDriver;
    private newJourney addJourney;
    private clientTableJFrame passengers;
    private java.awt.Color ocupado = new java.awt.Color(51,153,255);
    private java.awt.Color pasajero = new java.awt.Color(255,153,153);
    private java.awt.Color libre = new java.awt.Color(153, 255, 153);
    private DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
    private journey journeySelected;
    private journeyList journeys;
    private journeyControl controlJourneys;
    private busList buses;
    private controlBus controlBuses;
    private driverList drivers;
    private controlDriver controlDrivers;
    private comissionList comissions;
    private ticket asientoElegido;
    private comissionControl controlComissions;
    private ArrayList<JButton> asientos;
    private gestorChoferes choferesBD ;
    private gestorBuses busesBD ;
    private gestorViajes viajesBD;
    private gestorPersonas clientesBD;
    private gestorEncomiendas encomiendasBD;
    private clientList clients;
    private controlClient clientsControl;
     private gestorTicketes ticketsBD;
    private ticketList tickets;
    //falta actualizar en buses nada mas
    //cargar encomiendas y clientes, y el metodo para saber que ticketes estan ocupados
    
    public vistaPrincipal() throws Exception {
      
        initList();
        cargarListas();
        initComponents();
        initComboBox(this.controlJourneys);
        initAsientos();
        reiniciarAsientos();
        comboBoxViajes.setSelectedIndex(-1);
        
    }
    
    private void initAsientos(){
        asientos.add(asiento1);
        asientos.add(asiento2);
        asientos.add(asiento3);
        asientos.add(asiento4);
        asientos.add(asiento5);
        asientos.add(asiento6);
        asientos.add(asiento7);
        asientos.add(asiento8);
        asientos.add(asiento9);
        asientos.add(asiento10);
        asientos.add(asiento11);
        asientos.add(asiento12);
        asientos.add(asiento13);
        asientos.add(asiento14);
        asientos.add(asiento15);
        asientos.add(asiento16);
        asientos.add(asiento17);
        asientos.add(asiento18);
        asientos.add(asiento19);
        asientos.add(asiento20);
        asientos.add(asiento21);
        asientos.add(asiento22);
        asientos.add(asiento23);
        asientos.add(asiento24);
        asientos.add(asiento25);
        asientos.add(asiento26);
        asientos.add(asiento27);
        asientos.add(asiento28);
        asientos.add(asiento29);
        asientos.add(asiento30);
        asientos.add(asiento31);
        asientos.add(asiento32);
        asientos.add(asiento33);
        asientos.add(asiento34);
        asientos.add(asiento35);
        asientos.add(asiento36);
        asientos.add(asiento37);
        asientos.add(asiento38);
        asientos.add(asiento39);
        asientos.add(asiento40);
    }
    
    private void cargarAsientos(){
        for(int i = 0 ; i < controlJourneys.tickets(journeySelected).ticketNum(); i++){
            asientos.get(i).setVisible(true);
            if(controlJourneys.tickets(journeySelected).assigned(i)){
                asientos.get(i).setBackground(pasajero);
            }else{
                asientos.get(i).setBackground(libre);
            }
        }
    }
    
    private void reiniciarAsientos(){
        asiento1.setVisible(false);
        asiento2.setVisible(false);
        asiento3.setVisible(false);
        asiento4.setVisible(false);
        asiento5.setVisible(false);
        asiento6.setVisible(false);
        asiento7.setVisible(false);
        asiento8.setVisible(false);
        asiento9.setVisible(false);
        asiento10.setVisible(false);
        asiento11.setVisible(false);
        asiento12.setVisible(false);
        asiento13.setVisible(false);
        asiento14.setVisible(false);
        asiento15.setVisible(false);
        asiento16.setVisible(false);
        asiento17.setVisible(false);
        asiento18.setVisible(false);
        asiento19.setVisible(false);
        asiento20.setVisible(false);
        asiento21.setVisible(false);
        asiento22.setVisible(false);
        asiento23.setVisible(false);
        asiento24.setVisible(false);
        asiento25.setVisible(false);
        asiento26.setVisible(false);
        asiento27.setVisible(false);
        asiento28.setVisible(false);
        asiento29.setVisible(false);
        asiento30.setVisible(false);
        asiento31.setVisible(false);
        asiento32.setVisible(false);
        asiento33.setVisible(false);
        asiento34.setVisible(false);
        asiento35.setVisible(false);
        asiento36.setVisible(false);
        asiento37.setVisible(false);
        asiento38.setVisible(false);
        asiento39.setVisible(false);
        asiento40.setVisible(false);
         for(int i = 0; i < asientos.size(); i++){
                    if(asientos.get(i).getBackground() == ocupado){
                        asientos.get(i).setBackground(libre);
                    }
                }
    }
    
    public void agregarComboBox(journey journey){
        comboBoxViajes.addItem(journey.getDeparture());
    }
    
    
    private void cargarListas() throws Exception{
        choferesBD.consultar();
        ticketsBD.consultar();
        busesBD.consultar(controlDrivers);
        clientesBD.consultar();
        clientsControl.searchTicket(tickets);
        encomiendasBD.consultar();
        viajesBD.consultar(controlBuses, clientsControl, tickets);
    }
    
    public void initComboBox(journeyControl controlJourneys){
        comboBoxViajes.removeAllItems();
        for(int i = 0; i < controlJourneys.size(); i++){ 
           comboBoxViajes.addItem(controlJourneys.get(i).getArrival());
        }    
    }
    
    private void initList(){
        
        asientoElegido = null;
        journeySelected = null;
        drivers = new driverList();
        asientos = new ArrayList<>();
        buses = new busList();
        journeys = new journeyList();
        comissions = new comissionList();
        controlJourneys = new journeyControl(journeys);
         clients = new clientList();
         clientsControl = new controlClient(clients);
        controlBuses = new controlBus(buses);
        controlDrivers = new controlDriver(drivers);
        controlComissions = new comissionControl(comissions);
        choferesBD = new gestorChoferes(controlDrivers);
        busesBD = new gestorBuses(controlBuses);
        viajesBD = new gestorViajes(controlJourneys);
        clientesBD = new gestorPersonas(clientsControl);
        tickets = new ticketList();
        ticketsBD = new gestorTicketes(tickets);
        encomiendasBD = new gestorEncomiendas(controlComissions);
   
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        panelPrincipal = new javax.swing.JPanel();
        tituloTransaccion = new javax.swing.JLabel();
        botonMostrarMantenimiento = new javax.swing.JButton();
        panelEncomienda = new javax.swing.JPanel();
        panelInfoEncomienda = new javax.swing.JPanel();
        tituloDatos2 = new javax.swing.JLabel();
        labelIdentificacion = new javax.swing.JLabel();
        textoPeso = new javax.swing.JTextField();
        labelPretira = new javax.swing.JLabel();
        textoPretira = new javax.swing.JTextField();
        tituloCompra2 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        tituloViaje2 = new javax.swing.JLabel();
        labelAutobus1 = new javax.swing.JLabel();
        labelChofer2 = new javax.swing.JLabel();
        labelHora5 = new javax.swing.JLabel();
        labelHora6 = new javax.swing.JLabel();
        labelLlegada2 = new javax.swing.JLabel();
        labelSalida2 = new javax.swing.JLabel();
        labelFechaEntrega = new javax.swing.JLabel();
        botonPagarEncomienda = new javax.swing.JButton();
        tituloPeso = new javax.swing.JLabel();
        textoIdentificacion = new javax.swing.JTextField();
        labelCondicion = new javax.swing.JLabel();
        labelPrecioKilo = new javax.swing.JLabel();
        labelFecha3 = new javax.swing.JLabel();
        textoPrecioKilo = new javax.swing.JLabel();
        textoTotal = new javax.swing.JLabel();
        textoCondicion = new javax.swing.JLabel();
        textoFechaEntrega = new javax.swing.JLabel();
        textoEntra = new javax.swing.JLabel();
        textoChofer1 = new javax.swing.JLabel();
        textoHllegada1 = new javax.swing.JLabel();
        textoHsalida = new javax.swing.JLabel();
        textoAutobus1 = new javax.swing.JLabel();
        textoFecha1 = new javax.swing.JLabel();
        textoSale1 = new javax.swing.JLabel();
        textoPenvia1 = new javax.swing.JTextField();
        labelPenvia1 = new javax.swing.JLabel();
        tituloCodigo1 = new javax.swing.JLabel();
        textoCodigo1 = new javax.swing.JLabel();
        botonCalcular = new javax.swing.JButton();
        labelWarning = new javax.swing.JLabel();
        panelViaje = new javax.swing.JPanel();
        botonPagar = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        tituloDatos = new javax.swing.JLabel();
        tituloNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        tituloID = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        tituloCompra = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelIDTiquete = new javax.swing.JLabel();
        tituloViaje = new javax.swing.JLabel();
        labelAutobus = new javax.swing.JLabel();
        labelChofer = new javax.swing.JLabel();
        labelHora1 = new javax.swing.JLabel();
        labelHora2 = new javax.swing.JLabel();
        labelLlegada = new javax.swing.JLabel();
        labelSalida = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        textoChofer = new javax.swing.JLabel();
        textoHoraLlegada = new javax.swing.JLabel();
        textoHoraSalida = new javax.swing.JLabel();
        textoFecha = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JLabel();
        textoAutobus = new javax.swing.JLabel();
        textoSalida = new javax.swing.JLabel();
        textoEntrada = new javax.swing.JLabel();
        textoIDtiquete = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JLabel();
        tituloCodigo = new javax.swing.JLabel();
        panelAsientos = new javax.swing.JPanel();
        asiento2 = new javax.swing.JButton();
        asiento3 = new javax.swing.JButton();
        asiento4 = new javax.swing.JButton();
        asiento5 = new javax.swing.JButton();
        asiento6 = new javax.swing.JButton();
        asiento7 = new javax.swing.JButton();
        asiento8 = new javax.swing.JButton();
        asiento11 = new javax.swing.JButton();
        asiento12 = new javax.swing.JButton();
        asiento13 = new javax.swing.JButton();
        asiento14 = new javax.swing.JButton();
        asiento15 = new javax.swing.JButton();
        asiento16 = new javax.swing.JButton();
        asiento17 = new javax.swing.JButton();
        asiento18 = new javax.swing.JButton();
        asiento19 = new javax.swing.JButton();
        asiento20 = new javax.swing.JButton();
        asiento21 = new javax.swing.JButton();
        asiento22 = new javax.swing.JButton();
        asiento23 = new javax.swing.JButton();
        asiento24 = new javax.swing.JButton();
        asiento25 = new javax.swing.JButton();
        asiento26 = new javax.swing.JButton();
        asiento27 = new javax.swing.JButton();
        asiento28 = new javax.swing.JButton();
        asiento29 = new javax.swing.JButton();
        asiento1 = new javax.swing.JButton();
        asiento10 = new javax.swing.JButton();
        asiento30 = new javax.swing.JButton();
        asiento32 = new javax.swing.JButton();
        asiento34 = new javax.swing.JButton();
        asiento35 = new javax.swing.JButton();
        asiento36 = new javax.swing.JButton();
        asiento39 = new javax.swing.JButton();
        asiento40 = new javax.swing.JButton();
        asiento9 = new javax.swing.JButton();
        asiento31 = new javax.swing.JButton();
        asiento33 = new javax.swing.JButton();
        asiento38 = new javax.swing.JButton();
        asiento37 = new javax.swing.JButton();
        botonPasajeros = new javax.swing.JButton();
        labelAsientos = new javax.swing.JLabel();
        panelSeleccion = new javax.swing.JPanel();
        botonViaje = new javax.swing.JButton();
        botonEncomienda = new javax.swing.JButton();
        panelViajes = new javax.swing.JPanel();
        tituloViajes = new javax.swing.JLabel();
        comboBoxViajes = new javax.swing.JComboBox<>();
        botonConfirmar = new javax.swing.JButton();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        panelMantenimiento = new javax.swing.JPanel();
        tituloApartadoMantenimiento = new javax.swing.JLabel();
        botonAgregarC = new javax.swing.JButton();
        botonAgregarB = new javax.swing.JButton();
        botonAgregarV = new javax.swing.JButton();
        botonEncomiendas = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jButton2.setText("jButton2");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(null);

        tituloTransaccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloTransaccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTransaccion.setText("Tipo de transaccion");
        panelPrincipal.add(tituloTransaccion);
        tituloTransaccion.setBounds(470, 20, 170, 30);

        botonMostrarMantenimiento.setBackground(new java.awt.Color(255, 255, 153));
        botonMostrarMantenimiento.setText("Mostrar Mantenimiento");
        botonMostrarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarMantenimientoActionPerformed(evt);
            }
        });
        panelPrincipal.add(botonMostrarMantenimiento);
        botonMostrarMantenimiento.setBounds(30, 720, 170, 50);

        panelEncomienda.setBackground(new java.awt.Color(255, 255, 255));
        panelEncomienda.setLayout(null);

        panelInfoEncomienda.setBackground(new java.awt.Color(255, 255, 255));
        panelInfoEncomienda.setLayout(null);

        tituloDatos2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloDatos2.setForeground(new java.awt.Color(51, 102, 255));
        tituloDatos2.setText("Datos Personales");
        panelInfoEncomienda.add(tituloDatos2);
        tituloDatos2.setBounds(10, 10, 160, 22);

        labelIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelIdentificacion.setText("Identificacion:");
        panelInfoEncomienda.add(labelIdentificacion);
        labelIdentificacion.setBounds(440, 50, 150, 30);

        textoPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPesoActionPerformed(evt);
            }
        });
        panelInfoEncomienda.add(textoPeso);
        textoPeso.setBounds(570, 90, 90, 30);
        textoPeso.setText("");

        labelPretira.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelPretira.setText("Persona que retira:");
        panelInfoEncomienda.add(labelPretira);
        labelPretira.setBounds(10, 90, 140, 30);

        textoPretira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPretiraActionPerformed(evt);
            }
        });
        panelInfoEncomienda.add(textoPretira);
        textoPretira.setBounds(170, 90, 210, 30);
        textoPretira.setText("");

        tituloCompra2.setBackground(new java.awt.Color(0, 153, 153));
        tituloCompra2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloCompra2.setForeground(new java.awt.Color(51, 102, 255));
        tituloCompra2.setText("Informacion de encomienda");
        panelInfoEncomienda.add(tituloCompra2);
        tituloCompra2.setBounds(10, 150, 260, 30);

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelTotal.setText("Total:");
        panelInfoEncomienda.add(labelTotal);
        labelTotal.setBounds(40, 230, 50, 19);

        tituloViaje2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloViaje2.setForeground(new java.awt.Color(51, 102, 255));
        tituloViaje2.setText("Informacion del viaje");
        panelInfoEncomienda.add(tituloViaje2);
        tituloViaje2.setBounds(10, 280, 190, 30);

        labelAutobus1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelAutobus1.setText("Autobus:");
        panelInfoEncomienda.add(labelAutobus1);
        labelAutobus1.setBounds(20, 320, 70, 19);

        labelChofer2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelChofer2.setText("Chofer:");
        panelInfoEncomienda.add(labelChofer2);
        labelChofer2.setBounds(20, 350, 48, 19);

        labelHora5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelHora5.setText("Hora Llegada:");
        panelInfoEncomienda.add(labelHora5);
        labelHora5.setBounds(20, 380, 100, 19);

        labelHora6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelHora6.setText("Hora Salida:");
        panelInfoEncomienda.add(labelHora6);
        labelHora6.setBounds(20, 410, 80, 20);

        labelLlegada2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelLlegada2.setText("Llega a:");
        panelInfoEncomienda.add(labelLlegada2);
        labelLlegada2.setBounds(330, 390, 100, 19);

        labelSalida2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelSalida2.setText("Sale de:");
        panelInfoEncomienda.add(labelSalida2);
        labelSalida2.setBounds(330, 360, 90, 19);

        labelFechaEntrega.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelFechaEntrega.setText("Fecha de entrega:");
        panelInfoEncomienda.add(labelFechaEntrega);
        labelFechaEntrega.setBounds(330, 230, 140, 20);

        botonPagarEncomienda.setBackground(new java.awt.Color(255, 153, 153));
        botonPagarEncomienda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonPagarEncomienda.setText("Confirmar y Pagar");
        botonPagarEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarEncomiendaActionPerformed(evt);
            }
        });
        panelInfoEncomienda.add(botonPagarEncomienda);
        botonPagarEncomienda.setBounds(20, 520, 230, 50);

        tituloPeso.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tituloPeso.setText("Peso del paquete:");
        panelInfoEncomienda.add(tituloPeso);
        tituloPeso.setBounds(440, 90, 150, 30);
        panelInfoEncomienda.add(textoIdentificacion);
        textoIdentificacion.setBounds(570, 50, 190, 30);
        textoIdentificacion.setText("");

        labelCondicion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelCondicion.setText("Condicion: ");
        panelInfoEncomienda.add(labelCondicion);
        labelCondicion.setBounds(330, 200, 90, 20);

        labelPrecioKilo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelPrecioKilo.setText("Precio por kilo:");
        panelInfoEncomienda.add(labelPrecioKilo);
        labelPrecioKilo.setBounds(20, 200, 100, 19);

        labelFecha3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelFecha3.setText("Fecha:");
        panelInfoEncomienda.add(labelFecha3);
        labelFecha3.setBounds(330, 330, 44, 19);

        textoPrecioKilo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoPrecioKilo);
        textoPrecioKilo.setBounds(120, 200, 120, 20);

        textoTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoTotal);
        textoTotal.setBounds(120, 230, 120, 20);

        textoCondicion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoCondicion);
        textoCondicion.setBounds(400, 200, 160, 20);

        textoFechaEntrega.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoFechaEntrega);
        textoFechaEntrega.setBounds(460, 230, 170, 20);

        textoEntra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoEntra);
        textoEntra.setBounds(390, 390, 180, 20);

        textoChofer1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoChofer1);
        textoChofer1.setBounds(130, 350, 180, 20);

        textoHllegada1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoHllegada1);
        textoHllegada1.setBounds(130, 380, 180, 20);

        textoHsalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoHsalida);
        textoHsalida.setBounds(130, 410, 180, 20);

        textoAutobus1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoAutobus1);
        textoAutobus1.setBounds(130, 320, 180, 20);

        textoFecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoFecha1);
        textoFecha1.setBounds(390, 330, 180, 20);

        textoSale1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfoEncomienda.add(textoSale1);
        textoSale1.setBounds(390, 360, 180, 20);
        panelInfoEncomienda.add(textoPenvia1);
        textoPenvia1.setBounds(170, 50, 210, 30);
        textoPenvia1.setText("");

        labelPenvia1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelPenvia1.setText("Persona que envia:");
        panelInfoEncomienda.add(labelPenvia1);
        labelPenvia1.setBounds(10, 50, 150, 30);

        tituloCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloCodigo1.setForeground(new java.awt.Color(51, 102, 255));
        tituloCodigo1.setText("Codigo del viaje:");
        panelInfoEncomienda.add(tituloCodigo1);
        tituloCodigo1.setBounds(20, 470, 140, 30);

        textoCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCodigo1.setForeground(new java.awt.Color(51, 102, 255));
        panelInfoEncomienda.add(textoCodigo1);
        textoCodigo1.setBounds(160, 470, 160, 30);

        botonCalcular.setBackground(new java.awt.Color(51, 153, 255));
        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        panelInfoEncomienda.add(botonCalcular);
        botonCalcular.setBounds(670, 90, 90, 30);

        labelWarning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelWarning.setForeground(new java.awt.Color(0, 102, 255));
        labelWarning.setText("*En Kilogramos");
        panelInfoEncomienda.add(labelWarning);
        labelWarning.setBounds(440, 120, 110, 30);

        panelEncomienda.add(panelInfoEncomienda);
        panelInfoEncomienda.setBounds(20, 0, 790, 610);

        panelPrincipal.add(panelEncomienda);
        panelEncomienda.setBounds(270, 150, 830, 610);
        panelEncomienda.setVisible(false);

        panelViaje.setBackground(new java.awt.Color(255, 255, 255));
        panelViaje.setLayout(null);

        botonPagar.setBackground(new java.awt.Color(255, 153, 153));
        botonPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonPagar.setText("Confirmar y Pagar");
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
            }
        });
        panelViaje.add(botonPagar);
        botonPagar.setBounds(40, 580, 230, 50);

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelInfo.setLayout(null);

        tituloDatos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloDatos.setForeground(new java.awt.Color(51, 102, 255));
        tituloDatos.setText("Datos Personales");
        panelInfo.add(tituloDatos);
        tituloDatos.setBounds(10, 10, 160, 22);

        tituloNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tituloNombre.setText("Su nombre:");
        panelInfo.add(tituloNombre);
        tituloNombre.setBounds(10, 50, 90, 30);
        panelInfo.add(textoNombre);
        textoNombre.setBounds(170, 50, 210, 30);
        textoNombre.setText("");

        tituloID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tituloID.setText("Su identificacion:");
        panelInfo.add(tituloID);
        tituloID.setBounds(10, 90, 140, 30);

        textoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoIDActionPerformed(evt);
            }
        });
        panelInfo.add(textoID);
        textoID.setBounds(170, 90, 210, 30);
        textoID.setText("");

        tituloCompra.setBackground(new java.awt.Color(0, 153, 153));
        tituloCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloCompra.setForeground(new java.awt.Color(51, 102, 255));
        tituloCompra.setText("Informacion de compra");
        panelInfo.add(tituloCompra);
        tituloCompra.setBounds(10, 140, 210, 30);

        labelPrecio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelPrecio.setText("Precio:");
        panelInfo.add(labelPrecio);
        labelPrecio.setBounds(10, 190, 60, 19);

        labelIDTiquete.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelIDTiquete.setText("ID del tiquete:");
        panelInfo.add(labelIDTiquete);
        labelIDTiquete.setBounds(10, 220, 120, 20);

        tituloViaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloViaje.setForeground(new java.awt.Color(51, 102, 255));
        tituloViaje.setText("Informacion del viaje");
        panelInfo.add(tituloViaje);
        tituloViaje.setBounds(10, 270, 190, 30);

        labelAutobus.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelAutobus.setText("Autobus:");
        panelInfo.add(labelAutobus);
        labelAutobus.setBounds(10, 320, 70, 19);

        labelChofer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelChofer.setText("Conductor:");
        panelInfo.add(labelChofer);
        labelChofer.setBounds(10, 350, 71, 19);

        labelHora1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelHora1.setText("Hora Llegada:");
        panelInfo.add(labelHora1);
        labelHora1.setBounds(10, 380, 100, 19);

        labelHora2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelHora2.setText("Hora Salida:");
        panelInfo.add(labelHora2);
        labelHora2.setBounds(10, 410, 80, 20);

        labelLlegada.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelLlegada.setText("Llega a:");
        panelInfo.add(labelLlegada);
        labelLlegada.setBounds(250, 390, 60, 19);

        labelSalida.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelSalida.setText("Sale de:");
        panelInfo.add(labelSalida);
        labelSalida.setBounds(250, 360, 60, 19);

        labelFecha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelFecha.setText("Fecha:");
        panelInfo.add(labelFecha);
        labelFecha.setBounds(250, 330, 44, 19);

        textoChofer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoChofer);
        textoChofer.setBounds(90, 350, 140, 20);

        textoHoraLlegada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoHoraLlegada);
        textoHoraLlegada.setBounds(110, 380, 130, 20);

        textoHoraSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoHoraSalida);
        textoHoraSalida.setBounds(90, 410, 150, 20);

        textoFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoFecha);
        textoFecha.setBounds(300, 330, 160, 20);

        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoPrecio);
        textoPrecio.setBounds(70, 190, 150, 20);

        textoAutobus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoAutobus);
        textoAutobus.setBounds(90, 320, 150, 20);

        textoSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoSalida);
        textoSalida.setBounds(310, 360, 150, 20);

        textoEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoEntrada);
        textoEntrada.setBounds(310, 390, 150, 20);

        textoIDtiquete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelInfo.add(textoIDtiquete);
        textoIDtiquete.setBounds(120, 220, 150, 20);

        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCodigo.setForeground(new java.awt.Color(51, 102, 255));
        panelInfo.add(textoCodigo);
        textoCodigo.setBounds(160, 450, 160, 30);

        tituloCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloCodigo.setForeground(new java.awt.Color(51, 102, 255));
        tituloCodigo.setText("Codigo del viaje:");
        panelInfo.add(tituloCodigo);
        tituloCodigo.setBounds(10, 450, 140, 30);

        panelViaje.add(panelInfo);
        panelInfo.setBounds(20, 60, 480, 530);

        panelAsientos.setBackground(new java.awt.Color(255, 255, 255));
        panelAsientos.setLayout(null);

        asiento2.setBackground(new java.awt.Color(153, 255, 153));
        asiento2.setText("A2");
        asiento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento2ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento2);
        asiento2.setBounds(80, 30, 60, 50);

        asiento3.setBackground(new java.awt.Color(153, 255, 153));
        asiento3.setText("A3");
        asiento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento3ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento3);
        asiento3.setBounds(150, 30, 60, 50);

        asiento4.setBackground(new java.awt.Color(153, 255, 153));
        asiento4.setText("A4");
        asiento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento4ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento4);
        asiento4.setBounds(210, 30, 60, 50);

        asiento5.setBackground(new java.awt.Color(153, 255, 153));
        asiento5.setText("A5");
        asiento5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento5ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento5);
        asiento5.setBounds(20, 80, 60, 50);

        asiento6.setBackground(new java.awt.Color(153, 255, 153));
        asiento6.setText("A6");
        asiento6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento6ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento6);
        asiento6.setBounds(80, 80, 60, 50);

        asiento7.setBackground(new java.awt.Color(153, 255, 153));
        asiento7.setText("A7");
        asiento7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento7ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento7);
        asiento7.setBounds(150, 80, 60, 50);

        asiento8.setBackground(new java.awt.Color(153, 255, 153));
        asiento8.setText("A8");
        asiento8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento8ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento8);
        asiento8.setBounds(210, 80, 60, 50);

        asiento11.setBackground(new java.awt.Color(153, 255, 153));
        asiento11.setText("A11");
        asiento11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento11ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento11);
        asiento11.setBounds(150, 130, 60, 50);

        asiento12.setBackground(new java.awt.Color(153, 255, 153));
        asiento12.setText("A12");
        asiento12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento12ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento12);
        asiento12.setBounds(210, 130, 60, 50);

        asiento13.setBackground(new java.awt.Color(153, 255, 153));
        asiento13.setText("A13");
        asiento13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento13ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento13);
        asiento13.setBounds(20, 180, 60, 50);

        asiento14.setBackground(new java.awt.Color(153, 255, 153));
        asiento14.setText("A14");
        asiento14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento14ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento14);
        asiento14.setBounds(80, 180, 60, 50);

        asiento15.setBackground(new java.awt.Color(153, 255, 153));
        asiento15.setText("A15");
        asiento15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento15ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento15);
        asiento15.setBounds(150, 180, 60, 50);

        asiento16.setBackground(new java.awt.Color(153, 255, 153));
        asiento16.setText("A16");
        asiento16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento16ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento16);
        asiento16.setBounds(210, 180, 60, 50);

        asiento17.setBackground(new java.awt.Color(153, 255, 153));
        asiento17.setText("A17");
        asiento17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento17ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento17);
        asiento17.setBounds(20, 230, 60, 50);

        asiento18.setBackground(new java.awt.Color(153, 255, 153));
        asiento18.setText("A18");
        asiento18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento18ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento18);
        asiento18.setBounds(80, 230, 60, 50);

        asiento19.setBackground(new java.awt.Color(153, 255, 153));
        asiento19.setText("A19");
        asiento19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento19ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento19);
        asiento19.setBounds(150, 230, 60, 50);

        asiento20.setBackground(new java.awt.Color(153, 255, 153));
        asiento20.setText("A20");
        asiento20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento20ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento20);
        asiento20.setBounds(210, 230, 60, 50);

        asiento21.setBackground(new java.awt.Color(153, 255, 153));
        asiento21.setText("A21");
        asiento21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento21ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento21);
        asiento21.setBounds(20, 280, 60, 50);

        asiento22.setBackground(new java.awt.Color(153, 255, 153));
        asiento22.setText("A22");
        asiento22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento22ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento22);
        asiento22.setBounds(80, 280, 60, 50);

        asiento23.setBackground(new java.awt.Color(153, 255, 153));
        asiento23.setText("A23");
        asiento23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento23ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento23);
        asiento23.setBounds(150, 280, 60, 50);

        asiento24.setBackground(new java.awt.Color(153, 255, 153));
        asiento24.setText("A24");
        asiento24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento24ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento24);
        asiento24.setBounds(210, 280, 60, 50);

        asiento25.setBackground(new java.awt.Color(153, 255, 153));
        asiento25.setText("A25");
        asiento25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento25ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento25);
        asiento25.setBounds(20, 330, 60, 50);

        asiento26.setBackground(new java.awt.Color(153, 255, 153));
        asiento26.setText("A26");
        asiento26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento26ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento26);
        asiento26.setBounds(80, 330, 60, 50);

        asiento27.setBackground(new java.awt.Color(153, 255, 153));
        asiento27.setText("A27");
        asiento27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento27ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento27);
        asiento27.setBounds(150, 330, 60, 50);

        asiento28.setBackground(new java.awt.Color(153, 255, 153));
        asiento28.setText("A28");
        asiento28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento28ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento28);
        asiento28.setBounds(210, 330, 60, 50);

        asiento29.setBackground(new java.awt.Color(153, 255, 153));
        asiento29.setText("A29");
        asiento29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento29ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento29);
        asiento29.setBounds(20, 380, 60, 50);

        asiento1.setBackground(new java.awt.Color(153, 255, 153));
        asiento1.setText("A1");
        asiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento1ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento1);
        asiento1.setBounds(20, 30, 60, 50);

        asiento10.setBackground(new java.awt.Color(153, 255, 153));
        asiento10.setText("A10");
        asiento10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento10ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento10);
        asiento10.setBounds(80, 130, 60, 50);

        asiento30.setBackground(new java.awt.Color(153, 255, 153));
        asiento30.setText("A30");
        asiento30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento30ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento30);
        asiento30.setBounds(80, 380, 60, 50);

        asiento32.setBackground(new java.awt.Color(153, 255, 153));
        asiento32.setText("A32");
        asiento32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento32ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento32);
        asiento32.setBounds(210, 380, 60, 50);

        asiento34.setBackground(new java.awt.Color(153, 255, 153));
        asiento34.setText("A34");
        asiento34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento34ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento34);
        asiento34.setBounds(80, 430, 60, 50);

        asiento35.setBackground(new java.awt.Color(153, 255, 153));
        asiento35.setText("A35");
        asiento35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento35ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento35);
        asiento35.setBounds(150, 430, 60, 50);

        asiento36.setBackground(new java.awt.Color(153, 255, 153));
        asiento36.setText("A36");
        asiento36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento36ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento36);
        asiento36.setBounds(210, 430, 60, 50);

        asiento39.setBackground(new java.awt.Color(153, 255, 153));
        asiento39.setText("A39");
        asiento39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento39ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento39);
        asiento39.setBounds(150, 480, 60, 50);

        asiento40.setBackground(new java.awt.Color(153, 255, 153));
        asiento40.setText("A40");
        asiento40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento40ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento40);
        asiento40.setBounds(210, 480, 60, 50);

        asiento9.setBackground(new java.awt.Color(153, 255, 153));
        asiento9.setText("A9");
        asiento9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento9ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento9);
        asiento9.setBounds(20, 130, 60, 50);

        asiento31.setBackground(new java.awt.Color(153, 255, 153));
        asiento31.setText("A31");
        asiento31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento31ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento31);
        asiento31.setBounds(150, 380, 60, 50);

        asiento33.setBackground(new java.awt.Color(153, 255, 153));
        asiento33.setText("A33");
        asiento33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento33ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento33);
        asiento33.setBounds(20, 430, 60, 50);

        asiento38.setBackground(new java.awt.Color(153, 255, 153));
        asiento38.setText("A38");
        asiento38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento38ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento38);
        asiento38.setBounds(80, 480, 60, 50);

        asiento37.setBackground(new java.awt.Color(153, 255, 153));
        asiento37.setText("A37");
        asiento37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiento37ActionPerformed(evt);
            }
        });
        panelAsientos.add(asiento37);
        asiento37.setBounds(20, 480, 60, 50);

        botonPasajeros.setBackground(new java.awt.Color(51, 153, 255));
        botonPasajeros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonPasajeros.setText("Pasajeros");
        botonPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasajerosActionPerformed(evt);
            }
        });
        panelAsientos.add(botonPasajeros);
        botonPasajeros.setBounds(60, 540, 170, 40);

        labelAsientos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAsientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAsientos.setText("Asientos");
        panelAsientos.add(labelAsientos);
        labelAsientos.setBounds(90, 0, 110, 22);

        panelViaje.add(panelAsientos);
        panelAsientos.setBounds(490, 30, 290, 580);
        panelAsientos.setVisible(false);

        panelPrincipal.add(panelViaje);
        panelViaje.setBounds(270, 110, 810, 650);

        panelSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        panelSeleccion.setLayout(null);

        botonViaje.setBackground(new java.awt.Color(255, 153, 153));
        botonViaje.setText("Viaje");
        botonViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonViajeActionPerformed(evt);
            }
        });
        panelSeleccion.add(botonViaje);
        botonViaje.setBounds(10, 10, 180, 50);

        botonEncomienda.setBackground(new java.awt.Color(204, 204, 255));
        botonEncomienda.setText("Encomienda");
        botonEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncomiendaActionPerformed(evt);
            }
        });
        panelSeleccion.add(botonEncomienda);
        botonEncomienda.setBounds(210, 10, 170, 50);

        panelPrincipal.add(panelSeleccion);
        panelSeleccion.setBounds(360, 50, 390, 70);

        panelViajes.setBackground(new java.awt.Color(255, 255, 255));
        panelViajes.setLayout(null);

        tituloViajes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloViajes.setText("Destinos Disponibles");
        panelViajes.add(tituloViajes);
        tituloViajes.setBounds(30, 20, 170, 30);

        comboBoxViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxViajesActionPerformed(evt);
            }
        });
        panelViajes.add(comboBoxViajes);
        comboBoxViajes.setBounds(20, 60, 180, 40);

        botonConfirmar.setBackground(new java.awt.Color(51, 153, 255));
        botonConfirmar.setText("Continuar");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        panelViajes.add(botonConfirmar);
        botonConfirmar.setBounds(60, 110, 100, 30);

        textoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoBuscarActionPerformed(evt);
            }
        });
        panelViajes.add(textoBuscar);
        textoBuscar.setBounds(20, 160, 180, 30);

        botonBuscar.setBackground(new java.awt.Color(51, 153, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        panelViajes.add(botonBuscar);
        botonBuscar.setBounds(60, 200, 100, 30);

        panelPrincipal.add(panelViajes);
        panelViajes.setBounds(40, 120, 230, 260);

        panelMantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        panelMantenimiento.setLayout(null);

        tituloApartadoMantenimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloApartadoMantenimiento.setText("Apartado de mantenimiento");
        panelMantenimiento.add(tituloApartadoMantenimiento);
        tituloApartadoMantenimiento.setBounds(20, 30, 219, 22);

        botonAgregarC.setBackground(new java.awt.Color(255, 255, 102));
        botonAgregarC.setText("Agregar Conductores");
        botonAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCActionPerformed(evt);
            }
        });
        panelMantenimiento.add(botonAgregarC);
        botonAgregarC.setBounds(20, 180, 220, 40);

        botonAgregarB.setBackground(new java.awt.Color(255, 255, 102));
        botonAgregarB.setText("Agregar Buses");
        botonAgregarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarBActionPerformed(evt);
            }
        });
        panelMantenimiento.add(botonAgregarB);
        botonAgregarB.setBounds(20, 80, 220, 40);

        botonAgregarV.setBackground(new java.awt.Color(255, 255, 102));
        botonAgregarV.setText("Agregar Viajes");
        botonAgregarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarVActionPerformed(evt);
            }
        });
        panelMantenimiento.add(botonAgregarV);
        botonAgregarV.setBounds(20, 130, 220, 40);

        botonEncomiendas.setBackground(new java.awt.Color(255, 255, 102));
        botonEncomiendas.setText("Encomiendas realizadas");
        botonEncomiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncomiendasActionPerformed(evt);
            }
        });
        panelMantenimiento.add(botonEncomiendas);
        botonEncomiendas.setBounds(20, 260, 220, 40);

        panelPrincipal.add(panelMantenimiento);
        panelMantenimiento.setBounds(20, 380, 260, 320);
        panelMantenimiento.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonViajeActionPerformed
            panelViaje.setVisible(true);
            panelEncomienda.setVisible(false);
            botonEncomienda.setBackground(new java.awt.Color(204, 204, 255));
            botonViaje.setBackground(new java.awt.Color(255, 153, 153));
            panelAsientos.setVisible(false);
            cleanInfo();
    }//GEN-LAST:event_botonViajeActionPerformed

    private void cleanInfo(){
        textoAutobus.setText("");
         textoChofer.setText("");
         textoCodigo.setText("");
         textoHoraLlegada.setText("");
         textoHoraSalida.setText("");
         textoFecha.setText("");
         textoSalida.setText("");
         textoEntrada.setText("");
         textoAutobus1.setText("");
         textoChofer1.setText("");
         textoCodigo1.setText("");
         textoHllegada1.setText("");
         textoHsalida.setText("");
         textoFecha1.setText("");
         textoSale1.setText("");
         textoEntra.setText("");
         journeySelected = null;
         textoNombre.setText("");
         textoID.setText("");
         textoPenvia1.setText("");
         textoPretira.setText("");
         textoPeso.setText("");
         textoTotal.setText("");
         textoFechaEntrega.setText("");
         textoIDtiquete.setText("");
         textoPrecio.setText("");
         textoIdentificacion.setText("");
         asientoElegido = null;
         panelAsientos.setVisible(false);
         textoPrecioKilo.setText("");
         textoCondicion.setText("");
         reiniciarAsientos();
         comboBoxViajes.setSelectedIndex(-1);
    }
    
    private void cargarInfoViaje(journey J){
         if (panelViaje.isVisible()){
         textoAutobus.setText(J.bus().unit());
         textoChofer.setText(J.bus().driver().nombre());
         textoCodigo.setText(Integer.toString(J.getCode()));
         textoHoraLlegada.setText(J.getATime());
         textoHoraSalida.setText(J.getDTime());
         textoFecha.setText(J.getDate());
         textoSalida.setText(J.getDeparture());
         textoEntrada.setText(J.getArrival());
         }if(panelEncomienda.isVisible()){
         textoAutobus1.setText(J.bus().unit());
         textoChofer1.setText(J.bus().driver().nombre());
         textoCodigo1.setText(Integer.toString(J.getCode()));
         textoHllegada1.setText(J.getATime());
         textoHsalida.setText(J.getDTime());
         textoFecha1.setText(J.getDate());
         textoSale1.setText(J.getDeparture());
         textoEntra.setText(J.getArrival());
         textoPrecioKilo.setText(Double.toString(J.priceKilo()));
         textoCondicion.setText("Procesando");
         }
    }
    
    private void buscarAsiento(int asiento){
        asientoElegido = controlJourneys.tickets(journeySelected).search(asiento);
         if(asientoElegido == null){
                JOptionPane.showMessageDialog(null, "Ocupado");
         }else{
                 textoPrecio.setText(Integer.toString(asientoElegido.price()));
                 textoIDtiquete.setText(Integer.toString(asientoElegido.id()));
         }
    }
    
    private void refund(){
                for(int i = 0; i < asientos.size(); i++){
                    if(asientos.get(i).getBackground() == ocupado){
                        asientos.get(i).setBackground(libre);
                    }
                }
    }
    
    private void asiento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento2ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(2);
        if(asiento2.getBackground() != pasajero){
            asiento2.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento2ActionPerformed

    private void asiento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento3ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(3);
         if(asiento3.getBackground() != pasajero){
            asiento3.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento3ActionPerformed

    private void asiento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento4ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(4);
         if(asiento4.getBackground() != pasajero){
            asiento4.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento4ActionPerformed

    private void asiento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento5ActionPerformed
      if(asientoElegido != null){
                refund();
        }
        buscarAsiento(5);
         if(asiento5.getBackground() != pasajero){
            asiento5.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento5ActionPerformed

    private void asiento6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento6ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(6);
         if(asiento6.getBackground() != pasajero){
            asiento6.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento6ActionPerformed

    private void asiento7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento7ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(7);
         if(asiento7.getBackground() != pasajero){
            asiento7.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento7ActionPerformed

    private void asiento8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento8ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(8);
         if(asiento8.getBackground() != pasajero){
            asiento8.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento8ActionPerformed

    private void asiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento1ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(1);
         if(asiento1.getBackground() != pasajero){
            asiento1.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento1ActionPerformed

    private void asiento10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento10ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(10);
         if(asiento10.getBackground() != pasajero){
            asiento10.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento10ActionPerformed

    private void asiento11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento11ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(11);
         if(asiento11.getBackground() != pasajero){
            asiento11.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento11ActionPerformed

    private void asiento12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento12ActionPerformed
       if(asientoElegido != null){
                refund();
        }
        buscarAsiento(12);
         if(asiento12.getBackground() != pasajero){
            asiento12.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento12ActionPerformed

    private void asiento13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento13ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(13);
         if(asiento13.getBackground() != pasajero){
            asiento13.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento13ActionPerformed

    private void asiento14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento14ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(14);
         if(asiento14.getBackground() != pasajero){
            asiento14.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento14ActionPerformed

    private void asiento15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento15ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(15);
         if(asiento15.getBackground() != pasajero){
            asiento15.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento15ActionPerformed

    private void asiento16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento16ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(16);
        if(asiento16.getBackground() != pasajero){
            asiento16.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento16ActionPerformed

    private void asiento17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento17ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(17);
         if(asiento17.getBackground() != pasajero){
            asiento17.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento17ActionPerformed

    private void asiento18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento18ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(18);
        if(asiento18.getBackground() != pasajero){
            asiento18.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento18ActionPerformed

    private void asiento19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento19ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(19);
         if(asiento19.getBackground() != pasajero){
            asiento19.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento19ActionPerformed

    private void asiento20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento20ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(20);
         if(asiento20.getBackground() != pasajero){
            asiento20.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento20ActionPerformed

    private void asiento21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento21ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(21);
        if(asiento21.getBackground() != pasajero){
            asiento21.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento21ActionPerformed

    private void asiento22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento22ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(22);
         if(asiento22.getBackground() != pasajero){
            asiento22.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento22ActionPerformed

    private void asiento23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento23ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(23);
         if(asiento23.getBackground() != pasajero){
            asiento23.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento23ActionPerformed

    private void asiento24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento24ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(24);
         if(asiento24.getBackground() != pasajero){
            asiento24.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento24ActionPerformed

    private void asiento25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento25ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(25);
         if(asiento25.getBackground() != pasajero){
            asiento25.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento25ActionPerformed

    private void asiento26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento26ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(26);
         if(asiento26.getBackground() != pasajero){
            asiento26.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento26ActionPerformed

    private void asiento27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento27ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(27);
         if(asiento27.getBackground() != pasajero){
            asiento27.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento27ActionPerformed

    private void asiento28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento28ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(28);
         if(asiento28.getBackground() != pasajero){
            asiento28.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento28ActionPerformed

    private void asiento29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento29ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(29);
         if(asiento29.getBackground() != pasajero){
            asiento29.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento29ActionPerformed

    private void asiento30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento30ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(30);
         if(asiento30.getBackground() != pasajero){
            asiento30.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento30ActionPerformed

    private void asiento9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento9ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(9);
         if(asiento9.getBackground() != pasajero){
            asiento9.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento9ActionPerformed

    private void asiento31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento31ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(31);
         if(asiento31.getBackground() != pasajero){
            asiento31.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento31ActionPerformed

    private void asiento32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento32ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(32);
         if(asiento32.getBackground() != pasajero){
            asiento32.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento32ActionPerformed

    private void asiento33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento33ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(33);
         if(asiento33.getBackground() != pasajero){
            asiento33.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento33ActionPerformed

    private void asiento34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento34ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(34);
         if(asiento34.getBackground() != pasajero){
            asiento34.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento34ActionPerformed

    private void asiento35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento35ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(35);
         if(asiento35.getBackground() != pasajero){
            asiento35.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento35ActionPerformed

    private void asiento36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento36ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(36);
         if(asiento36.getBackground() != pasajero){
            asiento36.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento36ActionPerformed

    private void asiento37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento37ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(37);
         if(asiento37.getBackground() != pasajero){
            asiento37.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento37ActionPerformed

    private void asiento38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento38ActionPerformed
        if(asientoElegido != null){
                refund();
        }
        buscarAsiento(38);
         if(asiento38.getBackground() != pasajero){
            asiento38.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento38ActionPerformed

    private void asiento39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento39ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(39);
         if(asiento39.getBackground() != pasajero){
            asiento39.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento39ActionPerformed

    private void asiento40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiento40ActionPerformed
         if(asientoElegido != null){
                refund();
        }
        buscarAsiento(40);
         if(asiento40.getBackground() != pasajero){
            asiento40.setBackground(ocupado);
        }
    }//GEN-LAST:event_asiento40ActionPerformed

    private void textoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoIDActionPerformed
        //Inutil
    }//GEN-LAST:event_textoIDActionPerformed

    private void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarActionPerformed
        if(journeySelected != null){
            if("".equals(textoNombre.getText()) || "".equals(textoID.getText())){
                  JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
            }else{
                  if(asientoElegido == null){
                        JOptionPane.showMessageDialog(null, "Por favor, elija un asiento para continuar");
                  }else{
                      try {
                          ticketsBD.actualizar(asientoElegido, textoID.getText());
                      } catch (Exception ex) {
                          Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                      }
                        asientoElegido.buy(dtf5.format(LocalDateTime.now()), textoID.getText());
                        for(int i = 0; i < asientos.size(); i++){
                                if(asientos.get(i).getBackground() == ocupado){
                                        asientos.get(i).setBackground(pasajero);
                                }
                        }
                        client client = new client(textoNombre.getText(),textoID.getText());
                        client.assingTicket(asientoElegido);
                        try {
                          clientesBD.guardar(client, journeySelected.getCode());
                        } catch (Exception ex) {
                          Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        controlJourneys.addClient(journeySelected, client);
                        JOptionPane.showMessageDialog(null, "Gracias por preferir nuestro servicio!");
                        cleanInfo();
                  }
            }
        }else{
             JOptionPane.showMessageDialog(null, "Elija un viaje antes de continuar");
        }
    }//GEN-LAST:event_botonPagarActionPerformed

    private void comboBoxViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxViajesActionPerformed
//
    }//GEN-LAST:event_comboBoxViajesActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
        try {
        journeySelected = controlJourneys.choose(Integer.parseInt(textoBuscar.getText()));
            if ( journeySelected != null){
                if(panelViaje.isVisible()){
                    panelAsientos.setVisible(true);
                    cargarAsientos();
                    cargarInfoViaje( journeySelected);
                }else{
                    cargarInfoViaje( journeySelected);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado ningun viaje con este codigo");
            }
        } catch (NumberFormatException excepcion) {
               JOptionPane.showMessageDialog(null, "Digite un valor numerico");
        }
       
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void textoPretiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPretiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPretiraActionPerformed

    private void botonPagarEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarEncomiendaActionPerformed
       if(journeySelected != null){
            if("".equals(textoPeso.getText()) || "".equals(textoPenvia1.getText()) || "".equals(textoPretira.getText()) || "".equals(textoIdentificacion.getText()) || "".equals(textoTotal.getText()) ){
                  JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
            }else{            
                try {
                    encomiendasBD.guardar(Double.parseDouble(textoPeso.getText()),textoPenvia1.getText(), textoPretira.getText(), textoCondicion.getText(), journeySelected, textoIdentificacion.getText());
                } catch (Exception ex) { 
                    Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                   controlJourneys.addComission(journeySelected, Double.parseDouble(textoPeso.getText()),textoPenvia1.getText(), textoPretira.getText(), textoCondicion.getText(), journeySelected, textoIdentificacion.getText());
                   controlComissions.add(Double.parseDouble(textoPeso.getText()),textoPenvia1.getText(), textoPretira.getText(), textoCondicion.getText(), journeySelected, textoIdentificacion.getText());
                   JOptionPane.showMessageDialog(null, "Gracias por preferirnos!");
                   cleanInfo();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Elija un viaje antes de continuar");
        }
    }//GEN-LAST:event_botonPagarEncomiendaActionPerformed

    private void textoPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPesoActionPerformed
        //inutil
    }//GEN-LAST:event_textoPesoActionPerformed

    private void botonEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncomiendaActionPerformed
            panelViaje.setVisible(false);
            panelEncomienda.setVisible(true);
            botonEncomienda.setBackground(new java.awt.Color(255, 153, 153));
            botonViaje.setBackground(new java.awt.Color(204, 204, 255));
            cleanInfo();
    }//GEN-LAST:event_botonEncomiendaActionPerformed

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        if (comboBoxViajes.getSelectedIndex() != -1) {
            if(panelViajes.isVisible()){
                panelAsientos.setVisible(true);
                int seleccion = comboBoxViajes.getSelectedIndex();
                journeySelected = controlJourneys.get(seleccion);
                cargarInfoViaje( journeySelected);
                cargarAsientos();
            }else{
                int seleccion = comboBoxViajes.getSelectedIndex();
                journeySelected = controlJourneys.get(seleccion);
                cargarInfoViaje( journeySelected);
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Por favor seleccione una opcion para proceder");
        }
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void textoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoBuscarActionPerformed
            //inutil
    }//GEN-LAST:event_textoBuscarActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        if (journeySelected != null){
             try {
                 textoTotal.setText(Double.toString(journeySelected.priceKilo() * Double.parseDouble(textoPeso.getText())));
                 textoFechaEntrega.setText(journeySelected.getDate());
                } catch (NumberFormatException excepcion) {
                       JOptionPane.showMessageDialog(null, "Digite un valor numerico");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Por favor seleccione un viaje para proceder");
            }
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void botonMostrarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarMantenimientoActionPerformed
       if(panelMantenimiento.isVisible()){
           botonMostrarMantenimiento.setText("Mostrar Mantenimiento");
           panelMantenimiento.setVisible(false);
       }else{
           botonMostrarMantenimiento.setText("Ocultar Mantenimiento");
           panelMantenimiento.setVisible(true);
       }
        
    }//GEN-LAST:event_botonMostrarMantenimientoActionPerformed

    private void botonPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPasajerosActionPerformed
        if(controlJourneys.clients(journeySelected).clientsNum() == 0){
             JOptionPane.showMessageDialog(null, "Aun no hay pasajeros");
        }else{
            passengers = new clientTableJFrame(journeySelected);
            passengers.setVisible(true);
        }
    }//GEN-LAST:event_botonPasajerosActionPerformed

    private void botonAgregarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarBActionPerformed
        agregarBus = new newBus(controlBuses , controlDrivers, choferesBD, busesBD);
        agregarBus.setVisible(true);
    }//GEN-LAST:event_botonAgregarBActionPerformed

    private void botonEncomiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncomiendasActionPerformed
        
        if(comissions.numComission() == 0){
             JOptionPane.showMessageDialog(null, "Sin encomiendas");
        }else{
            viewComissions = new comissionTableView(comissions);
            viewComissions.setVisible(true);
        }
    }//GEN-LAST:event_botonEncomiendasActionPerformed

    private void botonAgregarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarVActionPerformed
        addJourney = new newJourney(controlJourneys, controlBuses, P, busesBD, viajesBD);
        addJourney.setVisible(true);
    }//GEN-LAST:event_botonAgregarVActionPerformed

    private void botonAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCActionPerformed
        addDriver = new newDriver(controlDrivers, choferesBD);
        addDriver.setVisible(true);
    }//GEN-LAST:event_botonAgregarCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asiento1;
    private javax.swing.JButton asiento10;
    private javax.swing.JButton asiento11;
    private javax.swing.JButton asiento12;
    private javax.swing.JButton asiento13;
    private javax.swing.JButton asiento14;
    private javax.swing.JButton asiento15;
    private javax.swing.JButton asiento16;
    private javax.swing.JButton asiento17;
    private javax.swing.JButton asiento18;
    private javax.swing.JButton asiento19;
    private javax.swing.JButton asiento2;
    private javax.swing.JButton asiento20;
    private javax.swing.JButton asiento21;
    private javax.swing.JButton asiento22;
    private javax.swing.JButton asiento23;
    private javax.swing.JButton asiento24;
    private javax.swing.JButton asiento25;
    private javax.swing.JButton asiento26;
    private javax.swing.JButton asiento27;
    private javax.swing.JButton asiento28;
    private javax.swing.JButton asiento29;
    private javax.swing.JButton asiento3;
    private javax.swing.JButton asiento30;
    private javax.swing.JButton asiento31;
    private javax.swing.JButton asiento32;
    private javax.swing.JButton asiento33;
    private javax.swing.JButton asiento34;
    private javax.swing.JButton asiento35;
    private javax.swing.JButton asiento36;
    private javax.swing.JButton asiento37;
    private javax.swing.JButton asiento38;
    private javax.swing.JButton asiento39;
    private javax.swing.JButton asiento4;
    private javax.swing.JButton asiento40;
    private javax.swing.JButton asiento5;
    private javax.swing.JButton asiento6;
    private javax.swing.JButton asiento7;
    private javax.swing.JButton asiento8;
    private javax.swing.JButton asiento9;
    private javax.swing.JButton botonAgregarB;
    private javax.swing.JButton botonAgregarC;
    private javax.swing.JButton botonAgregarV;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonEncomienda;
    private javax.swing.JButton botonEncomiendas;
    private javax.swing.JButton botonMostrarMantenimiento;
    private javax.swing.JButton botonPagar;
    private javax.swing.JButton botonPagarEncomienda;
    private javax.swing.JButton botonPasajeros;
    private javax.swing.JButton botonViaje;
    private javax.swing.JComboBox<String> comboBoxViajes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAsientos;
    private javax.swing.JLabel labelAutobus;
    private javax.swing.JLabel labelAutobus1;
    private javax.swing.JLabel labelChofer;
    private javax.swing.JLabel labelChofer2;
    private javax.swing.JLabel labelCondicion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha3;
    private javax.swing.JLabel labelFechaEntrega;
    private javax.swing.JLabel labelHora1;
    private javax.swing.JLabel labelHora2;
    private javax.swing.JLabel labelHora5;
    private javax.swing.JLabel labelHora6;
    private javax.swing.JLabel labelIDTiquete;
    private javax.swing.JLabel labelIdentificacion;
    private javax.swing.JLabel labelLlegada;
    private javax.swing.JLabel labelLlegada2;
    private javax.swing.JLabel labelPenvia1;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelPrecioKilo;
    private javax.swing.JLabel labelPretira;
    private javax.swing.JLabel labelSalida;
    private javax.swing.JLabel labelSalida2;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelWarning;
    private javax.swing.JPanel panelAsientos;
    private javax.swing.JPanel panelEncomienda;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelInfoEncomienda;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JPanel panelViaje;
    private javax.swing.JPanel panelViajes;
    private javax.swing.JLabel textoAutobus;
    private javax.swing.JLabel textoAutobus1;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JLabel textoChofer;
    private javax.swing.JLabel textoChofer1;
    private javax.swing.JLabel textoCodigo;
    private javax.swing.JLabel textoCodigo1;
    private javax.swing.JLabel textoCondicion;
    private javax.swing.JLabel textoEntra;
    private javax.swing.JLabel textoEntrada;
    private javax.swing.JLabel textoFecha;
    private javax.swing.JLabel textoFecha1;
    private javax.swing.JLabel textoFechaEntrega;
    private javax.swing.JLabel textoHllegada1;
    private javax.swing.JLabel textoHoraLlegada;
    private javax.swing.JLabel textoHoraSalida;
    private javax.swing.JLabel textoHsalida;
    private javax.swing.JTextField textoID;
    private javax.swing.JLabel textoIDtiquete;
    private javax.swing.JTextField textoIdentificacion;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPenvia1;
    private javax.swing.JTextField textoPeso;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JLabel textoPrecioKilo;
    private javax.swing.JTextField textoPretira;
    private javax.swing.JLabel textoSale1;
    private javax.swing.JLabel textoSalida;
    private javax.swing.JLabel textoTotal;
    private javax.swing.JLabel tituloApartadoMantenimiento;
    private javax.swing.JLabel tituloCodigo;
    private javax.swing.JLabel tituloCodigo1;
    private javax.swing.JLabel tituloCompra;
    private javax.swing.JLabel tituloCompra2;
    private javax.swing.JLabel tituloDatos;
    private javax.swing.JLabel tituloDatos2;
    private javax.swing.JLabel tituloID;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloPeso;
    private javax.swing.JLabel tituloTransaccion;
    private javax.swing.JLabel tituloViaje;
    private javax.swing.JLabel tituloViaje2;
    private javax.swing.JLabel tituloViajes;
    // End of variables declaration//GEN-END:variables
}
