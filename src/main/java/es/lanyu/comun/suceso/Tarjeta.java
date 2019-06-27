package es.lanyu.comun.suceso;

import es.lanyu.comun.suceso.TarjetaImpl.TipoTarjeta;

public interface Tarjeta extends Suceso {

	TipoTarjeta getTipoTarjeta();

	String toString();

}