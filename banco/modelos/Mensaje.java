package banco.modelos;

import java.util.Date;

public class Mensaje {

	
	private Integer id;
	private Integer id_origen;
	private Integer id_destino;
	private String texto;
	private Date fecha;
	
	
	public Mensaje() {
		
	}
	
	public Mensaje(Integer id, Integer id_origen, Integer id_destino, String texto) {
		this.id = id;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.texto = texto;
		this.fecha = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_origen() {
		return id_origen;
	}

	public void setId_origen(Integer id_origen) {
		this.id_origen = id_origen;
	}

	public Integer getId_destino() {
		return id_destino;
	}

	public void setId_destino(Integer id_destino) {
		this.id_destino = id_destino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String toString() {
		return "Mensaje{mensaje: " + texto + fecha +"}";
		
	}
	
	
}
