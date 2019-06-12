package es.lanyu.comun.evento;

import java.util.ArrayList;
import java.util.Collection;

import es.lanyu.commons.tiempo.DatableImpl;
import es.lanyu.comun.suceso.Suceso;
import es.lanyu.participante.Participante;

public abstract class EventoImpl extends DatableImpl implements Evento {
	protected Collection<? extends Suceso> sucesos = new ArrayList<>();
	
	@Override
	public Collection getSucesos() {
		return sucesos;
	}

	@Override
	public abstract String getResultado();
	
	@Override
	public abstract Participante getGanador();
}
