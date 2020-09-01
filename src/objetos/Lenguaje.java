
package objetos;

import java.io.Serializable;


public class Lenguaje implements Serializable{
    
    private String nombre, version, autor, lanzamiento, extension;

    public Lenguaje(String nombre) {
        this.nombre = nombre;
    }

    public Lenguaje() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    
    public String toString(){
        String texto = "Nombre: "+getNombre()+"\n";
        texto += "Version: "+getVersion()+"\n";
        texto += "Autor: "+getAutor()+"\n";
        texto += "Lanzamiento: "+getLanzamiento()+"\n";
        texto += "Extension: "+getExtension();
        return texto;
    }
    
    
}
