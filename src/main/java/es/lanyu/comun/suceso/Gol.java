package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class Gol extends Suceso {
	private Integer minuto;
	
	public Participante getEquipoAnotador() {
		return getParticipante();
	}

	public int getMinuto(){
		if(fecha == null)
			minuto = null;
		else//TODO Implementar el calculo del minuto
			;
		
		return minuto;
	}

	public Gol(){}
	
	public Gol(Date fecha, String actor, Participante equipoAnotador) {
		super();
		setFecha(fecha);
		this.actor = actor;
		setParticipante(equipoAnotador);
	}

	@Override
	public String toString() {
		return ((minuto != null)?minuto + "'":"") + " Gol para el " + getEquipoAnotador();
	}
	
}
