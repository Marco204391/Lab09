package it.polito.tdp.metrodeparis.model;

public class Linea {

	private int id_linea;
	private String nome;
	private double velocita;
	private double intervallo;
	
	
	public Linea(int id_linea, String nome, double velocita, double intervallo) {
		this.id_linea = id_linea;
		this.nome = nome;
		this.velocita = velocita;
		this.intervallo = intervallo;
	}
	public Linea(int id_linea){
		this.id_linea = id_linea;
	}
	/**
	 * @return the idLinea
	 */
	public int getIdLinea() {
		return id_linea;
	}
	/**
	 * @param idLinea the idLinea to set
	 */
	public void setIdLinea(int idLinea) {
		this.id_linea = idLinea;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the velocita
	 */
	public double getVelocita() {
		return velocita;
	}
	/**
	 * @param velocita the velocita to set
	 */
	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	/**
	 * @return the intervallo
	 */
	public double getIntervallo() {
		return intervallo;
	}
	/**
	 * @param intervallo the intervallo to set
	 */
	public void setIntervallo(int intervallo) {
		this.intervallo = intervallo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public String toString() {
		return "Linea --> idLinea=" + id_linea + ", nome=" + nome + ", velocita=" + velocita + ", intervallo=" + intervallo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_linea;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
	
}
