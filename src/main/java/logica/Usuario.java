package logica;

import java.util.ArrayList;

public class Usuario {
	private Integer id;
	private String nombre;
	private double presupuesto;
	private double tiempo_disponible;
	private ArrayList<Producto> itinerario;
	private ArrayList<Atraccion> soloAtracciones;

	public Usuario(Integer id, String nombre, double presupuesto, double tiempo_disponible) {
		this.id=id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.soloAtracciones=new ArrayList<Atraccion>();
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempo_disponible() {
		return this.tiempo_disponible;
	}

	public void setTiempo_disponible(double tiempo_disponible) {
		this.tiempo_disponible = tiempo_disponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}
	
	public void listarItinerarios() {
		for (Producto itinerarioA : this.itinerario) {
			System.out.println(itinerarioA.toString());
		}
	}

	public void setItinerario(ArrayList<Producto> itinerarios) {
		this.itinerario = itinerarios;
	}

	public ArrayList<Atraccion> getSoloAtracciones() {
		return soloAtracciones;
	}

	@Override
	public String toString() {
		return "USUARIO: [Nombre=" + nombre + ", Presupuesto=" + presupuesto + ", Tiempo_disponible=" + tiempo_disponible + "]"
				+ "\nITINERARIO:\n" + itinerario ;
	}

	public void setSoloAtracciones(ArrayList<Atraccion> soloAtracciones) {
		this.soloAtracciones=soloAtracciones;
	}

}
