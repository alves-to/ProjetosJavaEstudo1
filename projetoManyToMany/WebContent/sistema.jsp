<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fnt" uri="http://java.sun.com/jsp/jstl/functions" %>
  <jsp:useBean id="mb" class="manager.ManagerBean" scope="request"></jsp:useBean>
  <title>Projeto ManyToMany</title>
</head>
<body>
  <h2>Gravar relacionado Aluno e Curso</h2>
  <form method="post" action="Controle?cmd=gravar">
    <label for="idAluno">idAluno</label>
    <select name="idAluno">
      <c:forEach items="${mb.listaAluno}" var="linha1">
        <option value="${linha1.idAluno}">${linha1.nome}</option>
      </c:forEach>
    </select>
    
    <label for="idCurso">idAluno</label>
    <select name="idCurso">
      <c:forEach items="${mb.listaCurso}" var="linha2">
        <option value="${linha2.idCurso}">${linha2.nomeCurso}</option>
      </c:forEach>
    </select>
  
  	<button id="btn1">Enviar os dados</button>
  	${msg} 
  	</form>  
    
    <p/>
    
    <table id="chuck" border="1">
      <thead>
        <tr>
          <td>idAluno</td> 
          <td>nome</td>
          <td>email</td>
          <td>idCurso</td>
          <td>nomeCurso</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${mb.listaDto}" var="linha3">
          <tr>
            <td>${linha3.idAluno}</td>
            <td>${linha3.nome}</td>
            <td>${linha3.email}</td>
            <td>${linha3.idCurso}</td>
            <td>${linha3.nomeCurso}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  

</body>
</html>