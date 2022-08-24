package Implementation;

import java.sql.*;
import Classes.Product;
import Connection_cd.Connexion;
import Daos.Dao;

public class ImplProduct implements Dao <Product>{
	public String sql;
	public Connexion cn;
	@Override
	public void add(Product item) {
		Connection cnx = null;
		cn = new Connexion();
		cnx = cn.connect();
		sql="insert into product values (?,?,?,?,?)";
		
		try {

			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, item.getIdp());
			ps.setString(2, item.getTitre());
			ps.setString(3, item.getDescription());
			ps.setFloat(4, item.getPrix());
			ps.setInt(5, item.getIdc());
			ps.execute();
				
				ps.close();
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}

	@Override
	public void edit(Product item) {
		Connection cnx = null;
		Connexion cn = new Connexion();
		cnx = cn.connect();
		sql = "update product set titre=?, description=? where idp=?";
		try {
		
			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setString(1, item.getTitre());
			ps.setString(2, item.getDescription());
			ps.setInt(3,item.getIdp());
			
			ps.executeUpdate();
            ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	@Override
	public void delete(Product item) {
		Connection cnx = null;
		Connexion cn = new Connexion();

		cnx = cn.connect();
		try {
			sql = "delete from product where idp = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1,item.getIdp() );
			ps.executeUpdate();
            ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	@Override
	public void listAll(Product product) {
		Connection cnx = null;
		Connexion cn = new Connexion();
		cnx = cn.connect(); 
		
		sql = "select * from product";

		
		try {
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idp = rs.getInt("idp");
				String titre = rs.getString("titre");
				String description = rs.getString("description");
				float prix = rs.getFloat("prix");
				int idc = rs.getInt("idc");
			
				product.setIdp(idp);
				product.setTitre(titre);
				product.setDescription(description);
				product.setPrix(prix);
				product.setIdc(idc);
				

				System.out.println(product.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public void ListProductByCategory(int idc) {
		Connection cnx = null;
		Connexion cn = new Connexion();
		cnx = cn.connect(); 
		
		sql="SELECT c.namec as categorie ,p.titre,p.prix,p.description FROM product p INNER JOIN category c ON p.idc=c.idc WHERE c.idc='"+ idc + "'";
		//sql="SELECT *FROM "+ "product"+ " NATURAL JOIN "+ "category";
		try {
			
		PreparedStatement ps = cnx.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		 System.out.println("Category name\t     Product name   Prix\t  Description");
		 System.out.println("------------------------------------------------------------------------");
		while(rs.next()) {
			String namec =rs.getString(1);
			String titre = rs.getString(2);
			float prix = rs.getFloat(3); 
			String description = rs.getString(4);
			
			System.out.print(namec+"  "+titre+"      "+prix+"      "+description);
			 System.out.println("\n----------------------------------------------------------------------------");

		}
		cnx.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}


}
