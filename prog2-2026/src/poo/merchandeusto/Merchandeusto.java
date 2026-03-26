package poo.merchandeusto;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Merchandeusto {
	
	// Ejercicio 4: totalPedido + pedidoMasCaro
	public static Pedido pedidoMasCaro(ArrayList<Pedido> pedidos) {
		Pedido mayor = pedidos.get(0);
		
		for (Pedido pedido : pedidos) {
			if (pedido.totalPedido() > mayor.totalPedido()) {
				mayor = pedido;
			}
		}
		
		return mayor;
	}
	
	// Ejercicio 5: filtrarRopa
	public static ArrayList<Producto> filtrarRopa(ArrayList<Producto> productos) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
		for (Producto producto : productos) {
			if (producto instanceof Camiseta || producto instanceof Sudadera) {
				lista.add(producto);
			}
		}
		
		return lista;
	}

	public static void main(String[] args) {
		// Creamos los datos: productos, clientes y pedidos:
		ArrayList<Producto> productos = new ArrayList<Producto>(); 
		
		for (Talla talla : Talla.values()) {
			productos.add(new Camiseta("Camiseta blanca", 15.50, talla, Color.WHITE));
			productos.add(new Camiseta("Camiseta azul", 15.50, talla, Color.BLUE));
			productos.add(new Sudadera("Sudadera abierta", 25.0, talla, true, Color.BLUE));
			productos.add(new Sudadera("Sudadera cerrada", 25.0, talla, false, Color.BLUE));
		}
		
		productos.add(new Taza("Taza pequeña", 3.50, 100, false));
		productos.add(new Taza("Taza normal", 6.50, 200, true));
		productos.add(new Taza("Taza grande", 8.50, 400, true));

		System.out.println(productos.size() + " productos creados");
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(new Cliente("Ane", "ane@opendeusto.es", true));
		clientes.add(new Cliente("Kepa", "kepa@sakolegi.es", false));
		clientes.add(new Cliente("Jone", "jone2003@gmail.com", false));
		clientes.add(new Cliente("David", "david@opendeusto.es", true));
		
		System.out.println(clientes.size() + " clientes creados");
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>(); 
		
		pedidos.add(new Pedido(clientes.get(0), LocalDate.of(2026, 3, 21), new ArrayList<>(Arrays.asList(productos.get(0), productos.get(1), productos.get(2)))));
		pedidos.add(new Pedido(clientes.get(1), LocalDate.of(2026, 3, 22), new ArrayList<>(Arrays.asList(productos.get(20), productos.get(20), productos.get(20)))));
		pedidos.add(new Pedido(clientes.get(2), LocalDate.of(2026, 3, 21), new ArrayList<>(Arrays.asList(productos.get(3), productos.get(26), productos.get(25), productos.get(12)))));
		pedidos.add(new Pedido(clientes.get(3), LocalDate.of(2026, 3, 23), new ArrayList<>(Arrays.asList(productos.get(3), productos.get(6), productos.get(24), productos.get(7)))));
		pedidos.add(new Pedido(clientes.get(2), LocalDate.of(2026, 3, 23), new ArrayList<>(Arrays.asList(productos.get(22), productos.get(12), productos.get(21)))));
		pedidos.add(new Pedido(clientes.get(1), LocalDate.of(2026, 3, 23), new ArrayList<>(Arrays.asList(productos.get(23), productos.get(16), productos.get(17)))));
		
		System.out.println(pedidos.size() + " pedidos creados");
		
		// Ejercicio 1: codigo numérico único
		// Debería mostrar: 1 2 3 4 5 6
		for (Pedido pedido : pedidos) {
			System.out.println(pedido.getCodigo());
		}
		
		// Ejercicio 2: Comparable
		// Debería mostrar el producto más barato, Taza pequeña
		Collections.sort(productos);
		System.out.println(productos.get(0));
		
		// Ejercicio 3: Cambiable
		// Debería mostrar que la camiseta1 tiene la talla M y el color es blanco: [r=255,g=255,b=255]
		Camiseta camiseta1 = new Camiseta("Camiseta", 15.50, Talla.XL, Color.BLUE);
		camiseta1.cambiar(Color.WHITE, Talla.M);
		System.out.println(camiseta1);
		
		// Ejercicio 4: totalPedido + pedidoMasCaro
		// Debería mostrar el pedido con el código 4
		System.out.println(pedidoMasCaro(pedidos));
		
		// Ejercicio 5: filtrarRopa
		// Debería mostrar solo las camisetas y sudaderas
		for (Producto producto : filtrarRopa(productos)) {
			System.out.println(producto);
		}
	}

}
