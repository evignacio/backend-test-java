package br.fcamara.teste.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
public class Veiculo {
	
	@Id @GeneratedValue
	private Long Id;
	private String Marca;
	private String Modelo;
	private String Cor;
	private String Placa;
	private TipoVeiculo Tipo;
	
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public TipoVeiculo getTipo() {
		return Tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		Tipo = tipo;
	}

}
