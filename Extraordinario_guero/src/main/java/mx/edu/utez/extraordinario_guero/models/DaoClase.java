package mx.edu.utez.extraordinario_guero.models;

import mx.edu.utez.extraordinario_guero.models.crud.DaoRepository;
import mx.edu.utez.extraordinario_guero.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClase implements DaoRepository<Clase> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public List<Clase> findAll() {
        List<Clase> clasess = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM clases inner join users where id_role = 3 and status_class = 'ACTIVO';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId_clase(rs.getLong("id_clase"));
                clase.setName_class(rs.getString("name_class"));
                clase.setDescription_class(rs.getString("description_class"));
                clase.setStatus_class(rs.getString("status_class"));
                User user = new User();
                user.setName(rs.getString("name"));
                clase.setUser(user);
                clasess.add(clase);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoInstructor.class.getName())
                    .log(Level.SEVERE, "Error findAll "
                            + e.getMessage());
        } finally {
            close();
        }
        return clasess;
    }

    @Override
    public Clase findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(Clase object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO clases (status_class, name_class, description_class, fk_user)" +
                    " VALUES ('ACTIVO', ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getName_class());
            pstm.setString(2, object.getDescription_class());
            pstm.setLong(3, object.getUser().getId_user());

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
    public boolean update(Clase object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public List<Clase> findAllClass() {
        List<Clase> list = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM clases;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId_clase(rs.getLong("id_clase"));
                clase.setName_class(rs.getString("name_class"));
                System.out.println(clase);
                list.add(clase);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoClase.class.getName())
                    .log(Level.SEVERE,
                            "Find All Roles : " + e.getMessage());
        } finally {
            close();
        }
        return list;
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
