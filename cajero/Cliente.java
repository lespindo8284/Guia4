package cajero;

public class Cliente {
	
	private String numero_cuenta;
	private String nombre_completo;
	private String clave;
	private Integer saldo;
	private SQLiteConnection conexion;
	
	public Cliente(String numero_cuenta, String clave) {
		this.conexion = new SQLiteConnection();
		this.setNumero_cuenta(numero_cuenta);
		this.clave = clave;
		this.setNombre_completo(conexion.consultar_nombre_completo(numero_cuenta, clave));
		this.saldo = conexion.consultar_saldo(numero_cuenta, clave);
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		if(conexion.actualizar_clave(numero_cuenta, clave)) {
			this.clave = clave;
		}else {
			this.clave = "Error";
		}
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		if(conexion.actualizar_saldo(numero_cuenta, saldo)) {
			this.saldo = saldo;
		}else {
			this.saldo = -1;
		}
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

}
