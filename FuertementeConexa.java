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
	public void algoritmo(Digrafo g){
		a.llamadaDfsV(g);
		Digrafo g2 = g.clone();
		a.llamadaDfsV(g2); // llamada especial falta crear la llamada
	}
}