/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydatban.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import quanlydatban.Model.Account;

public class AccountDao {
    
    // --- Các phương thức đã có ---

    public List<Account> getAllAcount(){
        List<Account> listAcc = new ArrayList<Account>();
        
        String sql = "Select * from account";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            
            while(rs.next()){
                String user= rs.getString("username");
                String pass = rs.getString("password");
                // Lưu ý: Nếu Account Model của bạn có trường isActive, bạn nên lấy nó ra ở đây.
                listAcc.add(new Account(user , pass));
            }
            
        } catch (SQLException ex) {
            System.getLogger(AccountDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return listAcc;
    }

    public Account getAccountByUser(String user){
        Account acc = null;
        String sql = "Select * from Account "
                + "Where username = ?";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement psm = conn.prepareStatement(sql)) {
            
            psm.setString(1, user);
            try (ResultSet rs= psm.executeQuery()) {
                if(rs.next()){
                    String users = rs.getString("username");
                    String pass = rs.getString("password");
                    acc = new Account(users, pass);
                }
            }
            
        } catch (SQLException ex) {
            System.getLogger(AccountDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return acc;
        
    }

    public void updateActive(boolean isActive,String username){
        String sql = "UPDATE `Account` " 
               + "SET `isActive` = ? "
               + "WHERE `username` = ?";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement psm = conn.prepareStatement(sql)) {
            
            psm.setBoolean(1, isActive);
            psm.setString(2, username);
            psm.executeUpdate();
            
        } catch (SQLException ex) {
            System.getLogger(AccountDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    public String getEmployeeRoleByUsername(String username) {
        String role = null;
        // Sử dụng JOIN để liên kết Account và Employee
        String sql = "SELECT E.role "
                   + "FROM Employee E "
                   + "JOIN Account A ON E.username = A.username "
                   + "WHERE A.username = ?";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement psm = conn.prepareStatement(sql)) {

            psm.setString(1, username);
            
            try (ResultSet rs = psm.executeQuery()) {
                if (rs.next()) {
                    // Lấy giá trị của cột 'role'
                    role = rs.getString("role");
                }
            }
            
        } catch (SQLException ex) {
            System.getLogger(AccountDao.class.getName()).log(System.Logger.Level.ERROR, "Lỗi khi lấy vai trò nhân viên", ex);
        }
        return role;
    }
}
