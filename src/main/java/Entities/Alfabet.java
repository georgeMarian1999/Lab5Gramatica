package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Alfabet {
    private Vector<Simbol> simbolVector;

    public Alfabet(){
        simbolVector=new Vector<>();
        simbolVector.clear();
    }
    public Vector<Simbol> getSimbolVector() {
        return simbolVector;
    }
    public void setSimbolVector(Vector<Simbol> simbolVector) {
        this.simbolVector = simbolVector;
    }
    public void addSimbol(Simbol s){
        this.simbolVector.add(s);
    }
    public List<String> getListSimboluri(){
        List<String> simb=new ArrayList<>();
        for (int i = 0; i < simbolVector.size(); i++) {
            simb.add(simbolVector.get(i).getValue());
        }
        return simb;
    }
    public boolean isOnlyEps(){
        return (simbolVector.size()==1&&simbolVector.get(0).isEps());
    }
    public boolean containSimbol(Simbol S){
        for(Simbol s:simbolVector){
            if(s.equals(S))
                return true;
        }
        return false;
    }
    public boolean NeterminalPrimaPoz(){
        return simbolVector.get(0).getType()==TIPSimbol.NONTERMINAL;
    }
    public String toStringProd(){
        String s="";
        for(int i=0;i<simbolVector.size();i++){
            if(i!=simbolVector.size()-1)
                s=s+simbolVector.get(i).toString();
            else
                s=s+simbolVector.get(i).toString();
        }
        return s;
    }
    @Override
    public String toString() {
        String s="";
        for(int i=0;i<simbolVector.size();i++){
            if(i!=simbolVector.size()-1)
                s=s+simbolVector.get(i).toString()+",";
            else
                s=s+simbolVector.get(i).toString();
        }
        return s;
    }
}
