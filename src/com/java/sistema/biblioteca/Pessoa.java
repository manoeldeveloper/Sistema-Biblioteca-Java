package com.java.sistema.biblioteca;

public class Pessoa {

	protected int idade, id;
	protected String nome, sexo;
	
    protected Pessoa(String nome, String sexo, int id, int idade) {
    	this.nome = nome;
    	this.sexo = sexo;
    	this.id = id;
    	this.idade = idade;
    }

	@Override
	public String toString() {
		return "\nNome: " + getNome() +
		       "\nID: " + getId() +
		       "\nSexo: " + getSexo() + 
		       "\nIdade: "+ getIdade();
	}

	protected int getIdade() {
		return idade;
	}

	protected void setIdade(int idade) {
		this.idade = idade;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getSexo() {
		return sexo;
	}

	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
