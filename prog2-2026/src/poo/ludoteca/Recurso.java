package poo.ludoteca;

public class Recurso {
	
	protected static int contador = 1;
	
	protected int codigo;

	public Recurso() {
		super();
		this.codigo = Recurso.contador;
		Recurso.contador++;
	}

	@Override
	public String toString() {
		return "Recurso [codigo=" + codigo + "]";
	}
	
}
