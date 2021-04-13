package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Gramatica {
    private Alfabet SimboluriNeTerminale;
    private Alfabet SimboluriTerminale;
    private Vector<Productie> Productii;
    private Simbol SimbolStart;

    public Gramatica(){
        Productii=new Vector<>();
        SimboluriNeTerminale=new Alfabet();
        SimboluriTerminale=new Alfabet();
        SimbolStart=new Simbol();
    }
    public List<Simbol> SimboluriToEps(){
        List<Simbol> simbols=new ArrayList<>();
        for(Productie p:Productii){
            if(p.toEps()){
                simbols.add(p.getFrom());
            }
        }
        return simbols;
    }
    public Gramatica(Simbol start,Alfabet SimboluriNeT,Alfabet SimboluriT){
        SimbolStart=start;
        SimboluriNeTerminale=SimboluriNeT;
        SimboluriTerminale=SimboluriT;
    }
    public List<String> getListNeterminale(){
       return SimboluriNeTerminale.getListSimboluri();
    }
    public String getProductiiForSimbol(String value){
        String s="";
        for (int i = 0; i < Productii.size(); i++) {
            if(Productii.get(i).getFrom().getType()==TIPSimbol.NONTERMINAL&&Productii.get(i).getFrom().getValue().equals(value)){
                s=s+Productii.get(i).toString()+"\n";
            }
        }
        return s;
    }

    public Alfabet getSimboluriNeTerminale() {
        return SimboluriNeTerminale;
    }

    public Alfabet getSimboluriTerminale() {
        return SimboluriTerminale;
    }

    public Simbol getSimbolStart() {
        return SimbolStart;
    }

    public Vector<Productie> getProductii() {
        return Productii;
    }

    public void setProductii(Vector<Productie> productii) {
        Productii = productii;
    }

    public void setSimbolStart(Simbol simbolStart) {
        SimbolStart = simbolStart;
    }

    public void setSimboluriNeTerminale(Alfabet simboluriNeTerminale) {
        SimboluriNeTerminale = simboluriNeTerminale;
    }

    public void setSimboluriTerminale(Alfabet simboluriTerminale) {
        SimboluriTerminale = simboluriTerminale;
    }
    public void AddSimbolNeterminal(Simbol s){
        this.SimboluriNeTerminale.addSimbol(s);
    }
    public void AddSimbolTerminal(Simbol s){
        this.SimboluriTerminale.addSimbol(s);
    }
    public void AddProductie(Productie P){
        this.Productii.add(P);
    }
    public String Terminale(){
        return SimboluriTerminale.toString();
    }
    public String NonTerminale(){
        return SimboluriNeTerminale.toString();
    }
    public String Productii(){
        String s="";
        for(int i=0;i<Productii.size();i++){
            s=s+Productii.get(i).toString()+"\n";
        }
        return s;
    }
    public String SimbStart(){
        return SimbolStart.toString();
    }
    @Override
    public String toString() {
        String s="Simboluri Neterminale:"+SimboluriNeTerminale.toString()+"\n";
        s=s+"Simboluri Terminale:"+SimboluriTerminale.toString()+"\n";
        s=s+"Simbol de start:"+SimbolStart.toString()+"\n";
        s=s+"Productiile:";
        for(int i=0;i<Productii.size();i++){
            s=s+Productii.get(i).toString()+"\n";
        }
        return s;
    }

    public boolean checkReg() {
        for(Simbol s:SimboluriToEps()){
            for(Productie p:Productii){
                if(p.getTo().containSimbol(s))
                    return false;
            }
        }
        for(Productie p:Productii){
            if(p.NeterminalPrimaPoz())
                return false;
        }
        return true;
    }
}
