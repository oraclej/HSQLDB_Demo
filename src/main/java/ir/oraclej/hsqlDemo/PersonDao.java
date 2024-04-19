package ir.oraclej.hsqlDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public static List getAllPeople() {
        try {
            Connection connection = HSQLConnection.getConnection();
            List<PersonEntity> list = new ArrayList<>();
            String sql = "select * from person";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PersonEntity p = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addPerson(PersonEntity person) {
        try {
            Connection connection = HSQLConnection.getConnection();
            String sql = "insert into person values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, person.getId());
            ps.setString(2, person.getName());
            ps.setString(3, person.getFamily());
            ps.setInt(4, person.getAge());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
