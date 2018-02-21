package entity;

import java.util.ArrayList;
import java.util.List;

public class Curso {
//ManyToMany devo possuir uma lista de curso
	
	private Integer idCurso;
	private String nomeCurso;
	
	private List<Aluno> alunos;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer idCurso, String nomeCurso) {
		super();
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nomeCurso=" + nomeCurso + "]";
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	//usando varargs ..., posso adicionar vários alunos
	public void adicionarAluno(Aluno ...dados) throws Exception {
		if(alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		
		for(Aluno a : dados) {
			alunos.add(a);
		}
	}
	
}
