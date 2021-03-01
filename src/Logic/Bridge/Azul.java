package Logic.Bridge;

import Interfaces.Color;
import Logic.Elemento;

public class Azul implements Color {

	@Override
	public void colorearElemento(Elemento elemento) {
		elemento.setColor(java.awt.Color.BLUE);
		
	}

}
