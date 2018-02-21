package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;
	@Column(length=50)
	@Pattern(regexp="[a-z A-Z]+{2,100}", message="Nome invalido fora do padrao")
	private String nome;
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Email invalido fora do padrao")
	private String email;
	@Column(length=1)
	@Pattern(regexp="M|F|m|f", message="Sexo invalido fora do padrao")
	private String sexo;
	@Column(length=100)
	private String senha;
	@Column(columnDefinition="enum('usu','adm')")
	private String perfil;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String email, String sexo, String senha, String perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.senha = senha;
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", sexo=" + sexo
				+ ", perfil=" + perfil + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

	

}
