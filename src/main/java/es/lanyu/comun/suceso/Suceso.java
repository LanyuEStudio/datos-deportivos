package es.lanyu.comun.suceso;

import es.lanyu.commons.servicios.entidad.ServicioEntidad;
import es.lanyu.commons.tiempo.DatableImpl;
import es.lanyu.participante.Participante;

public abstract class Suceso extends DatableImpl {
	protected transient Participante participante;
	protected String idParticipante;
	protected String actor;
	transient ServicioEntidad servicioEntidad;

	public Participante getParticipante() {
		if(participante == null)
			participante = servicioEntidad.getIdentificable(Participante.class, idParticipante);
		return participante;
	}
	
	public void setParticipante(Participante participante) {
		this.participante = participante;
		this.idParticipante = participante.getIdentificador();
	}

	public String getActor() {
		return actor;
	}
	
	public void setActor(String actor) {
		this.actor = actor;
	}
}
