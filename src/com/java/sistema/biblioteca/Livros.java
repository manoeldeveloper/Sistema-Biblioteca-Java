package com.java.sistema.biblioteca;

import java.util.Scanner;

public class Livros {
	
	protected int numLivro;
	protected String nome, autor, editora;
	Pratileiras pratileiras;
	
	Scanner leia = new Scanner(System.in);
	
	protected Livros(int numLivro, String nome, String autor, String editora, Pratileiras pratileiras) {
		this.numLivro = numLivro;
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.pratileiras = pratileiras;
	}

	protected int getNumLivro() {
		return numLivro;
	}

	protected void setNumLivro(int numLivro) {
		this.numLivro = numLivro;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getAutor() {
		return autor;
	}

	protected void setAutor(String autor) {
		this.autor = autor;
	}

	protected String getEditora() {
		return editora;
	}

	protected void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "\nNúmero Livro: " + getNumLivro() + 
			   "\nNome do livro: " + getNome() +
			   "\nAutor: " + getAutor() +
			   "\nEditora: " + getEditora() +
			   "\n\nLocalização do Livro: " + pratileiras;
	}
}
