public class Charcos{
	/** 
 * Charcos:
 * Se genera el Grafo apartir de un archivo, provisto por el cliente.
 * se calcula el volumen maximo en metros cubicos que ocupa el agua
 * en la ciudad.
 * Parametros de entrada: 
 * @param String Nombre de archivo: args[0]
 * Parametros de salida:
 * @throws int VolumenMaximo: 
*/ 
	public static void main(String[] args){
		Digrafo g = new Digrafo();
		boolean success = g.cargarGrafo(args[0]);
		int resultado = ;
		System.out.println("El volumen es igual a " + String.valueOf(resultado) + " metros cubicos");

	}
}