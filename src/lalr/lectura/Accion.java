/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalr.lectura;

/**
 *
 * @author LENOVO-PC
 */
public class Accion {
   
    private String textoPila, textoSimbolo, textoEntrada, textoAccion;

    public Accion(String textoPila, String textoSimbolo, String textoEntrada, String textoAccion) {
        this.textoPila = textoPila;
        this.textoSimbolo = textoSimbolo;
        this.textoEntrada = textoEntrada;
        this.textoAccion = textoAccion;
    }

    public String getTextoPila() {
        return textoPila;
    }

    public void setTextoPila(String textoPila) {
        this.textoPila = textoPila;
    }

    public String getTextoSimbolo() {
        return textoSimbolo;
    }

    public void setTextoSimbolo(String textoSimbolo) {
        this.textoSimbolo = textoSimbolo;
    }

    public String getTextoEntrada() {
        return textoEntrada;
    }

    public void setTextoEntrada(String textoEntrada) {
        this.textoEntrada = textoEntrada;
    }

    public String getTextoAccion() {
        return textoAccion;
    }

    public void setTextoAccion(String textoAccion) {
        this.textoAccion = textoAccion;
    }
    
    
    
    
}
