/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1;

import java.util.ArrayList;
import Funcionalidades.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Analizadores.*;
import Funcionalidades.*;
import java.util.function.Consumer;
/**
 *
 * @author emayo
 */
public class Interfaz extends javax.swing.JFrame {
    public static ArrayList<Error_> listaErrores;
    public ArrayList<Arbol> listaArboles; 
    public ArrayList<Conjunto> listaConjuntos;
    public ArrayList<Validar> listaValidar;
    public String rutaAbiertaActual;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        generarCarpetas();
    }
    
    private void generarCarpetas(){
        generarCarpeta("../ARBOLES_201901758");
        generarCarpeta("../AFND_201901758");
        generarCarpeta("../SIGUIENTES_201901758");
        generarCarpeta("../TRANSICIONES_201901758");
        generarCarpeta("../AFD_201901758");
        generarCarpeta("../ERRORES_201901758");
        generarCarpeta("../SALIDAS_201901758");
    
    }
    
    private void generarCarpeta(String carpeta){
        File file;
        file = new File(carpeta);
        if(!file.isDirectory()) {
            file.mkdirs();
        }
    }    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entradaTextArea = new javax.swing.JTextArea();
        GenerarAutomadaButton = new javax.swing.JButton();
        AnalizarEntradaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salidaTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        xml_salida = new javax.swing.JMenu();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_Abrir = new javax.swing.JMenuItem();
        menu_guardar = new javax.swing.JMenuItem();
        menu_guardar_como = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Archivo de Entrada");

        entradaTextArea.setColumns(20);
        entradaTextArea.setRows(5);
        jScrollPane1.setViewportView(entradaTextArea);

        GenerarAutomadaButton.setText("Generar Automata");
        GenerarAutomadaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarAutomadaButtonActionPerformed(evt);
            }
        });

        AnalizarEntradaButton.setText("Analizar Entrada");
        AnalizarEntradaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarEntradaButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Salida");

        salidaTextArea.setColumns(20);
        salidaTextArea.setRows(5);
        jScrollPane2.setViewportView(salidaTextArea);

        jButton3.setText("Arboles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Siguientes");

        jButton5.setText("Transiciones");

        jButton6.setText("Automatas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(GenerarAutomadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AnalizarEntradaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GenerarAutomadaButton)
                            .addComponent(AnalizarEntradaButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        xml_salida.setText("Archivo");

        menu_nuevo.setText("Nuevo");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        xml_salida.add(menu_nuevo);

        menu_Abrir.setText("Abrir");
        menu_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_AbrirActionPerformed(evt);
            }
        });
        xml_salida.add(menu_Abrir);

        menu_guardar.setText("Guardar");
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        xml_salida.add(menu_guardar);

        menu_guardar_como.setText("Guardar Como");
        menu_guardar_como.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardar_comoActionPerformed(evt);
            }
        });
        xml_salida.add(menu_guardar_como);

        jMenuItem1.setText("Generar XML de Salida");
        xml_salida.add(jMenuItem1);

        jMenuBar1.add(xml_salida);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_guardar_comoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardar_comoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_guardar_comoActionPerformed

    private void AnalizarEntradaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarEntradaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnalizarEntradaButtonActionPerformed

    private void GenerarAutomadaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarAutomadaButtonActionPerformed
        // TODO add your handling code here:
        Interfaz.listaErrores = new ArrayList<Error_>();
        this.listaArboles = new ArrayList<Arbol>();
        usarAnalizadores();
    }//GEN-LAST:event_GenerarAutomadaButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_guardarActionPerformed

    private void menu_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_AbrirActionPerformed
        // ----> Abrir Archivo <-------
        FileReader fr =null;
        BufferedReader br = null;
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setVisible(true);
        selectorArchivo.setMultiSelectionEnabled(false);
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(null,"exp");
        System.out.println("Hizo Algo");
        selectorArchivo.setFileFilter(filtro);
        
        if(selectorArchivo.showDialog(null,null)==JFileChooser.APPROVE_OPTION){
            File file = selectorArchivo.getSelectedFile();
            this.rutaAbiertaActual = file.getAbsolutePath();
            try{
                //----> Leer Archivo y meter informacion, funcion Abrir 
                String doc = "";
                String linea;
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                
                while((linea = br.readLine())!= null){
                    doc +=linea + "\n";
                }
                this.entradaTextArea.setText(doc);
                
                
            }catch(IOException e){
            }
        }else{
            JOptionPane.showMessageDialog(null,"Extension Incorrecta");
        }        
    }//GEN-LAST:event_menu_AbrirActionPerformed

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        // TODO add your handling code here:
        JFileChooser selectorCarpeta = new JFileChooser();
        selectorCarpeta.setDialogTitle("Por favor seleccione la carpeta para generar un nuevo archivo");
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorCarpeta.setAcceptAllFileFilterUsed(false);
        System.out.println();
        if(selectorCarpeta.showDialog(null,null)== JFileChooser.APPROVE_OPTION){
            File file = selectorCarpeta.getSelectedFile();

            String ruta = file.getAbsolutePath();
            String nombre = JOptionPane.showInputDialog("Por favor ingrese un nombre para su nuevo documento", null);
            String rutaCompleta = ruta + "\\" + nombre + ".exp";

            File fileCreado = new File(rutaCompleta);
            this.entradaTextArea.setText("");
            this.salidaTextArea.setText("");
            this.rutaAbiertaActual = rutaCompleta;

            try {
                fileCreado.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrio un Error");
            }

            System.out.println(rutaCompleta);
        }      
    }//GEN-LAST:event_menu_nuevoActionPerformed
    
    public void usarAnalizadores() {
        if (!"".equals(entradaTextArea.getText())) {
            try {
                parser sintacticoA;
                sintacticoA = new parser(new Lexico(new StringReader(this.entradaTextArea.getText())));
                sintacticoA.parse();
                if (Interfaz.listaErrores.isEmpty()) {
                    this.listaArboles = sintacticoA.arboles;
                    this.listaConjuntos = sintacticoA.conjuntos;
                    this.listaValidar = sintacticoA.lista_validar;
                    for(Arbol unArbol: this.listaArboles){
                        unArbol.graficarArbol();
                        //unArbol.generarAFD();
                        unArbol.generarSiguientes();
                        unArbol.generarTransiciones();
                    }
                    

                } else {
                }
            } catch (Exception ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Informacion de Entrada");
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
    private javax.swing.JButton AnalizarEntradaButton;
    private javax.swing.JButton GenerarAutomadaButton;
    private javax.swing.JTextArea entradaTextArea;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menu_Abrir;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenuItem menu_guardar_como;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JTextArea salidaTextArea;
    private javax.swing.JMenu xml_salida;
    // End of variables declaration//GEN-END:variables

   

}
