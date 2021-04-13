package Entities;

import java.util.Objects;

public class Simbol {
    private TIPSimbol type;
    private String value;

    public Simbol(){

    }
    public Simbol(TIPSimbol tip,String valoare){
        type=tip;
        value=valoare;
    }
    public boolean isEps(){
        return (value.equals("eps"));
    }
    public String getValue() {
        return value;
    }

    public TIPSimbol getType() {
        return type;
    }

    public void setType(TIPSimbol type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(Simbol o) {
        if(o.getType()==type&& o.getValue().equals(value))
            return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return value;
    }
}
