/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.Serializable;

/**
 *
 * @author LENOVO-PC
 */
public class Estado implements Serializable{
    
    private String caracter, token;
    private int estadoSiguiente;

    public Estado(String caracter, int estadoSiguiente, String token) {
        this.caracter = caracter;
        this.estadoSiguiente = estadoSiguiente;
        this.token = token;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public int getEstadoSiguiente() {
        return estadoSiguiente;
    }

    public void setEstadoSiguiente(int estadoSiguiente) {
        this.estadoSiguiente = estadoSiguiente;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
