package dto;

public class DtoAlunoCurso {

	private Integer idAluno;
	private String  nome;
	private String  email;
	private Integer idCurso;
	private String  nomeCurso;
	
	public DtoAlunoCurso() {
		// TODO Auto-generated constructor stub
	}

	public DtoAlunoCurso(Integer idAluno, String nome, String email, Integer idCurso, String nomeCurso) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.email = email;
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "DtoAlunoCurso [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + ", idCurso=" + idCurso
				+ ", nomeCurso=" + nomeCurso + "]";
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
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

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	
	
}
