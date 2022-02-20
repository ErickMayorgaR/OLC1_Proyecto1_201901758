/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import java.util.ArrayList;

/**
 *
 * @author emayo
 */
public class Nodo {
    public Nodo hoja_izq;
    public Nodo hoja_der;
    public int id;
    public String valor;
    public boolean anulable;
    public ArrayList<Integer> primeros;
    public ArrayList <Integer> ultimos;
    public int id_hoja;

    public Nodo(Nodo hoja_izq, Nodo hoja_der, int id, String valor, int id_hoja) {
        this.hoja_izq = hoja_izq;
        this.hoja_der = hoja_der;
        this.id = id;
        this.valor = valor;
        this.id_hoja = id_hoja;
    }

    public Nodo(int id, String valor, int id_hoja) {
        this.id = id;
        this.valor = valor;
        this.id_hoja = id_hoja;
    }

    public Nodo getHoja_izq() {
        return hoja_izq;
    }

    public void setHoja_izq(Nodo hoja_izq) {
        this.hoja_izq = hoja_izq;
    }

    public Nodo getHoja_der() {
        return hoja_der;
    }

    public void setHoja_der(Nodo hoja_der) {
        this.hoja_der = hoja_der;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(ArrayList<Integer> primeros) {
        this.primeros = primeros;
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public void setUltimos(ArrayList<Integer> ultimos) {
        this.ultimos = ultimos;
    }

    public int getId_hoja() {
        return id_hoja;
    }

    public void setId_hoja(int id_hoja) {
        this.id_hoja = id_hoja;
    }
    
    
    
    
}
