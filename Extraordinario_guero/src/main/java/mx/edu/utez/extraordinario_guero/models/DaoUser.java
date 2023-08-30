package mx.edu.utez.extraordinario_guero.models;




import mx.edu.utez.extraordinario_guero.models.crud.DaoRepository;
import mx.edu.utez.extraordinario_guero.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoUser implements DaoRepository<User> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;


    public User loadUserByUsernameAndPassword(String username,
                                              String password) {
        System.out.println(username + password);
        try {
            conn = new MySQLConnection().connect();
            String query = "select users.id_user, users.username, r.role from users  join roles r on users.id_role = r.id_role where username=? and password=? and status='ACTIVO';";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId_user(rs.getLong("id_user"));
                user.setUsername(rs.getString("username"));

                Role role = new Role();
                role.setRole(rs.getString("role"));
                user.setRole(role);
                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,
                            "Credentials mismatch: " + e.getMessage());
        } finally {
            close();
        }
        return null;
    }



    public void close() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {

        }

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(User object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO users (name, lastname, curp, birthday, username, password, status, id_role)" +
                    " VALUES (?, ?, ?, ?, ?, ?, 'ACTIVO', 2);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getName());
            pstm.setString(2, object.getLastname());
            pstm.setString(3, object.getCurp());
            pstm.setString(4, object.getBirthday());
            pstm.setString(5, object.getUsername());
            pstm.setString(6, object.getPassword());
            return pstm.executeUpdate() > 0; // == 1
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save " + e.getMessage());
        } finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public List<User> findAllInstructors() {
        List<User> list = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = " SELECT * FROM users where id_role = 3;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getLong("id_user"));
                user.setName(rs.getString("name"));
                System.out.println(user);
                list.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,
                            "Find All Roles : " + e.getMessage());
        } finally {
            close();
        }
        return list;
    }

    public boolean saveIncripcion(User object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO inscripcion (fk_user, fk_clase, fk_temario)" +
                    " VALUES (?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, object.getId_user());
            pstm.setString(2, object.getLastname());
            pstm.setString(3, object.getCurp());
            return pstm.executeUpdate() > 0; // == 1
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save " + e.getMessage());
        } finally {
            close();
        }
        return false;
    }
}
