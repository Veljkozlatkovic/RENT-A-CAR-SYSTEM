import com.sun.tools.javac.Main;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainRAC extends JFrame {
        private final int sirina = 800;
        private final int visina =450;
        private JPanel mainpanel;
        private JButton prikaziDugme;
        private JRadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7; // za 7 Vrsta vozila u enumeraciji
        private ButtonGroup grupa; // za sve radiobittone
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


                mainpanel.setBorder(LineBorder.createBlackLineBorder());
                GridBagConstraints c = new GridBagConstraints(); /// ovo jos ne znam sta je

                scrollPane = new JScrollPane(mainpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               // JScrollPane scrollPane = new JScrollPane(mainpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                //scrollPane.setPreferredSize(new Dimension(400,visina-100));
            scrollPane.setViewportView (mainpanel);
            scrollPane.setBounds(200,50,400,visina-100);
                prikaziDugme = new JButton("PRIKAZI");
                prikaziDugme.setBounds(620,350,100,50);

                radioButton1 = new JRadioButton(Vrsta.HEČBEK.name());
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



                //u actionlisteneru za prikaziDugme ce svi filteri koje ubacujem da se primene, najveci problem trenutno pravi kako da prikazem u svom glavnom polju automobile.
                // ostale klase ce lako. Ali nakon toga treba i da napravim da se racuna ukupna vrednost koliko se placa, sa svim automobilima. Samo cu u cose da stavim za vece pozajmice pozovite +3816*-***-**-**

                //prvo moram da odaberem radiobuttone/checkboxove koji idu levo i mozda desno od glavnog polja



                //! za actionlistener za dugme ide nesto slicno kao u Poslednj Test -> mainDigitalnimediji ->red 66 samo umesto unutrasnjeg ifa koji ubaci to string, ide nov panel pa u njega sve sto treba da se ubaci

                prikaziDugme.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                mainpanel.removeAll();
                                if(radioButton1.isSelected()){
                                        int index = 0;
                                        for(Vozilo vozilo : Vozila){
                                                if(vozilo.getVrsta().name().equals(radioButton1.getText())){
                                                        JPanel voziloPanel = new JPanel(new GridBagLayout());
                                                        voziloPanel.setBorder(LineBorder.createBlackLineBorder());
                                                    voziloPanel.setPreferredSize(new Dimension(350, 60));
                                                    voziloPanel.add(new JLabel(vozilo.getMarka() + " " + vozilo.getModelVozila() + " (" + vozilo.getVrsta().name() + ")"));

                                                    GridBagConstraints panelConstr = new GridBagConstraints();
                                                        panelConstr.fill = GridBagConstraints.HORIZONTAL;
                                                        panelConstr.weightx = 0.5;
                                                        panelConstr.gridx = 0;
                                                        panelConstr.insets = new Insets(2, 2, 2, 2); // da vidim sta ce da uradi
                                                        panelConstr.gridy = index;
                                                        mainpanel.add(voziloPanel,panelConstr); ///// ne prikazuje se ovo sto sam dodao ovde iz nekog razloga!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1




                                                        index++;
                                                        //add(voziloPanel);

                                                }
                                        }
                                }       /*
                                if(radioButton2.isSelected())
                                        for(Medij medij : sviMediji){
                                                if(!medij.DostupnostMedija())
                                                        padajucaLista.addItem(medij.toString());
                                        }*/
                            mainpanel.revalidate();
                            mainpanel.repaint();
                        }
                });


                add(mainpanel);
                 add(scrollPane, BorderLayout.CENTER);
                add(prikaziDugme);
                add(radioButton1);
                add(radioButton2);
                add(radioButton3);
                add(radioButton4);
                add(radioButton5);
                add(radioButton6);
                add(radioButton7);


                setVisible(true);
        }

        public static void main(String[] args) {

                MainRAC mainRAC = new MainRAC();


                //Vozilo[] vozilos;
                Vozila.add(new KombiKamionet(Marka.PEUGEOT,"Expert",40.0,VrstaGoriva.DIZEL,Vrsta.KOMBI,4,1.4,6.6));
                Vozila.add(new Automobil(Marka.CITROEN,"Saxo",20.0,10,VrstaGoriva.DIZEL,Vrsta.HEČBEK,5));




        }

}
