package poo.deustotravel;

import java.util.ArrayList;
import java.util.Collections;

public class Excursion implements Cobrable, Comparable<Excursion> {
	protected String nombre;
	protected ArrayList<Trayecto> trayectos;
	protected boolean pagada;
	
	public Excursion(String nombre, ArrayList<Trayecto> trayectos, boolean pagada) {
		super();
		this.nombre = nombre;
		this.trayectos = new ArrayList<Trayecto>(trayectos);
		this.pagada = pagada;
	}
	
	public Excursion() {
		super();
		this.nombre = "";
		this.trayectos = new ArrayList<Trayecto>();
		this.pagada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	@Override
	public String toString() {
		return "Excursion [nombre=" + nombre + ", trayectos=" + trayectos + ", pagada=" + pagada + "]";
	}

	@Override
	public double calcularCoste() {
		// Sumar el coste de todos sus trayectos (distancia x getPrecioPorKm() del transporte usado)
		double total = 0;
		
		for (Trayecto trayecto : trayectos) {
			Transporte transporte = trayecto.getTransporte();
			total += trayecto.getDistancia() * transporte.getPrecioPorKm();
		}
		
		return total;
	}

	@Override
	public boolean cobrar() {
		this.pagada = true;
		return true;
	}
	
	public static Excursion getExcursionMasCara(ArrayList<Excursion> excursiones) {
		Excursion mayor = excursiones.get(0);
		
		for (Excursion excursion : excursiones) {
			if (excursion.calcularCoste() > mayor.calcularCoste()) {
				mayor = excursion;
			}
		}
		
		return mayor;
	}

	public static Excursion getExcursionMasCara2(ArrayList<Excursion> excursiones) {
		Collections.sort(excursiones);
		return excursiones.get(0);
	}

	
	@Override
	public int compareTo(Excursion other) {
		return (int) (other.calcularCoste() - this.calcularCoste());
	}
	
}
