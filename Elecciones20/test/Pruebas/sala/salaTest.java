
package Pruebas.sala;

import Controlador.ControladorSala;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Votantes.Votante;
import Vista.SalaVotaciones;

public class salaTest {
    public static void main(String[] args) {
        Votante votante = new Votante();
         SalaVotaciones sala = new SalaVotaciones();
    PartidoPolitico partido = new PartidoPolitico();
    Alcalde alcalde = new Alcalde();
    Presidente presidente = new Presidente();
    Diputado diputado = new Diputado();
    ConsultasVotaciones modelo = new ConsultasVotaciones();
    
       Controlador.ControladorSala controlador = new ControladorSala(votante, sala, partido, alcalde, presidente, diputado, modelo);
        controlador.iniciar();
    }
}
