package collections.amazon;

public class Pedido {
	protected String descripcion;
	protected int cobrar;
	protected int preparar;
	protected int enviar;
	
	public Pedido(String descripcion, int cobrar, int preparar, int enviar) {
		super();
		this.descripcion = descripcion;
		this.cobrar = cobrar;
		this.preparar = preparar;
		this.enviar = enviar;
	}
	
	public Pedido() {
		super();
		this.descripcion = "";
		this.cobrar = 0;
		this.preparar = 0;
		this.enviar = 0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCobrar() {
		return cobrar;
	}

	public void setCobrar(int cobrar) {
		this.cobrar = cobrar;
	}

	public int getPreparar() {
		return preparar;
	}

	public void setPreparar(int preparar) {
		this.preparar = preparar;
	}

	public int getEnviar() {
		return enviar;
	}

	public void setEnviar(int enviar) {
		this.enviar = enviar;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
}
