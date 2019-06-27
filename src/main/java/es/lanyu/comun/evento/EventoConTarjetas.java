package es.lanyu.comun.evento;

import java.util.Collection;
import java.util.stream.Collectors;

import es.lanyu.comun.suceso.Tarjeta;
import es.lanyu.comun.suceso.TarjetaImpl;
import es.lanyu.comun.suceso.TarjetaImpl.TipoTarjeta;
import es.lanyu.participante.Participante;

public interface EventoConTarjetas extends Evento, GestorSucesos, LocalContraVisitante {

	static String getFormatoTarjetas() {
		return LocalContraVisitante.getFormatoSucesos();
	}
	
	default Collection<Tarjeta> getTarjetas(){
		return getSucesosGestionados(Tarjeta.class);
	}

	default Collection<Tarjeta> getTarjetasEquipo(Participante participante) {
		return getTarjetas().stream().filter(t -> t.getParticipante().equals(participante)).collect(Collectors.toList());
	}
	
	default void addTarjetas(int numTarjetasLocal, int numTarjetasVisitante, TipoTarjeta tipo) {
		addTarjetas(numTarjetasLocal, getLocal(), tipo);
		addTarjetas(numTarjetasVisitante, getVisitante(), tipo);
	}
	
	default void addTarjetas(int numeroTarjetas, Participante participante, TipoTarjeta tipo) {
		for(int i = 0; i < numeroTarjetas; i++){
			TarjetaImpl tarjeta = new TarjetaImpl(null, participante, tipo);
			addSuceso(tarjeta);
		}
	}
	
	default Collection<Tarjeta> getTarjetasTipo(TipoTarjeta tipo) {
		return getTarjetas().stream().filter(t -> t.getTipoTarjeta().equals(tipo)).collect(Collectors.toList());
	}
	
	default int getNumeroTipoTarjetasEquipo(TipoTarjeta tipo, Participante equipo) {
		return (int) getTarjetasTipo(tipo).stream().filter(t -> equipo.equals(t.getParticipante())).count();
	}
	
	default int getAmarillasEquipo(Participante equipo) {
		return getNumeroTipoTarjetasEquipo(TipoTarjeta.AMARILLA, equipo);
	}
	
	default int getRojasEquipo(Participante equipo) {
		return getNumeroTipoTarjetasEquipo(TipoTarjeta.ROJA, equipo);
	}

	default String getAmarillasTotal() {
		return String.format(getFormatoTarjetas(), getAmarillasEquipo(getLocal()), getAmarillasEquipo(getVisitante()));
	}

	default String getRojasTotal() {
		return String.format(getFormatoTarjetas(), getRojasEquipo(getLocal()), getRojasEquipo(getVisitante()));
	}

}