public class GrafoCliente{
	public FuertementeConexa a;
	public static void main(String[] args){
		Digrafo g = new Digrafo();
		boolean success = g.cargarGrafo(args[0]);
		System.out.println(g.toString());
		FuertementeConexa a = new FuertementeConexa();
		a.algoritmo(g);
		//a.obtenerPre().toString();
	}
}