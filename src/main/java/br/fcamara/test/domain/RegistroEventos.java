package br.fcamara.test.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "REGISTRO_EVENTOS")
public class RegistroEventos {
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "estabelecimento_id", referencedColumnName = "id")
	private Estabelecimento estabelecimento;
	@NotNull
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "veiculo_id", referencedColumnName = "id")
	private Veiculo veiculo;
	private LocalDateTime dateEvento;
	private Evento evento;

	public Long getId() {
		return id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public LocalDateTime getDateEvento() {
		return dateEvento;
	}

	public void setDateEvento(LocalDateTime dateEvento) {
		this.dateEvento = dateEvento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
