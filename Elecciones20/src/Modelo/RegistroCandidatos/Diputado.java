
package Modelo.RegistroCandidatos;

import Modelo.Personas.Persona;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;

public class Diputado extends Persona {
    private int idDiputado;
    private int id_Partido;
    private int Votos;
    private BufferedImage imagen;
    private int id_Departamento;
    private int categoria;
    public File archivo;
    private FileInputStream archivoLeido;

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileInputStream getArchivoLeido() {
        return archivoLeido;
    }

    public void setArchivoLeido(FileInputStream archivoLeido) {
        this.archivoLeido = archivoLeido;
    }
    
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    
    public int getIdDiputado() {
        return idDiputado;
    }

    public void setIdDiputado(int idDiputado) {
        this.idDiputado = idDiputado;
    }

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public int getId_Partido() {
        return id_Partido;
    }

    public void setId_Partido(int id_Partido) {
        this.id_Partido = id_Partido;
    }

    public int getVotos() {
        return Votos;
    }

    public void setVotos(int Votos) {
        this.Votos = Votos;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getFechaNacimiento() {
        return super.getFechaNacimiento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEstadoCivil(String estadoCivil) {
        super.setEstadoCivil(estadoCivil); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEstadoCivil() {
        return super.getEstadoCivil(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGenero(String genero) {
        super.setGenero(genero); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGenero() {
        return super.getGenero(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNacionalidad(String nacionalidad) {
        super.setNacionalidad(nacionalidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdentidad(String identidad) {
        super.setIdentidad(identidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentidad() {
        return super.getIdentidad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNacionalidad() {
        return super.getNacionalidad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        return super.getEdad(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
