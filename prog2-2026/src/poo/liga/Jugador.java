package poo.liga;

public abstract class Jugador implements Convocable, Fichable {

	protected static int contador = 1;
	
	protected int codigo;
	protected String nombre;
	protected int velocidad;
	protected int habilidad;
	protected int fuerza;

	public Jugador(String nombre, int velocidad, int habilidad, int fuerza) {
		super();
		this.codigo = Jugador.contador;
		Jugador.contador++;
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.habilidad = habilidad;
		this.fuerza = fuerza;
	}
	
	public Jugador() {
		super();
		this.codigo = Jugador.contador;
		Jugador.contador++;
		this.nombre = "";
		this.velocidad = 0;
		this.habilidad = 0;
		this.fuerza = 0;
	}
	
	public abstract double getStats();
	
	@Override
	public void convocar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desconvocar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vender() {
		// TODO Auto-generated method stub
		return false;
	}

}
