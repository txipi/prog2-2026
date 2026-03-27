package api.agenda.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Principal {
	public static void main(String[] args) {
		Contacto c1 = new Contacto();
		Contacto c2 = new Contacto();
		Contacto c3 = new Contacto();
		c1.nombre = "XYZ";
		c1.telefono = "123";
		c1.email = "xyz@gmail.com";
		c2.nombre = "ABC";
		c2.telefono = "000123";
		c1.email = "xyz@abc.com";
		c3.nombre = "MNO";
		c3.telefono = "567";
		c3.email = "faisan@gmail.com";
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		contactos.add(c1);
		contactos.add(c2);
		contactos.add(c3);
		contactos.add(new Contacto()); // objeto anónimo, no se llama c4
		
		// Ordenamos por nombre, usando el criterio que hemos puesto en compareTo
		Collections.sort(contactos);
		System.out.println(contactos);
		
		// Ordenamos por telefono, usando un Comparator
		contactos.sort(new Comparator<Contacto>() {

			@Override
			public int compare(Contacto o1, Contacto o2) {
				return o1.telefono.compareTo(o2.telefono);
			}});
		System.out.println(contactos);
		
		// Ordenamos por email, usando un Comparator
		contactos.sort(new Comparator<Contacto>() {

			@Override
			public int compare(Contacto o1, Contacto o2) {
				return o1.email.compareTo(o2.email);
			}});
		System.out.println(contactos);
		
	}
}
