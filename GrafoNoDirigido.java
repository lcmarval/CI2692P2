/**
 * GrafoNoDirigido.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;
import java.io.*;

public class GrafoNoDirigido implements Grafo
{
    private LinkedList<Edificio> edificios;
    private LinkedList<Arista> aristas;
    private int nedificios;
    private int nLados;

/**
* GrafoNoDirigido:
* Creacion del grafo no dirigido
*/
    public GrafoNoDirigido() {
        edificios = new LinkedList<Edificio>();
        aristas = new LinkedList<Arista>();
        nedificios = 0;
        nLados = 0;
    }

/**
*cargarGrafo:
* Carga la información almacenada en un archivo de texto para crear un grafo.
* Parametros de entrada:
* @param g: grafo.
* @param dirArchivo: Nombre(direccion) del archivo con informacion.
* Parametros de salida:
* @throws boolean: true en caso de cargar exitosamente el grafo, false en caso contrario.
*/
    public boolean cargarGrafo(String dirArchivo) {

    	int n;
        String id, ext1, ext2;
        Double peso;

        try{
            BufferedReader buffer = new BufferedReader(new FileReader(dirArchivo));
            String linea;
            String[] datos;
            linea = buffer.readLine();
            n = Integer.parseInt(linea);

            linea = buffer.readLine();
            m = Integer.parseInt(linea);

            for(i=0; i == n-1; i++){
                for (j=0, j == m-1, j++){
                    linea = buffer.readLine();
                    String id = String.valueOf(i) + String.valueOf(j);
                    this.agregarEdificio(id,Integer.parseInt(linea));
                    // falta agregar arista
                }
            }

            }
            buffer.close();
            return true;
        }catch(IOException e){
            System.out.println("Hubo un error");
        }return false;
    }

/**
* numeroDeedificios:
* Indica el numero de edificios existentes en el grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws nedificios: tipo int, numero de edificios en el grafo
*/
    public int numeroDeedificios() {

        return edificios.size();
    }

/**
* numeroDeLados:f
* Indica el numero de lados existentes en el grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws nLados: tipo int, numero de lados en el grafo
*/
    public int numeroDeLados() {

        return aristas.size();
    }

/**
* agregarEdificio:
* Agrega el Edificio v al grafo g
* Parametros de entrada:
* @param g: grafo
* @param v: objeto tipo Edificio
* Parametros de salida:
* @throws boolean: true, en caso de agregar el Edificio de manera exitosa; false, en caso contrario
*/  
    public boolean agregarEdificio(Edificio v) {

        if(edificios.size() == 0) {
            edificios.addFirst(v);
            return true;
        }

        if(this.estaEdificio(v.getId())){
            return false;
        }
        edificios.add(v);
        return true;
    }

/**
* agregarEdificio:
* Agrega el Edificio v al grafo g
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* @param peso: tipo Double, peso del Edificio
* Parametros de salida:
* @throws boolean: true, en caso de agregar el Edificio de manera exitosa; false, en caso contrario
*/
    public boolean agregarEdificio(String id, double peso) {

        
        if(this.estaEdificio(id)){
            return false;
        }

        if(edificios.size() == 0) {
            Edificio v = new Edificio(id, peso);
            edificios.addFirst(v);
            return true;
        }

        Edificio v = new Edificio(id, peso);
        edificios.add(v);
        return true;
    }

/**
* obtenerEdificio:
* Retorna el Edificio contenido en el grafo que posee el identificador
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws Edificio: objeto tipo Edificio
*/    
    public Edificio obtenerEdificio(String id) {

        for(int i=0; i<edificios.size(); i++){
            if(edificios.get(i).getId().equals(id)){
                return edificios.get(i);
            }
        }
        throw new NoSuchElementException();
    }

/**
* estaEdificio:
* Indica si un Edificio con el identificador id se encuentra o no en el grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws boolean: true, en caso de que el Edificio exista en el grafo; false, en caso contrario
*/
    public boolean estaEdificio(String id) {

        for(int i=0; i<edificios.size(); i++){
            if (edificios.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }

/**
* estaLado:
* Indica si un lado pertenece al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del lado
* Parametros de salida:
* @throws boolean: true, en caso de que el lado pertenezca al grafo; false, en caso contrario
*/
    public boolean estaLado(String u, String v){

        for(int i=0; i<aristas.size(); i++){
            if (aristas.get(i).getExtremo1().equals(u) && aristas.get(i).getExtremo2().equals(v)){
                return true;
            }
        }
        return false;
    }

/**
* eliminarEdificio:
* Elimina el Edificio con identificador id del grafo g
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws boolean: true, en caso de que el Edificio se elimine exitosamente del grafo g; false, en caso contrario
*/
    public boolean eliminarEdificio(String id) {

        if (this.estaEdificio(id)){
            Edificio eliminar = this.obtenerEdificio(id);

            // Debo eliminar las aristas incidentes al vertive eliminar
            // Busco la arista
            for(int i=0;i<aristas.size();i++){
                if(aristas.get(i).getExtremo1().getId().equals(eliminar.getId()) || aristas.get(i).getExtremo2().getId().equals(eliminar.getId())){
                    this.eliminarArista(aristas.get(i).getId());
                }
            }
            edificios.remove(eliminar);
            return true;
        }
        return false;
    }

/**
* edificios:
* Retorna una lista con los edificios del grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws edificios: tipo Lista de Edificio, lista con los edificios contenidos en el grafo
*/
    public List<Edificio> edificios() {
        return edificios;
    }

/**
* lados:
* Retorna una lista con los lados del grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws aristas: tipo Lista de Arista, lista con los lados del grafo
*/
    public List<Lado> lados() {
        LinkedList<Lado> lados2 = new LinkedList<Lado>();
        for (int i=0;i<aristas.size();i++){
            lados2.add(aristas.get(i));
        }

        return lados2;
    }

/**
* grado:
* Calcula el grado del Edificio identificado por id en el grafo
* Parametros de entrada:
* @param g: grafo
* @param: id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws grado: tipo int, grado del Edificio
*/
    public int grado(String id) {

        if(!this.estaEdificio(id)){
            throw new NoSuchElementException();
        }
        Edificio vAux = this.obtenerEdificio(id);
        return vAux.adyacentes.size();
    }

/**
* adyacentes:
* Retorna una lista con los edificios adyacentes al Edificio con identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws vAux.adyacentes: tipo Lista de Edificio, lista con los edificios adyacentes al Edificio id
*/
    public List<Edificio> adyacentes(String id) {

        if(!this.estaEdificio(id)){
            throw new NoSuchElementException();
        }
        Edificio vAux = this.obtenerEdificio(id);
        return vAux.adyacentes;
    }

/**
* incidentes:
* Retorna una lista con los edificios incidentes al Edificio con identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del Edificio
* Parametros de salida:
* @throws listaIncidentes: tipo Lista de Lado, lista con los lados incidentes al Edificio id
*/ 
    public List<Lado> incidentes(String id) {

        if(!this.estaEdificio(id)){
            throw new NoSuchElementException();
        }
        LinkedList<Lado> listaIncidentes = new LinkedList<Lado>();
        for(int i=0; i<aristas.size(); i++){
            if(aristas.get(i).getExtremo1().getId().equals(id) || aristas.get(i).getExtremo2().getId().equals(id)){
                listaIncidentes.add(aristas.get(i));
            }
        }
        return listaIncidentes;
    }

/**
* clone:
* Retorna un nuevo grafo con la misma composición del grafo de entrada
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws : tipo GrafoNoDirigido, copia del grafo no dirigido original
*/
    public Object clone() {
        GrafoNoDirigido nvoGrafo = new GrafoNoDirigido();
        for (int i=0; i<edificios.size(); i++) {
            nvoGrafo.agregarEdificio(edificios.get(i));
        }
        for (int j=0; j<aristas.size(); j++) {
            nvoGrafo.agregarArista(aristas.get(j));
        }
        return nvoGrafo;
    }

/**
* toString:
* Devuelve una representacion del contenido del grafo como una cadena de caracteres
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws : tipo String, representacion del contenido del grafo en cadena de caracateres
*/
    public String toString() {
        String newLine = "\n";
        String salida = "";
        salida = salida + String.valueOf(edificios.size()) + newLine + String.valueOf(aristas.size()) + newLine;
        // guardar edificios en salida
        for(int i=0; i<edificios.size(); i++){
                salida = salida + edificios.get(i).toString() + newLine;
                }
        // guardar lados en salida
        for(int i=0; i<aristas.size(); i++){
                salida = salida + aristas.get(i).toString() + newLine;
                }
        // guardar salida a archivo
        File archivo = new File("GrafoNoDirigido.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(salida);
            bw.close();
        }
        catch(IOException e){
            System.out.println("Hubo un error al crear el archivo");
        }

        return salida;
    }

/**
* estaArista:
* Verifica que la arista con identificador id pertenezca al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador de la arista
* Parametros de salida:
* @throws boolean: true, en caso de que la arista pertenezca al grafo; false, en caso contrario
*/
    public boolean estaArista(String id){

        for(int i=0; i<aristas.size(); i++){
            if(aristas.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }

/**
* agregarArista:
* Agrega una nueva arista con identificador id al grafo
* Parametros de entrada:
* @param g: grafo
* @param a: tipo Arista, arista
* Parametros de salida:
* @throws boolean: true, en caso de que la arista se agregue de manera exitosa al grafo; false, en caso contrario
*/
    public boolean agregarArista(Arista a) {

        Edificio x;
        Edificio y;
        x = a.getExtremo1();
        y = a.getExtremo2();

        if (aristas.size() == 0){
            //Verificamos si los extremos de las aristas estan en la lista de edificios
            if(this.estaEdificio(x.getId()) && this.estaEdificio(y.getId())){
                aristas.addFirst(a);
                // Agregamos los edificios a la lista de adyacencias
                x.adyacentes.add(y);
                y.adyacentes.add(x);

                return true;

            }else{ // Caso en que alguno de los edificios no exista
                System.out.println("ERROR: Uno de los edificios de la arista" + a.getId() + "no existe");
                return false;
            }
        }

        //Verificamos si ya existe Arista a
        if(!this.estaArista(a.getId())){
            //Verificamos si los extremos de las aristas estan en la lista de edificios
            if(this.estaEdificio(x.getId()) && this.estaEdificio(y.getId())){
                aristas.add(a);
                // Agregamos los edificios a la lista de adyacencias
                x.adyacentes.add(y);
                y.adyacentes.add(x);

                return true;

            }else{ // Caso en que alguno de los edificios no exista
                System.out.println("ERROR: Uno de los edificios de la arista" + a.getId() + "no existe");
                return false;
            }
        }
        return false;
    }

/**
* agregarArista:
* Agrega una nueva arista con identificador id al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador de la arista
* @param peso: tipo Double, peso de la arista
* @param u: tipo Edificio, Edificio extremo de la arista
* @param v: tipo Edificio, Edificio extremo de la arista
* Parametros de salida:
* @throws boolean: true, en caso de que la arista se agregue de manera exitosa al grafo; false, en caso contrario
*/
    public boolean agregarArista(String id, double peso, String u, String v) {

        if(aristas.size() == 0){
            //Verificamos si los extremos de las aristas estan en la lista de edificios
            if(this.estaEdificio(u) && this.estaEdificio(v)){
                Arista a = new Arista(id,peso,obtenerEdificio(u),obtenerEdificio(v));
                aristas.addFirst(a);
                Edificio vert1 = this.obtenerEdificio(u);
                Edificio vert2 = this.obtenerEdificio(v);
                // Agregamos los edificios a la lista de adyacencias
                vert1.adyacentes.addFirst(vert2);
                vert2.adyacentes.addFirst(vert1);

                return true;
            }
            else{ // Caso en que alguno de los edificios no exista
                System.out.println("ERROR: Uno de los vértices de la arista" + id + "no existe");
                return false;
            }
        }

        //Verificamos si ya existe Arista a
        if(!this.estaArista(id)){
            //Verificamos si los extremos de las aristas estan en la lista de edificios
            if(this.estaEdificio(u) && this.estaEdificio(v)){
                Arista a = new Arista(id,peso,obtenerEdificio(u),obtenerEdificio(v));
                aristas.add(a);
                Edificio vert1 = this.obtenerEdificio(u);
                Edificio vert2 = this.obtenerEdificio(v);
                // Agregamos los edificios a la lista de adyacencias
                vert1.adyacentes.add(vert2);
                vert2.adyacentes.add(vert1);

                return true;
            }
            else{ // Caso en que alguno de los edificios no exista
                System.out.println("ERROR: Uno de los vértices de la arista" + id + "no existe");
                return false;
            }
        }
        return false;
    }

/**
* eliminarArista:
* Elimina la arista con identificador id del grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador de la arista
* Parametros de salida:
* @throws boolean: true, en caso de que la arista se elimine de manera exitosa al grafo; false, en caso contrario
*/

    public boolean eliminarArista(String id) {

        if(this.estaArista(id)){
            Arista aux = this.obtenerArista(id);
            aux.getExtremo1().adyacentes.remove(aux.getExtremo2());
            aux.getExtremo2().adyacentes.remove(aux.getExtremo1());
            aristas.remove(aux);

            return true;
        }
        return false;
    }

/**
* obtenerArista:
* Devuelve la arista que tiene como identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador de la arista
* Parametros de salida:
* @throws Arista: objeto tipo Arista, en caso de que la arista exista en el grafo; NoSuchElementException error, en caso contrario
*/
    public Arista obtenerArista(String id) {

        for(int i=0; i<aristas.size(); i++){
            if(aristas.get(i).getId().equals(id)){
                return aristas.get(i);
            }
        }
        throw new NoSuchElementException();
    }
}