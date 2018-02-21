package entity;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private Integer idAluno;
	private String nome;
	private String email;
	  
	private List<Curso> cursos;
  
	public Aluno() {
	// TODO Auto-generated constructor stub
	}
  

	public Aluno(Integer idAluno, String nome, String email) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + "]";
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void adicionar(Curso c) {
		if(cursos == null) {
			cursos = new ArrayList<Curso>();
	}
	cursos.add(c);
}
	
}
