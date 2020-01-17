package ejercicio2;
import java.io.*;

public class TestEjercicio2 {

	public static void main(String[] args) {
		String [] nif = {"20400200F","19000100S","46150200H"};
		String [] nombre = {"Marcelina","Paquita","Bienvenida"};
		int [] edad = {75, 80, 78};
		
		//escritura del fichero
		try{
		// Creamos un ObjectOutputStream asociado a un FileOutputStream para escribir
		// objetos en un flujo de salida y al conectarlos al fichero se escriben en el.
			FileOutputStream fs = new FileOutputStream("persona.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			for (int i=0; i<3; i++) {
				// construimos un objeto con los datos deseados y lo escribimos
				// en el flujo de salida ObjectOutputStream con el método writeObject	
				Persona a = new Persona(nif[i],nombre[i],edad[i]);
				oos.writeObject(a); //escribe el objeto en el flujo salida
			}
		
			// Cerramos los flujos abiertos una vez utilizados
			if (oos != null) {
				oos.close( );
				fs.close( );
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		
		// lectura del fichero (de manera análoga a la escritura)
		try{
			File f = null;
			FileInputStream fe = null;
			ObjectInputStream ois = null;
			try {
				f = new File("persona.dat");
				if (f.exists( )) {
				// Asociamos el FileInputStream con el ObjectInputStream
					fe = new FileInputStream (f);
					ois = new ObjectInputStream (fe);
					while (true) {
					// Lectura de datos hasta encontrar fin del fichero
						Persona a = null;
						a = (Persona) ois.readObject( );
						a.print( );
						System.out.println(" ");
					}
				}
			} catch (EOFException eof) {
			// Excepción de fin de fichero atrapada por el bloque catch
			System.out.println("FIN DE FICHERO");
			} catch (FileNotFoundException fnf) {
			System.err.println("Fichero no encontrado " + fnf);
			} catch (IOException e) {
			System.err.println("Se ha producido una IOException");
			e.printStackTrace();
			} catch (Throwable e) {
			System.err.println("Error de programa" + e);
			e.printStackTrace();
			} finally {
				if (ois != null) {
					ois.close( );
					fe.close( );
				}
			}
		} catch(IOException e) {
		e.printStackTrace();
		}		
	}
}
