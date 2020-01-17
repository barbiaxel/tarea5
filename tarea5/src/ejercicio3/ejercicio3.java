package ejercicio3;

import java.io.BufferedReader;
import java.io.*;
public class ejercicio3 {

	 public static void mostrarFichero() {
	        FileReader fr = null;
	        try {
	            File fichero = new File("C:\\Users\\Usuario\\git\\tarea5\\tarea5\\numeros.txt");
	            fr = new FileReader(fichero);
	            BufferedReader br = new BufferedReader(fr);
	            leerFichero(br);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (fr != null) {
	                    fr.close();
	                }
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }
	 
	    public static void leerFichero(BufferedReader br) throws Exception {
	        String linea;
	        int suma = 0;
	        int num;
	 
	        linea = br.readLine();
	 
	        while (linea != null) {
	 
	            num = Integer.parseInt(linea);
	            suma = suma + num;
	            linea = br.readLine();
	        }
	        System.out.println("La suma de los numeros es: " + suma);
	    }
	 
	    public static void main(String[] args) {
	        mostrarFichero();
	    }
	 
}


