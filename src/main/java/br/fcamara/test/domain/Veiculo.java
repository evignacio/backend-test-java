package br.fcamara.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	@NotNull
	private String cor;
	@NotNull
	private String placa;
	@NotNull
	private TipoVeiculo tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

}
