package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class TarjetaImpl extends SucesoImpl implements Tarjeta {
	public static enum TipoTarjeta {AMARILLA, ROJA}
	private TipoTarjeta tipoTarjeta;

	@Override
	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public TarjetaImpl() {}
	
	public TarjetaImpl(TipoTarjeta tipo) {
		super();
		this.tipoTarjeta = tipo;
	}
	
	public TarjetaImpl(Date fecha, Participante participante, TipoTarjeta tipo) {
		this(tipo);
		setFecha(fecha);
		setParticipante(participante);
	}

	@Override
	public String toString() {
		return "Tarjeta " + getTipoTarjeta() + ((getActor() != null)?" para " + getActor():"");
	};
	
	
}
