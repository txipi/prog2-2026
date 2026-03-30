package collections.embarque;

public enum Clase {
	PRIMERA, BUSINESS, ECONOMY;
	
	// En un Enum solamente podemos hacer 3 cosas:
	// 1) Usar un valor: Clase.BUSINESS
	// 2) Convertir un String a un valor válido del Enum: Clase.valueOf("BUSINESS");
	// 3) Conseguir un array con todos los valores válidos del Enum: Clase.values()
}
