package collections.wop;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable {
	private String codigo;
	private ArrayList<Participante> participantes;
	private Modalidad modalidad;
	
	public Equipo(String codigo, ArrayList<Participante> participantes, Modalidad modalidad) {
		super();
		this.codigo = codigo;
		this.participantes = participantes;
		this.modalidad = modalidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", participantes=" + participantes + ", modalidad=" + modalidad + "]";
	}

	public double getRitmoTotal() {
		double total = 0.0;
		for (Participante participante : participantes) {
			total += participante.getRitmo();
		}
		return total;
	}
}
