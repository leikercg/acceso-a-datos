/* Muestra los ficheros (archivos o directorios) de
 * un determinado directorio que se cargan en un
 * array de elementos tipo String usando el m�todo list()
 */


import java.io.*;

public class UD1_VerDir {
	public static void main(String[] args) {
		String dir = ".";
		File f = new File(dir);
		String[] archivos = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),
					f2.isDirectory());
		}
	}
}


/*
 * System.out.println("�Se puede leer ?"+f.canRead()); System.out.println(
 * "�Se puede escribir ?"+f.canWrite()); System.out.println(
 * "Nombre del fichero : "+f.getName()); System.out.println(
 * "Ruta               : "+f.getPath()); System.out.println(
 * "Ruta absoluta      : "+f.getAbsolutePath()); System.out.println(
 * "Tama�o             : "+f.length()); System.out.println(
 * "Es un directorio   : "+f.isDirectory()); System.out.println(
 * "Es un fichero      : "+f.isFile()); System.out.println(
 * "Directorio padre   : "+f.getParent());
 * 
 * 
 * 
 */
