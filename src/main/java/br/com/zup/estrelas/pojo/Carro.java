package br.com.zup.estrelas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	
	@Id
	private String chassi;
	@Column(length = 15, nullable = false)
	private String fabricante;
	@Column(length = 30, nullable = false)
	private String modelo;
	private int ano;
	@Column(length = 15, nullable = false)
	private String cor;
	@Column(length = 15, nullable = false)
	private String categoria;

	public Carro() {
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String frabricante) {
		this.fabricante = frabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String toString() {
		return "Carro chassi=" + chassi + ", fabricante=" + fabricante + ", modelo=" + modelo + ", ano=" + ano
				+ ", cor=" + cor + ", categoria=" + categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
