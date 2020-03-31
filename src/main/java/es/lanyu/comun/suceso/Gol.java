package es.lanyu.comun.suceso;

import es.lanyu.participante.Participante;

public interface Gol {

	Participante getEquipoAnotador();

	default Integer getMinuto() {
		return null;
	}

}