/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author bel22887
 */
public class Gestione {     
    
    FileReader f1 = null;
    BufferedReader fIN = null;
    
    FileWriter f2 = null;
    PrintWriter fOUT = null;
    
    private String[] italiano;
    private String[] inglese;
    private int nEstratto;
    
    //public boolean noFile = false; 
    //public boolean emptyFile = false;
    
    // ritorna un boolean: se true c'e' un errore, se false no.
    public boolean caricaLista() {    
        try {
            f1 = new FileReader("parole.txt");
            fIN = new BufferedReader(f1);
            
            try {
                int l = 0;
                while (fIN.readLine() != null) {
                    l++;
                }                
                f1.close();
                fIN.close();
                
                f1 = new FileReader("parole.txt");
                fIN = new BufferedReader(f1);

                italiano = new String[l];
                inglese = new String[l];            
            
                boolean stop = false;
                
                for (int i = 0; !stop; i++) {
                    String tmp = fIN.readLine();
                    if (tmp == null) {
                        stop = true;
                    }
                    else {
                    String s[] = tmp.split(";");
                    // 1: key - 2: value 
                    // 1: inglese - 2: italiano
                    inglese[i] = s[0];
                    italiano[i] = s[1];
                    }
                } 
            }
            catch (IOException ex) {
                return true;
            }
        }
        catch (FileNotFoundException ex) {
            return true;
        }  
        return false;
    }
    
    public int randomParola() {
        Random estrattore = new Random();        
        nEstratto = estrattore.nextInt(inglese.length);          
        return nEstratto;
    }
    
    public boolean controlla (int locazione, String parolaInglese, String parolaItaliano) {
        return (inglese[locazione].equalsIgnoreCase(parolaInglese) && italiano[locazione].equalsIgnoreCase(parolaItaliano));
    }
    
    public String getParolaIng (int n) {
        return inglese[n];
    }
    
    public String getParolaIta (int n) {
        return italiano[n];
    }
    
    public boolean aggiungiParola (String parolaIng, String parolaIta) {
        
        try {
            f2 = new FileWriter("parole.txt", true);
            fOUT = new PrintWriter(f2);
            
            //for (int i = 0; i < inglese.length; i++) {
            //    fOUT.print(inglese[i] + ";" + italiano[i]);
            //}
            fOUT.println("");
            fOUT.print(parolaIng + ";" + parolaIta);
            fOUT.close();
            f2.close();
        }
        catch (FileNotFoundException ex) {
            return true;
        }
        catch (IOException ex) {
            return true;
        }
        return false;
    }
        
}
