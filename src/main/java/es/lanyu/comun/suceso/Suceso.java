package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.commons.tiempo.Datable;
import es.lanyu.participante.Participante;

public interface Suceso extends Datable {

	Participante getParticipante();

	void setParticipante(Participante participante);
	
	String getActor();
	
	void setFecha(Date fecha);
	
}