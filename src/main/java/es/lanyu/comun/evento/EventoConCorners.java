package es.lanyu.comun.evento;

import java.util.Collection;

import es.lanyu.comun.suceso.Corner;
import es.lanyu.participante.Participante;

public interface EventoConCorners extends Evento, GestorSucesos, LocalContraVisitante {
	
	static String getFormatoCorners() {
		return LocalContraVisitante.getFormatoSucesos();
	}
	
	default Collection<Corner> getCorners(){
		return getSucesosGestionados(Corner.class);
	}

	default int getCornersEquipo(Participante equipo) {
		return (int) getCorners().stream().filter(c -> c.getParticipante().equals(equipo)).count();
	}
	
	default void addCorners(int numCornersLocal, int numCornersVisitante) {
		addSucesos(Corner.class, numCornersLocal, getLocal());
		addSucesos(Corner.class, numCornersVisitante, getVisitante());
	}

	default String getCornersTotal() {
		return String.format(getFormatoCorners(), getCornersEquipo(getLocal()), getCornersEquipo(getVisitante()));
	}
}