package br.fcamara.teste.domain;

import javax.persistence.Entity;

@Entity
public class Veiculo {
	private String Marca;
	private String Modelo;
	private String Cor;
	private String Placa;
	private TipoVeiculo Tipo;

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
