package restaurante;

import java.util.ArrayList;

public class Pedido{
	private static int countIdentificador = 0;
	private int identificador;
	private boolean llevar;
	private ArrayList<Ingrediente> listaIngredientes;
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(boolean llevar, ArrayList<Ingrediente> listaIngredientes) {
		super();
		this.identificador = countIdentificador;
		countIdentificador = countIdentificador + 1;
		this.llevar = llevar;
		this.listaIngredientes = listaIngredientes;
	}
	public boolean isLlevar() {
		return llevar;
	}
	public void setLlevar(boolean llevar) {
		this.llevar = llevar;
	}
	public ArrayList<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}
	public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}
	public int getIdentificador() {
		return identificador;
	}
	@Override
	public String toString() {
		return "Pedido [identificador=" + identificador + ", llevar=" + llevar + ", listaIngredientes="
				+ listaIngredientes + "]";
	}
	
}
