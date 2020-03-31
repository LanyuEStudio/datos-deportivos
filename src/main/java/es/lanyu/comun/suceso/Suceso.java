package es.lanyu.comun.suceso;

import java.time.Instant;

import es.lanyu.commons.tiempo.Datable;
import es.lanyu.participante.Participante;

public interface Suceso extends Datable<Instant>{

	Participante getParticipante();

	void setParticipante(Participante participante);
	
	String getActor();
	
}