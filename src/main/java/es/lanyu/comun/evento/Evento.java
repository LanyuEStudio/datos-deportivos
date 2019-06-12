package es.lanyu.comun.evento;

import java.util.Collection;
import java.util.Date;

import es.lanyu.comun.suceso.Suceso;
import es.lanyu.participante.Participante;

public interface Evento {

	Date getFecha();

	Collection<Suceso> getSucesos();

	String getResultado();

	Participante getGanador();

}