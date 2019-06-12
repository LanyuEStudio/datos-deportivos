package es.lanyu.comun.evento;

import java.util.Arrays;
import java.util.Collection;

import es.lanyu.participante.Participante;

public interface LocalContraVisitante {
	public static String getFormatoSucesos(){ return "%s-%s"; }
	
	Participante getLocal();

	Participante getVisitante();
	
	default Collection<Participante> getParticipantes() {
		return Arrays.asList(getLocal(), getVisitante());
	}
	
	default String getEquipos(){
		return getLocal() + " vs " + getVisitante();
	}
	
}