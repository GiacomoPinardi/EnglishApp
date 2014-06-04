/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StatisticheGraphic.java
 *
 * Created on 3-giu-2014, 8.37.32
 */
package englishapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author bel22887
 */
public class StatisticheGraphic extends javax.swing.JFrame {

    //boolean noFile = false;
    // statistiche[0] = totali ; statistiche[1] = corrette ; statistiche[2] = incorrette
    int statistiche[] = new int[3];
    
    FileReader f1 = null;
    BufferedReader fIN = null;
        
    FileWriter f2 = null;
    PrintWriter fOUT = null;       

    @Override
    public void setTitle(String string) {
        super.setTitle("EnglishApp - Statistiche"); //To change body of generated methods, choose Tools | Templates.
    }
    /** Creates new form StatisticheGraphic */
    public StatisticheGraphic() {
        initComponents();   
        
        if (this.leggiFile()) {
            JOptionPane.showMessageDialog(rootPane, "Il file relativo alle statistiche non esiste oppure e' vuoto!", "Errore!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            this.setInterfaccia();
        }
    }
    
    // valora indica se azzerare le statistiche (0), incrementare una parola tradotta correttamente (1) o inserire uno sbaglio (2).
    public boolean cambia (int valore) {
        try {
            f2 = new FileWriter("statistiche.txt");
            fOUT = new PrintWriter(f2);
            
            switch (valore) {
                case 0:                   
                    fOUT.print("0;0;0;");                                                          
                    break;
                case 1:
                    statistiche[0] = statistiche[0] + 1;
                    statistiche[1] = statistiche[1] + 1;
                    fOUT.print(String.valueOf(statistiche[0]) + ";" + String.valueOf(statistiche[1]) + ";" + String.valueOf(statistiche[2]));
                    break;
                case 2:
                    statistiche[0] = statistiche[0] + 1;
                    statistiche[2] = statistiche[2] + 1;
                    fOUT.print(String.valueOf(statistiche[0]) + ";" + String.valueOf(statistiche[1]) + ";" + String.valueOf(statistiche[2]));
                    break;
            }
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
    
    public boolean leggiFile() {
        try {
            f1 = new FileReader("statistiche.txt");
            fIN = new BufferedReader(f1);
            
            String s = fIN.readLine();
            String stats[];
            stats = s.split(";");
            
            statistiche[0] = Integer.parseInt(stats[0]);
            statistiche[1] = Integer.parseInt(stats[1]);
            statistiche[2] = Integer.parseInt(stats[2]);
        }
        catch (FileNotFoundException ex) {
            return true;
        }
        catch (IOException ex) {
            return true;
        }
        return false;
    }
    
    public void setInterfaccia() {

        jLabel6.setText(String.valueOf(statistiche[0]));
        jLabel7.setText(String.valueOf(statistiche[1]));
        jLabel8.setText(String.valueOf(statistiche[2]));

        int tmp1 = statistiche[1];
        int tmp2 = statistiche[0];

        float tmp;
        
        if (tmp2 != 0) {
            tmp = (tmp1 * 100) / tmp2;
        }
        else {
            tmp = 0;
        }

        jLabel9.setText(String.valueOf(tmp) + " %");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Parole totali:");

        jLabel2.setText("Parole esatte:");

        jLabel3.setText("Parole errate:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel4.setText("Statistiche");

        jLabel5.setText("Percentuale successo:");

        jButton1.setText("Azzera statistiche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(60, 60, 60)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (this.cambia(0)) {
        JOptionPane.showMessageDialog(rootPane, "Il file relativo alle statistiche non esiste o e' vuoto!", "Errore!", JOptionPane.ERROR_MESSAGE);
    }
    this.leggiFile();
    this.setInterfaccia();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
