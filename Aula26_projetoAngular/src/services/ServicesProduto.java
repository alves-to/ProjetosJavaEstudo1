package services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import entity.Produto;
import persistence.ProdutoDao;

@Path("/produto")
public class ServicesProduto {

	
	@GET
	@Path("/gravar/{nomeProduto}/{preco}")
	@Produces("text/plain")
	public String gravar(@PathParam("nomeProduto") String nome,
		                	@PathParam("preco") String preco
			){
		try{
			Produto p = new Produto(null,nome ,new Double(preco));
			new ProdutoDao().create(p);
			return "ok Dados Gravados ...";
		}catch(Exception ex){
           return ex.getMessage();			
		}
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public String listar(){
		try{
        	return new Gson().toJson(new ProdutoDao().findAll());		
		}catch(Exception ex){
        	return "error :" + ex.getMessage();
       }
	}
	
	@GET
	@Path("/buscarCodigo/{cod}")
	@Produces("application/json")
	public String buscarCodigo(@PathParam("cod") String cod){
		try{
        	return new Gson().toJson(new ProdutoDao().findByCode(new Integer(cod)));		
		}catch(Exception ex){
        	return "error :" + ex.getMessage();
       }
	}
	

	
	
}
