package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class GolImpl extends SucesoImpl implements Gol {
	private Integer minuto;
	
	@Override
	public Participante getEquipoAnotador() {
		return getParticipante();
	}

	@Override
	public Integer getMinuto(){
		if(getFecha() == null)
			minuto = null;
		else//TODO Implementar el calculo del minuto
			;
		
		return minuto;
	}

	public GolImpl(){
		super();
		setFecha(null);
	}
	
	public GolImpl(Date fecha, String actor, Participante equipoAnotador) {
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
