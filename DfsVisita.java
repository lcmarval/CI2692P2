/**
 * DfsVisita.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;

public class DfsVisita{
	public Hashtable<String,String> p;  // id, id
	public Hashtable<String,String> color;  // id, color
	//public Hashtable<String,Integer> d; // id, tiempo
	//public Hashtable<String,Integer> f; // id, tiempo
	//public LinkedList<Vertice> cola;
	//public int tiempo;

	public DfsVisita(){
		p = new Hashtable<String,String>();
		color = new Hashtable<String,String>(); 
		//d = new Hashtable<String,Integer>();
		//f = new Hashtable<String,Integer>();
		//cola = new LinkedList<Vertice>();
		//tiempo = 0;
	}

	public void llamadaDfsV(Grafo g){
		// inicializacion tablas
		for (Vertice v : g.vertices()){
			color.put(v.getId(), "blanco");
			p.put(v.getId(), "-");
		}
		// llamada DfsV
		for (Vertice v : g.vertices()){
			if (color.get(v.getId()).equals("blanco")){
				DfsV(v); 
			}
		}
		System.out.println(color);
	}

	/**
	*public void llamadaDfsV2(Grafo g, LinkedList<Vertice> cola){
	* llamada especial que toma en cuenta el ultimo en 
		* inicializacion tablas
	*	for (Vertice v : g.vertices()){
	*		color.put(v.getId(), "blanco");
	*		p.put(v.getId(), "-");
	*	}
	*	// llamada DfsV
	*	while (!cola.isEmpty()){
	*		//String vId = cola.remove();
	*		Vertice v = cola.remove();
	*		if (color.get(v.getId()).equals("blanco")){
	*			DfsV(v); 
	*		}
	*	}
	*}
	**/
	public String DfsV(Vertice v){
		//tiempo = tiempo + 1;
		//d.put(v.getId(), tiempo);
		if (v.getEstado().equals("0")){
			return v.getEstado();
		}
		color.put(v.getId(), "gris");
		String estadoActual = v.getEstado();
		for (Vertice w : v.predecesores){
			System.out.println("Entro con: " + v.getId() + ". Sucesor: " +  w.getId());
			if (color.get(w.getId()).equals("blanco")){
				p.put(w.getId(), v.getId());
				estadoActual = (DfsV(w));
				if (estadoActual.equals("0")){
					break;
				}
			}
		}
		v.setEstado(estadoActual);
		color.put(v.getId(), "negro");
		return estadoActual;
		//tiempo = tiempo + 1;
		//v.setEstado(estadoActual);
		//f.put(v.getId(), tiempo);
		//cola.add(v);
	}

	public Hashtable<String, String> obtenerPre(){
		return p;
	}

	public Hashtable<String, String> obtenerColor(){
		return color;
	}
	/**
	*public Hashtable<String, Integer> obtenerTiempoI(){
	*	return d;
	*}
	*public Hashtable<String, Integer> obtenerTiempoF(){
	*	return f;
	*}
	*public LinkedList<Vertice> obtenerCola(){
	*	return cola;
	*}
	**/
}