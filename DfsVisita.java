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
	private int suma;
	private LinkedList<Vertice> alturas;	// lista para medir alturas


/** 
 * DfsVisita:
 * Inicializa la clase DfsVisita, crea las tablas de Hash (p,color)
*/ 
	public DfsVisita(){
		p = new Hashtable<String,String>();
		color = new Hashtable<String,String>();
		alturas = new LinkedList<Vertice>(); 
		suma = 0;

	}
/** 
 * llamadaDfsV:
 * llama a la funcion DfsV en todos los vertices
 * Parametros de entrada: 
 * @param Grafo g(V,E)
 * Parametros de salida:
 * void
*/ 
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
			if (!alturas.isEmpty()){
				int mayorInm = v.sucesores.get(0).getAltura();
				for (Vertice w: alturas){
					for (Vertice u: w.sucesores){
						if (u.getAltura() < mayorInm && u.getAltura() > w.getAltura()){
							mayorInm = u.getAltura();
						}
					}
				}
				System.out.println(" MA alto menor:" + String.valueOf(mayorInm));
				for(Vertice z: alturas){
					suma = suma + (mayorInm - z.getAltura());
				}
				alturas.clear();
			}
		}
	}

/** 
 * DfsV:
 * funcion DfsV que visita visita los vertices alcanzables por v
 * Parametros de entrada: 
 * @param Vertice v
 * Parametros de salida:
 * @throws p: Tabla de Hash
 * @throws color: Tabla de Hash
*/ 
	public String DfsV(Vertice v){

		if (v.getEstado().equals("0")){
			return v.getEstado();
		}
		alturas.add(v);
		color.put(v.getId(), "gris");
		String estadoActual = v.getEstado();
		for (Vertice w : v.predecesores){
			if (color.get(w.getId()).equals("blanco")){
				p.put(w.getId(), v.getId());
				estadoActual = (DfsV(w));
				if (estadoActual.equals("0")){
					break;
				}
			}
		}
		v.setEstado(estadoActual);
		if (v.getEstado().equals("x")){
			alturas.add(v);
		}
		color.put(v.getId(), "negro");
		return estadoActual;
	}


/** 
 * obtenerPre:
 * funcion que retorna los predecesores
 * Parametros de entrada: 
 * void
 * Parametros de salida:
 * @throws p: Tabla de Hash
*/ 
	public Hashtable<String, String> obtenerPre(){
		return p;
	}

/** 
 * obtenerPre:
 * funcion que retorna los predecesores
 * Parametros de entrada: 
 * void
 * Parametros de salida:
 * @throws p: Tabla de Hash
*/ 
	public int suma(){
		return suma;
	}

/** 
 * obtenerColor:
 * funcion que retorna los predecesores
 * Parametros de entrada: 
 * void
 * Parametros de salida:
 * @throws color: Tabla de Hash
*/ 
	public Hashtable<String, String> obtenerColor(){
		return color;
	}
	
}