package logica;

import java.util.Comparator;

import model.Producto;

public class ComparadorProductos implements Comparator<Producto> {

	public int compare(Producto p1, Producto p2) {
		if (p1.getCosto() != p2.getCosto()) {
			return -1 * Double.compare(p1.getCosto(), p2.getCosto());
		} else {
			return -1 * Double.compare(p1.getTiempo(), p2.getTiempo());
		}
	}

}
