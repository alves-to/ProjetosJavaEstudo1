package manager;

import java.util.List;

import dto.DtoAlunoCurso;
import entity.Aluno;
import entity.Curso;
import persistence.AlunoDao;
import persistence.CursoDao;
import persistence.DtoAlunoCursoDao;

public class ManagerBean {

	private List<DtoAlunoCurso> listaDto;
	private List<Aluno> listaAluno;
	private List<Curso> listaCurso;
	
	public List<DtoAlunoCurso> getListaDto() {
		try {
			if(listaDto == null) {
				listaDto = new DtoAlunoCursoDao().findAll();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return listaDto;
	}
	
	public void setListaDto(List<DtoAlunoCurso> listaDto) {
		this.listaDto = listaDto;
	}
	
	public List<Aluno> getListaAluno() {
		try {
			if(listaAluno == null) {
				listaAluno = new AlunoDao().findAll();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listaAluno;
	}
	
	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	public List<Curso> getListaCurso() {
		try {
			if(listaCurso == null) {
				listaCurso = new CursoDao().findAll();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listaCurso;
	}
	
	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	
	
	
}
