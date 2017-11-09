/**
 * Arista.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

public class Arista extends Lado
{
  private Vertice u;
  private Vertice v;

/** 
 * Arista:
 * Crea una arista con identificador, peso, vertice extremo 1 y vertice extremo 2 de la arista
 * Parametros de entrada: 
 * @param id: tipo String, identificador de la arista
 * @param peso: tipo Double, peso de la arista 
 * @param vi: objeto tipo Vertice, vertice extremo 1 de la arista
 * @param vf: objeto tipo Vertice, vertice extremo 2 de la arista
 * Parametros de salida:
 * @throws arista: objeto Arista
*/ 
  public Arista(String id, int altura, Vertice u, Vertice v) {
  	super(id, altura);
    id = id;
    altura = altura;
    this.u = u;
    this.v = v;
  }

/** 
 * getExtremo1:
 * Obtiene el vertice que es el extremo 1 de la arista
 * Parametros de entrada: 
 * @param arco: tipo Arco
 * Parametros de salida:
 * @throws u: tipo Vertice, vertice de la arista
*/ 
  public Vertice getExtremo1() {
  	return u;
  }

/** 
 * getExtremo2:
 * Obtiene el vertice que es el extremo 2 de la arista
 * Parametros de entrada: 
 * @param arista: tipo Arista
 * Parametros de salida:
 * @throws v: tipo Vertice, vertice de la arista
*/ 
  public Vertice getExtremo2() {
  	return v;
  }

/** 
 * toString:
 * Retorna la representacion en String de la arista
 * Parametros de entrada: 
 * @param arista: tipo Arista
 * Parametros de salida:
 * @throws String: tipo String, representacion en cadena de caracteres de la arista
*/ 
  public String toString() {
  	String space = " ";
    String pesoStr = Double.toString(this.getPeso());
    return this.getId() + space + u.getId() + space + v.getId() + space + pesoStr;
  }
}