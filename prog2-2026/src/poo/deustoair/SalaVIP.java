package poo.deustoair;

import java.util.ArrayList;

public class SalaVIP implements Reservable {
	protected boolean wifi;
	protected int capacidad;
	protected ArrayList<Pasajero> pasajeros;
	
	public SalaVIP(boolean wifi, int capacidad, ArrayList<Pasajero> pasajeros) {
		super();
		this.wifi = wifi;
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public SalaVIP() {
		super();
		this.wifi = false;
		this.capacidad = 0;
		this.pasajeros = new ArrayList<Pasajero>();
	}
	
	public SalaVIP(SalaVIP s) {
		super();
		this.wifi = s.wifi;
		this.capacidad = s.capacidad;
		this.pasajeros = new ArrayList<Pasajero>(s.pasajeros);
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "SalaVIP [wifi=" + wifi + ", capacidad=" + capacidad + ", pasajeros=" + pasajeros + "]";
	}

	@Override
	public boolean pagarReserva(Pasajero p) {
		// Si este pasajero no estaba ya en la lista y hay capacidad para que entre, lo añadimos
		if (!this.pasajeros.contains(p) && this.capacidad > this.pasajeros.size()) {
			this.pasajeros.add(p);
			return true;
		} else {
			// Si no, la reserva ha salido mal y devolvemos false
			return false;
		}
	}

	@Override
	public boolean cancelarReserva(Pasajero p) {
		// Si este pasajero estaba en la lista, lo sacamos
		if (this.pasajeros.contains(p)) {
			this.pasajeros.remove(p);
			return true;
		} else {
			// Si no, la reserva no se ha podido cancelar correctamente
			return false;
		}
	}

	
	
}
