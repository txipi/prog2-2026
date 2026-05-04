package collections.restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
				boolean llevar = Boolean.parseBoolean(campos[0]);
				ArrayList<Ingrediente> lista = new ArrayList<Ingrediente>(); // campos[1].split(";")
				String[] nombres = campos[1].split(";");
				for (String nombre : nombres) {
					// Buscar el ingrediente que se llame así
					Ingrediente ingrediente = null;
					for (Ingrediente ing : this.listaIngredientes) {
						if (ing.getNombre().equals(nombre)) {
							ingrediente = ing;
							break;
						}
					}
					// añadirlo a la lista
					if (ingrediente != null) {
						lista.add(ingrediente);
					}
				}
				Pedido pedido = new Pedido(llevar, lista);
				this.listaPedidos.add(pedido);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void generarClientes() {
		ArrayList<Integer> pedidosUsados = new ArrayList<Integer>();
		for (int i = 0; i < 25; i++) {
			String nombre = "cliente" + (i+1);
			String telefono = "+34844784525";
			ArrayList<Integer> pedidos = new ArrayList<Integer>();
			// Tenemos que elegir aleatoriamente 2 pedidos y meterlos en la lista
			for (int j = 0; j < 2; j++) {
				int alea = (int) (Math.random() * this.listaPedidos.size());
				Pedido pedidoAleatorio = this.listaPedidos.get(alea);
				
				while (pedidosUsados.contains(pedidoAleatorio.getIdentificador())) {
					alea = (int) (Math.random() * this.listaPedidos.size());
					pedidoAleatorio = this.listaPedidos.get(alea);
				}
				
				pedidos.add(pedidoAleatorio.getIdentificador());	
				pedidosUsados.add(pedidoAleatorio.getIdentificador());	
			}
			Cliente cliente = new Cliente(nombre, telefono, pedidos);
			this.listaClientes.add(cliente);
		}
	}

	public ArrayList<Pedido> ordenarPedidos() {
		// TODO Auto-generated method stub
		ArrayList<Pedido> ordenada = new ArrayList<Pedido>(this.listaPedidos);
		
		// Si hacemos que Pedido sea Comparable: Collections.sort(ordenada);
		ordenada.sort(new Comparator<Pedido>() {
			@Override
			public int compare(Pedido o1, Pedido o2) {
				return Double.compare(o1.getTotal(), o2.getTotal());
			}
		});
		
		return ordenada;
	}

	public HashMap<String, ArrayList<Integer>> pedidosPorIngrediente() {
		HashMap<String, ArrayList<Integer>> mapa = new HashMap<String, ArrayList<Integer>>();
		
		for (Pedido pedido : listaPedidos) {
			for (Ingrediente ingrediente : pedido.getListaIngredientes()) {
				String nombre = ingrediente.getNombre();
				if (!mapa.containsKey(nombre)) {
					mapa.put(nombre, new ArrayList<Integer>());
				}
				// Comprobar si ya existía este identificador en la lista
				if (!mapa.get(nombre).contains(pedido.getIdentificador())) {
					mapa.get(nombre).add(pedido.getIdentificador());
				}
			}
		}
		
		return mapa;
	}


}
