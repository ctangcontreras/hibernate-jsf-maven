package javaServerFaces;

import java.util.Objects;

import org.hibernate.Session;

import com.solmit.dao.UsuarioDao;
import com.solmit.entidad.Usuario;
import com.solmit.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if (Objects.nonNull(session)){
        	System.out.println("Conexion Exitosa");
        } else {
        	System.out.println("Conexion Fallida");
        }
       
       Usuario user=new Usuario();
       user.setIdUsuario("pepe1");
       user.setClave("11");
       user.setCorreo("asdadsads");
       user.setDireccion("bvfbvetbet");;
       user.setEstado((char) 1);;
       user.setMaterno("asdasdasd");
       user.setPaterno("asdasdsadsad");
       
 
       UsuarioDao dao= new UsuarioDao();
       
       dao.eliminar(user);
       
       
       
       
         
	}

}
