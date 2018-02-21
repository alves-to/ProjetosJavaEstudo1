package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Aluno;
import entity.Curso;
import persistence.DtoAlunoCursoDao;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Aluno a = new Aluno();
    	Curso c = new Curso();
    	
    	try {
			a.setIdAluno(Integer.parseInt(request.getParameter("idAluno")));
    		c.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
    		new DtoAlunoCursoDao().gravarDto(a, c);
    		request.setAttribute("msg", "Dados gravados ...");
    	} catch (Exception ex) {
    		request.setAttribute("msg", "Error: " + ex.getMessage());
		} finally {
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
    	
    }

}
