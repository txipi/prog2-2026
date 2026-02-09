package primerospasos;

import javax.swing.JOptionPane;

public class Euros {

	public static void main(String[] args) {
		// cantidad : str = input("Introduce la cantidad en euros: ")
		String cantidad = JOptionPane.showInputDialog("Introduce la cantidad en euros: ");
		// euros : float = float(cantidad)
		double euros = Double.parseDouble(cantidad);
		// dolares : float = euros * 1.18
		double dolares = euros * 1.18;
		// print(str(euros) + " euros son " + str(dolares) + " dolares")  # 20.35 + "" -> "20.35"
		System.out.println(euros + " euros son " + dolares + " dolares");
		JOptionPane.showMessageDialog(null, euros + " euros son " + dolares + " dolares");
	}

}
