package poo.deustoair;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vuelo implements Reservable {
	protected String codigo;
	protected Aeropuerto origen;
	protected Aeropuerto destino;
	protected LocalDate hora;
	protected Aeronave aeronave;
	protected ArrayList<Pasajero> pasajeros;
	
	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, LocalDate hora, Aeronave aeronave,
			ArrayList<Pasajero> pasajeros) {
		super();
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.hora = hora;
		this.aeronave = aeronave;
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public Vuelo() {
		super();
		this.codigo = "";
		this.origen = null;
		this.destino = null;
		this.hora = LocalDate.now(); // devuelve la fecha actual
		this.aeronave = null;
		this.pasajeros = new ArrayList<Pasajero>();
	}
	
	public Vuelo(Vuelo v) {
		super();
		this.codigo = v.codigo;
		this.origen = v.origen;
		this.destino = v.destino;
		this.hora = v.hora;
		this.aeronave = v.aeronave;
		this.pasajeros = new ArrayList<Pasajero>(v.pasajeros);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "Vuelo [codigo=" + codigo + ", origen=" + origen + ", destino=" + destino + ", hora=" + hora
				+ ", aeronave=" + aeronave + ", pasajeros=" + pasajeros + "]";
	}

	@Override
	public boolean pagarReserva(Pasajero p) {
		// Si este pasajero no estaba ya en la lista, lo añadimos
		if (!this.pasajeros.contains(p)) {
			this.pasajeros.add(p);
			return true;
		} else {
			// Si ya estaba en la lista, la reserva ha salido mal y devolvemos false
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
