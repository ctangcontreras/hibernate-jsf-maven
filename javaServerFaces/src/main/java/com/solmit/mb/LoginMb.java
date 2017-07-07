package com.solmit.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.solmit.entidad.Usuario;
import com.solmit.service.UsuarioService;

@ManagedBean(name = "loginMb")
@SessionScoped
public class LoginMb {
	@ManagedProperty(value="#{usuarioService}")
	UsuarioService usuarioService;
	
	private Usuario userLogin;
 
	public Usuario getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Usuario userLogin) {
		this.userLogin = userLogin;
	}
	
	public LoginMb() {
		userLogin=new Usuario();
	}
	
	@PostConstruct
	public void init(){
		
		 
 	}
	
	public String login(Usuario user){
		
		System.out.println(user);
		
		Usuario userRegistrado=usuarioService.validaUser(user);
		
		System.out.println(">>>data usuario login" +userRegistrado);
		
		if (userRegistrado==null) {
			System.out.println("Null");
	        FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "E", "Usuario o Contraseña incorrecto."));
			return "login";
		}
		else{return "usuarios";	}
		
		
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

 
}
