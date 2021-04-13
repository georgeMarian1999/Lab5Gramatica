package Entities;

import java.util.Vector;

public class Productie {
    private Simbol from;
    private Alfabet to;

    public Productie(){
        to=new Alfabet();
    }
    public Productie(Simbol From){
        from=From;
        to=new Alfabet();
    }

    public boolean toEps(){
        return to.isOnlyEps();
    }

    public Simbol getFrom() {
        return from;
    }

    public boolean NeterminalPrimaPoz(){
        return to.NeterminalPrimaPoz();
    }

    public void setFrom(Simbol from) {
        this.from = from;
    }

    public void setTo(Alfabet to) {
        this.to = to;
    }

    public Alfabet getTo() {
        return to;
    }

    @Override
    public String toString() {
        String s=from.toString()+"->";
        s=s+to.toStringProd()+";";
        return s;
    }
}
