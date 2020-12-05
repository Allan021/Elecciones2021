
package Controlador;

import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.Categoria;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.ModeloBusqueda;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Votantes.Votante;
import Vista.SalaVotaciones;
import Vista.Ventana;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class ControladorSala implements FocusListener,MouseListener,ActionListener,KeyListener{
    Votante votante;
    SalaVotaciones sala;
    PartidoPolitico partido;
    Alcalde alcalde;
    Presidente presidente;
    Diputado diputado;
    ConsultasVotaciones modelo;
    
    
    
    public ControladorSala(Votante votante, SalaVotaciones sala, PartidoPolitico partido, Alcalde alcalde, Presidente presidente, Diputado diputado, ConsultasVotaciones modelo) {
        this.votante = votante;
        this.sala = sala;
        this.partido = partido;
        this.alcalde = alcalde;
        this.presidente = presidente;
        this.diputado = diputado;
        this.modelo = modelo;
        eventos();
        separadores();
        elementosInvisibles();
        agregarListas();
    }

  
    public void iniciar(){
        sala.setLocationRelativeTo(null);
        sala.setVisible(true);
    }
    
    private void eventos(){
        eventosFocus();
        eventosLabel();
        
    }
    public void elementosInvisibles(){
        sala.NombreUsuario.setText(votante.getNombre());
    }
    
     private void separadores(){
         colorSeparador(sala.jSeparator1);
         colorSeparador(sala.jSeparator2);
          colorSeparador(sala.jSeparator3);
    }
     
     public void colorSeparador(JSeparator separar){
        separar.setForeground(new Color(160,160,160));
    }

    
     
    private void eventosFocus(){
        sala.listaCandidatos.addFocusListener(this);
        sala.listacategoria.addFocusListener(this);
        sala.listaBusqueda.addFocusListener(this);
        
        
     sala.buscar.addFocusListener(this);
      sala.campoGenero.addFocusListener(this);
       sala.campoNacionalidad.addFocusListener(this);
       sala.campoNombre.addFocusListener(this);
       sala.campoPartido1.addFocusListener(this);
       
    }
      
    private void eventosLabel(){
        sala.MENOS.addMouseListener(this);
        sala.cerrar.addMouseListener(this);
    }
    
    
  @Override
    public void actionPerformed(ActionEvent e) {

    }


  
    @Override
    public void focusGained(FocusEvent e) {
        anadirFocusEnable(e, sala.listaCandidatos);
        anadirFocusEnable(e,sala.listaBusqueda);
        anadirFocusEnable(e, sala.listacategoria);
        
        //campo nombre
        anadirFocusGainedCampos(e, sala.buscar, "Nombre Candidato");
        anadirFocusGainedCampos(e, sala.campoGenero, "");
        anadirFocusGainedCampos(e, sala.campoNacionalidad, "");
        anadirFocusGainedCampos(e, sala.campoPartido1, "");
        anadirFocusGainedCampos(e, sala.campoNombre, "");
        
        anadirFocusGainedCampos2(e, sala.jTextArea1, "Discurso Presidencial");
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        anadirFocuslost(e, sala.listaCandidatos);
        anadirFocuslost(e, sala.listaBusqueda);
        anadirFocuslost(e,sala.listacategoria);
        
        anadirFocuslostCampos(e, sala.buscar, "Nombre Candidato");
        anadirFocuslostCampos(e, sala.campoGenero, "");
        anadirFocuslostCampos(e, sala.campoNacionalidad, "");
        anadirFocuslostCampos(e, sala.campoPartido1, "");
        anadirFocuslostCampos(e, sala.campoNombre, "");
        anadirFocuslostCampos2(e, sala.jTextArea1, "Discurso Presidencial");
        
       
    }
    public void agregarListas(){
        agregarMetodoBusqueda();
        agregarCategoria();
    }
    
    public void agregarMetodoBusqueda(){
        ModeloBusqueda model = new ModeloBusqueda();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(model.modelos());
        
        sala.listaBusqueda.setModel(modelo);
    }
    
       public void agregarCategoria(){
        Categoria model = new Categoria();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(model.establecerCategoria());
        
        sala.listacategoria.setModel(modelo);
    }
    
    
    
    //le mando un componente cualquiera en los parametros
        public void anadirFocusEnable(FocusEvent e,JComponent combo){
        
        if(e.getSource() == combo){
           Color azul = new Color(0,109,196)  ;
             
          Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
          Border bordeDentro = BorderFactory.createLineBorder(azul, 2, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        combo.setBorder(bordeFinal);
        
    }
        
        }
        public void anadirFocuslost(FocusEvent e,JComponent combo){
        
        if(e.getSource() == combo){
    
            Color sombras = new Color(105,116,112);  
              
          Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
          Border bordeDentro = BorderFactory.createLineBorder(sombras, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        combo.setBorder(bordeFinal);
          
      }
        
    }
        
         public void anadirFocusGainedCampos(FocusEvent e,JTextField campo,String placeholder){
            if(e.getSource() == campo){
             
             if(campo.getText().trim().equals(placeholder)){
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }
             
          Color ColorBlanco = new Color(239,243,245);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);
         
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
             
         }
            
         }
         
          public void anadirFocuslostCampos(FocusEvent e,JTextField campo,String placeholder){
        
               if (e.getSource() == campo) {
                    if(campo.getText().trim().equals(placeholder) || campo.getText().equals("")){
                campo.setText(placeholder);
                campo.setForeground(new Color(105,116,112));
            }
             
          Color ColorGris = new Color(118,118,118);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
              
               }
          }
          
                 public void anadirFocuslostCampos2(FocusEvent e,JTextArea campo,String placeholder){
        
               if (e.getSource() == campo) {
                    if(campo.getText().trim().equals(placeholder) || campo.getText().equals("")){
                campo.setText(placeholder);
                campo.setForeground(new Color(105,116,112));
            }
             
          Color ColorGris = new Color(118,118,118);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
              
               }
               
                 }
                public void anadirFocusGainedCampos2(FocusEvent e,JTextArea campo,String placeholder){
            if(e.getSource() == campo){
             
             if(campo.getText().trim().equals(placeholder)){
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }
             
          Color ColorBlanco = new Color(239,243,245);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);
         
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
             
         }
            
         }
               
          

    @Override
    public void mouseClicked(MouseEvent e) {
   
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
 if(e.getSource() == sala.MENOS){
             Color color = new Color(180,180,180);
       sala.MENOS.setForeground(color);
      }
        if(e.getSource() == sala.cerrar){
        Color color = new Color(180,180,180);
       sala.cerrar.setForeground(color);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
if(e.getSource() == sala.MENOS){
             Color color = new Color(239,243,245);
       sala.MENOS.setForeground(color);
      }
        if(e.getSource() == sala.cerrar){
        Color color = new Color(239,243,245);
       sala.cerrar.setForeground(color);
        }
    }

  
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
        
    
    
}
