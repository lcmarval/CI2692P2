/**
 * FuertementeConexa.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;

public class FuertementeConexa{
	public DfsVisita a;
	//public Hashtable<String,String> pre;
	public FuertementeConexa(){
		a = new DfsVisita();
	}
	public void algoritmo(Digrafo g){
		a.llamadaDfsV(g);
		Hashtable<String, Integer> tiempo1 = a.obtenerTiempoI();
		System.out.println(tiempo1.toString());
		Digrafo g2 = g.simetria();
		LinkedList<Vertice> colaG = a.obtenerCola();
		a.llamadaDfsV2(g2, colaG);
		// output arboles dfs (componentes fuertemente conexas)
		
	
	}
}