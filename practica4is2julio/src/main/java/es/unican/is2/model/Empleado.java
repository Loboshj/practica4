package es.unican.is2.model;
import java.time.LocalDate;
public class Empleado{
	public class DatoIncorrectoException extends Exception{};
	private String nombre;
	private LocalDate fechaContratacion;
	private boolean baja;
	private Categoria categoria;

	public Empleado(String nombre, LocalDate fechaContratacion,Categoria categoria) throws DatoIncorrectoException {
		this.categoria=categoria;
		this.nombre=nombre;
		this.fechaContratacion=fechaContratacion;
		this.baja=false;
		LocalDate diaActual = LocalDate.now();
		if(fechaContratacion==null) {
			throw new NullPointerException();
		}
		if(fechaContratacion.isAfter(diaActual)) {
			throw new DatoIncorrectoException();
		}
		if(categoria==null) {
			throw new NullPointerException();
		} else if(categoria!=Categoria.DIRECTIVO && categoria!=Categoria.GESTOR && categoria!=Categoria.OBRERO) {
			throw new DatoIncorrectoException();
		}
	}
	public double sueldoBruto() {
		LocalDate diaActual = LocalDate.now();
		double sueldo=0;
		switch(categoria) {
		case OBRERO:
			sueldo+=100;
			break;
		case GESTOR:
			sueldo+=1200;
			break;
		case DIRECTIVO:
			sueldo+=1500;
			break;
		}
		if(fechaContratacion.isBefore(diaActual.minusYears(20))) {
			sueldo+=200;
		}
		else if(fechaContratacion.isBefore(diaActual.minusYears(10))) {
			sueldo+=100;
		}
		else if(fechaContratacion.isBefore(diaActual.minusYears(5))) {
			sueldo+=50;
		}

		if(baja) {
			sueldo*=0.75;
		}
		return sueldo;
	}
	public void darAlta() {
		baja=false;
	}
	public void darBaja() {
		baja=true;
	}
	public String getNombre() {
		return nombre;
	}
	public boolean getBaja() {
		return baja;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria=categoria;
	}

}