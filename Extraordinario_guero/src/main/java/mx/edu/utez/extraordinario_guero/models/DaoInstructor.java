package mx.edu.utez.extraordinario_guero.models;

import mx.edu.utez.extraordinario_guero.models.crud.DaoRepository;
import mx.edu.utez.extraordinario_guero.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoInstructor implements DaoRepository<User> {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM users where id_role = 3;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getLong("id_user"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setCurp(rs.getString("curp"));
                user.setBirthday(rs.getString("birthday"));
                user.setStatus(rs.getString("status"));
                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoInstructor.class.getName())
                    .log(Level.SEVERE, "Error findAll "
                            + e.getMessage());
        } finally {
            close();
        }
        return users;
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
                    " VALUES (?, ?, ?, ?, ?, ?, 'ACTIVO', 3);";
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

    public void close() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {

        }

    }
}
