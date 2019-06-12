package es.lanyu.participante;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Participante extends AbstractNombrable {

	public Participante(){}
	
	public Participante(String nombre) {
		super();
		setNombre(nombre);
	}
	
	@Override
	public String toString() {
		return getNombre() + " " + getIdentificador();
	}
	
}
