package logica;

import java.util.Comparator;

public class OrdenadorPromocionXPrecio implements Comparator<Promocion>{

	public int compare(Promocion p1, Promocion p2) {
		return Double.compare(p1.getCosto(), p2.getCosto());
	}
	
}