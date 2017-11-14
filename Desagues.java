public class Desagues{
	public DfsVisita a;
	/** 
 * Desagues:
 * Se genera el Grafo apartir de un archivo, provisto por el cliente.
 * Se retorna una matriz que muestra con "x" los lugares donde,
 * se requiere un desague
 * Parametros de entrada: 
 * @param String Nombre de archivo: args[0]
 * Parametros de salida:
 * @throws matriz: impresion
*/ 
	public static void main(String[] args){
		Digrafo g = new Digrafo();
		boolean success = g.cargarGrafo(args[0]);
		DfsVisita a = new DfsVisita();
		a.llamadaDfsV(g);
		System.out.println(g.toStringMatriz());	
	}
}