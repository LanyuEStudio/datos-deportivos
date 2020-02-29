package es.lanyu.comun.evento;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.lanyu.commons.servicios.entidad.ServicioEntidad;
import es.lanyu.commons.tiempo.Datable;
import es.lanyu.participante.Participante;

public class Partido extends EventoImpl implements 	EventoConGoles,
													EventoConCorners,
													EventoConTarjetas,
													ContadorDeMinutos {
	private transient Participante local;
	private String idLocal;
	private transient Participante visitante;
	private String idVisitante;
//	private transient Integer minuto = -1;
	private transient Competicion competicion;
	private String idCompeticion;
	static private SimpleDateFormat formatoDiaHora = new SimpleDateFormat("E dd/MM HH:mm");
	transient private ServicioEntidad servicioEntidad;
	
	protected ServicioEntidad getServicioEntidad() {
		System.err.println("GET ServicioEntidad");
		System.err.println(servicioEntidad);
		return servicioEntidad;
	}
	
	public void setServicioEntidad(ServicioEntidad servicioEntidad) {
		System.err.println("SET ServicioEntidad");
		System.err.println(servicioEntidad);
		this.servicioEntidad = servicioEntidad;
	}


	public static Comparator<Partido> getComparatorPartido(){
		return new Comparator<Partido>() {
			@Override
			public int compare(Partido partido1, Partido partido2) {
				int comparacion = Datable.getComparatorDatable(Instant.class).compare(partido1, partido2);
				if(comparacion == 0)
					comparacion = partido2.getMinuto().compareTo(partido1.getMinuto());
				
				return comparacion;
			}
		};
	}
	
	@Override
	public Participante getLocal() {
		if(local == null)
			local = getServicioEntidad().getIdentificable(Participante.class, idLocal);
		return local;
	}

	@Override
	public Participante getVisitante() {
		if(visitante == null)
			visitante = getServicioEntidad().getIdentificable(Participante.class,idVisitante);
		return visitante;
	}

//	public Integer getMinuto() {
//		return minuto;
//	}
//
//	public void setMinuto(Integer minuto) {
//		this.minuto = minuto;
//	}
	public Integer getMinuto() {
		return getMinutoActual();
	}
	
	public Competicion getCompeticion() {
		if(competicion == null)
			competicion = Competicion.mapaCompeticiones.get(idCompeticion);
		return competicion;
	}
	
	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
		this.idCompeticion = competicion.getIdentificador();
	}
	
	public Partido() {}
	
	public Partido(Participante local, Participante visitante) {
		super();
		this.local = local;
		this.visitante = visitante;
		
		try{
			this.idLocal = local.getIdentificador();
			this.idVisitante = visitante.getIdentificador();
		}
		catch (Exception e) {
			Logger logger = Logger.getLogger(getClass().getName());
			if(local == null || visitante == null)
				logger.log(Level.SEVERE, "No se puede crear un partido sin participantes válidos");
			else
				logger.log(Level.WARNING, "Error al crear el Partido: " + local + " vs " + visitante);
			
			logger.log(Level.INFO, "Verifique que se ha permitido registrar nuevos participantes en la configuración");
		}
		
	}
	
	@Override
	public String toString() {
		boolean empezo = estaEmpezado();
		boolean termino = estaTerminado();
		return 	((getFecha() != null)?" (" + formatoDiaHora.format(getFecha()) + ")":"")
				+ ((empezo)?" (min " + getMinuto() + "')":"") + " "
				+ getLocal() + " "
				+ ((empezo || termino)?
						(getGolesEquipo(getLocal()) + " - " + getGolesEquipo(getVisitante()) + " ")
						: "vs ")
				+ getVisitante();
	}
	
	public boolean estaEmpezado(){
		return getMinuto() >= 0;
	}
	
	public boolean estaTerminado(){
		if(getFecha() != null)
			return estimarHoraFin(getFecha()).before(Calendar.getInstance().getTime());
		else
			return false;
	}
	
	private Date estimarHoraFin(Date inicio){
		Calendar c = Calendar.getInstance();
		c.setTime(inicio);
		c.add(Calendar.MINUTE, 115);//Sumamos casi 2 horas como tiempo de partido
		return c.getTime();
	}
	
	public String detallesDelPartido(){
		return getResultadoYEquipos() + " " +
				((estaEmpezado() || estaTerminado())?
					(((getCorners().size() > 0)?"C:" + getCornersTotal() + " ":"") +
					((getTarjetas().size() > 0)?"Y:" + getAmarillasTotal() + " R:" + getRojasTotal() + " ":"") +
//					" el " + sDateFormat.format(getFecha()) +
					((getGanador() == null)?"empatan":"gana " + getGanador()) + " => " +
					((getGanador() == getLocal())?"1":(getGanador() == null)?"X":"2")).trim()
				:"")
				;
	}

	@Override
	public Participante getGanador() {
		return getGanador(getParticipantes());
	}

	@Override
	public String getResultado() {
		return EventoConGoles.super.getResultado();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((visitante == null) ? 0 : visitante.hashCode());
		result = prime * result + ((getFecha() == null) ? 0 : getFecha().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (visitante == null) {
			if (other.visitante != null)
				return false;
		} else if (!visitante.equals(other.visitante))
			return false;
		if (getFecha() == null) {
			if (other.getFecha() != null)
				return false;
		} else if (!getFecha().equals(other.getFecha()))
			return false;
		return true;
	}

}
