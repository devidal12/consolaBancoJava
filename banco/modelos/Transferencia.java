package banco.modelos;

import java.util.Date;

public class Transferencia {

	
	private Integer id;
	private Integer id_ordenante;
	private Integer id_beneficiario;
	private Double importe;
	private String concepto;
	private Date fecha;
	
	
	public Transferencia() {
	
	}
	
	
	public Transferencia(Integer id, int id_ordenante, int id_beneficiario, Double importe, String concepto) {
		this.id = id;
		this.id_ordenante = id_ordenante;
		this.id_beneficiario = id_beneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = new Date();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId_ordenante() {
		return id_ordenante;
	}


	public void setId_ordenante(Integer id_ordenante) {
		this.id_ordenante = id_ordenante;
	}


	public Integer getId_beneficiario() {
		return id_beneficiario;
	}


	public void setId_beneficiario(Integer id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String toString() {
		return "Transferencia{Transferencia: " + " importe: " + importe + " || concepto:" +concepto + "||" + fecha +"}";
		
	}
	
	
	
}
