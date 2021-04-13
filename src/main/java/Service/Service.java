package Service;

import Entities.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Gramatica gramatica;

    public Service(){
        gramatica=new Gramatica();
    }

    public Gramatica getGramatica() {
        return gramatica;
    }
    public String Terminale(){
        return gramatica.Terminale();
    }
    public String NonTerminale(){
        return gramatica.NonTerminale();
    }
    public String Productii(){
        return gramatica.Productii();
    }
    public String SimbStart(){
        return gramatica.SimbStart();
    }
    public List<String> getListNeterminale(){
        return gramatica.getListNeterminale();
    }
    public void setGramatica(Gramatica gramatica) {
        this.gramatica = gramatica;
    }
    public void ReadFromFile(String path) throws IOException {
        Path fileName = Path.of(path);
        List<String> file=new ArrayList<>();
        String aux= Files.readString(fileName);
        String[] aux3,aux4,aux5,tofrom,from;
        String aux2[]=aux.split("\\r?\\n");
        aux3=aux2[0].split(",");
        for(int i=0;i< aux3.length;i++){
            Simbol NeTerminal=new Simbol(TIPSimbol.NONTERMINAL,aux3[i]);
            gramatica.AddSimbolNeterminal(NeTerminal);
        }
        Simbol Start=new Simbol(TIPSimbol.NONTERMINAL,aux2[1]);
        gramatica.setSimbolStart(Start);
        aux4=aux2[2].split(",");
        for(int i=0;i< aux4.length;i++){
            Simbol Terminal=new Simbol(TIPSimbol.TERMINAL,aux4[i]);
            gramatica.AddSimbolTerminal(Terminal);
        }
        aux5=aux2[3].split(";");
        for(int i=0;i< aux5.length;i++){
            tofrom=aux5[i].split("-");
            Productie P=new Productie(new Simbol(TIPSimbol.NONTERMINAL,tofrom[0]));
            from=tofrom[1].split(",");
            Alfabet ToAlfabet=new Alfabet();
            for (String s : from) {

                if (isStringUpperCase(s)){
                    System.out.println("S a gasit simbol terminal "+s);
                    ToAlfabet.addSimbol(new Simbol(TIPSimbol.NONTERMINAL, s));
                }
                else {ToAlfabet.addSimbol(new Simbol(TIPSimbol.TERMINAL, s));
                    if(!gramatica.getSimboluriTerminale().containSimbol(new Simbol(TIPSimbol.TERMINAL, s))&&!(new Simbol(TIPSimbol.TERMINAL, s)).isEps())
                        gramatica.AddSimbolTerminal(new Simbol(TIPSimbol.TERMINAL, s));
                    System.out.println("S a gasit simbol nonterminal "+s);
                    }
            }
            P.setTo(ToAlfabet);
            gramatica.AddProductie(P);
        }
    }
    private static boolean isStringUpperCase(String str){

        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }

        return true;
    }
    public String getProductiiForSimbol(String value){
        return gramatica.getProductiiForSimbol(value);
    }
    public boolean chechReg(){
        return gramatica.checkReg();
    }
    public List<Productie> ProductiiSimbol(Simbol S){
        List<Productie> productieList=new ArrayList<>();
        for (int i = 0; i < gramatica.getProductii().size(); i++) {
            if(gramatica.getProductii().get(i).getFrom().equals(S))
                productieList.add(gramatica.getProductii().get(i));
        }
        return productieList;
    }
}
