package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

/*konstruktor sa četiri parametra: početna tačka, krajnja tačka (obje tipa double),
boolean vrijednost koja označava da li početna tačka pripada intervalu ili ne, te isto i za krajnju
tačku; u slučaju da je početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException;*/
public class Interval {
    private double pocetak;
    private double kraj;
    private boolean ukljucen_Pocetak;
    private boolean ukljucen_kraj;
    public Interval(double pocetna_tacka,double krajnja_tacka,boolean pocetna_pripada,boolean krajnja_pripada){
        if(pocetna_tacka>krajnja_tacka)throw  new IllegalArgumentException("something just like this");
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
    public boolean isIn(double tacka){
        return ((tacka==pocetak && ukljucen_Pocetak) ||  (tacka==kraj && ukljucen_kraj) || (tacka>pocetak && tacka<kraj));
    }
    public Interval intersect(Interval drugi){
        double pocetna;
        double krajnja;
        boolean poc;
        boolean kr;
        if(this.pocetak<drugi.pocetak) {pocetna=drugi.pocetak; poc=drugi.ukljucen_Pocetak;}
        else {
            if(this.pocetak>drugi.pocetak){ pocetna=this.pocetak; poc=this.ukljucen_Pocetak;}
            else {pocetna=this.pocetak; if(this.ukljucen_Pocetak && drugi.ukljucen_kraj) poc=true; else poc=false; }
        }
        if(this.kraj>drugi.kraj) {krajnja=drugi.kraj; kr=drugi.ukljucen_kraj;}
        else {
            if(this.kraj<drugi.kraj){ krajnja=this.kraj; kr=this.ukljucen_kraj;}
            else {krajnja=this.kraj; if(this.ukljucen_kraj && drugi.ukljucen_kraj) kr=true; else kr=false; }
        }
        Interval i=new Interval(pocetna,krajnja,poc,kr);
        return i;
    }
    public static Interval intersect(Interval prvi, Interval drugi){
        double pocetna;
        double krajnja;
        boolean poc;
        boolean kr;
        if(prvi.pocetak<drugi.pocetak) {pocetna=drugi.pocetak; poc=drugi.ukljucen_Pocetak;}
        else {
            if(prvi.pocetak>drugi.pocetak){ pocetna=prvi.pocetak; poc=prvi.ukljucen_Pocetak;}
            else {pocetna=prvi.pocetak; if(prvi.ukljucen_Pocetak && drugi.ukljucen_kraj) poc=true; else poc=false; }
        }
        if(prvi.kraj>drugi.kraj) {krajnja=drugi.kraj; kr=drugi.ukljucen_kraj;}
        else {
            if(prvi.kraj<drugi.kraj){ krajnja=prvi.kraj; kr=prvi.ukljucen_kraj;}
            else {krajnja=prvi.kraj; if(prvi.ukljucen_kraj && drugi.ukljucen_kraj) kr=true; else kr=false; }
        }
        Interval i=new Interval(pocetna,krajnja,poc,kr);
        return i;
    }

    @Override
    public String toString() {
        if(this.isNull()) return "()";
        if(ukljucen_kraj && ukljucen_Pocetak) return "[" + pocetak +","+kraj+"]" ;
        if(ukljucen_kraj && !ukljucen_Pocetak) return "(" + pocetak +","+kraj+"]" ;
        if(!ukljucen_kraj && ukljucen_Pocetak) return "[" + pocetak +","+kraj+")" ;
        if(!ukljucen_kraj && !ukljucen_Pocetak) return "(" + pocetak +","+kraj+")" ;
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetak, pocetak) == 0 &&
                Double.compare(interval.kraj, kraj) == 0 &&
                ukljucen_Pocetak == interval.ukljucen_Pocetak &&
                ukljucen_kraj == interval.ukljucen_kraj;
    }

}
