/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidades;

import java.util.ArrayList;

/**
 *
 * @author emayo
 */
public class Estado {
    public ArrayList<Integer> valoresSiguientes;
    public int idEstado;
    public ArrayList<Transicion> transicionesEstado;
    
    public Estado(){
        this.valoresSiguientes = new ArrayList<>();
        this.transicionesEstado = new ArrayList<>();
    }
    
      
    
}
