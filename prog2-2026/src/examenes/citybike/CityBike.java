package examenes.citybike;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class CityBike {
	private ArrayList<Cliente> clientes;
	private ArrayList<Bicicleta> bicicletas;
	private TreeSet<Estacion> estaciones;
	
	public CityBike(ArrayList<Cliente> clientes, ArrayList<Bicicleta> bicicletas, TreeSet<Estacion> estaciones) {
		super();
		this.clientes = clientes;
		this.bicicletas = bicicletas;
		this.estaciones = estaciones;
	}
	
	public CityBike() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.bicicletas = new ArrayList<Bicicleta>();
		this.estaciones = new TreeSet<Estacion>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}

	public TreeSet<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(TreeSet<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	@Override
	public String toString() {
		return "CityBike [clientes=" + clientes + ", bicicletas=" + bicicletas + ", estaciones=" + estaciones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityBike other = (CityBike) obj;
		return Objects.equals(estaciones, other.estaciones);
	}
		
	public void cargarClientes(String ruta) {
		// fis -> ois -> readObject
		try {
			FileInputStream fis = new FileInputStream(ruta);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.clientes = (ArrayList<Cliente>) ois.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Estacion buscarEstacionNombre(String nombre) {
		// TAREA 2B
		Estacion encontrada = null;
		for (Estacion estacion : estaciones) {
			if (estacion.getNombre().equals(nombre)) {
				encontrada = estacion;
				break;
			}
		}
		return encontrada;
	}

	public void cargarBicletasCSV(String ruta) {
		// TAREA 2C
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				try {
					String codigo = campos[0];
					String tipo = campos[1];
					boolean operativa = Boolean.parseBoolean(campos[2]);
					double bateria = Double.parseDouble(campos[3]);
					String nombreEstacion = campos[4];
					int capacidadEstacion = Integer.parseInt(campos[5]);
					// Creamos la bicicleta
					Bicicleta bicicleta;
					if (tipo.equals("ELECTRICA")) {
						bicicleta = new Electrica(operativa, bateria);
					} else {
						bicicleta = new Mecanica(operativa);
					}
					this.bicicletas.add(bicicleta);
					// Creamos la estación
					Estacion estacion = new Estacion(nombreEstacion, capacidadEstacion);
					this.estaciones.add(estacion); // Como estaciones es un Set, no hay que preocuparse 
												   // por si está repetida
					// Añadimos la bicicleta dentro de la estacion
					// esto puede funcionar, pero casi siempre falla: estacion.getBicicletas().add(bicicleta);
					Estacion encontrada = buscarEstacionNombre(nombreEstacion);
					encontrada.getBicicletas().add(bicicleta);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error en la linea, faltan campos");
				} catch (NumberFormatException e2) {
					System.out.println("Formato numérico erróneo");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al cargar CSV");
		}
	}
	
	public void simularReservas() {
		// TAREA 3A
		for (int dia = 1; dia <= 30; dia++) {
			for (int i = 0; i < 100; i++) {
				// Elegir un cliente aleatorio (lista)
				int alea = (int) (Math.random() * this.clientes.size());
				Cliente cliente = this.clientes.get(alea);
				
				// Elegir una estación aleatoria (conjunto)
				ArrayList<Estacion> listaEstaciones = new ArrayList<Estacion>(this.estaciones);
				alea = (int) (Math.random() * listaEstaciones.size());
				Estacion origen = listaEstaciones.get(alea);

				// Fechas en función del día
				LocalDate fecha = LocalDate.of(2025, 06, dia);
				
				// Coger la primera bici de esa estación
				Bicicleta bicicleta = origen.getBicicletas().removeFirst();
				
				// Estación de destino aleatoria
				alea = (int) (Math.random() * listaEstaciones.size());
				Estacion destino = listaEstaciones.get(alea);

				// Añadir la bici a la estación de destino
				destino.getBicicletas().add(bicicleta);
				
				// Crear la reserva para ese cliente, esa bici y esa estación
				Reserva reserva = new Reserva(cliente, bicicleta, fecha, fecha, origen, destino);
		
				// Añadir la reserva al cliente
				cliente.getReservas().add(reserva);
				
			}			
		}
	}
	
	public HashMap<Cliente, Double> calcularCostesPorCliente() {
		HashMap<Cliente, Double> mapa = new HashMap<Cliente, Double>();
		
		for (Cliente cliente : clientes) {
			double total = 0.0;
			for (Reserva reserva : cliente.getReservas()) {
				total += reserva.calcularCoste();
			}
			if (!mapa.containsKey(cliente)) {
				mapa.put(cliente, total);
			} else {
				double valor = mapa.get(cliente);
				mapa.put(cliente, valor + total);
			}
		}
		
		return mapa;
	}
	
	public Cliente clienteMayorCoste(HashMap<Cliente, Double> mapa) {
		// TAREA 3C
		Cliente mayor_clave = null;
		Double mayor_valor = 0.0;
		for (Cliente clave : mapa.keySet()) {
			double valor = mapa.get(clave);
			if (valor > mayor_valor) {
				mayor_clave = clave;
				mayor_valor = valor;
			}
		}
		return mayor_clave;
	}
	
	public int recolocarBicicletas() {
		// TAREA EXTRA
		return 0;
	}

	public void generarDatosIniciales() {
		for (int i = 0; i < 9; i++) {
			estaciones.add(new Estacion("ESTACION"+(i+1), (int) (Math.random() * 16) + 16, null));
		}
		for (int i = 0; i < 20; i++) {
			clientes.add(new Cliente("6100330"+i, TipoCliente.values()[(int) (Math.random() * TipoCliente.values().length)]));
		}
		Estacion e = new Estacion("ESTACION1", (int) (Math.random() * 16) + 16);
		for (int i = 0; i < 200; i++) {
			if (i % 20 == 0) {
				e = new Estacion("ESTACION"+(i%20+1), (int) (Math.random() * 16) + 16);
				estaciones.add(e);
			}
			Bicicleta b;
			if (Math.random() > 0.5) {
				b = new Mecanica(true);
			} else {
				b = new Electrica(true, Math.random() * 50 + 50);
			}
			e.getBicicletas().add(b);
			bicicletas.add(b);
		}		
	}
	
}
