public class KombiKamionet extends Vozilo{// ova dva su spojena jer oba imaju nosivost i zapreminu
    private double nosivostUTonama;
    private double zapremina;

    public KombiKamionet(Marka marka,String modelVozila,double cenaPoDanu, VrstaGoriva vrstaGoriva,Vrsta vrstaVozila, int brojDostupnih,double nosivostUTonama, double zapremina){
        super(marka,modelVozila,cenaPoDanu,brojDostupnih,vrstaGoriva,vrstaVozila);
        this.nosivostUTonama = nosivostUTonama;
        this.zapremina = zapremina;
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
    public String getModelVozila() {
        return super.getModelVozila();
    }

    public double getNosivostUTonama() {
        return nosivostUTonama;
    }

    public double getZapremina() {
        return zapremina;
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
    public VrstaGoriva getVrstaGoriva() {
        return super.getVrstaGoriva();
    }

    @Override
    public String toString() {
        return super.toString() + " Nosivost(T):" + nosivostUTonama + " Zapremina(m^3):" + zapremina ;
    }
}
