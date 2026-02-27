package poo.paint;

import java.awt.Color;

public class Principal {

	public static void main(String[] args) {
		Dibujo dibujo1 = new Dibujo();
		dibujo1.setFichero("dibujo1.png");
		
		Texto texto1 = new Texto(500, 200, Color.RED, "¡Hola, mundo!");
		dibujo1.getTextos().add(texto1);
		
		Texto texto2 = new Texto(500, 400, Color.GREEN, "Esto es una prueba");
		dibujo1.getTextos().add(texto2);
		
		Circulo circulo1 = new Circulo(100, 100, Color.YELLOW, 25);
		dibujo1.getFormas().add(circulo1);
		
		Rectangulo rect1 = new Rectangulo(500, 500, Color.PINK, 100, 25);
		dibujo1.getFormas().add(rect1);
		
		System.out.println(dibujo1);

	}

}
