package co.edu.unbosque.lagenerica.ProveedoresBack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="db_proveedores")
public class Proveedor {
	
	@Id
	
	private int nit;
	private String direccionProveedor;
	private String Ciudad;
	private String nombreProveedor;
	private String telefonoProveedor;
	
	
	public Proveedor() {
		
	}
	
	public Proveedor(int nit, String direccionProveedor, String Ciudad, String nombreProveedor,
			String telefonoProveedor) {
		super();
		this.nit = nit;
		this.direccionProveedor = direccionProveedor;
		this.Ciudad = Ciudad;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}


	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getdireccionProveedor() {
		return direccionProveedor;
	}
	public void setdireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String Ciudad) {
		this.Ciudad = Ciudad;
	}
	public String getnombreProveedor() {
		return nombreProveedor;
	}
	public void setnombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String gettelefonoProveedor() {
		return telefonoProveedor;
	}
	public void settelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
	@Override
	public String toString() {
		return "Proveedor [nit=" + nit + ", direccionProveedor=" + direccionProveedor + ", Ciudad="
				+ Ciudad + ", nombreProveedor=" + nombreProveedor + ", telefonoProveedor=" + telefonoProveedor + "]";
	}

}
