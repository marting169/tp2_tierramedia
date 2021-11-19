package logica;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{
	
	private double conDescuento;
	

	public PromocionAbsoluta(int id,String nombreAtraccion, double costo, double tiempo,
			ArrayList<Atraccion> atracciones, double conDescuento) {
		super(id,nombreAtraccion, costo, tiempo, atracciones);
		setDescuento(conDescuento);
	}

	public void setDescuento(double precioAbsoluto) {
		this.conDescuento=precioAbsoluto;
	}
	
	public double getConDescuento() {
		return conDescuento;
	}

	/*@Override
	public String toString() {
		return "PromocionAbsoluta [conDescuento=" + conDescuento + ", atracciones=" + atracciones + ", nombre=" + nombre
				+ ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
	}*/
	
	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duracion :" + tiempo
				+ " horas \n-Precio original: " + costo + "\n-Precio con descuento:" + conDescuento+"\n";
	}

	@Override
	public double getPresupuesto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTiempo_disponible() {
		// TODO Auto-generated method stub
		return 0;
	}

}
