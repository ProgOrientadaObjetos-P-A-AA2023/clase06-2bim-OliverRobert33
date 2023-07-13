/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author reroes
 */
public class Ciudad {
    private String nombre;
    private int poblacion;
    
    public Ciudad(String n, int p){
        nombre = n;
        poblacion = p;
    }
    
    public void establecerNombre(String n){
        nombre = n;
    }
    
    public void establecerPoblacion(int n){
        poblacion = n;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public int obtenerPoblacion(){
        return poblacion;
    }
    
    @Override
    public String toString(){
        String data = String.format("Nombre: %s\n"
                + "Población: %d\n", 
                obtenerNombre(), obtenerPoblacion());
        return data;
    }
    
}
