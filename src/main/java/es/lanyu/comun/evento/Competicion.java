package es.lanyu.comun.evento;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import es.lanyu.commons.identificable.AbstractNombrable;
import es.lanyu.participante.Participante;

public class Competicion extends AbstractNombrable {
	public static Map<String, Competicion> mapaCompeticiones = new HashMap<>();
	
	public static final Competicion LA_LIGA = new Competicion("ESP-D1", "La Liga");
	public static final Competicion SEGUNDA = new Competicion("ESP-D2", "Segunda");
	public static final Competicion PREMIER = new Competicion("ING-D1", "Premier");
	public static final Competicion BUNDESLIGA = new Competicion("ALE-D1", "Bundesliga");
	public static final Competicion BUNDESLIGA_2 = new Competicion("ALE-D2", "Bundesliga 2");
	public static final Competicion LIGA_FRANCESA = new Competicion("FRA-D1", "Liga Francesa");
	public static final Competicion LIGA_FRANCESA_2 = new Competicion("FRA-D2", "Liga Francesa 2");
	public static final Competicion EREDIVISIE = new Competicion("HOL-D1", "Eredivisie");
	public static final Competicion JUPILER_BELGICA = new Competicion("BEL-D1", "Jupiler (Bélgica)");
	public static final Competicion PORTUGAL = new Competicion("POR-D1", "Portugal");
	public static final Competicion GRECIA = new Competicion("GRE-D1", "Grecia");
	public static final Competicion SERIE_A = new Competicion("ITA-D1", "Serie A");
	public static final Competicion CHAMPIONS_LEAGUE = new Competicion("CHL-EU", "Champions League");
	public static final Competicion EUROPA_LEAGUE = new Competicion("EUL-EU", "Europa League");
	public static final Competicion AMISTOSOS_CLUBES = new Competicion("AMI-CL", "Amistosos de Clubes");
	
	private Collection<Participante> participantes;

	public Collection<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Collection<Participante> participantes) {
		this.participantes = participantes;
	}

	public Competicion(String id, String nombre) {
		super();
		setIdentificador(id);
		setNombre(nombre);
		participantes = new HashSet<>();
		mapaCompeticiones.put(id, this);
	}
	
}
