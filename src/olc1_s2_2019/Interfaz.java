/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_s2_2019;

import Analisis.parser;
import Analisis.scanner;
import AnalisisHTML.parserHTML;
import AnalisisHTML.scannerHTML;
import Dibujador.dibujador;
import Interprete.Interprete;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilidades.*;

/**
 *
 * @author erick
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        botonRun1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[OLC1] Sección C");

        botonRun.setText("Analizar");
        botonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRunActionPerformed(evt);
            }
        });

        txtInput.setColumns(20);
        txtInput.setRows(5);
        txtInput.setText("claves = [\"nombre\", \"carnet\", \"total\"];");
        jScrollPane1.setViewportView(txtInput);

        txtOutput.setBackground(new java.awt.Color(0, 0, 0));
        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txtOutput.setForeground(new java.awt.Color(255, 255, 255));
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        botonRun1.setText("Analizar HTML");
        botonRun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRun1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRun1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(botonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(botonRun1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRunActionPerformed
        Analizar();
    }//GEN-LAST:event_botonRunActionPerformed

    private void botonRun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRun1ActionPerformed
        AnalizarHTML();
    }//GEN-LAST:event_botonRun1ActionPerformed

    
    public void AnalizarHTML()
    {
        Singlenton.listaErrores.clear();
        this.txtOutput.setText("-------------Iniciando Analisis----------------");//Limpiamos la consola de salida.
        
        try 
        {
            String input = txtInput.getText();
            scannerHTML analizadorLexico = new scannerHTML(new BufferedReader(new StringReader(input)));        
            parserHTML analizadorSintactico = new parserHTML(analizadorLexico);                        
            analizadorSintactico.parse();
            
            

            txtOutput.setText(txtOutput.getText()  +"\n" + analizadorLexico.lexemas);
            this.setTitle(analizadorSintactico.titulo);
            
            /*Imprimimos los tokens*/
            
            /*Imprimir errores*/
            for(ErrorC e: Singlenton.listaErrores)
            {
                txtOutput.setText(txtOutput.getText()  +"\n" + e.valor + "\t" + e.descripcion +"\t" + e.linea +"\t" + e.columna +"\t" +e.archivo);
            }
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void Analizar()
    {
        Singlenton.listaErrores.clear();
        this.txtOutput.setText("-------------Iniciando Analisis----------------");//Limpiamos la consola de salida.
        
        try 
        {
            String input = txtInput.getText();
            scanner analizadorLexico = new scanner(new BufferedReader(new StringReader(input)));        
            parser analizadorSintactico = new parser(analizadorLexico);                        
            analizadorSintactico.parse();
            
            
            if(analizadorSintactico.raizAST!=null)
            {
                dibujador dib = new dibujador();
                dib.generarGrafica(analizadorSintactico.raizAST);
                Interprete inter = new Interprete(analizadorSintactico.raizAST);
                inter.comenzar();
            }
            
            for(String clave: analizadorSintactico.listaClaves)
            {
                txtOutput.setText(txtOutput.getText()  +"\n" + "Clave encontrada : \t " + clave);
            }
            
            /*Imprimimos los tokens*/
            
            /*Imprimir errores*/
            for(ErrorC e: Singlenton.listaErrores)
            {
                txtOutput.setText(txtOutput.getText()  +"\n" + e.valor + "\t" + e.descripcion +"\t" + e.linea +"\t" + e.columna +"\t" +e.archivo);
            }
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRun;
    private javax.swing.JButton botonRun1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
