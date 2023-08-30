package mx.edu.utez.extraordinario_guero.models;

import mx.edu.utez.extraordinario_guero.models.crud.DaoRepository;
import mx.edu.utez.extraordinario_guero.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTemario implements DaoRepository<Temario> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public List<Temario> findAll() {
       return null;
    }

    @Override
    public Temario findOne(Long id) {
        return null;
    }

    @Override
    public boolean save(Temario object) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO temarios (description_temario, fk_clase)" +
                    " VALUES (?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, object.getDescription_temario());
            pstm.setLong(2, object.getClase().getId_clase());

            return pstm.executeUpdate() > 0; // == 1
        } catch (SQLException e) {
            Logger.getLogger(DaoTemario.class.getName())
                    .log(Level.SEVERE, "Error save " + e.getMessage());
        } finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(Temario object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public List<Temario> findAllTemas() {
        List<Temario> list = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM temarios;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Temario temario = new Temario();
                temario.setId_temario(rs.getLong("id_temario"));
                temario.setDescription_temario(rs.getString("description_temario"));
                System.out.println(temario);
                list.add(temario);
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

    public List<Temario> findAllTemarios(Long id_clase) {
        List<Temario> list = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM temarios where fk_clase = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id_clase);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Temario temario = new Temario();
                temario.setId_temario(rs.getLong("id_temario"));
                temario.setDescription_temario(rs.getString("description_temario"));
                System.out.println(temario);
                list.add(temario);
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


    public void close() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {

        }

    }
}

