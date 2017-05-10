package it.polito.tdp.metrodeparis.model;

public class Connessione {

	private int id_connessione;
	private Linea linea;
	private Fermata stazione_P;
	private Fermata stazione_A;
	
	public Connessione(int id_connessione, Linea linea, Fermata stazione_P, Fermata stazione_A) {
		super();
		this.id_connessione = id_connessione;
		this.linea = linea;
		this.stazione_P = stazione_P;
		this.stazione_A = stazione_A;
	}
	/**
	 * @return the id_connessione
	 */
	public int getId_connessione() {
		return id_connessione;
	}
	/**
	 * @param id_connessione the id_connessione to set
	 */
	public void setId_connessione(int id_connessione) {
		this.id_connessione = id_connessione;
	}
	/**
	 * @return the linea
	 */
	public Linea getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	/**
	 * @return the stazione_P
	 */
	public Fermata getStazione_P() {
		return stazione_P;
	}
	/**
	 * @param stazione_P the stazione_P to set
	 */
	public void setStazione_P(Fermata stazione_P) {
		this.stazione_P = stazione_P;
	}
	/**
	 * @return the stazione_A
	 */
	public Fermata getStazione_A() {
		return stazione_A;
	}
	/**
	 * @param stazione_A the stazione_A to set
	 */
	public void setStazione_A(Fermata stazione_A) {
		this.stazione_A = stazione_A;
	}
	
	
}
