/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import static hotel.management.system.LoginController.ceckUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;

/**
 *
 * @author gg
 */
public class CustomerRegister {

    private Connection connect() throws SQLException {
        Connection con = null;
        String url = "jdbc:sqlite:D:/sqllite/HMS1.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established");
        return con;
    }

    public void CustomerRegisterdb(String name, String username, String email, String phone, String password) throws SQLException {
        String sql = "INSERT INTO CustomerRegister(name, username,email,phone,password) VALUES('" + name + "','" + username + "','" + email + "','" + phone + "','" + password + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The user added......");

    }

    public int checkLoging(String username, String password) throws SQLException {
        String sql = "select username, password, userType "
                + "From CustomerRegister "
                + "where username = '" + username + "';";
        //conctions
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

//        boolean cheaklog = false;
        if (rs.next()) {
            String u = rs.getString("username");
            String p = rs.getString("password");
            String t = rs.getString("userType");
            if (username.equals(u) && password.equals(p)) {
                if (t.equals("admin")) {
                    st.close();
                    con.close();
                    ceckUser = 2;
                } else {
                    st.close();
                    con.close();
                    ceckUser = 1;
                }
            } else {
                st.close();
                con.close();
                ceckUser = 0;
            }
        } else {
            st.close();
            con.close();
            ceckUser = 0;
        }
        return ceckUser;

    }

    public void addRooms(String rates,String roomType) throws SQLException {
        String sql = "INSERT INTO Rooms (room_riate,room_type) VALUES ('" + rates + "','" + roomType + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Room added......:D");
    }

    public void bookRoom(String roomNo) throws SQLException {
        String sql = "UPDATE Rooms "
                + "set room_Available ='Booked' "
                + "where RoomsNo = '" + roomNo + "' ";
        //conctions
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Room Booked......:D");

    }

    public boolean checkRoomAvailable(String roomNo) throws SQLException {
        String sql = "SELECT RoomsNo , room_Available FROM Rooms "
                + "where room_Available = 'available'; ";
        //conctions
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        //sheck the room

        while (rs.next()) {
            String roomnumber = rs.getString("RoomsNo");
            String roomAva = rs.getString("room_Available");

            if (roomAva.equals("available") && roomnumber.equals(roomNo)) {

                st.close();
                con.close();
                return true;

            }
        }
        st.close();
        con.close();
        return false;
    }
    
    public ResultSet AdminRoom() throws SQLException{
        String sql = "SELECT * FROM Rooms";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
         st.close();
        con.close();
        return rs;
    }

}
