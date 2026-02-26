package poo.zoo;

public class Ave extends Animal {
	protected boolean vuela;

	public Ave(String nombre, double edad, boolean vuela) {
		super(nombre, edad); // llama al constructor Animal(nombre, edad)
		this.vuela = vuela;
	}
	
	public Ave() {
		super(); // llama al constructor Animal()
		this.vuela = false;
	}
	
	public Ave(Ave a) {
		super(a.nombre, a.edad); // llama al constructor Animal(a.nombre, a.edad)
		this.vuela = a.vuela;
	}
	
	public boolean isVuela() {
		return vuela;
	}

	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}

	@Override
	public String toString() {
		return "Ave [vuela=" + vuela + ", codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	
}
