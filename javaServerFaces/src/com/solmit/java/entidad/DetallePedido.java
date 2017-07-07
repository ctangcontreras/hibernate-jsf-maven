package com.solmit.java.entidad;
// Generated 25/05/2017 03:35:17 PM by Hibernate Tools 4.0.1.Final

/**
 * DetallePedido generated by hbm2java
 */
public class DetallePedido implements java.io.Serializable {

	private DetallePedidoId id;
	private Pedido pedido;
	private Producto producto;
	private Double precio;
	private Integer cantidad;

	public DetallePedido() {
	}

	public DetallePedido(DetallePedidoId id, Pedido pedido, Producto producto) {
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
	}

	public DetallePedido(DetallePedidoId id, Pedido pedido, Producto producto, Double precio, Integer cantidad) {
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public DetallePedidoId getId() {
		return this.id;
	}

	public void setId(DetallePedidoId id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}