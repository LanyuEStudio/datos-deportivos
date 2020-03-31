package es.lanyu.comun.evento;

import java.time.Instant;
import java.util.Date;

import es.lanyu.commons.tiempo.Datable;

public interface ContadorDeMinutos extends Datable<Instant> {
	
	static Integer getMinutoDesdeHasta(Date desde, Date hasta) {
		if(hasta == null || desde == null)
			return null;
		else
			return (int) (((hasta.getTime() - desde.getTime())/(60000)));
	}
	
	default Integer getMinutoActual() {
		return getMinutoDesdeHasta(getFecha(), new Date());
	}
	
}
