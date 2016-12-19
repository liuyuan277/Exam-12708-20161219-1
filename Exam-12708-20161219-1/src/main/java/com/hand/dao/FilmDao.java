package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.entity.Film;
import com.hand.jdbc.ConnectionFactory;
import com.hand.util.PageUtil;

public class FilmDao {
	
	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select f.film_id,f.title,f.description,l.name,f.language_id from language l,film f where l.language_id=f.language_id;");
		return ps.executeQuery();
	}

	public ResultSet getFile(Connection conn,Film film) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select f.film_id,f.title,f.description,l.name,f.language_id from language l,film f where l.language_id=f.language_id and  f.film_id=? ;");
		ps.setInt(1, film.getFilm_id());
		return ps.executeQuery();
	}
	
	
	  //根据页码和每页的容量来得到数据
	
    public PageUtil getPage(int pageNo, int pageSize) {
        Connection conn =ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Film> list = new ArrayList<Film>();
        PageUtil page = null;
        try {
            //获取总数据条数
            int totalCount = 0; 
            ps = conn.prepareStatement("select count(film_id) from film");
            rs = ps.executeQuery();
            while(rs.next()){
                totalCount = rs.getInt(1);
            }
            ps = conn.prepareStatement("select f.film_id,f.title,f.description,l.name,f.language_id from language l,film f where l.language_id=f.language_id limit " + (pageNo-1)*pageSize+","+pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
        		Film film=new Film();
        		film.setFilm_id(rs.getInt("film_id"));
        		film.setTitle(rs.getString("title"));
        		film.setDescription(rs.getString("description"));
        		film.setLanguage_id(rs.getInt("language_id"));
        		film.setLanguage(rs.getString("name"));
                list.add(film);
            }
            page = new PageUtil(pageSize, totalCount);
            page.setData(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

        return page;
    }
	
	public void save(Connection conn, Film film) throws SQLException {

		PreparedStatement pstm=conn.
				prepareCall("insert into film(title,description,language_id) values(?,?,?)");
		
		pstm.setString(1, film.getTitle());
		pstm.setString(2,film.getDescription());
		pstm.setInt(3,film.getLanguage_id());
		pstm.execute();
	}
	public void delete(Connection conn, Film film) throws SQLException {

		PreparedStatement pstm=conn.prepareStatement("DELETE FROM film WHERE film_id=?");
		pstm.setLong(1,film.getFilm_id());
		
		pstm.execute();
	}
	
	public void update(Connection conn, Film film) throws SQLException {

		PreparedStatement pstm=conn.
				prepareCall("update film set title=?,description=?,language_id=? where film_id=? ");
		
		pstm.setString(1, film.getTitle());
		pstm.setString(2,film.getDescription());
		pstm.setInt(3,film.getLanguage_id());
		pstm.setInt(4,film.getFilm_id());
		pstm.execute();
	}	
	
}
