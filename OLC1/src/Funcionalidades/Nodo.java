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
        this.primeros = new ArrayList<>();
        this.ultimos = new ArrayList<>();
        ValidarReglas();
    }

    public Nodo(int id, String valor, int id_hoja) {
        this.id = id;
        this.valor = valor;
        this.id_hoja = id_hoja;
        this.hoja_der = null;
        this.hoja_izq = null;
        this.primeros = new ArrayList<>();
        this.ultimos = new ArrayList<>();
        ValidarReglas();
    }
    
    private void ValidarReglas(){
        ReglaHoja();
        ReglaExpr();
    }
    
    public void ReglaHoja(){
         if((this.hoja_der == null) && (this.hoja_izq== null)){
        this.anulable = false;
        this.primeros.add(this.id_hoja);
        this.ultimos.add(this.id_hoja);
        }
    }
    
    public void ReglaExpr(){
        Anulabilidad();
        PrimerosUltimos();
       
    }
    
    public void Anulabilidad(){
         switch (this.valor) {
            case "*" -> {
                this.anulable = true;
            }
            case "+" -> {
                if (!this.hoja_izq.anulable) {
                    this.anulable = false;
                } else {
                    this.anulable = true;
                }
            }
            case "?" -> {
                this.anulable = true;
            }
            case "|" -> {
                this.anulable = (this.hoja_izq.anulable == true) || (this.hoja_der.anulable == true);
            }
            case "." -> {
                this.anulable = (this.hoja_izq.anulable == true) && (this.hoja_der.anulable == true);
            }
        }
    }
    
    public void PrimerosUltimos(){
        switch (this.valor) {
            case "*","+","?" -> {
                this.primeros.addAll(this.hoja_izq.primeros);
                this.ultimos.addAll(this.hoja_izq.ultimos);
            }           
            case "|" -> {
                this.primeros.addAll(this.hoja_izq.primeros);
                this.primeros.addAll(this.hoja_der.primeros);
                
                this.ultimos.addAll(this.hoja_izq.ultimos);
                this.ultimos.addAll(this.hoja_der.ultimos);
            }
            case "." -> {
                if(this.hoja_izq.anulable){
                    this.primeros.addAll(this.hoja_der.primeros);
                    this.primeros.addAll(this.hoja_izq.primeros);
                    
                   
                }else{
                    this.primeros.addAll(this.hoja_izq.primeros);
                }
                if(this.hoja_der.anulable){
                     this.ultimos.addAll(this.hoja_izq.ultimos);
                     this.ultimos.addAll(this.hoja_der.ultimos);
                }else{
                     this.ultimos.addAll(this.hoja_der.ultimos);
                }
            }
        }
    }
    
    public String obtenerCodigoNodo(){
        String codigoNodo= "";
        String valor_ = ("|".equals(this.valor) || "\"".equals(this.valor))? "\\" + this.valor:valor;
        if(this.valor.contains("\"")){
            valor_ = valor.replaceAll("\"", "");
        }
        
        codigoNodo = "nodo" + id + "[shape=record label =\""+ this.primeros.toString() +"|{"+ this.anulable + "|"+ valor_ + "| id:" + this.id_hoja + "}|" + this.ultimos.toString() +"\"" + "]\n";
        
        
        if(this.hoja_izq != null){
            codigoNodo += this.hoja_izq.obtenerCodigoNodo()+ "nodo" +this.id + "->nodo"+ this.hoja_izq.id +";\n";
        }
        if(this.hoja_der != null){
            codigoNodo += this.hoja_der.obtenerCodigoNodo()+ "nodo" +this.id + "->nodo"+ this.hoja_der.id +";\n";
        }
        return codigoNodo;
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
