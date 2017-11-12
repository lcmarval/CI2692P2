/**
 * FuertementeConexa.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

public class FuertementeConexa{
	public DfsVisita a;

	public FuertementeConexa(){
		a = new DfsVisita();
	}
	public Void algoritmo(Grafo g){
		a.llamadaDfsV(g);
		g2 = g.simetria();
		a.llamadaDfsV(g2); // llamada especial falta crear la llamada
	}
}