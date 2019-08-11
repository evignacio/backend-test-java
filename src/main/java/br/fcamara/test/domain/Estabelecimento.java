package br.fcamara.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue
	private Long Id;
	@NotNull
	private String nome;
	@NotNull
	private String cnpj;
	@NotNull
	private String endereco;
	@NotNull
	private String telefone;
	@NotNull
	private int qtVagasMoto;
	@NotNull
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
