package Logic;

import java.awt.Color;
import java.util.ArrayList;

public class Casilla {
	
	private boolean estado;
	private Color color;
	private ArrayList<Ficha> fichas;
	
	public boolean esSeguro() {
		return estado;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Casilla(Color color) {
		this.color = color;
	}
	

}
