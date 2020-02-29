package es.lanyu.comun.evento;

import java.util.ArrayList;
import java.util.Collection;

import es.lanyu.commons.tiempo.DatableInstant;
import es.lanyu.comun.suceso.Suceso;
import es.lanyu.participante.Participante;

public abstract class EventoImpl extends DatableInstant implements Evento {
	protected Collection<Suceso> sucesos = new ArrayList<>();
	
	@Override
	public Collection<Suceso> getSucesos() {
		return sucesos;
	}

	@Override
	public abstract String getResultado();
	
	@Override
	public abstract Participante getGanador();
}
