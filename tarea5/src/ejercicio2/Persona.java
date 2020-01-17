package ejercicio2;

public class Persona implements java.io.Serializable {

	protected String nif;
	protected String nombre;
	protected int edad;
	
	public Persona(String n, String nom, int e) {
		nif = n;
		nombre = nom;
		edad = e;
	}
	public void print() {
		System.out.println(nif +" "+ nombre +" "+ edad);
	}
}


