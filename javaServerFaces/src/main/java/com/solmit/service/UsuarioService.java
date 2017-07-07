package com.solmit.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.solmit.dao.UsuarioDao;
import com.solmit.entidad.Usuario;

@ManagedBean(name = "usuarioService")
@SessionScoped
public class UsuarioService {
	
	@ManagedProperty(value="#{usuarioDao}")
	UsuarioDao usuarioDao;

    public Usuario obtenerUsuario(String idUsuario) {
        return this.usuarioDao.obtenerUsuario(idUsuario);  
    }

	public List<Usuario> listarUsuarios() {		
    	return this.usuarioDao.listarUsuarios();  
	}

	public void eliminar(Usuario usuario) {
		this.usuarioDao.eliminar(usuario); 
	}

	public void persistir(Usuario usuario) {
		System.out.println(">"+usuario);
		this.usuarioDao.persistir(usuario); 
	}

	public void actualizar(Usuario usuario) {
		this.usuarioDao.actualizar(usuario); 
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	public Long contador(){
		return this.usuarioDao.contador();
	}
 
	public Long contador2(){
		return this.usuarioDao.contador2();
	}
	
	public Usuario validaUser(Usuario usuario) {
		return this.usuarioDao.validaUser(usuario);
	}
	
}
