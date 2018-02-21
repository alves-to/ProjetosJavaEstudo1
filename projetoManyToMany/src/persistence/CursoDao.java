package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;
import entity.Curso;

public class CursoDao extends Dao {

	public List<Curso> findAll() throws Exception {
		open();
			stmt = con.
					prepareStatement("select * from curso");
			rs = stmt.executeQuery();
			List<Curso> lst = new ArrayList<Curso>();
			while(rs.next()) {
				Curso c = new Curso();
					c.setIdCurso(rs.getInt(1));
					c.setNomeCurso(rs.getString(2));
				lst.add(c);
			}
		close();
		return lst;
	}
	
	public Curso findByCode(Integer cod) throws Exception {
		open();
			stmt = con.
					prepareStatement("select * from curso where idCurso = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			Curso curso = null;
			if(rs.next()) {
				curso = new Curso();
				curso.setIdCurso(rs.getInt(1));
				curso.setNomeCurso(rs.getString(2));
			}
		close();
		return curso;
	}
	
	//main
	public static void main(String[] args) {
		try {
			CursoDao cd = new CursoDao();
			cd.findAll().stream().forEach(System.out::println);
			System.out.println(cd.findByCode(3).toString());
		} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
}
