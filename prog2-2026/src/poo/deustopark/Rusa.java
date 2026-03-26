package poo.deustopark;

import java.util.ArrayList;

public class Rusa extends Atraccion implements Reservable {
	protected double velocidadMax;
	protected double alturaMin;
	protected ArrayList<Visitante> visitantes;
	
	@Override
	public boolean esApta(int edad) {
		// TODO Auto-generated method stub
		return false;
	}

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
