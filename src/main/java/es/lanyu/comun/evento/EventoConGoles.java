package es.lanyu.comun.evento;

import java.util.Collection;
import java.util.Comparator;

import es.lanyu.comun.suceso.Gol;
import es.lanyu.participante.Participante;

public interface EventoConGoles extends GestorSucesos, LocalContraVisitante{
	
	static String getFormatoGoles() {
		return LocalContraVisitante.getFormatoSucesos();
	}
	
	default Collection<Gol> getGoles(){
		return getSucesosGestionados(Gol.class);
	}

	default int getGolesEquipo(Participante equipo) {
		return (int) getGoles().stream().filter(g -> g.getEquipoAnotador().equals(equipo)).count();
	}
	
	default void addGoles(int numGolesLocal, int numGolesVisitante) {
		addSucesos(Gol.class, numGolesLocal, getLocal());
		addSucesos(Gol.class, numGolesVisitante, getVisitante());
	}
	
	default String getResultado() {
		return String.format(getFormatoGoles(), getGolesEquipo(getLocal()), getGolesEquipo(getVisitante()));
	}
	
	default String getResultadoYEquipos(){
		return getResultado() + " | " + getEquipos();
	}
	
	//Devuelve null si no hubo ganador
	default Participante getGanador(Collection<Participante> participantes) {
		Comparator<Participante> comparador = new Comparator<Participante>(){
				@Override
				public int compare(Participante o1, Participante o2) {
					return Integer.compare(getGolesEquipo(o1), getGolesEquipo(o2));
				}
			};
		
		Participante ganador = participantes.stream().max(comparador).get();
		Participante perdedor = participantes.stream().min(comparador).get();
		
		return (ganador == perdedor)?null:ganador;
	}
}