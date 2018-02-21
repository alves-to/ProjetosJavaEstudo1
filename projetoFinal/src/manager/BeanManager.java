package manager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Usuario;
import persistence.UsuarioDao;

@ManagedBean(name="mb")
@RequestScoped
public class BeanManager {

	private Usuario usuario;

	public BeanManager() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String logar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		try {
			Usuario resp = new UsuarioDao().findByLogin(usuario);
			HttpSession session = null;
			
			if(resp != null) {
				session = request.getSession();
				session.setAttribute("usuario", resp);
				return resp.getPerfil() + "/logado.jsf?faces-redirect"; 
			} else  {
				session = null;
			}
			fc.addMessage(null, new FacesMessage("Erro no login..."));
			return null;
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: " + ex.getMessage()));
			return null;
		}	
	}
	
	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if(usuario.getEmail().equals("feio@gmail.com")) {
				usuario.setPerfil("adm");
			} else {
				usuario.setPerfil("usu");
			}
			new UsuarioDao().create(usuario);
			fc.addMessage(null, new FacesMessage("Dados gravados usuario"));
			usuario = new Usuario();
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: " + ex.getMessage()));
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
