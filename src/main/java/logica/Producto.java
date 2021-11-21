package logica;

public abstract class Producto {
	
	protected String nombre;
	protected double costo;
	protected double tiempo;
	
	public Producto(String nombre, double costo, double tiempo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
	}
	

	public String getNombreAtraccion() {
		return nombre;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombre = nombreAtraccion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

}
