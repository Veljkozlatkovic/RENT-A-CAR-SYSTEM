public class kvadBuggy extends Vozilo{
    public kvadBuggy(Marka marka,String modelVozila,Double cenaPoDanu, int brojDostupnih, VrstaGoriva vrstaGoriva,Vrsta vrstaVozila,String imagePath) {
       super(marka,modelVozila,cenaPoDanu,brojDostupnih,vrstaGoriva,vrstaVozila,imagePath);

    }

    @Override
    public String getImagePath() {
        return super.getImagePath();
    }

    @Override
    public Double getCenaPoDanu() {
        return super.getCenaPoDanu();
    }

    @Override
    public int getBrojDostupnih() {
        return super.getBrojDostupnih();
    }

    @Override
    public Marka getMarka() {
        return super.getMarka();
    }

    @Override
    public Vrsta getVrsta() {
        return super.getVrsta();
    }

    @Override
    public String getModelVozila() {
        return super.getModelVozila();
    }

    @Override
    public VrstaGoriva getVrstaGoriva() {
        return super.getVrstaGoriva();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
