package restaurante;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String telefono;
	private ArrayList<Integer> listaIdPedidos;
	public Cliente(String nombre, String telefono, ArrayList<Integer> listaIdPedidos) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.listaIdPedidos = listaIdPedidos;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Integer> getListaIdPedidos() {
		return listaIdPedidos;
	}
	public void setListaIdPedidos(ArrayList<Integer> listaIdPedidos) {
		this.listaIdPedidos = listaIdPedidos;
	}
	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", telefono=" + telefono + ", listaIdPedidos=" + listaIdPedidos + "]";
	}
	
}
