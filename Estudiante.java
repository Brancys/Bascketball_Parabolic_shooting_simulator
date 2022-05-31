package General;
import java.io.*;


public class Estudiante implements Serializable{
    private String nombre;
    private String grupo;
    private String boleta;
    
    public void inicializa ( String nombre, String grupo, String boleta ){
        this.nombre = nombre;
        this.grupo = grupo;
        this.boleta= boleta;
    }    
    
 
    
}

