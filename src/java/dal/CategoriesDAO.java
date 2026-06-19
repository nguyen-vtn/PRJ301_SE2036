/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Categories;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class CategoriesDAO extends DBContext {

    public Map<Integer, Categories> getAllCategories() {
        Map<Integer, Categories> listC = new HashMap<>();
        try {
            String sql = "select * from Categories";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                listC.put(c.getId(), c);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listC;
    }

    public boolean isIdExist(int id) {
        boolean exists = false;
        try {
            String sql = "select 1 from Categories where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return exists;
    }

    public boolean isNameExist(String name) {
        boolean exists = false;
        try {
            String sql = "select 1 from Categories where name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return exists;
    }

    public String addCategories(int id, String name) {
        try {
            String sql = "insert into Categories(id, name) values (?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.executeUpdate();
            st.close();
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Categories getCategoriesById(int id) {
        try {
            String sql = "select * from Categories where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("Name"));
                rs.close();
                st.close();
                return c;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Categories getCategoriesByName(String name) {
        try {
            String sql = "select * from Categories where name = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("Name"));
                rs.close();
                st.close();
                return c;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String updateCategories(int id, String name) {
        try {
            String sql = "update Categories set Name = ? where ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);

            st.executeUpdate();
            st.close();

            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
