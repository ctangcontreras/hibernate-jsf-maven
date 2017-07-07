package com.solmit.entidad;
// Generated 30/10/2016 03:08:55 AM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "tienda")
public class Usuario implements java.io.Serializable {

	private String idUsuario;
	private String clave;
	private String nombres;
	private String paterno;
	private String materno;
	private String correo;
	private String direccion;
	private String telefono;
	private Character estado;
	private Set<UsuarioRol> usuarioRols = new HashSet<UsuarioRol>(0);
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Usuario() {
	}

	public Usuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(String idUsuario, String clave, String nombres, String paterno, String materno, String correo,
			String direccion, String telefono, Character estado, Set<UsuarioRol> usuarioRols, Set<Pedido> pedidos) {
		this.idUsuario = idUsuario;
		this.clave = clave;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
		this.usuarioRols = usuarioRols;
		this.pedidos = pedidos;
	}

	@Id

	@Column(name = "id_usuario", unique = true, nullable = false, length = 20)
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "clave", length = 20)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "nombres", length = 64)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "paterno", length = 32)
	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	@Column(name = "materno", length = 32)
	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	@Column(name = "correo", length = 64)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "direccion", length = 128)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono", length = 32)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "estado", length = 1)
	public Character getEstado() {
		return this.estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario",cascade = CascadeType.ALL)
	public Set<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(Set<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return String.format(
				"Usuario [idUsuario=%s, clave=%s, nombres=%s, paterno=%s, materno=%s, correo=%s, direccion=%s, telefono=%s, estado=%s, usuarioRols=%s, pedidos=%s]",
				idUsuario, clave, nombres, paterno, materno, correo, direccion, telefono, estado, usuarioRols, pedidos);
	}

}