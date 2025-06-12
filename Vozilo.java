import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class Vozilo implements Comparable<Vozilo>{ // klasu vozilo ce nasledjivati klase automobil,kombi,
                               //sva vozila osim elektricnih imace kubikazu
                               // u gui ce moci da se scrolluje kroz sve opcije za vozila, prikazuje se slika i pored je checkbox koji ako se cekira dodaje se cena iznajmljivanjna na ukupnu
    //ukupna cena iznajmljivanja racunace se pomocu tekstboxa u koji se unosi ceo broj dana na koliko se pozajmljuje vozilo *  cena vozila po danu
    // mogu i da postoje 2 radio buttona koji odredjuju da li se vozilo dovozi do kucne adrese(dodaje se na cenu 10%) ili osoba preuzima licno
    //da postoji padajuci meni koji odredjuje kako se sortiraju pretrazeni automobili.Npr po ceni rastuce i opadajuce.d

    //private Image slika;
    private BufferedImage slika;
    private String imagePath;

    private String modelVozila;
    private int brojDostupnih;
    private Double cenaPoDanu;
    private Marka marka;
    private Vrsta vrsta;
    private VrstaGoriva vrstaGoriva;
    public Vozilo(Marka marka,String modelVozila,Double cenaPoDanu, int brojDostupnih, VrstaGoriva vrstaGoriva,Vrsta vrstaVozila,String imagePath) {
        this.modelVozila = modelVozila;
        this.cenaPoDanu = cenaPoDanu; // ovo mozda mora da se promeni???? ipak vrv ne mora....
        this.brojDostupnih = brojDostupnih;
        this.marka = marka;
        this.vrsta = vrstaVozila;
        this.vrstaGoriva = vrstaGoriva;
        this.imagePath = imagePath;

        //this.slika = slika;
        //


    }

    public String getImagePath() {
        return imagePath;
    }

    public Double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public int getBrojDostupnih() {
        return brojDostupnih;
    }

    public String getModelVozila() {
        return modelVozila;
    }

    public Marka getMarka() {
        return marka;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public VrstaGoriva getVrstaGoriva() {
        return vrstaGoriva;
    }
    /*
    public static Comparator<Vozilo> PoredjenjeCene = new Comparator<Vozilo>() {
        @Override
        public int compare(Vozilo v1, Vozilo v2) {
            return v1.getCenaPoDanu().compareTo(v2.getCenaPoDanu());
        }
    };*/

    @Override
    public int compareTo(Vozilo o) { // ovo je ostalo kao visak // mozda za kasnije // hteo sam da imam mogucnost da sortiram modele automobila po ceni rastuce i opadajuce
        return this.cenaPoDanu.compareTo(o.cenaPoDanu);
    }




/*
    public static BufferedImage loadImage(String imagePath) {/////////////////////////////
        BufferedImage image = null;
        try {
            File file = new File(imagePath);
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        return image;
    }*/
/*
    public void ucitajSliku(Graphics g, String path){ ///////////////////ovaj koristim?
        ImageIcon imageIcon = new ImageIcon(path);
        g.drawImage(imageIcon.getImage(),0,0,400,350,null);
    }
*/
    @Override
    public String toString() { // cisto da je ima ali postoji sansa da je ne izkoristim
        return marka + " " + modelVozila ;
    }
}
