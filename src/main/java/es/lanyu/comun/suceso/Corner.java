package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class Corner extends Suceso {

	public Corner(){}
	
	public Corner(Date fecha, Participante participante) {
		super();
		setFecha(fecha);
		setParticipante(participante);
	}

	@Override
	public String toString() {
		return "Corner para " + getParticipante();
	};
	
	
}
