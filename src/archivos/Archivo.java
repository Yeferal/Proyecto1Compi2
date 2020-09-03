
package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.ArchivoLenguaje;
import objetos.Lenguaje;

public class Archivo {
    
    public ArrayList<ArchivoLenguaje> listaLenguajes = new ArrayList<>();
    
    public String leerArchivo(String ruta){
        String texto = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        

      try {
         archivo = new File (ruta);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         String linea;
         while((linea=br.readLine())!=null)
            texto+=linea+"\n";
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      } 
        //System.out.println(texto);
        return texto;
    }
    
    public void escribir(String texto, String ruta){
        
        
        File file = new File(ruta);
        
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void crearArchivo(String ruta,String texto){
        File file = new File(ruta);
        
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void listarFicherosPorCarpeta(final File carpeta) {
        listaLenguajes.clear();
        for (final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                try {
                    //System.out.println(ficheroEntrada.getPath());
                    leerObjeto("Lenguajes/"+ficheroEntrada.getName());
                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        }
    }
    
    public void leerObjeto(String pd) throws IOException{
        
        try {
            ArchivoLenguaje archivoLenguaje = null;
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(pd) );
            archivoLenguaje = ( ArchivoLenguaje )leyendoFichero.readObject();
            leyendoFichero.close();
            
            System.out.println("Nombre Lenguaje: "+archivoLenguaje.getLenguaje().getNombre());
            listaLenguajes.add(archivoLenguaje);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidClassException ex) {
            //Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean buscarLenguajeExistente(String nombre){
        for (int i = 0; i < listaLenguajes.size(); i++) {
            if(listaLenguajes.get(i).getLenguaje().getNombre().equals(nombre)){
                return true;
            }
        }
        return false;   
    }
    
    public void borrarLenguaje(String nombre){
        File fichero = new File("Lenguajes/"+nombre+".dat");
        if (fichero.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
         else
            System.out.println("El fichero no puede ser borrado");
    }
        
        
}
