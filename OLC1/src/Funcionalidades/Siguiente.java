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
public class Siguiente {
    int id;
    public String valorRama;
    public ArrayList<Integer> siguientes;

    public Siguiente(int id) {
        this.id = id;
        this.siguientes = new ArrayList<>();
    }   
    
    //Metodo para agregar no repetidos
    public void agregarSiguiente(int valorAgregar) {
        boolean repetido = false;
        for (int valorLista : this.siguientes) {
            if (valorLista == valorAgregar) {
                repetido = true;
                break;
            }
        }
        if (!repetido) {
            siguientes.add(valorAgregar);
        }
    }
    
}
