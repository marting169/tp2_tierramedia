package model;

import java.util.ArrayList;

public class PromocionAXB extends Promocion{
	
	private double conDescuento;
	
	public PromocionAXB(int id,String nombreAtraccion, double costo, double tiempo, ArrayList<Atraccion> atracciones) {
		super(id,nombreAtraccion, costo, tiempo, atracciones);
		setDescuento();
	}

	public void setDescuento() {
		double suma=0;
		for(int i=0;i < 2;i++) {
			suma+=atracciones.get(i).getCosto();
		}
		conDescuento=suma;
	}

	public double getConDescuento() {
		return conDescuento;
	}
	
	
	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duracion :" + tiempo
				+ " horas \n-Precio original: " + costo + "\n-Precio con descuento:" + conDescuento+"\n";
	}

}
