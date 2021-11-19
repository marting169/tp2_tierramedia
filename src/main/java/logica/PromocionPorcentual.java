package logica;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double conDescuento;
	
	public PromocionPorcentual(int id,String nombreAtraccion, double costo, double tiempo,
			ArrayList<Atraccion> atracciones, double conDescuento) {
		super(id,nombreAtraccion, costo, tiempo, atracciones);
		setDescuento(conDescuento);
	}
	//OK
	public void setDescuento(double descuento) {
		this.conDescuento= this.getCosto()-(this.getCosto()*descuento/100);
	}

	public double getConDescuento() {
		return conDescuento;
	}
	/*@Override
	public String toString() {
		return "PromocionPorcentual [conDescuento=" + conDescuento + ", atracciones=" + this.getAtracciones() + ", nombre="
				+ nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
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
