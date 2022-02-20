/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author emayo
 */
public class generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generar_Analizador();
        
    }
    
    private static void Generar_Analizador(){
        
        try{
            String ruta = "src/Analizador/";
            String opcFlex[] = {ruta + "Lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "sintactico", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
