/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package quanlydatban.Model;
/**
 *
 * @author HELLO
 */
public class Account {
    public boolean isActive = false;
    public String username;
    public String password;
    public String role;

    public Account(String username, String password , String role) {
        this.username = username;
        this.password = password;
        this.role=role;
    }
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
