/* Crea una lista de objetos (ListaPersonas) del tipo  (clase) Persona,
 * que obtiene leyendo desde un fichero .dat que incluye los datos.
 * Despu�s convierte la lista de objetos (ListaPersonas) en un fichero XML, es decir,  
 * serializa objetos Java a XML. Lo hace empleando la librer�a XStream => https://x-stream.github.io/download.html
 */

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class UD1_EscribirPersonas2 {
  
	public static void main(String[] args)  {  	
	File fichero = new File("FichPersona.dat");
	FileInputStream filein;
	try {
        filein = new FileInputStream(fichero);//crea el flujo de entrada   	
        ObjectInputStream dataIS = new ObjectInputStream(filein);      
	  System.out.println("Comienza el proceso de creaci�n del fichero a XML ...");
	  ListaPersonas listaper = new ListaPersonas();	      

      try {
           while (true) { //lectura del fichero
	         Persona persona= (Persona) dataIS.readObject(); //leer una Persona     
	         listaper.add(persona); //a�adir persona a la lista  
           }//del while	
        } catch (EOFException eo) {//fin de fichero bo hago nada
	  
        } catch (ClassNotFoundException  cn) {
             cn.printStackTrace();
        
        }//final bloque try interno

	  dataIS.close();  //cerrar stream de entrada     
	  
	  XStream xstream = new XStream();   
 	  xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);		
	  xstream.alias("DatosPersona", Persona.class);
	  xstream.addImplicitCollection(ListaPersonas.class, "lista");
	  xstream.toXML(listaper, new FileOutputStream("Personas.xml"));		
	  System.out.println("Creado fichero XML....");
	  
	} catch (IOException io) {
	    io.printStackTrace();

	} catch (Exception e)  {
		e.printStackTrace();
	}//final bloque try mas externo		
  
	} // fin main
} //fin EscribirPersonas
