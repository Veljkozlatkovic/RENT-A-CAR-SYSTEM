import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class MainRAC extends JFrame {
    private final int sirina = 800;
    private final int visina =450;
    private JPanel mainpanel;
    private JButton prikaziDugme,filtrirajDugme,potvrdiDugme;
    private JRadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7; // za 7 Vrsta vozila u enumeraciji
    private ButtonGroup grupa; // za sve radiobittone
    private JComboBox comboBoxIzbor;
    private JTextField poljeDan;


    private JLabel /*slika,*/labelDostupni,labelCena,labelGorivo,labelzapreminaBrSedista, labelBrDana,labelUkupnaCena,labelNosivost; // mozda treba jos neki

    JScrollPane scrollPane;
    static ArrayList<Vozilo> Vozila = new ArrayList<Vozilo>();
    //napravicu for petlju koja prolazi kroz arraylistu objekata tipa vozilo i za svako vozilo ce da doda po jedan panel u vec postojeci panel i pomocu gridbag layout ce svi biti iste velicine i jedan ispod drugog
    //gridy = i; a i se povecava sa svakim objektom.
    // ako zelim slike automobila onda cu mozda morati da dodam i to u konstruktore
    public MainRAC(){
        setTitle("Rent-a-car");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(500,40, sirina,visina);

        //ArrayList<Vozilo> Vozila = new ArrayList<Vozilo>();
        mainpanel = new JPanel(new GridBagLayout());
        mainpanel.setBounds(200,50,400,visina-100);
        mainpanel.setBorder(LineBorder.createBlackLineBorder());
        mainpanel.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints(); /// ovo jos ne znam sta je
        c.gridx =0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        //TODO///////////////////////////////////////////////////////////////////////////////////////////////////////////

        //scrollPane = new JScrollPane(mainpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // JScrollPane scrollPane = new JScrollPane(mainpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setPreferredSize(new Dimension(400,visina-100));

        prikaziDugme = new JButton("PRIKAZI IZBOR");
        prikaziDugme.setBounds(10,350,150,50);
        prikaziDugme.setBackground(Color.ORANGE);

        filtrirajDugme = new JButton("Filtriraj");
        filtrirajDugme.setBounds(10,290,150,50);

        potvrdiDugme = new JButton("POTVRDI");
        potvrdiDugme.setBounds(610,350,150,50);
        potvrdiDugme.setBackground(Color.ORANGE);


        comboBoxIzbor = new JComboBox<Vozilo>();
        comboBoxIzbor.setBounds(200,10,400,30);


        radioButton1 = new JRadioButton(Vrsta.HEČBEK.name()); // ne radi :( if(radioButton1.isSelected()) radioButton1.setBackground(Color.ORANGE);
        radioButton2 = new JRadioButton(Vrsta.LIMUZINA.name());
        radioButton3 = new JRadioButton("KUPE/SPORT"/*Vrsta.KUPESPORT.name()*/);
        radioButton4 = new JRadioButton(Vrsta.KOMBI.name());
        radioButton5 = new JRadioButton(Vrsta.ČETVOROTOČKAŠ.name());
        radioButton6 = new JRadioButton(Vrsta.KAMIONET.name());
        radioButton7 = new JRadioButton(Vrsta.SUV.name());

        radioButton1.setBounds(10,50,140,25);
        radioButton2.setBounds(10,80,140,25);
        radioButton3.setBounds(10,110,140,25);
        radioButton4.setBounds(10,140,140,25);
        radioButton5.setBounds(10,170,140,25);
        radioButton6.setBounds(10,200,140,25);
        radioButton7.setBounds(10,230,140,25);

        grupa = new ButtonGroup();
        grupa.add(radioButton1);
        grupa.add(radioButton2);
        grupa.add(radioButton3);
        grupa.add(radioButton4);
        grupa.add(radioButton5);
        grupa.add(radioButton6);
        grupa.add(radioButton7);

        labelCena= new JLabel("Cena po danu:");
        labelCena.setBounds(610,50,150,25);

        labelDostupni = new JLabel("Broj dostupnih:");
        labelDostupni.setBounds(610,130,100,25);

        labelGorivo = new JLabel("Vrsta goriva:");
        labelGorivo.setBounds(610,80, 150,25);

        //labelzapreminaBrSedista = new JLabel("");
        //labelzapreminaBrSedista.setBounds(610,150,100,25);

        labelNosivost = new JLabel("");
        labelNosivost.setBounds(610,140,100,25);

        labelBrDana = new JLabel("Broj dana:");
        labelBrDana.setBounds(610,170,75,25 );

        poljeDan = new JTextField();
        poljeDan.setBounds(680,170,40,25);


        labelUkupnaCena = new JLabel("Ukupna cena:");
        labelUkupnaCena.setBounds(610,290,150,30);

        JLabel label = new JLabel("");

        // label.setIcon(new ImageIcon("saxo.jpg"));// ova slika iz nekog razloga radi????

        mainpanel.add(label);





        //u actionlisteneru za prikaziDugme ce svi filteri koje ubacujem da se primene, najveci problem trenutno pravi kako da prikazem u svom glavnom polju automobile.
        // ostale klase ce lako. Ali nakon toga treba i da napravim da se racuna ukupna vrednost koliko se placa, sa svim automobilima. Samo cu u cose da stavim za vece pozajmice pozovite +3816*-***-**-**

        //prvo moram da odaberem radiobuttone/checkboxove koji idu levo i mozda desno od glavnog polja



        //! za actionlistener za dugme ide nesto slicno kao u Poslednj Test -> mainDigitalnimediji ->red 66 samo umesto unutrasnjeg ifa koji ubaci to string, ide nov panel pa u njega sve sto treba da se ubaci

        filtrirajDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxIzbor.removeAllItems();
                if(radioButton1.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton1.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem(vozilo/*vozilo.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton2.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton2.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem(vozilo/*vozilo.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton3.isSelected()){ ///////////////////////////////////
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){//////////////////////
                        if(vozilo.getVrsta().name().equals(Vrsta.KUPESPORT.name())){ //nisam ovo morao da radim sa imenom ali sam hteo da se poklapa sa time kako sam radio ostatak
                            comboBoxIzbor.addItem(vozilo/*vozilo.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton4.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton4.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem(vozilo/*.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton5.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton5.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem(vozilo/*.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton6.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton6.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem(vozilo/*.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                if(radioButton7.isSelected()){
                    // int index = 0;
                    for(Vozilo vozilo : Vozila){
                        if(vozilo.getVrsta().name().equals(radioButton7.getText())){ // ako se poklapaju
                            comboBoxIzbor.addItem( vozilo/*vozilo.getMarka().name()+" "+vozilo.getModelVozila()*/);
                        }
                    }
                }
                            /*
                                /*
                                if(radioButton2.isSelected())
                                        for(Medij medij : sviMediji){
                                                if(!medij.DostupnostMedija())
                                                        padajucaLista.addItem(medij.toString());
                                        }*/
                // mainpanel.revalidate();
                // mainpanel.repaint();
            }
        });

        prikaziDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {/////////////////////////////////////////////////////////////////////
                //mainpanel.removeAll();
                Vozilo vozilo = (Vozilo) comboBoxIzbor.getSelectedItem();
                //ImageIcon imageIcon = new ImageIcon(vozilo.getImagePath());
                // JLabel imageLabel = new JLabel(imageIcon);
                // File file = new File(vozilo.getImagePath());


//                         najblize sto sam uspeo da dodjem do sad(pogledati red 118)
                //JLabel label = new JLabel("");
                ImageIcon imageIcon= new ImageIcon(vozilo.getImagePath());
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT));
                label.setIcon(imageIcon);// ova slika iz nekog razloga radi????

                labelBrDana.setText("Broj dana:");

                //if(vozilo.getVrsta() == Vrsta.KOMBI || vozilo.getVrsta() == Vrsta.KAMIONET){
// nisam siguran da moze tako kako sam zamislio  vozilo = new KombiKamionet();
                // }

                labelCena.setText("Cena po danu:");
                labelCena.setText(labelCena.getText() + vozilo.getCenaPoDanu() + "€");

                labelGorivo.setText("Vrsta goriva:"+ vozilo.getVrstaGoriva().name());// iz nekog razloga se ne prikazuje???

                labelDostupni.setText("Broj dostupnih:");
                labelDostupni.setText(labelDostupni.getText() + vozilo.getBrojDostupnih());
              //  labelGorivo.setVisible(true);
                //  mainpanel.add(label);
                //    label.setVisible(true);

                //mainpanel.revalidate();
                //mainpanel.repaint();


                //slika = new JLabel("");
                // slika.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("Expert.jpg"))));
                // mainpanel.add(slika,c);

                //mainpanel.add(slika);
                // mainpanel.add( vozilo.ucitajSliku(getComponent(visina).getGraphics() , vozilo.getImagePath()) );

                //treba da se stvori slika u panelu i desno sve osobine tog vozila
            }
        });
        potvrdiDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vozilo vozilo = (Vozilo) comboBoxIzbor.getSelectedItem();
                labelUkupnaCena.setText("Ukupna cena:");

                double ukupnaCena = vozilo.getCenaPoDanu() * Double.parseDouble(poljeDan.getText());
                labelUkupnaCena.setText(labelUkupnaCena.getText() + ukupnaCena +"€");
                JOptionPane.showMessageDialog(null,"Hvala na saradnji! :)" +
                        "\n Vaš dug je:" + ukupnaCena + "€");
                poljeDan.setText("");
            }
        });

        add(labelCena);
        add(labelGorivo);
        add(labelNosivost);
       // add(labelzapreminaBrSedista);
        add(labelDostupni);

        add(poljeDan);



        add(mainpanel);
        //add(scrollPane, BorderLayout.CENTER);
        add(prikaziDugme);
        add(filtrirajDugme);
        add(potvrdiDugme);
        add(labelUkupnaCena);
       // add(labelGorivo);
        add(labelBrDana);

        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
        add(radioButton4);
        add(radioButton5);
        add(radioButton6);
        add(radioButton7);
        add(comboBoxIzbor);

        setVisible(true);
    }

    public static void main(String[] args) {

        MainRAC mainRAC = new MainRAC();

        //Vozilo[] vozilos;
        Vozila.add(new KombiKamionet(Marka.PEUGEOT,"Expert",40.0,VrstaGoriva.DIZEL,Vrsta.KOMBI,4,1.4,6.6,"images/Expert.jpg"));
        Vozila.add(new KombiKamionet(Marka.RENAULT,"Kangoo",25.0,VrstaGoriva.DIZEL,Vrsta.KOMBI,10,0.65,1.4, "images/kangoo.jpg"));

        Vozila.add(new Automobil(Marka.CITROEN,"Saxo",20.0,10,VrstaGoriva.DIZEL,Vrsta.HEČBEK,5,"images/saxo.jpg"));
        Vozila.add(new Automobil(Marka.TOYOTA,"Corolla GR",35.0,5,VrstaGoriva.HIBRID,Vrsta.HEČBEK,5,"images/Corolla.jpg"));

        Vozila.add(new Automobil(Marka.MERCEDES,"E63 AMG",100.0,1,VrstaGoriva.BENZIN,Vrsta.LIMUZINA,5,"images/AMG-E63.jpg"));
        Vozila.add(new Automobil(Marka.MERCEDES,"G63",100.0,5,VrstaGoriva.BENZIN,Vrsta.SUV,5,"images/Gclass.jpg"));

        Vozila.add(new Automobil(Marka.MAZDA,"mx-5 ND",30.0,1,VrstaGoriva.BENZIN,Vrsta.KUPESPORT,2,"images/miata.jpg"));
        Vozila.add(new Automobil(Marka.ASTON_MARTIN,"Vantage GT",200.0,1,VrstaGoriva.BENZIN,Vrsta.KUPESPORT,2,"images/vantage.jpg"));

        Vozila.add(new Automobil(Marka.TOYOTA,"Century",50.0,2,VrstaGoriva.BENZIN,Vrsta.LIMUZINA,5,"images/century.jpg"));
        Vozila.add(new KombiKamionet(Marka.FORD,"Raptor F-150",50.0,VrstaGoriva.BENZIN,Vrsta.KAMIONET,4,0.6,1.5,"images/Raptor.jpg"));

        Vozila.add(new kvadBuggy(Marka.HONDA,"TRX-420",25.0,10,VrstaGoriva.BENZIN,Vrsta.ČETVOROTOČKAŠ,"images/HondaTRX.jpg"));
        Vozila.add(new kvadBuggy(Marka.HONDA,"Talon",30.0,4,VrstaGoriva.BENZIN,Vrsta.ČETVOROTOČKAŠ,"images/Talon.jpg"));
        Vozila.add(new Automobil(Marka.MG,"4 EV",35.0,5,VrstaGoriva.ELEKTRICNI,Vrsta.HEČBEK,5,"images/MG4.jpg"));







    }

}
