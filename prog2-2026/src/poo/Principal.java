package poo;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Circulo c1 = new Circulo();
		c1.setRadio(0.5);
		System.out.println(c1.getRadio());
		System.out.println(c1.getColor());
		System.out.println(c1);

		
		Circulo c2 = new Circulo(3.0, "blue");
		c2.setRadio(25.0);
		System.out.println(c2.getRadio());
		System.out.println(c2.getColor());
		
		Contacto contacto1 = new Contacto("Pablo", "Garaizar", "666666666", "garaizar@deusto.es", "");
		System.out.println(contacto1);
		System.out.println(contacto1.getNombre());
		
		Agenda agenda1 = new Agenda();
		System.out.println(agenda1);
		agenda1.setNombre("personal");
		agenda1.getContactos().add(contacto1);
		System.out.println(agenda1);
		
		Superheroe super1 = new Superheroe();
		ArrayList<String> poderesIronman = new ArrayList<String>();
		poderesIronman.add("Dinero");
		poderesIronman.add("Inteligencia");
		poderesIronman.add("Volar");
		Superheroe ironman = new Superheroe("Ironman", false, poderesIronman, "Marvel", 2008, "masculino", 70, true);
		Superheroe ironwoman = new Superheroe(ironman);
		ironwoman.setNombre("Ironwoman");
		ironwoman.setGenero("femenino");
		ironwoman.getPoderes().add("Empatía");
		
		System.out.println(super1);
		System.out.println(ironman);
		System.out.println(ironwoman);
		
	}

}
