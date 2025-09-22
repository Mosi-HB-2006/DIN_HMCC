package model;

import java.sql.*;
import java.util.*;

public class DBUserAccessor implements DataAccessible {

    private Connection con;
    private PreparedStatement stmt;

    @SuppressWarnings("FieldMayBeFinal")
    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    final String SQLUSER = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";

    public DBUserAccessor() {
        this.configFile = ResourceBundle.getBundle("modelo.configClase");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    private void openConnection() {
        try {
            con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User accessDataFile(String username, String password) {
        User user = null;

        this.openConnection();
        try {
            stmt = con.prepareStatement(SQLUSER);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getDate("BIRTHDATE").toString(),
                        rs.getString("DESCRIPTION"), Gender.valueOf(rs.getString("GENDER")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
