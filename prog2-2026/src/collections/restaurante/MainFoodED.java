package collections.restaurante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainFoodED {

	public static void main(String[] args) {
		// Crear una instancia de la clase contenedora
		GoFood gofood = new GoFood();
		
		// Cargamos los datos de ingredientes.csv en la lista de la clase contenedora
		gofood.cargarIngredientes();
		
		// Cargamos los datos de pedidos.csv en la lista de la clase contenedora
		gofood.cargarPedidos();
				
		System.out.println(gofood.getListaPedidos());
		
		// Generar 25 clientes aleatorios con 2 pedidos aleatorios no repetidos
		gofood.generarClientes();
		
		// Devuelve la lista de pedidos ordenada
		ArrayList<Pedido> ordenados = gofood.ordenarPedidos();
		
		// Devuelve un mapa de identificadores de pedidos por cada ingrediente
		HashMap<String, ArrayList<Integer>> mapa = gofood.pedidosPorIngrediente();
	}

}
