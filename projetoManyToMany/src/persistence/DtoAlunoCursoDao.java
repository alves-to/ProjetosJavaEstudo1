package persistence;

import java.util.ArrayList;
import java.util.List;

import dto.DtoAlunoCurso;
import entity.Aluno;
import entity.Curso;

public class DtoAlunoCursoDao extends Dao {
	
	public void gravarDto(Aluno a, Curso c) throws Exception {
		open();
			stmt = con.
					prepareStatement("insert into aluno_curso values(?,?)");
			stmt.setInt(1, a.getIdAluno());
			stmt.setInt(2, c.getIdCurso());
			stmt.execute();
		close();
	}
	
	public List<DtoAlunoCurso> findAll() throws Exception {
		open();
		stmt = con.
				prepareStatement("select * from V$Consulta");
		rs = stmt.executeQuery();
		List<DtoAlunoCurso> lst = new ArrayList<DtoAlunoCurso>();
		while(rs.next()) {
			DtoAlunoCurso dto = new DtoAlunoCurso();
				dto.setIdAluno(rs.getInt(1));
				dto.setNome(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setIdCurso(rs.getInt(4));
				dto.setNomeCurso(rs.getString(5));
			lst.add(dto);	
		}
		
		close();
		return lst;
	}
	
	//main
	public static void main(String[] args) {
		DtoAlunoCursoDao dtoAC = new DtoAlunoCursoDao();
		AlunoDao ac = new AlunoDao();
		CursoDao cd = new CursoDao();
		try {
			//dtoAC.gravarDto(ac.findByCode(1), cd.findByCode(3));
			dtoAC.findAll().stream().forEach(System.out::println);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
}
