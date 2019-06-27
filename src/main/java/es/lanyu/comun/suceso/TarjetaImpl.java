package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class TarjetaImpl extends SucesoImpl implements Tarjeta {
	public static enum TipoTarjeta {AMARILLA, ROJA}
	private TipoTarjeta tipoTarjeta;

	/* (non-Javadoc)
	 * @see es.lanyu.comun.suceso.Tarjeta#getTipoTarjeta()
	 */
	@Override
	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public TarjetaImpl(){}
	
	public TarjetaImpl(Date fecha, Participante participante, TipoTarjeta tipo) {
		super();
		setFecha(fecha);
		setParticipante(participante);
		this.tipoTarjeta = tipo;
	}

	/* (non-Javadoc)
	 * @see es.lanyu.comun.suceso.Tarjeta#toString()
	 */
	@Override
	public String toString() {
		return "Tarjeta " + getTipoTarjeta() + ((getActor() != null)?" para " + getActor():"");
	};
	
	
}
