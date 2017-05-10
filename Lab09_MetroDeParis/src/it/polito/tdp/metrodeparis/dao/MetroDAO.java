package it.polito.tdp.metrodeparis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javadocmd.simplelatlng.LatLng;

import it.polito.tdp.metrodeparis.model.Connessione;
import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Linea;

public class MetroDAO {

	public List<Fermata> getAllFermate() {

		final String sql = "SELECT id_fermata, nome, coordx, coordy FROM fermata ORDER BY nome ASC";
		List<Fermata> fermate = new ArrayList<Fermata>();

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Fermata f = new Fermata(rs.getInt("id_Fermata"), rs.getString("nome"), new LatLng(rs.getDouble("coordx"), rs.getDouble("coordy")));
				fermate.add(f);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return fermate;
	}
	

	public List <Linea> getAllLinee(){
		
		final String sql = "SELECT id_linea, nome, velocita, intervallo FROM linea ORDER BY id_linea ASC";
		List<Linea> linee = new ArrayList<Linea>();

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Linea l = new Linea(rs.getInt("id_Linea"), rs.getString("nome"), rs.getInt("velocita"), rs.getInt("intervallo"));
				linee.add(l);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return linee;
		
	}


	public List<Connessione> getAllConnessioni(List<Fermata> fermate, List<Linea> linee) {

		final String sql = "SELECT id_connessione, id_linea	, id_stazP, id_stazA FROM connessione ";
		List<Connessione> connessioni = new ArrayList<Connessione>();
		
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int id_linea=rs.getInt("id_linea");
				int id_stazP=rs.getInt("id_stazP");
				int id_stazA=rs.getInt("id_stazA");
			
				Linea l=linee.get(linee.indexOf(new Linea(id_linea)));
				Fermata stA=fermate.get(fermate.indexOf(new Fermata(id_stazA)));
				Fermata stP=fermate.get(fermate.indexOf(new Fermata(id_stazP)));
				
				Connessione cnx = new Connessione(rs.getInt("id_connessione"), l, stP, stA);
				connessioni.add(cnx);
				
			}
			st.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return connessioni;
	}
	
}
