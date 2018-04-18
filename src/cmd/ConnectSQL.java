package cmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IRS37
 */
public class ConnectSQL {

    private Connection con = null;
    private Statement stat = null;
    private PreparedStatement prestat = null;
    private ResultSet resultSet = null;

    public void connect(String user, String pass, String db) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + db, user, pass);
            //System.out.println("Berhasil login");
        } catch (SQLException e) {
            //System.out.println("Salah username/password");
        } catch (Exception e) {
            //System.out.println("Tidak tersambung");
            close();
        }
    }
    
    public boolean isConnected() throws SQLException{
        return con.isValid(1);
    }
    
    public void createDB(String database) throws SQLException {
        stat = con.createStatement();
        String db = "create database " + database;
        stat.executeUpdate(db);
    }

    public void connectDB(String database) {

    }

    public void write(String set) throws Exception {
        prestat = con.prepareStatement(set);
        prestat.executeUpdate();
    }

    public void insertListKaca(Map<Kaca, Integer> lk) throws Exception {
        for (Map.Entry<Kaca, Integer> list : lk.entrySet()) {
            String id = Integer.toString(list.getKey().getId());
            String p = Float.toString(list.getKey().getPanjang());
            String l = Float.toString(list.getKey().getLebar());
            String k = Float.toString(list.getKey().getKepadatan());
            String j = Integer.toString(list.getValue());
            write("insert into kaca values "
                    + "(" + id + "," + p + "," + l + "," + k + "," + j + ")");
        }
    }

    public void insertListKusen(Map<Kusen, Integer> lk) throws Exception {
        for (Map.Entry<Kusen, Integer> list : lk.entrySet()) {
            String id = Integer.toString(list.getKey().getId());
            String p = Float.toString(list.getKey().getPanjang());
            String l = Float.toString(list.getKey().getLebar());
            String k = list.getKey().getBahan();
            String j = Integer.toString(list.getValue());
            write("insert into kaca values "
                    + "(" + id + "," + p + "," + l + ",'" + k + "'," + j + ")");
        }
    }

    public void readtableid(String set) throws Exception {
        stat = con.createStatement();
        resultSet = stat.executeQuery(set);
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stat != null) {
                stat.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
