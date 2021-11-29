package model;

public class Atraccion extends Producto {

	protected int cupo;
	protected int id;

	public Atraccion(int id, String nombreAtraccion, double costo, double tiempo, int cupo) {
		super(nombreAtraccion, costo, tiempo);
		this.id = id;
		this.setCupo(cupo);
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		if (cupo >=0) {
			this.cupo = cupo;
		} else {
			throw new Error("Se ingresó un cupo negativo");
		}
	}

	public void usarUnCupo() {
		this.cupo--;
	}

	@Override
	public String toString() {
		return "\nAtraccion" + "\n-Nombre [" + nombre + "]" + "\n-Precio: $" + costo + "\n-Duracion: " + tiempo
				+ " horas";
	}

	public String toString2() {
		return nombre + " ";
	}

	public int getId() {
		return this.id;
	}
}
