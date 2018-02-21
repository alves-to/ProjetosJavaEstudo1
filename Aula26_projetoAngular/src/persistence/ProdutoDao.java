package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class ProdutoDao extends Dao {
	
	public void create(Produto p) throws Exception{
		open();
		 stmt = con.prepareStatement("insert into produto values(null,?,?) ");
		  stmt.setString(1, p.getNomeProduto());
		  stmt.setDouble(2, p.getPreco());
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	public void update(Produto p) throws Exception{
		open();
		 stmt = con.prepareStatement
 ("update produto set nomeProduto=?,preco=? where idProduto=?");
		  stmt.setString(1, p.getNomeProduto());
		  stmt.setDouble(2, p.getPreco());
		  stmt.setInt(3, p.getIdProduto());
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	public void delete(Integer cod) throws Exception{
		open();
		 stmt = con.prepareStatement
("delete from produto where idProduto=?");
		  stmt.setInt(1, cod);
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	
	public List<Produto> findAll() throws Exception{
		open();
		 stmt = con.prepareStatement("select * from produto");
		  rs = stmt.executeQuery();
		  List<Produto> lst = new ArrayList<Produto>();
		  while(rs.next()){
			  Produto p = new Produto();
			          p.setIdProduto(rs.getInt(1));
			          p.setNomeProduto(rs.getString(2));
			          p.setPreco(rs.getDouble(3));
			  lst.add(p);
		  }
		  stmt.execute();
		  stmt.close();
		close();
		return lst;
	}
	
	public Produto findByCode(Integer cod) throws Exception{
		open();
		 stmt = con.prepareStatement("select * from produto where idProduto=?");
		 stmt.setInt(1, cod);
		  rs = stmt.executeQuery();
          Produto produto=null;
		  if(rs.next()){
			 produto = new Produto();
			         produto.setIdProduto(rs.getInt(1));
			          produto.setNomeProduto(rs.getString(2));
			          produto.setPreco(rs.getDouble(3));
		  }
		  stmt.execute();
		  stmt.close();
		close();
		return produto;
	}

}
