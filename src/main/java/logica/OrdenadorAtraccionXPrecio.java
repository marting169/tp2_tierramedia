package logica;

import java.util.Comparator;

import model.Atraccion;

public class OrdenadorAtraccionXPrecio implements Comparator<Atraccion>{
	
	public int compare(Atraccion a1, Atraccion a2) {
		return Double.compare(a1.getCosto(), a2.getCosto());
	}

}