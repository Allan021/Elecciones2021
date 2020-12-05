
package Modelo.RegistroCandidatos;

import java.util.Vector;

public class ModeloBusqueda {
    private String nombre;
    private int idBusqueda;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

  

 
   public Vector<ModeloBusqueda> modelos(){
        Vector<ModeloBusqueda> modelos = new Vector<ModeloBusqueda>();
        
        ModeloBusqueda modelo1 = new ModeloBusqueda();
        ModeloBusqueda modelo2 = new ModeloBusqueda();
       ModeloBusqueda modelo3 = new ModeloBusqueda();
       ModeloBusqueda modelo4 = new ModeloBusqueda();

       
          
        modelo2.setIdBusqueda(0);
        modelo2.setNombre("Nombre");
        
          modelo3.setIdBusqueda(1);
        modelo3.setNombre("Lista");
          
        modelo4.setIdBusqueda(2);
        modelo4.setNombre("Partido");
         
         
     
         modelos.add(modelo2);
         modelos.add(modelo3);
         modelos.add(modelo4);

         return modelos;
         
   }
    
    @Override
    public String toString() {
       return nombre;
    }
    
    
}
