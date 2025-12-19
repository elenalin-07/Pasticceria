/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pasticceria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author zxt02
 */
public class Form1 extends javax.swing.JFrame{
    private Dessert[] d, v;
    private ImageIcon[] images;
    private int numProdotto, costo, clic, numDessert, mese, numStand, t, quantita, rimborso, c, S1nR, S2nR, S3nR, R4nS;
    private String tipo, qualita, ingredient, nome;
    private Dessert dessert, dessertSelezionato;
    private Negozio negozio;
    private Pasticcere pasticcereLuca;
    private Pasticcere pasticcereMellisa;
    private Pasticcere pasticcerePaolo;
    private boolean checkIng, checkPast, timerStarted;
    private Timer timer;
    private HashMap<String, Object> m;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Form1.class.getName());
    
   Random r;
    public HashMap<String, Integer> ingredients;

    /**
     * Creates new form Form1
     */
    
    public void resetStand1(){
        lblPrezzoS1.setText("");
        lblQuantitaS1.setText("0");
        lblImmagineS1.setIcon(null);
        btnEliminaS1.setEnabled(false);
        lblLedS1.setIcon(null);
    }
    
    public void resetStand2(){
        lblPrezzoS2.setText("");
        lblQuantitaS2.setText("0");
        lblImmagineS2.setIcon(null);
        btnEliminaS2.setEnabled(false);
        lblLedS2.setIcon(null);
    }
    
    public void resetStand3(){
        lblPrezzoS3.setText("");
        lblQuantitaS3.setText("0");
        lblImmagineS3.setIcon(null);
        btnEliminaS3.setEnabled(false);
        lblLedS3.setIcon(null);
    }
    
    public void setStand1(Dessert d, ImageIcon icon){
        lblPrezzoS1.setText(String.valueOf(d.getPrezzo()));
        lblQuantitaS1.setText(String.valueOf(d.getQuantita()));
        lblImmagineS1.setIcon(icon);
        lblLedS1.setIcon(new ImageIcon(getClass().getResource(setLed(d))));
        btnEliminaS1.setEnabled(true);
    }
    
    public String setLed(Dessert d){
        if(d.getQualita() > 80){
            return "/Immagini/led verde.jpg";
        }
        else if(d.getQualita() > 50){
            return "/Immagini/led arancione.jpg";
        }
        return "/Immagini/led rosso.jpg";
    }
    public void setStand2(Dessert d, ImageIcon icon){
        lblPrezzoS2.setText(String.valueOf(d.getPrezzo()));
        lblQuantitaS2.setText(String.valueOf(d.getQuantita()));
        lblImmagineS2.setIcon(icon);
        lblLedS2.setIcon(new ImageIcon(getClass().getResource(setLed(d))));
        btnEliminaS2.setEnabled(true);
    }
    
    public void setStand3(Dessert d, ImageIcon icon){
        lblPrezzoS3.setText(String.valueOf(d.getPrezzo()));
        lblQuantitaS3.setText(String.valueOf(d.getQuantita()));
        lblImmagineS3.setIcon(icon);
        lblLedS3.setIcon(new ImageIcon(getClass().getResource(setLed(d))));
        btnEliminaS3.setEnabled(true);
    }
    
    public void resetLabelR1(){
       lblR1Level.setText("");
       lblR1Prezzo.setText("");
       lblR1CProduzione.setText("");
       lblImmagineR1.setIcon(null);
    }
    
    public void resetLabelR2(){
       lblR2Level.setText("");
       lblR2Prezzo.setText("");
       lblR2CProduzione.setText("");
       lblImmagineR2.setIcon(null);
    }
    
    public void resetLabelR3(){
       lblR3Level.setText("");
       lblR3Prezzo.setText("");
       lblR3CProduzione.setText("");
       lblImmagineR3.setIcon(null);
    }
    
    public void resetLabelR4(){
       lblR4Level.setText("");
       lblR4Prezzo.setText("");
       lblR4CProduzione.setText("");
       lblImmagineR4.setIcon(null);
    }
    
    public void enableR1(boolean check){
        btnEliminaR1.setEnabled(check);
        btnAggiungiR1.setEnabled(check);
    }
    
    public void enableR2(boolean check){
        btnEliminaR2.setEnabled(check);
        btnAggiungiR2.setEnabled(check);
    }
    
    public void enableR3(boolean check){
        btnEliminaR3.setEnabled(check);
        btnAggiungiR3.setEnabled(check);
    }
    
    public void enableR4(boolean check){
        btnEliminaR4.setEnabled(check);
        btnAggiungiR4.setEnabled(check);
    }
    
    public String filePathDessert(){
        switch(dessert.setImage()){
            case "donut fragola":
                return "/Immagini/Donut alla fragola.jpg";
            case "donut cioccolato":
                return "/Immagini/Donut al cioccolato.jpg"; 
            case "donut latte":
                return "/Immagini/Donut al latte.jpg";
            case "donut crema":
                return "/Immagini/Donut alla crema.jpg";
            case "gelato fragola":
                return "/Immagini/Gelato alla fragola.JPG";
            case "gelato cioccolato":
                return "/Immagini/Gelato al cioccolato.JPG"; 
            case "gelato caffe":
                return "/Immagini/Gelato al caffè.JPG";
            case "gelato vaniglia":
                return "/Immagini/Gelato alla vaniglia.JPG";  
            case "torta fragola":
                return "/Immagini/Torta alla fragola.JPG";
            case "torta cioccolato":
                return "/Immagini/Torta al cioccolato.JPG"; 
            case "torta latte":
                return "/Immagini/Torta al latte.JPG";
            case "tiramisu":
                return "/Immagini/Tiramisù.JPG"; 
            case "girella":
                return "/Immagini/Girella alla cannella.JPG"; 
            case "fallimento":
                return "/Immagini/fallimento.jpg"; 
        }
        return "";
    }
    
    public void resetProdotto(){
        lblProdotto1.setIcon(null);
        lblProdotto2.setIcon(null);
        lblProdotto3.setIcon(null);
        lblPasticcere.setIcon(null);
    }
    
    public void set(){
        tipo = cmbTipo.getSelectedItem().toString();
        
        resetProdotto();
        
        switch(tipo){
            case "Donut":
                dessert = new Donut();
                break;
            case "Torta":
                dessert = new Torta();
                break;
            case "Gelato":
                dessert = new Gelato();
                break;
        }
    }
    public String filePath(String i){
            switch(i){
            case "fragola":
                return "/Immagini/fragola.JPG";
            case "farina":
                return "/Immagini/farina.jpg";
            case "uova":
                return "/Immagini/uova.jpg";
            case "cioccolato":
                return "/Immagini/cioccolato.jpg";
            case "latte":
                return "/Immagini/latte.jpg";
            case "cannella":
                return "/Immagini/cannella.JPG";
            case "formaggio cremoso":
                return "/Immagini/formaggio cremoso.jpg";
            case "liquore":
                return "/Immagini/liquore.jpg";
            case "lievito":
                return "/Immagini/lievito.jpg";    
            case "crema":
                return "/Immagini/crema.jpg";
            case "latte condensato":
                return "/Immagini/latte condensato.JPG";   
            case "vaniglia":
                return "/Immagini/vaniglia.JPG";
            case "caffè":
                return "/Immagini/caffè.jpg";   
            case "cacao":
                return "/Immagini/cacao.jpg";
        }
        return "errore";
    }
    
    public void incendio(){
        for(int i = 0; i < d.length; i++){
            d[i] = null;
        }
        resetLabelR1();
        resetLabelR2();
        resetLabelR3();
        resetLabelR4();
    }
    
    public void eventiCasuali(){
        int m = r.nextInt(6);
        
        switch(m){
            case 2:
                JOptionPane.showMessageDialog(null, "Alla pasticceria si è verificato un incendio che ha causato la distruzione di ricette.", "Evento", 1);
                negozio.incendio();
                incendio();
                break;
            case 5: 
                JOptionPane.showMessageDialog(null, "Nel corso di questo mese, in occasione della festa, si è registrato un aumento del numero dei clienti.", "Evento", 1);
                if(timerStarted) timer.stop();
                timer(10);
                break;
        }
        
    }
    
    public void aggiornaLabels(){
        lblSoldi.setText(String.valueOf(negozio.getSoldi()));
        switch(S1nR){
            case 0:
              if(v[0] != null)lblQuantitaS1.setText(String.valueOf(v[0].getQuantita()));
              break;
            case 1:
              if(v[1] != null)lblQuantitaS1.setText(String.valueOf(v[1].getQuantita()));
              break;
            case 2:
              if(v[2] != null)lblQuantitaS1.setText(String.valueOf(v[2].getQuantita()));
              break;
        }
        switch(S2nR){
            case 0:
              if(v[0] != null)lblQuantitaS2.setText(String.valueOf(v[0].getQuantita()));
              break;
            case 1:
              if(v[1] != null)lblQuantitaS2.setText(String.valueOf(v[1].getQuantita()));
              break;
            case 2:
              if(v[2] != null)lblQuantitaS2.setText(String.valueOf(v[2].getQuantita()));
              break;
        }
        switch(S3nR){
            case 0:
              if(v[0] != null)lblQuantitaS3.setText(String.valueOf(v[0].getQuantita()));
              break;
            case 1:
              if(v[1] != null)lblQuantitaS3.setText(String.valueOf(v[1].getQuantita()));
              break;
            case 2:
              if(v[2] != null)lblQuantitaS3.setText(String.valueOf(v[2].getQuantita()));
              break;
        }
    }
    
    public void timer(int c){
        t = 0;
        eventiCasuali();
        timer = new Timer(5000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                timerStarted = true;

                if(numStand > 0){
                    HashMap<String, Object> m = negozio.compra();
                    Dessert dessertSelezionato = (Dessert) m.get("dessert");
                    int quantitaRichiesta = (int) m.get("quantita");

                    if(dessertSelezionato != null && quantitaRichiesta > 0){
                        int venduti = dessertSelezionato.vendita(quantitaRichiesta);
                        int guadagno = negozio.vende(venduti, dessertSelezionato);

                        System.out.println("Cliente ha comprato " + venduti + " dessert e ha speso " + guadagno + " euro");
                    }

                    for(int i = 0; i < v.length; i++){
                        if(v[i] != null && v[i].getQuantita() <= 0){
                            negozio.removeDessert(v[i]);
                            v[i] = null;
                        }
                    }
                }

                t++;
                aggiornaLabels();

                if(!negozio.checkSoldi()){
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Il tuo saldo è sceso sotto zero. Hai perso.", "Fallimento", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if(t == c){
                    mese++;
                    System.out.println("\nMese; " + mese);
                    System.out.println("affitto: " + 2000);
                    negozio.affitto();
                    lblSoldi.setText(String.valueOf(negozio.getSoldi()));
                    eventiCasuali();
                    lblMese.setText(String.valueOf(mese));

                    if(mese == 12){
                        timer.stop();
                        if(negozio.getSoldi() >= 20000){
                            JOptionPane.showMessageDialog(null, "Complimenti! Hai raggiunto 15.000 euro e hai vinto!", "Vittoria", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Il tuo saldo non ha raggiunto i 15.000 euro. Non hai vinto.", "Fallimento", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    t = 0;
                }
            }
        });

        timer.start();
    }


    
    public void checkCreare(){
        if(checkIng && checkPast){
            btnCreare.setEnabled(true);
        }
    }
    
    public Form1() {
        initComponents();
        
        r = new Random();
        
        d = new Dessert[4];
        v = new Dessert[3];
        images = new ImageIcon[4];
        
        m = new HashMap<>();
        
        UIManager.put("Panel.background", new java.awt.Color(232,249,255));
        UIManager.put("OptionPane.background", new java.awt.Color(232,249,255));
                
        enableR1(false);
        enableR2(false);
        enableR3(false);
        enableR4(false);
        
        timerStarted = false;
        checkIng = false;
        checkPast = false;
        
        btnCreare.setEnabled(false);
        tipo = cmbTipo.getSelectedItem().toString();
        numProdotto = 0;
        numDessert = 1;
        numStand = 0;
        mese = 1;
        
        pasticcereLuca = new Pasticcere("Luca");
        pasticcereMellisa = new Pasticcere("Mellissa");
        pasticcerePaolo = new Pasticcere("Paolo");
        
        negozio = new Negozio();

        nome = "luca";
             
        btnEliminaS1.setEnabled(false);
        btnEliminaS2.setEnabled(false);
        btnEliminaS3.setEnabled(false);
        
        ingredients = new HashMap<String, Integer>();
        ingredients.put("fragola", 80);
        ingredients.put("farina", 50);
        ingredients.put("uova", 70);
        ingredients.put("cioccolato", 150);
        ingredients.put("cacao", 250);
        ingredients.put("latte", 100);
        ingredients.put("cannella", 200);
        ingredients.put("formaggio cremoso", 100);
        ingredients.put("liquore", 300);
        ingredients.put("lievito", 50);
        ingredients.put("crema", 120);
        ingredients.put("latte condensato", 100);
        ingredients.put("vaniglia", 150);
        ingredients.put("caffè", 160);
        
        timer(6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbProdotto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbPasticcere = new javax.swing.JComboBox<>();
        btnCreare = new javax.swing.JButton();
        btnAggiungi = new javax.swing.JButton();
        btnIntroduzione = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblSoldi = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblMese = new javax.swing.JLabel();
        btnIstruzione = new javax.swing.JButton();
        cmbQualita = new javax.swing.JComboBox<>();
        Qualità = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCostoProduzioneLabel = new javax.swing.JLabel();
        lblCostoProduzione = new javax.swing.JLabel();
        btnLevelUp = new javax.swing.JButton();
        btnRicette = new javax.swing.JButton();
        btnConfermo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblLivello = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPasticcere = new javax.swing.JLabel();
        pnlR1 = new javax.swing.JPanel();
        lblR1L = new javax.swing.JLabel();
        lblR1P = new javax.swing.JLabel();
        lblR1Level = new javax.swing.JLabel();
        lblR1Cliente = new javax.swing.JLabel();
        lblR1Prezzo = new javax.swing.JLabel();
        lblImmagineR1 = new javax.swing.JLabel();
        btnEliminaR1 = new javax.swing.JButton();
        btnAggiungiR1 = new javax.swing.JButton();
        lblR1CP = new javax.swing.JLabel();
        lblR1CProduzione = new javax.swing.JLabel();
        pnlR2 = new javax.swing.JPanel();
        lblR2L1 = new javax.swing.JLabel();
        lblR2P = new javax.swing.JLabel();
        lblR2Prezzo = new javax.swing.JLabel();
        lblR2Cliente = new javax.swing.JLabel();
        lblR2Level = new javax.swing.JLabel();
        lblImmagineR2 = new javax.swing.JLabel();
        btnEliminaR2 = new javax.swing.JButton();
        btnAggiungiR2 = new javax.swing.JButton();
        lblR1CP1 = new javax.swing.JLabel();
        lblR2CProduzione = new javax.swing.JLabel();
        pnlR3 = new javax.swing.JPanel();
        lblR3L = new javax.swing.JLabel();
        lblR3Level = new javax.swing.JLabel();
        lblR3Prezzo = new javax.swing.JLabel();
        lblR3P = new javax.swing.JLabel();
        btnEliminaR3 = new javax.swing.JButton();
        btnAggiungiR3 = new javax.swing.JButton();
        lblImmagineR3 = new javax.swing.JLabel();
        lblR3CProduzione = new javax.swing.JLabel();
        lblR1CP2 = new javax.swing.JLabel();
        pnlR4 = new javax.swing.JPanel();
        lblR4L = new javax.swing.JLabel();
        lblR4Level = new javax.swing.JLabel();
        lblR4Prezzo = new javax.swing.JLabel();
        lblR4P = new javax.swing.JLabel();
        btnEliminaR4 = new javax.swing.JButton();
        lblImmagineR4 = new javax.swing.JLabel();
        btnAggiungiR4 = new javax.swing.JButton();
        lblR4CProduzione = new javax.swing.JLabel();
        lblR1CP3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImmagineS1 = new javax.swing.JLabel();
        btnEliminaS1 = new javax.swing.JButton();
        lblPrezzoS1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblQuantitaS1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblLedS1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblImmagineS3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblPrezzoS3 = new javax.swing.JLabel();
        btnEliminaS3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        lblQuantitaS3 = new javax.swing.JLabel();
        lblLedS3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblImmagineS2 = new javax.swing.JLabel();
        lblPrezzoS2 = new javax.swing.JLabel();
        btnEliminaS2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblQuantitaS2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblLedS2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblProdotto3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblProdotto1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblProdotto2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));

        pnlBackground.setBackground(new java.awt.Color(228, 237, 250));
        pnlBackground.setPreferredSize(new java.awt.Dimension(1000, 600));

        pnlMenu.setBackground(new java.awt.Color(143, 175, 225));
        pnlMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pnlMenu.setPreferredSize(new java.awt.Dimension(320, 600));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pasticceria");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Donut", "Torta", "Gelato" }));
        cmbTipo.setToolTipText("");
        cmbTipo.setPreferredSize(new java.awt.Dimension(70, 22));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 153));
        jLabel3.setText("Ingredienti");

        cmbProdotto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "fragola", "farina", "uova", "cioccolato", "cacao", "latte", "cannella", "formaggio cremoso", "liquore", "lievito", "crema", "latte condensato", "vaniglia", "caffè" }));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setText("Pasticcere");

        cmbPasticcere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luca", "Mellisa", "Paolo" }));
        cmbPasticcere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPasticcereActionPerformed(evt);
            }
        });

        btnCreare.setBackground(new java.awt.Color(123, 193, 132));
        btnCreare.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnCreare.setForeground(new java.awt.Color(255, 255, 255));
        btnCreare.setText("Creare");
        btnCreare.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCreare.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreareActionPerformed(evt);
            }
        });

        btnAggiungi.setBackground(new java.awt.Color(51, 153, 255));
        btnAggiungi.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        btnAggiungi.setForeground(new java.awt.Color(255, 255, 255));
        btnAggiungi.setText("Aggiungi");
        btnAggiungi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAggiungi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiActionPerformed(evt);
            }
        });

        btnIntroduzione.setBackground(new java.awt.Color(51, 204, 0));
        btnIntroduzione.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnIntroduzione.setForeground(new java.awt.Color(255, 255, 255));
        btnIntroduzione.setText("Introduzione");
        btnIntroduzione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnIntroduzione.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIntroduzione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntroduzioneActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("Soldi:");

        lblSoldi.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblSoldi.setForeground(new java.awt.Color(255, 204, 102));
        lblSoldi.setText("1000");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel10.setText("Mese:");

        lblMese.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblMese.setText("1");

        btnIstruzione.setBackground(new java.awt.Color(255, 51, 255));
        btnIstruzione.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnIstruzione.setForeground(new java.awt.Color(255, 255, 255));
        btnIstruzione.setText("Istruzione");
        btnIstruzione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnIstruzione.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIstruzione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIstruzioneActionPerformed(evt);
            }
        });

        cmbQualita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Bassa" }));
        cmbQualita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQualitaActionPerformed(evt);
            }
        });

        Qualità.setBackground(new java.awt.Color(204, 255, 204));
        Qualità.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Qualità.setForeground(new java.awt.Color(204, 255, 204));
        Qualità.setText("Qualità");

        jLabel12.setBackground(new java.awt.Color(153, 255, 204));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 255, 204));
        jLabel12.setText("Prodotto");

        lblCostoProduzioneLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCostoProduzioneLabel.setForeground(new java.awt.Color(234, 255, 234));
        lblCostoProduzioneLabel.setText("Costo di Produzione:");

        lblCostoProduzione.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCostoProduzione.setForeground(new java.awt.Color(234, 255, 234));
        lblCostoProduzione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCostoProduzione.setText("30");
        lblCostoProduzione.setMaximumSize(new java.awt.Dimension(80, 16));
        lblCostoProduzione.setMinimumSize(new java.awt.Dimension(80, 16));
        lblCostoProduzione.setPreferredSize(new java.awt.Dimension(80, 16));

        btnLevelUp.setBackground(new java.awt.Color(0, 204, 204));
        btnLevelUp.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnLevelUp.setForeground(new java.awt.Color(255, 255, 255));
        btnLevelUp.setText("level up");
        btnLevelUp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLevelUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLevelUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLevelUpActionPerformed(evt);
            }
        });

        btnRicette.setBackground(new java.awt.Color(0, 153, 153));
        btnRicette.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        btnRicette.setForeground(new java.awt.Color(255, 255, 255));
        btnRicette.setText("Ricette");
        btnRicette.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRicette.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRicette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRicetteActionPerformed(evt);
            }
        });

        btnConfermo.setBackground(new java.awt.Color(153, 153, 255));
        btnConfermo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnConfermo.setForeground(new java.awt.Color(255, 255, 255));
        btnConfermo.setText("Confermo");
        btnConfermo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnConfermo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfermoActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 239, 239));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 242, 242));
        jLabel5.setText("Livello:");

        lblLivello.setBackground(new java.awt.Color(255, 239, 239));
        lblLivello.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLivello.setForeground(new java.awt.Color(255, 242, 242));
        lblLivello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLivello.setText("1");

        jLabel14.setBackground(new java.awt.Color(255, 239, 239));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 242, 242));
        jLabel14.setText("Costo:");

        lblCosto.setBackground(new java.awt.Color(255, 239, 239));
        lblCosto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(255, 242, 242));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCosto.setText("100");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("costo: 80");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoldi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addComponent(btnIntroduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIstruzione, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(12, 12, 12)
                                            .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Qualità, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cmbProdotto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbQualita, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRicette, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(187, 187, 187))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4))
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMenuLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(cmbPasticcere, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlMenuLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblLivello, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnLevelUp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMenuLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnConfermo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblCostoProduzioneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCostoProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreare, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblSoldi)
                    .addComponent(jLabel10)
                    .addComponent(lblMese))
                .addGap(43, 43, 43)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Qualità)
                    .addComponent(cmbQualita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbProdotto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRicette, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCostoProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCostoProduzioneLabel))
                .addGap(27, 27, 27)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPasticcere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblLivello, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLevelUp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfermo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreare, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(8, 8, 8)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIntroduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIstruzione, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 153));
        jLabel6.setText("Dolce Creazione");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("Ricette");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Stand");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));

        lblPasticcere.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPasticcere.setMaximumSize(new java.awt.Dimension(88, 88));
        lblPasticcere.setMinimumSize(new java.awt.Dimension(88, 88));
        lblPasticcere.setPreferredSize(new java.awt.Dimension(88, 88));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblPasticcere, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblPasticcere, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlR1.setBackground(new java.awt.Color(255, 255, 255));
        pnlR1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        lblR1L.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1L.setText("Qualità");

        lblR1P.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1P.setText("Prezzo");

        lblR1Level.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1Level.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR1Level.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR1Cliente.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1Cliente.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR1Cliente.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR1Prezzo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1Prezzo.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR1Prezzo.setMinimumSize(new java.awt.Dimension(10, 10));

        lblImmagineR1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineR1.setMaximumSize(new java.awt.Dimension(70, 70));
        lblImmagineR1.setMinimumSize(new java.awt.Dimension(70, 70));
        lblImmagineR1.setPreferredSize(new java.awt.Dimension(70, 70));

        btnEliminaR1.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminaR1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaR1.setText("Elimina");
        btnEliminaR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaR1ActionPerformed(evt);
            }
        });

        btnAggiungiR1.setBackground(new java.awt.Color(204, 255, 204));
        btnAggiungiR1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnAggiungiR1.setText("Aggiungi");
        btnAggiungiR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAggiungiR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiR1ActionPerformed(evt);
            }
        });

        lblR1CP.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1CP.setText("Costo Pfoduzione");

        lblR1CProduzione.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1CProduzione.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR1CProduzione.setMinimumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout pnlR1Layout = new javax.swing.GroupLayout(pnlR1);
        pnlR1.setLayout(pnlR1Layout);
        pnlR1Layout.setHorizontalGroup(
            pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlR1Layout.createSequentialGroup()
                        .addComponent(btnEliminaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAggiungiR1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlR1Layout.createSequentialGroup()
                        .addComponent(lblR1L, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblR1Level, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlR1Layout.createSequentialGroup()
                        .addComponent(lblR1P, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblR1Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblR1Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblImmagineR1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlR1Layout.createSequentialGroup()
                            .addComponent(lblR1CP)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblR1CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlR1Layout.setVerticalGroup(
            pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR1L, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR1Level, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR1Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblR1P)
                        .addComponent(lblR1Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR1CP)
                    .addComponent(lblR1CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImmagineR1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminaR1)
                    .addComponent(btnAggiungiR1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnEliminaR1.getAccessibleContext().setAccessibleName("");
        btnAggiungiR1.getAccessibleContext().setAccessibleName("");

        pnlR2.setBackground(new java.awt.Color(255, 255, 255));
        pnlR2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        lblR2L1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2L1.setText("Qualità");

        lblR2P.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2P.setText("Prezzo");

        lblR2Prezzo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2Prezzo.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR2Prezzo.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR2Cliente.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2Cliente.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR2Cliente.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR2Level.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2Level.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR2Level.setMinimumSize(new java.awt.Dimension(10, 10));

        lblImmagineR2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineR2.setMaximumSize(new java.awt.Dimension(70, 70));
        lblImmagineR2.setMinimumSize(new java.awt.Dimension(70, 70));
        lblImmagineR2.setPreferredSize(new java.awt.Dimension(70, 70));

        btnEliminaR2.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminaR2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaR2.setText("Elimina");
        btnEliminaR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaR2ActionPerformed(evt);
            }
        });

        btnAggiungiR2.setBackground(new java.awt.Color(204, 255, 204));
        btnAggiungiR2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnAggiungiR2.setText("Aggiungi");
        btnAggiungiR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAggiungiR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiR2ActionPerformed(evt);
            }
        });

        lblR1CP1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1CP1.setText("Costo Pfoduzione");

        lblR2CProduzione.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR2CProduzione.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR2CProduzione.setMinimumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout pnlR2Layout = new javax.swing.GroupLayout(pnlR2);
        pnlR2.setLayout(pnlR2Layout);
        pnlR2Layout.setHorizontalGroup(
            pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlR2Layout.createSequentialGroup()
                        .addComponent(btnEliminaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAggiungiR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlR2Layout.createSequentialGroup()
                        .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlR2Layout.createSequentialGroup()
                                .addComponent(lblR2P, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblR2Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblR2Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblImmagineR2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlR2Layout.createSequentialGroup()
                                    .addComponent(lblR1CP1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblR2CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlR2Layout.createSequentialGroup()
                                .addComponent(lblR2L1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblR2Level, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlR2Layout.setVerticalGroup(
            pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR2Level, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR2L1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR2Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR2P)
                    .addComponent(lblR2Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR1CP1)
                    .addComponent(lblR2CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImmagineR2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAggiungiR2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnEliminaR2.getAccessibleContext().setAccessibleName("");
        btnAggiungiR2.getAccessibleContext().setAccessibleName("");

        pnlR3.setBackground(new java.awt.Color(255, 255, 255));
        pnlR3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        lblR3L.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR3L.setText("Qualità");

        lblR3Level.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR3Level.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR3Level.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR3Prezzo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR3Prezzo.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR3Prezzo.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR3P.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR3P.setText("Prezzo");

        btnEliminaR3.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminaR3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaR3.setText("Elimina");
        btnEliminaR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaR3ActionPerformed(evt);
            }
        });

        btnAggiungiR3.setBackground(new java.awt.Color(204, 255, 204));
        btnAggiungiR3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnAggiungiR3.setText("Aggiungi");
        btnAggiungiR3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAggiungiR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiR3ActionPerformed(evt);
            }
        });

        lblImmagineR3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineR3.setMaximumSize(new java.awt.Dimension(70, 70));
        lblImmagineR3.setMinimumSize(new java.awt.Dimension(70, 70));
        lblImmagineR3.setPreferredSize(new java.awt.Dimension(70, 70));

        lblR3CProduzione.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR3CProduzione.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR3CProduzione.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR1CP2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1CP2.setText("Costo Pfoduzione");

        javax.swing.GroupLayout pnlR3Layout = new javax.swing.GroupLayout(pnlR3);
        pnlR3.setLayout(pnlR3Layout);
        pnlR3Layout.setHorizontalGroup(
            pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlR3Layout.createSequentialGroup()
                        .addComponent(btnEliminaR3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAggiungiR3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addGroup(pnlR3Layout.createSequentialGroup()
                        .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlR3Layout.createSequentialGroup()
                                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblR3L, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblR3P, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblR3Level, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblR3Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblImmagineR3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlR3Layout.createSequentialGroup()
                                    .addComponent(lblR1CP2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblR3CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        pnlR3Layout.setVerticalGroup(
            pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR3Level, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR3L))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR3Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR3P))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR1CP2)
                    .addComponent(lblR3CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImmagineR3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnlR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminaR3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAggiungiR3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnEliminaR3.getAccessibleContext().setAccessibleName("");
        btnAggiungiR3.getAccessibleContext().setAccessibleName("");

        pnlR4.setBackground(new java.awt.Color(255, 255, 255));
        pnlR4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        lblR4L.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR4L.setText("Qualità");

        lblR4Level.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR4Level.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR4Level.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR4Prezzo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR4Prezzo.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR4Prezzo.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR4P.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR4P.setText("Prezzo");

        btnEliminaR4.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminaR4.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaR4.setText("Elimina");
        btnEliminaR4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaR4ActionPerformed(evt);
            }
        });

        lblImmagineR4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineR4.setMaximumSize(new java.awt.Dimension(70, 70));
        lblImmagineR4.setMinimumSize(new java.awt.Dimension(70, 70));
        lblImmagineR4.setPreferredSize(new java.awt.Dimension(70, 70));

        btnAggiungiR4.setBackground(new java.awt.Color(204, 255, 204));
        btnAggiungiR4.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnAggiungiR4.setText("Aggiungi");
        btnAggiungiR4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAggiungiR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiR4ActionPerformed(evt);
            }
        });

        lblR4CProduzione.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR4CProduzione.setMaximumSize(new java.awt.Dimension(10, 10));
        lblR4CProduzione.setMinimumSize(new java.awt.Dimension(10, 10));

        lblR1CP3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblR1CP3.setText("Costo Pfoduzione");

        javax.swing.GroupLayout pnlR4Layout = new javax.swing.GroupLayout(pnlR4);
        pnlR4.setLayout(pnlR4Layout);
        pnlR4Layout.setHorizontalGroup(
            pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlR4Layout.createSequentialGroup()
                        .addComponent(btnEliminaR4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAggiungiR4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlR4Layout.createSequentialGroup()
                        .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlR4Layout.createSequentialGroup()
                                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblR4L, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblR4P, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblR4Level, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblR4Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblImmagineR4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlR4Layout.createSequentialGroup()
                                    .addComponent(lblR1CP3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblR4CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlR4Layout.setVerticalGroup(
            pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlR4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR4Level, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR4L))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblR4Prezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR4P))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR1CP3)
                    .addComponent(lblR4CProduzione, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImmagineR4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnlR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminaR4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAggiungiR4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnEliminaR4.getAccessibleContext().setAccessibleName("");
        btnAggiungiR4.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 166));

        lblImmagineS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineS1.setMaximumSize(new java.awt.Dimension(95, 95));
        lblImmagineS1.setMinimumSize(new java.awt.Dimension(95, 95));
        lblImmagineS1.setPreferredSize(new java.awt.Dimension(95, 95));

        btnEliminaS1.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminaS1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaS1.setText("Elimina");
        btnEliminaS1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaS1ActionPerformed(evt);
            }
        });

        lblPrezzoS1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblPrezzoS1.setMaximumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS1.setMinimumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS1.setPreferredSize(new java.awt.Dimension(17, 10));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel11.setText("Prezzo");

        lblQuantitaS1.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblQuantitaS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantitaS1.setText("0");
        lblQuantitaS1.setMaximumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS1.setMinimumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS1.setPreferredSize(new java.awt.Dimension(17, 10));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel13.setText("Quantità");

        lblLedS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblLedS1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminaS1)
                            .addComponent(lblImmagineS1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrezzoS1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuantitaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblImmagineS1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLedS1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrezzoS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblQuantitaS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminaS1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 166));

        lblImmagineS3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineS3.setMaximumSize(new java.awt.Dimension(95, 95));
        lblImmagineS3.setMinimumSize(new java.awt.Dimension(95, 95));
        lblImmagineS3.setPreferredSize(new java.awt.Dimension(95, 95));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel21.setText("Prezzo");

        lblPrezzoS3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblPrezzoS3.setMaximumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS3.setMinimumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS3.setPreferredSize(new java.awt.Dimension(17, 10));

        btnEliminaS3.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminaS3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaS3.setText("Elimina");
        btnEliminaS3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaS3ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel22.setText("Quantità");

        lblQuantitaS3.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblQuantitaS3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantitaS3.setText("0");
        lblQuantitaS3.setMaximumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS3.setMinimumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS3.setPreferredSize(new java.awt.Dimension(17, 10));

        lblLedS3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrezzoS3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuantitaS3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLedS3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblImmagineS3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnEliminaS3)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblImmagineS3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLedS3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrezzoS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(lblQuantitaS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnEliminaS3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 102)));
        jPanel5.setPreferredSize(new java.awt.Dimension(180, 166));

        lblImmagineS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmagineS2.setMaximumSize(new java.awt.Dimension(95, 95));
        lblImmagineS2.setMinimumSize(new java.awt.Dimension(95, 95));
        lblImmagineS2.setPreferredSize(new java.awt.Dimension(95, 95));

        lblPrezzoS2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblPrezzoS2.setMaximumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS2.setMinimumSize(new java.awt.Dimension(17, 10));
        lblPrezzoS2.setPreferredSize(new java.awt.Dimension(17, 10));

        btnEliminaS2.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminaS2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnEliminaS2.setText("Elimina");
        btnEliminaS2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaS2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel15.setText("Prezzo");

        lblQuantitaS2.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        lblQuantitaS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantitaS2.setText("0");
        lblQuantitaS2.setMaximumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS2.setMinimumSize(new java.awt.Dimension(17, 10));
        lblQuantitaS2.setPreferredSize(new java.awt.Dimension(17, 10));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        jLabel16.setText("Quantità");

        lblLedS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblLedS2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblImmagineS2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnEliminaS2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblPrezzoS2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuantitaS2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblImmagineS2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLedS2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrezzoS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lblQuantitaS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminaS2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel6.setMaximumSize(new java.awt.Dimension(152, 155));
        jPanel6.setMinimumSize(new java.awt.Dimension(152, 155));
        jPanel6.setPreferredSize(new java.awt.Dimension(152, 155));

        lblProdotto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProdotto3.setMaximumSize(new java.awt.Dimension(88, 88));
        lblProdotto3.setMinimumSize(new java.awt.Dimension(88, 88));
        lblProdotto3.setPreferredSize(new java.awt.Dimension(88, 88));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblProdotto3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblProdotto3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel1.setMaximumSize(new java.awt.Dimension(152, 155));
        jPanel1.setMinimumSize(new java.awt.Dimension(152, 155));
        jPanel1.setPreferredSize(new java.awt.Dimension(152, 155));

        lblProdotto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProdotto1.setMaximumSize(new java.awt.Dimension(88, 88));
        lblProdotto1.setMinimumSize(new java.awt.Dimension(88, 88));
        lblProdotto1.setPreferredSize(new java.awt.Dimension(88, 88));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblProdotto1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(lblProdotto1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel7.setMaximumSize(new java.awt.Dimension(152, 155));
        jPanel7.setMinimumSize(new java.awt.Dimension(152, 155));
        jPanel7.setPreferredSize(new java.awt.Dimension(152, 155));

        lblProdotto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProdotto2.setMaximumSize(new java.awt.Dimension(88, 88));
        lblProdotto2.setMinimumSize(new java.awt.Dimension(88, 88));
        lblProdotto2.setPreferredSize(new java.awt.Dimension(88, 88));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(lblProdotto2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblProdotto2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(pnlR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlR4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlR3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbQualitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQualitaActionPerformed

    }//GEN-LAST:event_cmbQualitaActionPerformed

    private void btnIntroduzioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntroduzioneActionPerformed
        JOptionPane.showMessageDialog(null,"Sei un impiegato stanco di ripetere ogni giorno le stesse attività alla scrivania. Finalmente, decidi di riscoprire il sogno della tua infanzia: aprire una pasticceria tutta tua. Anche se disponi di pochi fondi, "
                + "                         \ncoraggiosamente contrai un prestito di 20.000 euro per realizzare il tuo sogno.\n" +
                                            "\n" +
                                            "Il tuo obiettivo è chiaro: entro un anno devi far crescere il capitale fino ad almeno 20.000 euro. Se al termine dell’anno non raggiungerai questo traguardo, la pasticceria sarà costretta a chiudere.","Introduzione",1);

    }//GEN-LAST:event_btnIntroduzioneActionPerformed

    private void btnIstruzioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIstruzioneActionPerformed
        JOptionPane.showMessageDialog(null,"Benvenuto!\n" +
                                            "Area di lavoro a sinistra: controlla il tipo di dolce che vuoi preparare, gli ingredienti e le ricette.\n" +
                                            "\n" +
                                            "Aree a destra:\n" +
                                            "- Dolce Creazione: prepara i dolci! La qualità degli ingredienti influisce sul risultato, scegli il tuo pasticcere, il cui livello influenzerà anche la qualità dei dolci. Ogni pasticcere è specializzato in\n" +
                                            "  diversi tipi di dolci. Scegli il pubblico e crea dolci di alta qualità. Ogni volta che crei un dessert, costa 80.\n" +
                                            "- Ricette: vedi tutti i dolci che hai preparato.\n" +
                                            "- Stand: esponi i dolci (3 slot). Controlla la luce in alto a sinistra:\n" +
                                            "         Rosso: poco popolare, meglio cambiare\n" +
                                            "         Arancione: popolarità media, puoi cambiare o no\n" +
                                            "         Verde: molto apprezzato\n" +
                                            "\n" +
                                            "Durante il gioco ci saranno eventi imprevisti, affrontali con attenzione!\n" +
                                            "L’introduzione e gli obiettivi sono nel pulsante Introduzione, leggili attentamente!","Istruzione",1);
    }//GEN-LAST:event_btnIstruzioneActionPerformed

    private void btnAggiungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiActionPerformed
        if(clic == 0) {
            set();
            clic++;
        }
        ingredient = cmbProdotto.getSelectedItem().toString();
        costo = ingredients.get(ingredient);
        qualita = cmbQualita.getSelectedItem().toString();
        
        numProdotto++;
                
        dessert.addIngrediente(new Ingrediente(ingredient, costo, qualita), numProdotto);
        lblCostoProduzione.setText(String.valueOf(dessert.calcolaCosto()));
                
        ImageIcon icon = new ImageIcon(getClass().getResource(filePath(ingredient)));
        if(numProdotto == 1) {
            lblProdotto1.setIcon(icon);
        }
        else if(numProdotto == 2) {
            lblProdotto2.setIcon(icon);
        }
        else {
            lblProdotto3.setIcon(icon);
            numProdotto = 0;
            checkIng = true;
            checkCreare();
        }
    }//GEN-LAST:event_btnAggiungiActionPerformed

    private void btnCreareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreareActionPerformed
        negozio.diminuiSoldi(c);
        numProdotto = 0;
        int pos = 1;
        resetProdotto();
        
        boolean saved = false;
        
        if(numDessert < 5){
            negozio.addDessert(dessert);
                for(int i = 0; i < d.length; i++){
                    if(d[i] == null && !saved){
                        d[i] = dessert;
                        saved = true;
                        pos = i+1;
                    }
                }
            lblSoldi.setText(String.valueOf(negozio.getSoldi()));
            
            ImageIcon i = new ImageIcon(getClass().getResource(filePathDessert()));
            
            switch(pos){
                case 1:
                    lblImmagineR1.setIcon(i);
                    images[0] = i;
                    lblR1CProduzione.setText(String.valueOf(dessert.calcolaCosto()));
                    lblR1Prezzo.setText(String.valueOf(dessert.getPrezzo()));
                    lblR1Level.setText(String.valueOf(dessert.getQualita()));
                    enableR1(true);
                    break;
                case 2:
                    lblImmagineR2.setIcon(i);
                    images[1] = i;
                    lblR2CProduzione.setText(String.valueOf(dessert.calcolaCosto()));
                    lblR2Prezzo.setText(String.valueOf(dessert.getPrezzo()));
                    lblR2Level.setText(String.valueOf(dessert.getQualita()));
                    enableR2(true);
                    break;
                case 3:
                    lblImmagineR3.setIcon(i);
                    images[2] = i;
                    lblR3CProduzione.setText(String.valueOf(dessert.calcolaCosto()));
                    lblR3Prezzo.setText(String.valueOf(dessert.getPrezzo()));
                    lblR3Level.setText(String.valueOf(dessert.getQualita()));
                    enableR3(true);
                    break;
                case 4:
                    lblImmagineR4.setIcon(i);
                    images[3] = i;
                    lblR4CProduzione.setText(String.valueOf(dessert.calcolaCosto()));
                    lblR4Prezzo.setText(String.valueOf(dessert.getPrezzo()));
                    lblR4Level.setText(String.valueOf(dessert.getQualita()));
                    enableR4(true);
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Elimina una ricetta prima di aggiungere una nuova!", "Errore", 1);
        }
        numDessert++;
        btnCreare.setEnabled(false);
        checkPast = false;
        checkIng = false;
        clic = 0;
    }//GEN-LAST:event_btnCreareActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        set();
        numProdotto = 0;
        clic++;
        lblCostoProduzione.setText(String.valueOf(dessert.getCostoProduzione()));
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnRicetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRicetteActionPerformed
        switch(tipo){
            case "Donut":
                JOptionPane.showMessageDialog(null,"Consiglio: segui la ricetta passo dopo passo per evitare risultati fallimentari\n" +
                                                   "\nDonut al latte: farina, lievito, latte\n" +
                                                   "Donut alla fragola: farina, lievito, fragola\n" +
                                                   "Donut al cioccolato: farina, lievito, cioccolato\n" +
                                                   "Donut alla crema: farina, lievito, crema","Ricette - Donut",1);
                break;
            case "Torta":
                JOptionPane.showMessageDialog(null,"Consiglio: segui la ricetta passo dopo passo per evitare risultati fallimentari\n" +
                                                   "Torta alla fragola: fragola, farina, uova\n" +
                                                   "Torta al cioccolato: cioccolato, farina, cacao\n" +
                                                   "Torta al latte: uova, farina, latte\n" +
                                                   "Girella alla cannella: cannella, farina, uova\n" +
                                                   "Tiramisù: formaggio cremoso, cacao, liquore","Ricette - Torta",1);
                break;
            case "Gelato":
                JOptionPane.showMessageDialog(null,"Consiglio: segui la ricetta passo dopo passo per evitare risultati fallimentari\n" +
                                                   "Gelato alla vaniglia: crema, latte condensato, vaniglia\n" +
                                                   "Gelato alla fragola: crema, latte condensato, fragola\n" +
                                                   "Gelato al cioccolato: crema, latte condensato, cioccolato\n" +
                                                   "Gelato al caffè: crema, latte condensato, chicchi di caffè","Ricette - Gelato",1);
                break;
        }
    }//GEN-LAST:event_btnRicetteActionPerformed

    private void btnConfermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfermoActionPerformed
        checkPast = true;
        checkCreare();
        nome = cmbPasticcere.getSelectedItem().toString();
        String path = "";
        
        switch(nome){
            case "Luca":
                path = "/Immagini/Luca.jpg";
                pasticcereLuca.aumentaEsperienza();
                c = pasticcereLuca.getCosto();
                pasticcereLuca.aumentaQualita(dessert);
                break;
            case "Mellisa":
                path = "/Immagini/Mellisa.jpg";
                pasticcereMellisa.aumentaEsperienza();
                c = pasticcereMellisa.getCosto();
                pasticcereMellisa.aumentaQualita(dessert);
                break;
            case "Paolo":
                path = "/Immagini/Paolo.jpg";
                pasticcerePaolo.aumentaEsperienza();
                c = pasticcerePaolo.getCosto();
                pasticcerePaolo.aumentaQualita(dessert);
                break;
        }
        
        lblCosto.setText(String.valueOf(c));
        lblSoldi.setText(String.valueOf(negozio.getSoldi()));
        ImageIcon p = new ImageIcon(getClass().getResource(path));
        lblPasticcere.setIcon(p);
    }//GEN-LAST:event_btnConfermoActionPerformed

    private void cmbPasticcereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasticcereActionPerformed
        nome = cmbPasticcere.getSelectedItem().toString();
        
        switch(nome){
            case "Luca":
                lblCosto.setText(String.valueOf(pasticcereLuca.getCosto()));
                break;
            case "Mellisa":
                lblCosto.setText(String.valueOf(pasticcereMellisa.getCosto()));
                break;
            case "Paolo":
                lblCosto.setText(String.valueOf(pasticcerePaolo.getCosto()));
                break;
        }
    }//GEN-LAST:event_cmbPasticcereActionPerformed

    private void btnLevelUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevelUpActionPerformed
        switch(nome){
            case "Luca":
                pasticcereLuca.aumentaLevel();
                break;
            case "Mellisa":
                pasticcereMellisa.aumentaLevel();
                break;
            case "Paolo":
                pasticcerePaolo.aumentaLevel();
                break;
        }
    }//GEN-LAST:event_btnLevelUpActionPerformed

    private void btnEliminaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaR1ActionPerformed
        numDessert--;
        negozio.removeDessert(d[0]);
        d[0] = null;
        enableR1(false);
        resetLabelR1();
        images[0] = null;
    }//GEN-LAST:event_btnEliminaR1ActionPerformed

    private void btnEliminaR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaR2ActionPerformed
        numDessert--;
        negozio.removeDessert(d[1]);
        d[1] = null;
        enableR2(false);
        resetLabelR2();
        images[1] = null;
    }//GEN-LAST:event_btnEliminaR2ActionPerformed

    private void btnEliminaR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaR3ActionPerformed
        numDessert--;
        negozio.removeDessert(d[2]);
        d[2] = null;
        enableR3(false);
        resetLabelR3();
        images[2] = null;
    }//GEN-LAST:event_btnEliminaR3ActionPerformed

    private void btnEliminaR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaR4ActionPerformed
        numDessert--;
        negozio.removeDessert(d[3]);
        d[3] = null;
        enableR4(false);
        resetLabelR4();
        images[3] = null;
    }//GEN-LAST:event_btnEliminaR4ActionPerformed

    private void btnAggiungiR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiR1ActionPerformed
        if(numStand < 4){
            lblSoldi.setText(String.valueOf(negozio.getSoldi()));
            v[numStand] = d[0];
            negozio.addVendita(d[0]);
            numStand++;
            switch(numStand){
                case 1:
                    setStand1(d[0], images[0]);
                    S1nR = 0;
                    break;
                case 2:
                    setStand2(d[0], images[0]);
                    S2nR = 0;
                    break;
                case 3:
                    setStand3(d[0], images[0]);
                    S3nR = 0;
                    break;
            }
        }
    }//GEN-LAST:event_btnAggiungiR1ActionPerformed

    private void btnAggiungiR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiR2ActionPerformed
        if(numStand < 3){
            lblSoldi.setText(String.valueOf(negozio.getSoldi()));
            v[numStand] = d[1];
            negozio.addVendita(d[1]);
            numStand++;
            switch(numStand){
                case 1:
                    setStand1(d[1], images[1]);
                    S1nR = 1;
                    break;
                case 2:
                    setStand2(d[1], images[1]);
                    S2nR = 1;
                    break;
                case 3:
                    setStand3(d[1], images[1]);
                    S3nR = 1;
                    break;
            }
        }
    }//GEN-LAST:event_btnAggiungiR2ActionPerformed

    private void btnAggiungiR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiR3ActionPerformed
        if(numStand < 4){
            lblSoldi.setText(String.valueOf(negozio.getSoldi()));
            v[numStand] = d[2];
            negozio.addVendita(d[2]);
            numStand++;
            switch(numStand){
                case 1:
                    setStand1(d[2], images[2]);
                    S1nR = 2;
                    break;
                case 2:
                    setStand2(d[2], images[2]);
                    S2nR = 2;
                    break;
                case 3:
                    setStand3(d[2], images[2]);
                    S3nR = 2;
                    break;
            }
        }
    }//GEN-LAST:event_btnAggiungiR3ActionPerformed

    private void btnAggiungiR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiR4ActionPerformed
        if(numStand <4){
            lblSoldi.setText(String.valueOf(negozio.getSoldi()));
            v[numStand] = d[3];
            negozio.addVendita(d[3]);
            numStand++;
            switch(numStand){
                case 1:
                    setStand1(d[3], images[3]);
                    S1nR = 3;
                    break;
                case 2:
                    setStand2(d[3], images[3]);
                    S2nR = 3;
                    break;
                case 3:
                    setStand3(d[3], images[3]);
                    S3nR = 3;
                    break;
            }
        }
    }//GEN-LAST:event_btnAggiungiR4ActionPerformed

    private void btnEliminaS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaS1ActionPerformed
        resetStand1();
        numStand--;
        v[0] = null;
        negozio.removeVendita(v[0]);
    }//GEN-LAST:event_btnEliminaS1ActionPerformed

    private void btnEliminaS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaS2ActionPerformed
        resetStand2();
        numStand--;
        v[1] = null;
        negozio.removeVendita(v[1]);
    }//GEN-LAST:event_btnEliminaS2ActionPerformed

    private void btnEliminaS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaS3ActionPerformed
        resetStand3();
        numStand--;
        v[2] = null;
        negozio.removeVendita(v[2]);
    }//GEN-LAST:event_btnEliminaS3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Form1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Qualità;
    private javax.swing.JButton btnAggiungi;
    private javax.swing.JButton btnAggiungiR1;
    private javax.swing.JButton btnAggiungiR2;
    private javax.swing.JButton btnAggiungiR3;
    private javax.swing.JButton btnAggiungiR4;
    private javax.swing.JButton btnConfermo;
    private javax.swing.JButton btnCreare;
    private javax.swing.JButton btnEliminaR1;
    private javax.swing.JButton btnEliminaR2;
    private javax.swing.JButton btnEliminaR3;
    private javax.swing.JButton btnEliminaR4;
    private javax.swing.JButton btnEliminaS1;
    private javax.swing.JButton btnEliminaS2;
    private javax.swing.JButton btnEliminaS3;
    private javax.swing.JButton btnIntroduzione;
    private javax.swing.JButton btnIstruzione;
    private javax.swing.JButton btnLevelUp;
    private javax.swing.JButton btnRicette;
    private javax.swing.JComboBox<String> cmbPasticcere;
    private javax.swing.JComboBox<String> cmbProdotto;
    private javax.swing.JComboBox<String> cmbQualita;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCostoProduzione;
    private javax.swing.JLabel lblCostoProduzioneLabel;
    private javax.swing.JLabel lblImmagineR1;
    private javax.swing.JLabel lblImmagineR2;
    private javax.swing.JLabel lblImmagineR3;
    private javax.swing.JLabel lblImmagineR4;
    private javax.swing.JLabel lblImmagineS1;
    private javax.swing.JLabel lblImmagineS2;
    private javax.swing.JLabel lblImmagineS3;
    private javax.swing.JLabel lblLedS1;
    private javax.swing.JLabel lblLedS2;
    private javax.swing.JLabel lblLedS3;
    private javax.swing.JLabel lblLivello;
    private javax.swing.JLabel lblMese;
    private javax.swing.JLabel lblPasticcere;
    private javax.swing.JLabel lblPrezzoS1;
    private javax.swing.JLabel lblPrezzoS2;
    private javax.swing.JLabel lblPrezzoS3;
    private javax.swing.JLabel lblProdotto1;
    private javax.swing.JLabel lblProdotto2;
    private javax.swing.JLabel lblProdotto3;
    private javax.swing.JLabel lblQuantitaS1;
    private javax.swing.JLabel lblQuantitaS2;
    private javax.swing.JLabel lblQuantitaS3;
    private javax.swing.JLabel lblR1CP;
    private javax.swing.JLabel lblR1CP1;
    private javax.swing.JLabel lblR1CP2;
    private javax.swing.JLabel lblR1CP3;
    private javax.swing.JLabel lblR1CProduzione;
    private javax.swing.JLabel lblR1Cliente;
    private javax.swing.JLabel lblR1L;
    private javax.swing.JLabel lblR1Level;
    private javax.swing.JLabel lblR1P;
    private javax.swing.JLabel lblR1Prezzo;
    private javax.swing.JLabel lblR2CProduzione;
    private javax.swing.JLabel lblR2Cliente;
    private javax.swing.JLabel lblR2L1;
    private javax.swing.JLabel lblR2Level;
    private javax.swing.JLabel lblR2P;
    private javax.swing.JLabel lblR2Prezzo;
    private javax.swing.JLabel lblR3CProduzione;
    private javax.swing.JLabel lblR3L;
    private javax.swing.JLabel lblR3Level;
    private javax.swing.JLabel lblR3P;
    private javax.swing.JLabel lblR3Prezzo;
    private javax.swing.JLabel lblR4CProduzione;
    private javax.swing.JLabel lblR4L;
    private javax.swing.JLabel lblR4Level;
    private javax.swing.JLabel lblR4P;
    private javax.swing.JLabel lblR4Prezzo;
    private javax.swing.JLabel lblSoldi;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlR1;
    private javax.swing.JPanel pnlR2;
    private javax.swing.JPanel pnlR3;
    private javax.swing.JPanel pnlR4;
    // End of variables declaration//GEN-END:variables
}
