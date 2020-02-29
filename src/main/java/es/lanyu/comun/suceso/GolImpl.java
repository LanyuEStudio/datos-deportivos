package es.lanyu.comun.suceso;

import java.util.Date;

import es.lanyu.participante.Participante;

public class GolImpl extends SucesoImpl implements Gol {
	private Integer minuto;
	
	/* (non-Javadoc)
	 * @see es.lanyu.comun.suceso.Gol#getEquipoAnotador()
	 */
	@Override
	public Participante getEquipoAnotador() {
		return getParticipante();
	}

	/* (non-Javadoc)
	 * @see es.lanyu.comun.suceso.Gol#getMinuto()
	 */
	@Override
	public Integer getMinuto(){
		if(getFecha() == null)
			minuto = null;
		else//TODO Implementar el calculo del minuto
			;
		
		return minuto;
	}

	public GolImpl(){}
	
	public GolImpl(Date fecha, String actor, Participante equipoAnotador) {
		super();
		setFecha(fecha);
		this.actor = actor;
		setParticipante(equipoAnotador);
	}

	/* (non-Javadoc)
	 * @see es.lanyu.comun.suceso.Gol#toString()
	 */
	@Override
	public String toString() {
		return ((minuto != null)?minuto + "'":"") + " Gol para el " + getEquipoAnotador();
	}
	
}
