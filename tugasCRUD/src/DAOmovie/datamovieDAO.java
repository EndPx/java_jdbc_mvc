/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOmovie;
import java.sql.*;
import java.util.*;
import tugascrud.keneksi.koneksi;
import tugascrud.model.*;
import tugascrud.DAOimplement.datamovileimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author abaym
 */
public class datamovieDAO implements datamovileimplement{
    Connection connection;
    
    final String select = "SELECT * FROM `movie`;";
    final String insert = "INSERT INTO `movie`(`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES (?,?,?,?,?);";
    final String update = "UPDATE `movie` SET `alur`=?,`penokohan`=?,`akting`=?,`nilai`=? WHERE `judul`=?;";
    final String delete = "DELETE FROM `movie` WHERE judul=?";
    public datamovieDAO(){
        connection = koneksi.connection();
    }

    @Override
    public void insert(movie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(movie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            statement.setDouble(4, m.getNilai());
            statement.setString(5, m.getJudul());
            statement.executeUpdate();     
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(movie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, m.getJudul());
            statement.executeUpdate();     
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<movie> getAll() {
        List<movie> dp = null;
        try{
            dp = new ArrayList<movie> ();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                movie m = new movie();
                m.setJudul(rs.getString("judul"));
                m.setAlur(rs.getDouble("alur"));
                m.setPenokohan(rs.getDouble("penokohan"));
                m.setAkting(rs.getDouble("akting"));
                m.setNilai(rs.getDouble("nilai"));
                dp.add(m);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dp;
    }
}
