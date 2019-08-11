package br.fcamara.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

	@Id @GeneratedValue
	private Long Id;
	private String Nome;
	private String CNPJ;
	private String Endereco;
	private String Telefone;
	private int QtVagasMoto;
	private int QtVagasCarro;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public int getQtVagasMoto() {
		return QtVagasMoto;
	}

	public void setQtVagasMoto(int qtVagasMoto) {
		QtVagasMoto = qtVagasMoto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getQtVagasCarro() {
		return QtVagasCarro;
	}

	public void setQtVagasCarro(int qtVagasCarro) {
		QtVagasCarro = qtVagasCarro;
	}
}
