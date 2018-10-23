package ba.unsa.etf.rpr.tutorijal02;
/*konstruktor sa četiri parametra: početna tačka, krajnja tačka (obje tipa double),
boolean vrijednost koja označava da li početna tačka pripada intervalu ili ne, te isto i za krajnju
tačku; u slučaju da je početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException;*/
public class Interval {
    private double pocetak;
    private double kraj;
    private boolean ukljucen_Pocetak;
    private boolean ukljucen_kraj;
    public Interval(double pocetna_tacka,double krajnja_tacka,boolean pocetna_pripada,boolean krajnja_pripada){
        if(pocetna_tacka>krajnja_tacka)throw IllegalArgumentException;
        pocetak=pocetna_tacka;
        kraj=krajnja_tacka;
        ukljucen_Pocetak=pocetna_pripada;
        ukljucen_kraj=krajnja_pripada;

    }
    public Interval(){
        pocetak=0;
        kraj=0;
        ukljucen_kraj=false;
        ukljucen_Pocetak=false;
    }
    public boolean isNull(){
        return ( pocetak==0 &&    kraj==0 &&   ukljucen_kraj==false &&  ukljucen_Pocetak==false);
    }
}
