
package Vista;

import Modelo.Votantes.Votante;


public class Main {
    public static void main(String[] args) {
        
        Ventana ventana = new Ventana();
        //hacer visible la ventana
        ventana.setVisible(true);
        
        //Para establecer el tamaño de la ventana
        ventana.setSize(500, 500);
        
        //cambiarle la ubicacion de inicio
        
        //ubicar la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);
        
        
    }
    
}
