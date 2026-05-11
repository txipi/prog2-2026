package examenes.citybike;

public class Mecanica extends Bicicleta {

	public Mecanica(boolean operativa) {
		super(operativa);
	}
	
	public Mecanica() {
		super();
	}
	
	@Override
	public String toString() {
		return "Mecanica ["+ getCodigo() + "]";
	}

	@Override
	public String getCodigo() {
		return "M" + this.getNumero();
	}

	@Override
	public boolean usable() {
		return this.isOperativa();
	}
	
}
