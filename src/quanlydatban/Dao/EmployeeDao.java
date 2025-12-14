package quanlydatban.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import quanlydatban.Model.Employee;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HELLO
 */
public class EmployeeDao {
    List<Employee> list = new ArrayList<>();
    
    // 1. Phương thức tải dữ liệu (Đã dùng try-with-resources, giữ nguyên)
    public void getEmployee() throws java.sql.SQLException {
        list.clear();
        String sql = "select IDemploy , Name, DoB , Gender , Phone, Address, Salary, role from employee";
        
        try (java.sql.Connection conn = ConnectionDatabase.getConnection();
             java.sql.Statement stm= conn.createStatement();
             java.sql.ResultSet rs= stm.executeQuery(sql)) {
            
            while(rs.next()){
                int IdEmploy = rs.getInt("IDemploy");
                String name = rs.getString("Name");
                String DoB = rs.getString("DoB");
                String Gender = rs.getString("Gender");
                String Phone = rs.getString("Phone");
                String Address = rs.getString("Address");
                int Salary = rs.getInt("Salary");
                String Role= rs.getString("role");
                list.add(new Employee(IdEmploy,name, DoB, Gender, Phone, Address, Salary, Role));
            }
        }
    }
    
    public List<Employee> getList() {
        return list;
    }

    // 2. PHƯƠNG THỨC THÊM NHÂN VIÊN (Đã có sẵn và sử dụng try-with-resources, giữ nguyên)
    public boolean addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employee (IDemploy, Name, DoB, Gender, Phone, Address, Salary, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, emp.getIdEmploy());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDoB()); 
            ps.setString(4, emp.getGender());
            ps.setString(5, emp.getPhone());
            ps.setString(6, emp.getAddress());
            ps.setInt(7, emp.getSalary());
            ps.setString(8, emp.getRole());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
    }
    public boolean deleteEmployee(int employeeId) throws SQLException {
    String sql = "DELETE FROM employee WHERE IDemploy = ?";
    
    try (Connection conn = ConnectionDatabase.getConnection();
          PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, employeeId); 
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } 
}
    
    // 3. SỬA LỖI: isManager - Dùng try-with-resources để đóng tài nguyên
    public boolean isManager(String users) throws SQLException {
        String sql = "SELECT role FROM employee WHERE username = ?";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, users);
            
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    String getRole = rs.getString("role");
                    return getRole.equalsIgnoreCase("Manager");
                }
            }
        } // conn, ps, rs tự động đóng
        
        return false;
    }
    
    // 4. SỬA LỖI: getEmpbyUsername - Dùng try-with-resources để đóng tài nguyên
    public Employee getEmpbyUsername(String username) {
        Employee emp = null;
        String sql= "SELECT IDemploy, Name, DoB, Gender, Phone, Address, Salary, role FROM Employee WHERE username = ?";
        
        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement psm = conn.prepareStatement(sql)) {
            
            System.out.println("DEBUG: Đang tìm nhân viên có username = " + username);
            psm.setString(1, username);
            
            try (ResultSet rs= psm.executeQuery()) {
                while(rs.next()){
                    int id = rs.getInt("IDemploy");
                    String name = rs.getString("Name");
                    String dob = rs.getString("DoB");
                    String gender =rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int salary =rs.getInt("Salary");
                    String role = rs.getString("role");
                    
                    emp= new Employee(id, name , dob, gender , phone , address , salary , role);
                }
            }
        } catch (SQLException ex) {
             // Sử dụng logger hiện đại hơn và cung cấp thông báo lỗi
             System.getLogger(EmployeeDao.class.getName()).log(System.Logger.Level.ERROR, 
                                                              "Lỗi khi lấy nhân viên theo username: " + username, ex);
        }
        
        return emp;
    }

    public List<Employee> getAllEmployees() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}

