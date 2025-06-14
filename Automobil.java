import java.awt.image.BufferedImage;

public class Automobil extends Vozilo{
    private int brojSedista;

    public Automobil(Marka marka, String modelVozila, Double cenaPoDanu, int brojDostupnih, VrstaGoriva vrstaGoriva, Vrsta vrstaVozila, int brojSedista,String imagePath){
        super(marka,modelVozila,cenaPoDanu,brojDostupnih,vrstaGoriva,vrstaVozila,imagePath);
        this.brojSedista = brojSedista;
    }

    @Override
    public String getImagePath() {
        return super.getImagePath();
    }

    @Override
    public VrstaGoriva getVrstaGoriva() {
        return super.getVrstaGoriva();
    }

    @Override
    public String getModelVozila() {
        return super.getModelVozila();
    }

    @Override
    public int getBrojDostupnih() {
        return super.getBrojDostupnih();
    }

    @Override
    public Double getCenaPoDanu() {
        return super.getCenaPoDanu();
    }

    @Override
    public Vrsta getVrsta() {
        return super.getVrsta();
    }

    @Override
    public Marka getMarka() {
        return super.getMarka();
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
