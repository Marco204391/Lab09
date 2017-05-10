package it.polito.tdp.metrodeparis.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.metrodeparis.dao.MetroDAO;

public class Model {

	private SimpleWeightedGraph<Fermata, DefaultWeightedEdge>graph=null;
	private List<Fermata> fermate;
	private List<Linea> linee;
	private List<Connessione> connessioni;
	
	public List<Fermata> getFermate(){
		if(this.fermate==null){
			MetroDAO dao = new MetroDAO();
			this.fermate= dao.getAllFermate();
		}
	return this.fermate;		
	}
	
	public void createGraph(){
		
		graph= new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		MetroDAO dao = new MetroDAO();
		linee= dao.getAllLinee();
		fermate=dao.getAllFermate();
		connessioni= dao.getAllConnessioni(fermate, linee);
		
		Graphs.addAllVertices(graph, fermate);
		
		for(Connessione c : connessioni){
			
			double v = c.getLinea().getVelocita();
			double distanz= LatLngTool.distance(c.getStazione_P().getCoords(),c.getStazione_A().getCoords(), LengthUnit.KILOMETER);
			double tempo=(distanz/v)*60*60;
			
			Graphs.addEdge(graph,c.getStazione_A(), c.getStazione_P(), tempo);
		}
		
		System.out.println("Grafo creato : numero di vertici "+ graph.vertexSet().size()+ " e numero archi " + graph.edgeSet().size());
	
	}
	
}
