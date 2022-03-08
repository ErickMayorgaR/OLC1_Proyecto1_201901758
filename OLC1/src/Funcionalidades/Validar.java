/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

/**
 *
 * @author emayo
 */
public class Validar {
    String entrada;
    String cadena;

    public Validar(String expresion, String cadena) {
        this.entrada = expresion;
        this.cadena = cadena;
    }

    public String getExpresion() {
        return entrada;
    }

    public void setExpresion(String expresion) {
        this.entrada = expresion;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
    
}
