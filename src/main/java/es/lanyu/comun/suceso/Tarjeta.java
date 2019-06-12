package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class Tarjeta extends Suceso {
	public static enum TipoTarjeta {AMARILLA, ROJA}
	private TipoTarjeta tipoTarjeta;

	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public Tarjeta(){}
	
	public Tarjeta(Date fecha, Participante participante, TipoTarjeta tipo) {
		super();
		setFecha(fecha);
		setParticipante(participante);
		this.tipoTarjeta = tipo;
	}

	@Override
	public String toString() {
		return "Tarjeta " + getTipoTarjeta() + ((getActor() != null)?" para " + getActor():"");
	};
	
	
}
