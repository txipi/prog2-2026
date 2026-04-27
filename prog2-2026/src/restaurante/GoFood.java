package restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GoFood {
	
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	private ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public GoFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GoFood(ArrayList<Pedido> listaPedidos, ArrayList<Ingrediente> listaIngredientes,
			ArrayList<Cliente> listaClientes) {
		super();
		this.listaPedidos = listaPedidos;
		this.listaIngredientes = listaIngredientes;
		this.listaClientes = listaClientes;
	}

	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}
	@Override
	public String toString() {
		return "GoFood [listaPedidos=" + listaPedidos + ", listaIngredientes=" + listaIngredientes + ", listaClientes="
				+ listaClientes + "]";
	}

	public void cargarIngredientes() {
		// Llena this.listaIngredientes a partir de la información que está en ingredientes.csv
		try {
			File f = new File("ingredientes.csv");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				String nombre = campos[0];
				double precio = Double.parseDouble(campos[1]);
				Ingrediente ingrediente = new Ingrediente(nombre, precio);
				this.listaIngredientes.add(ingrediente);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void cargarPedidos() {
		// Llenar this.listaPedidos con la información de pedidos.csv
		try {
			File f = new File("pedidos.csv");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				boolean llevar = false; // campos[0]
				ArrayList<Ingrediente> lista = null; // campos[1].split(";")
				Pedido pedido = new Pedido(llevar, lista);
				this.listaPedidos.add(pedido);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
