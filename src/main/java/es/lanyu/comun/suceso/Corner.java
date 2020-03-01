package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class Corner extends SucesoImpl {

	public Corner(){
		super();
		setFecha(null);
	}
	
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
