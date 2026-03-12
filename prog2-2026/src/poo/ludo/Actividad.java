package poo.ludo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Actividad implements Reservable {
	protected String descripcion;
	protected TipoActividad tipo;
	protected LocalDate fecha;
	protected Trabajadora trabajadora;
	protected ArrayList<Usuaria> asistentes;
	
	@Override
	public boolean reservar(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean anular(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
}
