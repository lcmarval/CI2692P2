/**
 * DfsVisita.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

public class DfsVisita{
	public HashTable<String, String> p;  // id, id
	public HashTable<String, String> color;  // id, color
	public HashTable<String, int> d; // id, tiempo
	public HashTable<String, int> f; // id, tiempo

	public DfsVisita(){
		p = new HashTable<String, String>();
		color = new HashTable<String, String>(); 
		d = new HashTable<String, int>();
		f = new HashTable<String, int>()
		int tiempo = 0;
	}

	public void llamadaDfsV(Grafo g){
		// inicializacion tablas
		for (Vertice v : g.vertices()){
			color.put(v.getId(), "blanco");
			p.put(v.getId(), null);
		}
		// llamada DfsV
		for (Vertice v : g.vertices()){
			if color.get(v.getId()).equals("blanco"){
				DfsV(v); 
			}
		}
	}

	public void DfsV(Vertice v){
		tiempo = tiempo + 1;
		d.put(v.getId(), tiempo);
		color.put(v.getId(), "gris");
		for (Vertice w : v.adyacentes()){
			if color.get(w.getId()).equals("blanco"){
				p.put(w.getId(), v.getId());
				DfsV(w);
			}
		}
		color.put(v.getId(), "negro");
		tiempo = tiempo + 1;
		f.put(v.getId(), tiempo);
	}

	public HashTable<String, String> obtenerPre(){
		return p;
	}

	public HashTable<String, String> obtenerColor(){
		return color;
	}

	public HashTable<String, int> obtenerTiempoI(){
		return d;
	}

	public HashTable<String, int> obtenerTiempoF(){
		return f;
	}
}