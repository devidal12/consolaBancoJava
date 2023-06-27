package banco.otrosmodelos;

public class Cliente {
	
	private Integer id;
	private Integer id_gestor;
	private String usuario;
	private String password;
	private String correo;
	private Double saldo;

	public Cliente() {
		
	}
	
	public Cliente(Integer id, Integer id_gestor, String usuario, String password,String correo, Double saldo) {
		
		this.id = id;
		this.id_gestor = id_gestor;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_gestor() {
		return id_gestor;
	}

	public void setId_gestor(Integer id_gestor) {
		this.id_gestor = id_gestor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "Cliente{id: " + this.id + ", usuario: " + this.usuario +"}";
		
	}

}