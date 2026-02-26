package poo.zoo;

public class Mamifero extends Animal {
	protected int camada;

	public Mamifero(String nombre, double edad, int camada) {
		super(nombre, edad);
		this.camada = camada;
	}
	
	public Mamifero() {
		super();
		this.camada = 0;
	}
	
	public Mamifero(Mamifero m) {
		super(m.nombre, m.edad);
		this.camada = m.camada;
	}

	public int getCamada() {
		return camada;
	}

	public void setCamada(int camada) {
		this.camada = camada;
	}

	@Override
	public String toString() {
		return "Mamifero [camada=" + camada + ", codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}	
	
}
