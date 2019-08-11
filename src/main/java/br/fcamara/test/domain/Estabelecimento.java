package br.fcamara.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue
	private Long Id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private int qtVagasMoto;
	private int qtVagasCarro;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtVagasMoto() {
		return qtVagasMoto;
	}

	public void setQtVagasMoto(int qtVagasMoto) {
		this.qtVagasMoto = qtVagasMoto;
	}

	public int getQtVagasCarro() {
		return qtVagasCarro;
	}

	public void setQtVagasCarro(int qtVagasCarro) {
		this.qtVagasCarro = qtVagasCarro;
	}

}
