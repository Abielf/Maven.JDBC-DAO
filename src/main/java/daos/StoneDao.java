package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class StoneDao implements DAO<StoneDTO>{

    String dbUrl = "jdbc:mysql://localhost:3306/car";
    String user="root";
    String pass="Mrhappy64!";


    public StoneDao(){}

    public StoneDTO findById(int id){
        Connection connection;
        try {
            connection= DriverManager.getConnection(dbUrl, user, pass);
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM carTable WHERE id=" + id);

            if(rs.next())
            {
            return extractCar(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;}


    public List findAll(){
        Connection connection;
        try {
            connection= DriverManager.getConnection(dbUrl, user, pass);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM carTable");
            List garage = new ArrayList();
            while(rs.next())
            {
                StoneDTO vroom = extractCar(rs);
                toString(vroom);
                garage.add(vroom);
            }
            return garage;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public StoneDTO extractCar(ResultSet rs) throws SQLException{
        StoneDTO vroom= new StoneDTO();
        vroom.setId( rs.getInt("id") );
        vroom.setMake( rs.getString("make") );
        vroom.setModel( rs.getString("Model") );
        vroom.setColor( rs.getString("Color") );
        vroom.setVin( rs.getInt("vin") );
        return vroom;
    }


    public StoneDTO update(StoneDTO dto, int id){
        Connection connection;
        try {
            connection= DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement ps = connection.prepareStatement("UPDATE carTable SET make=?, model=?, color=?, vin=? WHERE id="+id);
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setString(3,dto.getColor());
            ps.setInt(4,dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public StoneDTO create(StoneDTO dto){Connection connection;
        try {
            connection= DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO carTable VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1,dto.getid());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setString(4,dto.getColor());
            ps.setInt(5,dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;}


    public void delete(int id){
        Connection connection;
        try {
            connection=DriverManager.getConnection(dbUrl,user,pass);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM carTable WHERE id=" + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void toString(StoneDTO s){
        System.out.println("ID:" + s.getid());
        System.out.println("Make:" + s.getMake());
        System.out.println("Model:" + s.getModel());
        System.out.println("Color:" + s.getColor());
        System.out.println("VIN:" + s.getVin());
    }
}