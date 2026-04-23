package collections.repaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {

	public static void guardarBinario(ArrayList<String> palabras, String ruta) {
		// fos -> oos -> writeObject (Ojo, no olvidar Serializable)
		try {
			FileOutputStream fos = new FileOutputStream(ruta);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(palabras);
			oos.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error: problema de entrada/salida");
		}
	}

	public static ArrayList<String> cargarBinario(String ruta) {
		// fis -> ois -> readObject (Ojo, no olvidar Serializable)
		ArrayList<String> palabras = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(ruta);
			ObjectInputStream ois = new ObjectInputStream(fis);
			palabras = (ArrayList<String>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error: problema de entrada/salida");
		}
		return palabras;
	}

	public static void guardarTexto(ArrayList<String> palabras, String ruta) {
		try {
			PrintWriter pw = new PrintWriter(ruta);
			for (String palabra : palabras) {
				pw.println(palabra);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<String> cargarTexto(String ruta) {
		ArrayList<String> palabras = new ArrayList<String>();
		
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				palabras.add(campos[0]);
				palabras.add(campos[1]);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return palabras;
	}
	
	public static void main(String[] args) {
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<String> copia = new ArrayList<String>();
		
		palabras.add("hola;mundo;");
		palabras.add("eres;cruel;");
		palabras.add("pero;bien");

		guardarBinario(palabras, "palabras.dat");
		copia = cargarBinario("palabras.dat");
		
		System.out.println(copia);
		
		guardarTexto(palabras, "palabras.csv");
	}

}
