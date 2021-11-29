package model;

import java.util.ArrayList;

public abstract class Promocion extends Producto{
	
	protected ArrayList<Atraccion> atracciones;
	protected int id;

	public Promocion(int id,String nombreAtraccion, double costo, double tiempo, ArrayList<Atraccion> atracciones) {
		super(nombreAtraccion, costo, tiempo);
		this.atracciones = atracciones;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void decrementarCupos() {
		for (Atraccion atraccion : atracciones) {
			atraccion.usarUnCupo();
		}
	}

	
	public int obtenerCupoMinimo() {
		int minimo = 1000;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() < minimo) {
				minimo = atraccion.getCupo();
			}
		}
		return minimo;
	}

	
	public ArrayList<Atraccion> obtenerAtracciones() {
		return atracciones;
	}

	public String getAtracciones() {
		String respuesta = "[";
		for (Atraccion atraccionA : atracciones) {
			respuesta = respuesta + atraccionA.getNombreAtraccion() + ", ";
		}
		respuesta = respuesta.substring(0, respuesta.length() - 2);
		return respuesta + "]";
	}

	public abstract double getConDescuento();
	
	public boolean atraccionIncluida(Atraccion nuevaAtraccion) {
		return this.atracciones.contains(nuevaAtraccion);
	}

	public boolean atraccionIncluidaEnPromocion(ArrayList<Atraccion> soloAtracciones) {
		boolean existe=false;
		int i=0;
		while(i< soloAtracciones.size() && !existe) {
			existe = this.atraccionIncluida(soloAtracciones.get(i));
			i++;
		}
		return existe;
	}
	
}
