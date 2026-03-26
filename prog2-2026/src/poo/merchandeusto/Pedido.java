package poo.merchandeusto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	protected static int contador = 1;
	
	protected int codigo;
	protected Cliente cliente;
	protected LocalDate fecha;
	protected ArrayList<Producto> productos;
	
	public Pedido(Cliente cliente, LocalDate fecha, ArrayList<Producto> productos) {
		super();
		this.codigo = Pedido.contador;
		Pedido.contador++;
		this.cliente = cliente;
		this.fecha = fecha;
		this.productos = new ArrayList<Producto>(productos);
	}
	
	public Pedido() {
		super();
		this.codigo = Pedido.contador;
		Pedido.contador++;
		this.cliente = null;
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<Producto>();
	}
	
	public Pedido(Pedido p) {
		super();
		this.codigo = Pedido.contador;
		Pedido.contador++;
		this.cliente = p.cliente;
		this.fecha = p.fecha;
		this.productos = new ArrayList<Producto>(p.productos);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente + ", fecha=" + fecha + ", productos=" + productos
				+ "]";
	}
	
	public double totalPedido() {
		double total = 0;
		
		for (Producto producto : productos) {
			total += producto.getPrecio();
		}
		
		if (this.cliente.isAlumni()) {
			total *= 0.8;
		}
		
		return total;
	}
	
}
