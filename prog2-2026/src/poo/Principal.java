package poo;

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
	}

}
