package com.solmit.java.entidad;
// Generated 25/05/2017 03:35:17 PM by Hibernate Tools 4.0.1.Final

/**
 * DetallePedidoId generated by hbm2java
 */
public class DetallePedidoId implements java.io.Serializable {

	private int idDetallePedido;
	private int idPedido;

	public DetallePedidoId() {
	}

	public DetallePedidoId(int idDetallePedido, int idPedido) {
		this.idDetallePedido = idDetallePedido;
		this.idPedido = idPedido;
	}

	public int getIdDetallePedido() {
		return this.idDetallePedido;
	}

	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetallePedidoId))
			return false;
		DetallePedidoId castOther = (DetallePedidoId) other;

		return (this.getIdDetallePedido() == castOther.getIdDetallePedido())
				&& (this.getIdPedido() == castOther.getIdPedido());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdDetallePedido();
		result = 37 * result + this.getIdPedido();
		return result;
	}

}
