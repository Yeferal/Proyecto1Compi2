
package objetos;

public class ArchivoExtension {
    
    private String nombre,path;

    public ArchivoExtension(String nombre, String path) {
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
