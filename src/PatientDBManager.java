import java.sql.*;
import java.util.ArrayList;

public class PatientDBManager {
    private Connection conn;

    public PatientDBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital", "root", "yourpassword");
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public void addPatient(Patient patient) {
        try {
            String sql = "INSERT INTO patients (id, name, age, gender, disease) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patient.getId());
            stmt.setString(2, patient.getName());
            stmt.setInt(3, patient.getAge());
            stmt.setString(4, patient.getGender());
            stmt.setString(5, patient.getDisease());
            stmt.executeUpdate();
            HospitalDBLogger.log("Added patient: " + patient.getName());
        } catch (SQLException e) {
            System.out.println("Add patient failed: " + e.getMessage());
        }
    }

    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM patients");
            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("disease")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Fetch patients failed: " + e.getMessage());
        }
        return list;
    }

    public void deletePatient(int id) {
        try {
            String sql = "DELETE FROM patients WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                HospitalDBLogger.log("Deleted patient ID: " + id);
            } else {
                System.out.println("No patient found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}
