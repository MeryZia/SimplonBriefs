package Implementation;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Classes.Category;
import Connection_cd.Connexion;
import Daos.Dao;

public class ImplCategory implements Dao<Category> {
	public String sql;
	public Connexion cn;
	@Override
	public void add(Category item) {
		Connection cnx = null;
		cn = new Connexion();
		cnx = cn.connect();
		sql="insert into category(idc, namec) values (?,?)";
		
		try {

			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, item.getIdc());
			ps.setString(2, item.getNamec());
			
			ps.execute();
				
				ps.close();
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void edit(Category item) {
		Connection cnx = null;
		Connexion cn = new Connexion();
		cnx = cn.connect();
		try {
			sql = "update category set namec=? where idc= ?";
			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setString(1, item.getNamec());
			ps.setInt(2,item.getIdc());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void delete(Category item) {
		Connection cnx = null;
		Connexion cn = new Connexion();

		cnx = cn.connect();
		try {
			sql = "delete from category where idc = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1,item.getIdc() );
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void listAll(Category category) {
		Connection cnx = null;
		Connexion cn = new Connexion();
		cnx = cn.connect(); 
		
		sql = "select * from category";

	
		
		try {
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idc = rs.getInt("idc");
				String namec = rs.getString("namec");
			

				category.setIdc(idc);
				category.setNamec(namec);
				

				System.out.println(category.toString());
		
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void ListProductByCategory(int idc) {
		// TODO Auto-generated method stub
		
	}
}
