
package Modelo.Votantes;

import Modelo.Personas.Persona;
import Modelo.Regiones.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Consultas extends Conexion{
    //Atributos de la consulta
    
    PreparedStatement consultas;
    ResultSet resultados;
  
    
    public boolean insertarVotante (Votante votante) {//le pasare una persona que gracias al polimorfismo la convertire en una persona
        boolean estado = false;
        Connection conexion = getConnection();
      
         try{
          
              
          consultas =  conexion.prepareStatement("insert into votantes (nombres,apellidos,genero,edad,fechaNacimiento,numeroIdentidad,departamento,municipio) values(?,?,?,?,?,?,?,?) ");
                     
          consultas.setString(1, votante.getNombre());
          consultas.setString(2, votante.getApellidos());
          consultas.setString(3, votante.getGenero());
          consultas.setInt(4, votante.getEdad());
          consultas.setDate(5, votante.getFechaNacimiento());
          consultas.setString(6, votante.getNumeroIdentidad());
          consultas.setString(7, votante.getDepartamento());
          consultas.setString(8, votante.getMunicpio());
          
          
       int resultado =  consultas.executeUpdate();//Insertar,eliminar o modificar
          
         if(resultado > 0){//si el resultado es mayor que uno todo salio buen
             estado = true;
         }else{
             estado = false;
         }
          
        }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
            estado = false;
        }finally{
            try{
               conexion.close(); 
                       
            }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
          
        }
        }
    
        
       return estado; 
        
    }
    
    
    
public int verificarUsuario(String numeroIdentidad){
    Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("select count(id_Votante) from votantes where numeroIdentidad=?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     consultas.setString(1, numeroIdentidad);
     resultados = consultas.executeQuery();
     
        if (resultados.next()) {
            nUsuarios = resultados.getInt(1);//aca obtengo el conteo de uantos usuarios tengo de la columna 1
        }else{
            nUsuarios = 0;
        }
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        nUsuarios =0;
    }
    return nUsuarios;
}
//aca es para unir las tablas de usuario con el id de su municipio y el id de su departamento
public void joinUserAdress(Votante votante){
  try{
     Connection conexion = getConnection();//esto obtiene la conexion de arriba
    
     consultas = conexion.prepareStatement("select id_Votante from votantes where numeroIdentidad=?");
     consultas.setString(1, votante.getNumeroIdentidad());
     
     resultados = consultas.executeQuery();
     
     if(resultados.next()){
         votante.setIdVotante(resultados.getInt("id_Votante"));
     }
     
     consultas = conexion.prepareStatement("insert into union_vdepamuni (id_Votante,id_Departamento,id_municipio) values(?,?,?)");
     consultas.setInt(1, votante.getIdVotante());
     consultas.setInt(2, votante.getIdDepartamento());
     consultas.setInt(3,votante.getIdMunicipio()); 
     consultas.executeUpdate();//aca no enviare nada ya que esto no lo vera el usuario xd
     
     
  }catch(Exception ex){
      System.err.println("Error "+ex);
  }
    
    
}

public Votante buscarUsuario(String identidad){

    Votante votante = null;
    try{
     Connection conexion = getConnection();//esto obtie(nombre)ne la conexion de arriba    
     consultas = conexion.prepareStatement("select id_Votante,nombres,apellidos,genero,departamento,municipio from votantes where numeroIdentidad = ?");
     
     consultas.setString(1,identidad );
     
     resultados = consultas.executeQuery();

     votante = new Votante();
     votante.setIdVotante(0);
        while (resultados.next()) {            
         votante.setNombre(resultados.getString("nombres"));
         votante.setApellidos(resultados.getString("apellidos"));
         votante.setIdVotante(resultados.getInt("id_Votante"));
         votante.setDepartamento(resultados.getString("departamento"));
         votante.setMunicpio(resultados.getString("municipio"));
         votante.setGenero(resultados.getString("genero"));
        }
        
        if(votante.getIdVotante() == 0){
            votante = null;
        }
     
      
    
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
       votante = null;
    }finally{
        try {
            consultas.close();
        } catch (SQLException ex) {
            
        }
    }
    
    return votante;
}

}