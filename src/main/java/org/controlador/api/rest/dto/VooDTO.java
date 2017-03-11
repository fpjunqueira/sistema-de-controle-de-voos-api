package org.controlador.api.rest.dto;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VooDTO {

	private Long id;

	private Date partida;
	private Date chegada;
	private PilotoDTO piloto;
	private AviaoDTO aviao;
	private AeroportoDTO origem;
	private AeroportoDTO destino;
	private String status;

	public VooDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPartida() {
		return partida;
	}

	public void setPartida(Date partida) {
		this.partida = partida;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}

	public PilotoDTO getPiloto() {
		return piloto;
	}

	public void setPiloto(PilotoDTO piloto) {
		this.piloto = piloto;
	}

	public AviaoDTO getAviao() {
		return aviao;
	}

	public void setAviao(AviaoDTO aviao) {
		this.aviao = aviao;
	}

	public AeroportoDTO getOrigem() {
		return origem;
	}

	public void setOrigem(AeroportoDTO origem) {
		this.origem = origem;
	}

	public AeroportoDTO getDestino() {
		return destino;
	}

	public void setDestino(AeroportoDTO destino) {
		this.destino = destino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String formatarData(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
	}

	public String getHorarioDeChegadaLocal() {
		return formatarData(calcularHorarioLocal(getDestino().getUtc(), getChegada()));
	}

	public String getHorarioDePartidaLocal() {
		return formatarData(calcularHorarioLocal(getOrigem().getUtc(), getPartida()));
	}

	public String getHorarioDeChegadaUTC() {
		return formatarData(this.chegada);
	}

	public String getHorarioDePartidaUTC() {
		return formatarData(this.partida);
	}

	private Date calcularHorarioLocal(String utc, Date horario) {
		Date horarioChegadaLocalDate= null;
		if (utc != null && !"".equals(utc) && horario != null) {
			String split = utc.split(":")[0];
			int valor = Integer.parseInt(split.substring(utc.split(":")[0].length() - 1));
			
			Calendar horarioChegadaLocalCalendar = Calendar.getInstance();
			horarioChegadaLocalCalendar.setTime(horario);
			
			if (utc.contains("+")) {
				horarioChegadaLocalCalendar.add(Calendar.HOUR_OF_DAY, valor);
			} else {
				horarioChegadaLocalCalendar.add(Calendar.HOUR_OF_DAY, -valor);
			}
			horarioChegadaLocalDate = horarioChegadaLocalCalendar.getTime();
		}
		return horarioChegadaLocalDate;
	}
	
}
