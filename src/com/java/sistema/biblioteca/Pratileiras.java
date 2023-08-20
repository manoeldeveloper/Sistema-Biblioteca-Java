package com.java.sistema.biblioteca;

public class Pratileiras {
	
	protected int corredor, pratileira;
	
	protected Pratileiras(int corredor, int pratileira) {
		this.corredor = corredor;
		this.pratileira = pratileira;
	}

	protected int getCorredor() {
		return corredor;
	}

	protected void setCorredor(int corredor) {
		this.corredor = corredor;
	}

	protected int getPratileira() {
		return pratileira;
	}

	protected void setPratileira(int pratileira) {
		this.pratileira = pratileira;
	}

	@Override
	public String toString() {
		return "\nCorredor: " + getCorredor() + 
			   "\nPratileira: " + getPratileira();
	}
}
