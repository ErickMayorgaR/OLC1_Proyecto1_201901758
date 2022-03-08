/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emayo
 */
public class Arbol {
    public Nodo raiz;
    public String nombre;
    public int contadorS;
    
    public int contadorEstado;
    public boolean crearEstadoNuevo;
    public ArrayList<Integer> sigEstadoNuevo;
    
    public int contadorTransicionEstado;
    //Listas Para Crear Tablas
    public ArrayList<Siguiente> listaSiguientes;
    public ArrayList<Transicion> listaTransiciones;
    public ArrayList<Estado> listaEstados;
    boolean transicionFinal = false;
    
    int contadorTerminalesGraficar;
    public ArrayList<String> listaTerminales;
    
    public Arbol(String nombre, Nodo raiz) {
        this.raiz = raiz;
        this.nombre = nombre;
    }
    
    
    public void graficarArbol(){
        FileWriter archivo = null;
        PrintWriter pw = null;
         try{
             //Mandar a Crear Codigo Arbol 
             archivo = new FileWriter("../ARBOLES_201901758/" + this.nombre + ".dot");
             pw = new PrintWriter(archivo);
             pw.println("digraph G{");
             pw.println("rankdir=UD");
             pw.println("concentrate=true");
             String codigoNodo = this.raiz.obtenerCodigoNodo();
             pw.println(this.raiz.obtenerCodigoNodo());
             pw.println("}");
             archivo.close();
             
         }catch(Exception e){
             System.out.println("Error, no se pudo graficar el Arbol");
         }
        
        String path = "../ARBOLES_201901758/" + this.nombre +".dot";
        String outputPath = "../ARBOLES_201901758/" + this.nombre +".png";
        transformarDotToPNG(path, outputPath);
        
    }
    
    public void transformarDotToPNG(String path, String outputPath){
        String dotCompiler = "C:\\Program Files\\Graphviz\\bin\\dot.exe"; 
        try {
            //Comando para graficar
            String[] comando = new String[5];
            comando[0] = dotCompiler;
            comando[1] = "-Tpng";
            comando[2]=  path;
            comando[3] = "-o";
            comando[4]= outputPath;
            Runtime runT = Runtime.getRuntime();
            runT.exec(comando);
        } catch (IOException e) {}
        
    }
    
    public void generarSiguientes(){
        this.listaSiguientes = new ArrayList<>();
        obtenerSiguiente(this.raiz);
        this.contadorS = 0;
        asignarColumaHojasEnSiguientes(this.raiz);
        graficarSiguientes();
    }
    
    public void obtenerSiguiente(Nodo nodo){
        if(!(nodo.hoja_der == null && nodo.hoja_izq == null)){
            obtenerSiguiente(nodo.hoja_izq);
            if(!(nodo.hoja_der ==null)){
                obtenerSiguiente(nodo.hoja_der);
            } 
            
            if(nodo.getValor().equals(".")){
                for(int idSiguiente: nodo.hoja_izq.ultimos){
                    for(int valorAgregar: nodo.hoja_der.primeros){
                        agregarSiguienteSinRepetir(idSiguiente, valorAgregar);
                    }
                }     
            }else if(nodo.getValor().equals("*") || nodo.getValor().equals("+")){
                for(int idSiguiente: nodo.hoja_izq.ultimos){
                    for(int valorAgregar : nodo.hoja_izq.primeros){
                        agregarSiguienteSinRepetir(idSiguiente,valorAgregar);
                    }
                }                
            }
        }
        
    }
    //Metodo para revisar si el numero del siguiente existe
    //Para agregar directamente a la lista o crear un nuevo objeto 
    public void agregarSiguienteSinRepetir(int idSiguiente, int valorAgregar){
        boolean existeId = false;
        
        for(Siguiente siguienteValidar: this.listaSiguientes){
            if(siguienteValidar.id == idSiguiente){
                siguienteValidar.agregarSiguiente(valorAgregar);
                existeId = true;
                break;
            }
        }
        if(!existeId){
            Siguiente siguienteNuevo = new Siguiente(idSiguiente); 
            siguienteNuevo.agregarSiguiente(valorAgregar);
            agregarEnOrdenSiguiente(siguienteNuevo);
        }
    }
    
    public void agregarEnOrdenSiguiente(Siguiente siguienteNuevo) {
        if (this.listaSiguientes.isEmpty() || (this.listaSiguientes.get(this.listaSiguientes.size()-1).id < siguienteNuevo.id)) {
            listaSiguientes.add(siguienteNuevo);
        }else{
            for (int i = 0; i < this.listaSiguientes.size(); i++) {
                if (this.listaSiguientes.get(i).id > siguienteNuevo.id) {
                    this.listaSiguientes.add(i, siguienteNuevo);
                    break;
                }
            }
            
        }
    }
// coloca el valor de cada hoja de manera 
//recursiva a la izquierda en la columna valorRama   
    public void asignarColumaHojasEnSiguientes(Nodo nodoAux){
        if(!(nodoAux.hoja_der == null && nodoAux.hoja_izq == null)){
            asignarColumaHojasEnSiguientes(nodoAux.hoja_izq);
            if(nodoAux.hoja_der != null){
            asignarColumaHojasEnSiguientes(nodoAux.hoja_der);
            }
        }else if (nodoAux.hoja_der == null && nodoAux.hoja_izq == null) {
            if(this.contadorS < this.listaSiguientes.size()){
            this.listaSiguientes.get(this.contadorS).valorRama = nodoAux.getValor();
            this.contadorS++;
            }else if(this.contadorS == this.listaSiguientes.size()) {
                Siguiente siguiente = new Siguiente((this.contadorS + 1));
                siguiente.valorRama = nodoAux.getValor();
                this.listaSiguientes.add(siguiente);
            }
        }      
    }

    public void graficarSiguientes() {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try {
            //Mandar a Crear Codigo Arbol 
            archivo = new FileWriter("../SIGUIENTES_201901758/" + this.nombre + ".dot");
            pw = new PrintWriter(archivo);
            pw.println("digraph G{");
            pw.println("node [ shape=none]");
            pw.println("""
                        tbl [label=<
                         <TABLE>
                          <TR>
                          <TD colspan = "2" >Hoja</TD>
                          <TD>Siguientes</TD>
                          </TR>
                          """);
            for(Siguiente siguienteGraficar : this.listaSiguientes){
                pw.println("<TR>");
                pw.println("<TD>"+ siguienteGraficar.valorRama + "</TD>");
                pw.println("<TD>"+ siguienteGraficar.id + "</TD>");
                pw.println("<TD>"+ siguienteGraficar.siguientes.toString() + "</TD>");
                pw.println("</TR>");
            }
            pw.println("""
                       </TABLE>
                       >];
                       }""");
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error, no se pudo graficar Siguientes");
        }
        
        String path = "../SIGUIENTES_201901758/" + this.nombre +".dot";
        String outputPath = "../SIGUIENTES_201901758/" + this.nombre +".png";
        transformarDotToPNG(path, outputPath);
       
    }
    
    public void generarTransiciones() {
        this.contadorEstado = 0;
        this.listaEstados = new ArrayList<>();
        this.listaTransiciones = new ArrayList<>();
        Nodo raizAux = this.raiz;
        ArrayList<Integer> valoresRaiz = raizAux.primeros;
        for (int valorRaiz : valoresRaiz) {
            generarUnaTransicion(this.contadorEstado, valorRaiz, valoresRaiz);
        }
        this.contadorTransicionEstado = 1;
        generarTransicionEstado();
        int prueba = 0;
        graficarTransiciones();
    }
    
    /* Genera un objeto de tipo transicion tomando como base los valores 
    de los cuales se transiciona a otro estado
    ej: Transicion(0,Digito) = Siguiente.Id = 1 = 1,2,3, etc. Estado = 1 */
    public void generarUnaTransicion(int idTransicion, int idSiguiente, ArrayList<Integer> valoresValidos) {
        Transicion transicionNueva = new Transicion();
        transicionNueva.idTransicion = idTransicion;
        for (Siguiente siguienteTemp : this.listaSiguientes) {
            if (siguienteTemp.id == idSiguiente) {
                transicionNueva.valorTransicion = siguienteTemp.valorRama;   
            }
        }
        ArrayList<Integer> listaSiguientesEstado = new ArrayList<>();    
        for (Siguiente siguienteTemp : this.listaSiguientes) {
            for (int valorRef : valoresValidos) {
                if (siguienteTemp.valorRama.equals(transicionNueva.valorTransicion) && siguienteTemp.id == valorRef) {
                    for (int unValor : siguienteTemp.siguientes) {
                        agregarValorSinRepetir(unValor, listaSiguientesEstado);
                    }
                }
            }
        }
        transicionNueva.estadoObjetivo = validarEstado(listaSiguientesEstado);
        this.listaTransiciones.add(transicionNueva);
    }
    
    
    public int validarEstado(ArrayList<Integer> listaSiguientes){
        int estadoObjetivo =0;
        if(this.listaEstados.isEmpty()&& this.transicionFinal == false){
            this.contadorEstado++;
            estadoObjetivo = crearEstadoNuevo(listaSiguientes);   
        }else if(listaSiguientes.isEmpty()&& this.transicionFinal == true){
            estadoObjetivo = -1;
            this.transicionFinal = true;
        }    
        else{
            boolean estadoExiste = false;
            for(Estado unEstado: this.listaEstados){
                if(unEstado.valoresSiguientes.equals(listaSiguientes)){
                    estadoObjetivo = unEstado.idEstado;
                    estadoExiste = true;
                }
            }
            if(!estadoExiste){
                this.contadorEstado++;
                estadoObjetivo = this.contadorEstado;
                this.sigEstadoNuevo = new ArrayList<>();
                this.sigEstadoNuevo = listaSiguientes;
                this.crearEstadoNuevo = true;
                
                        
            }
        }
        return estadoObjetivo;
    }
    
    public int crearEstadoNuevo(ArrayList<Integer> listaSiguientes){
        int estadoObjetivo;
        Estado estado = new Estado();
        
        estado.valoresSiguientes = listaSiguientes;
        estado.idEstado = this.contadorEstado;
        estadoObjetivo = this.contadorEstado;
        this.listaEstados.add(estado);
        return estadoObjetivo;
    }
    
    //Funcion que llama a si misma hasta que no queden estados
    public void generarTransicionEstado(){
        if(this.contadorTransicionEstado <= this.listaEstados.size()){
             
            _generarTransicionEstado(this.contadorTransicionEstado);
        }
    }
    
    public void _generarTransicionEstado(int idEstado){
        ArrayList <Estado>listaEstadosAux = this.listaEstados;
        for(int i= 0; i< listaEstadosAux.size(); i++){
            if(listaEstadosAux.get(i).idEstado == idEstado){
                for(int unSiguiente : listaEstadosAux.get(i).valoresSiguientes){
                    generarUnaTransicion(idEstado, unSiguiente, listaEstadosAux.get(i).valoresSiguientes);
                    if(this.crearEstadoNuevo){
                        crearEstadoNuevo(this.sigEstadoNuevo);
                        this.crearEstadoNuevo = false;
                    }
                }
                
            }
        }
        this.contadorTransicionEstado++;
        generarTransicionEstado();
        
    }
    
    public void agregarValorSinRepetir(int valorAgregar, ArrayList<Integer> lista) {
        boolean repetido = false;
        for (int valorLista : lista) {
            if (valorLista == valorAgregar) {
                repetido = true;
                break;
            }
        }
        if (!repetido) {
            lista.add(valorAgregar);
        }
    }
    
    
    
    public void graficarTransiciones(){
        FileWriter archivo = null;
        PrintWriter pw = null;
        contadorTerminalesGraficar = 0;
        String codigo = generarCodigoTransiciones();
        
        try {
            //Mandar a Crear Codigo Arbol   
            archivo = new FileWriter("../TRANSICIONES_201901758/" + this.nombre + ".dot");
            pw = new PrintWriter(archivo);
            pw.println("digraph G{");
            pw.println("node [ shape=none]");
            pw.println("""
                        tbl [label=<
                         <TABLE>
                          <TR>
                        <TD colspan = "1" rowspan = "2">Estado</TD>
                          """);
            pw.println("<TD colspan = \" " + this.listaTerminales.size()  + "\" >Terminales</TD>");
            pw.println("</TR>");
            pw.println(codigo);
            pw.println("""
                       </TABLE>
                       >];
                       }""");
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error, no se pudo graficar Siguientes");
        }
        
        String path = "../TRANSICIONES_201901758/" + this.nombre +".dot";
        String outputPath = "../TRANSICIONES_201901758/" + this.nombre +".png";
        transformarDotToPNG(path, outputPath);
       
        
    }
    
    public String generarCodigoTransiciones(){
        String codigo ="";
        this.listaTerminales = new ArrayList<>();
        for(Transicion unaTransicion : this.listaTransiciones ){
            agregarValorSinRepetirString(unaTransicion.valorTransicion, this.listaTerminales);
        }
        Estado estadoCero = new Estado();
        estadoCero.idEstado= 0;
        for(Estado estado : this.listaEstados){
            for(int i = 0; i< this.listaTransiciones.size() -1; i++){
                if(this.listaTransiciones.get(i).idTransicion == estado.idEstado){
                    estado.transicionesEstado.add(this.listaTransiciones.get(i));
                }
                if(this.listaTransiciones.get(i).idTransicion == 0){
                    estadoCero.transicionesEstado.add(this.listaTransiciones.get(i));
                    
                }
            }
        }
        
        HashMap<String, String> posicionesTerminales = new HashMap<String,String>();
        codigo +="<tr>";
        for(int i =0; i< this.listaTerminales.size()-1; i++){
            codigo += "<td>"+ this.listaTerminales.get(i)+"</td>";
            posicionesTerminales.put(String.valueOf(i), this.listaTerminales.get(i));
        }
        this.listaEstados.add(0, estadoCero);
        codigo+= "</tr>";
        for(int i=0; i<this.listaEstados.size()-1; i++){
            codigo += "<tr>";
            codigo +=  "<td> S" + this.listaEstados.get(i).idEstado +  "</td>";
            for(Map.Entry<String,String> posicion : posicionesTerminales.entrySet()){
                boolean existe = false;
                int estadoObjetivo = 0;
                for(Transicion transicion : this.listaEstados.get(i).transicionesEstado){
                    if(posicion.getValue().equals(transicion.valorTransicion)){
                        existe = true;
                        estadoObjetivo = transicion.estadoObjetivo;
                        break;
                    }
                }
                if(existe){
                    codigo += "<td> S"+ estadoObjetivo + "</td>";
                }else{
                    codigo +="<td>--</td>";
                }  
            }
            codigo +=" </tr>";
        }
        return codigo;
    }
    
    public void agregarValorSinRepetirString(String valorAgregar, ArrayList<String> lista) {
        boolean repetido = false;
        for (String valorLista : lista) {
            if (valorLista.equals(valorAgregar)) {
                repetido = true;
                break;
            }
        }
        if (!repetido) {
            lista.add(valorAgregar);
        }
    }
    
}
