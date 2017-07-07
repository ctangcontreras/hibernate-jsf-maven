package com.solmit.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.solmit.entidad.Usuario;
import com.solmit.service.UsuarioService;

@ManagedBean(name = "usuarioMb")
@SessionScoped
public class UsuarioMb  {

	@ManagedProperty(value="#{usuarioService}")
	UsuarioService usuarioService;
	List<Usuario> usuarioLista;
	private Usuario seleccionado;
	private Usuario newUser;
	
	
		
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}
	
	@PostConstruct
	private void init(){
	usuarioLista = usuarioService.listarUsuarios();
	seleccionado=new Usuario();
	Long var=	usuarioService.contador();
	Long var2=	usuarioService.contador2();	
	
	System.out.println(">>" +var);
	System.out.println(">>>" +var2);
	}

	public Usuario getSeleccionado() {
		return seleccionado;
	}
	
	
	

	public void setSeleccionado(Usuario seleccionado) {
		System.out.println("ser");
		System.out.println(seleccionado.getIdUsuario());
		System.out.println(seleccionado.getNombres());
		System.out.println(seleccionado.getPaterno());
		
		this.seleccionado = seleccionado;
		System.out.println(">"+this.seleccionado.getNombres());
		System.out.println("<"+this.seleccionado.getPaterno());

		
	}
	

	public void editar(Usuario user) {
	System.out.println("editar" +user);
		
	usuarioService.actualizar(user);
	System.out.println("actualizado corrrectamente");
	usuarioLista = usuarioService.listarUsuarios();
	}
	
	
	public void eliminar(Usuario user) {
	System.out.println("eliminar" +user);
		
	usuarioService.eliminar(user);
	System.out.println("eliminardo corrrectamente");
	usuarioLista = usuarioService.listarUsuarios();
	}
	
	
	public String crear(Usuario user) {

	System.out.println("crear" +user);
		
	usuarioService.persistir(user);
	System.out.println("creado corrrectamente");
	usuarioLista = usuarioService.listarUsuarios();
	return "usuarios";
	}
	
	
	
	public String page1(){
		newUser=new Usuario();

		 return "NewUser";

	}
	public String regresar(){
		 return "usuarios";

	}
	 

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public Usuario getNewUser() {
		return newUser;
	}

	public void setNewUser(Usuario newUser) {
		this.newUser = newUser;
	}
 
}
