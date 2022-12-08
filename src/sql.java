import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {
	
	/**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(String day, String one, String two, String three, String four, String five, String six, String seven) {
        String sql = "INSERT INTO subjects(day,one,two,three,four,five,six,seven) VALUES(?,?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, day);
            pstmt.setString(2, one);
            pstmt.setString(3, two);
            pstmt.setString(4, three);
            pstmt.setString(5, four);
            pstmt.setString(6, five);
            pstmt.setString(7, six);
            pstmt.setString(8, seven);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String day, String one, String two, String three, String four, String five, String six, String seven) {
        String sql = "UPDATE subjects SET one = ? , "
                + "two = ? , "
                + "three = ? , "
                + "four = ? , "
                + "five = ? , "
                + "six = ? , "
                + "seven = ? "
                + "WHERE day = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, one);
            pstmt.setString(2, two);
            pstmt.setString(3, three);
            pstmt.setString(4, four);
            pstmt.setString(5, five);
            pstmt.setString(6, six);
            pstmt.setString(7, seven);
            pstmt.setString(8, day);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(String day) {
        String sql = "DELETE FROM subjects WHERE day = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, day);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public String[] selectday(){
    	String[] result = new String[5];
        String sql = "SELECT day FROM subjects";
        int i = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	result[i] = rs.getString("day");
            	i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public String[][] selectAll(){
    	String[][] result = new String[5][7];
        String sql = "SELECT day, one, two, three, four, five, six, seven FROM subjects";
        int i = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	result[i][0] = rs.getString("one");
            	result[i][1] = rs.getString("two");
            	result[i][2] = rs.getString("three");
            	result[i][3] = rs.getString("four");
            	result[i][4] = rs.getString("five");
            	result[i][5] = rs.getString("six");
            	result[i][6] = rs.getString("seven");
            	i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
