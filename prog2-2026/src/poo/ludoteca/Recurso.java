package poo.ludoteca;

public abstract class Recurso {
	
	protected static int contador = 1;
	
	protected int codigo;

	public Recurso() {
		super();
		this.codigo = Recurso.contador;
		Recurso.contador++;
	}
	
	public abstract boolean esFamiliar();

	@Override
	public String toString() {
		return "Recurso [codigo=" + codigo + "]";
	}
	
}
