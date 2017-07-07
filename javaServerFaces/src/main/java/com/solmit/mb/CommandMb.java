package com.solmit.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import com.solmit.entidad.Usuario;
import com.solmit.util.HibernateUtil;

@SessionScoped
@ManagedBean(name = "commandMb")
public class CommandMb {


    String direccion;
    String auto;

    List<String> autosList;

    public CommandMb() {
        super();
        autosList = new ArrayList<String>(3);

        autosList.add("Toyota");
        autosList.add("Nissan");
        autosList.add("Porsche");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    String comentarios;
    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public List<String> getAutosList() {
        return autosList;
    }

    public void setAutosList(List<String> autosList) {
        this.autosList = autosList;
    }

    public void grabar(){

        System.out.println("Se est� procesando...");
        System.out.printf("Direccion  --->%s<---%n", direccion);
    }

    public void procesar(){

        Session session = HibernateUtil.getSessionFactory().openSession();


        String idUsuario = comentarios;


        try {

            Usuario usuario = (Usuario) session.get(Usuario.class, idUsuario);

            if (usuario != null) {
                System.out.println("Register found!!!");
                System.out.println(usuario);
            } else {
                System.out.printf(
                        "Register was not found... Id requested: -->%s<--",
                        idUsuario);
            }


        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }

        System.out.println("Se está procesando...");
        System.out.printf("Comentarios  --->%s<---%n", comentarios);
    }
}
