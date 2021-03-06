
package Modelo.RegistroCandidatos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class PartidoPolitico {
    
    private int id_PartidoPolitico;
    private String nombre;
    private BufferedImage imagen;

    public int getId_PartidoPolitico() {
        return id_PartidoPolitico;
    }

    public void setId_PartidoPolitico(int id_PartidoPolitico) {
        this.id_PartidoPolitico = id_PartidoPolitico;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre ;//que solo el nombr se seleccione
    }
    
    
    public Vector<PartidoPolitico> establecerPartidos(){//establecer un arreglo de partidos politicos
         Vector<PartidoPolitico> partidos = new Vector<PartidoPolitico>();//un nuevo arreglo de partidos politicos
        PartidoPolitico seleccion1 = new PartidoPolitico();
        seleccion1.id_PartidoPolitico = 0;
        seleccion1.nombre = "Seleccione un Partido";
        
        partidos.add(seleccion1);
        Conexion con = new Conexion();
        PreparedStatement consulta =null;
        ResultSet resultados;
        try {
            Connection conexion =con.getConnection();
         consulta = conexion.prepareStatement("select idPartido,nombrePartido from partidos");
            
         resultados = consulta.executeQuery();
         
         while(resultados.next()){
             PartidoPolitico partido = new PartidoPolitico();
             partido.setId_PartidoPolitico(resultados.getInt("idPartido"));
             partido.setNombre(resultados.getString("nombrePartido"));
             partidos.add(partido);//terminar de llenar los partidos
         }
         
         
            
        } catch (Exception e) {
            System.err.println("Error "+e);
        }
        
        return partidos;
    }
    
    
}
