package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDao extends Dao {
	
	public List<Aluno> findAll() throws Exception {
		open();
			stmt = con.
					prepareStatement("select * from aluno");
			rs = stmt.executeQuery();
			List<Aluno> lst = new ArrayList<Aluno>();
			while(rs.next()) {
				Aluno a = new Aluno();
					a.setIdAluno(rs.getInt(1));
					a.setNome(rs.getString(2));
					a.setEmail(rs.getString(3));
				lst.add(a);
			}
		close();
		return lst;
	}
	
	public Aluno findByCode(Integer cod) throws Exception {
		open();
			stmt = con.
					prepareStatement("select * from aluno where idAluno = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			Aluno aluno = null;
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setEmail(rs.getString(3));
			}
			
			
		close();
		return aluno;
	}
	
	
	//main
	public static void main(String[] args) {
		try {
			AlunoDao ad = new AlunoDao();
			ad.findAll().stream().forEach(System.out::println);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	
	
}
