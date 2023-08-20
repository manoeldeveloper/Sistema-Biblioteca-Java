package com.java.sistema.biblioteca;


public class Conta {
	
	private Livros Livros;
	private Pessoa Pessoa;

	public Conta(Pessoa pessoa, Livros livros) {
		this.Pessoa = pessoa;
		this.Livros = livros;
	}

	protected Livros getLivros() {
		return Livros;
	}

	protected void setLivros(Livros livros) {
		Livros = livros;
	}

	protected Pessoa getPessoa() {
		return Pessoa;
	}

	protected void setPessoa(Pessoa pessoa) {
		Pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "\n#######################\n" + "\nConta que Alugou: " + getPessoa() + 
			   "\n\nLivro Alugado: " + getLivros() + "\n#######################\n";
	}


	

}
