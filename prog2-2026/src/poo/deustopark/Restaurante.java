package poo.deustopark;

import java.util.ArrayList;

public class Restaurante implements Reservable {
	protected String nombre;
	protected int aforo;
	protected TipoComida tipo;
	protected ArrayList<Visitante> visitantes;
	
	@Override
	public boolean reservar(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean cancelar(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
