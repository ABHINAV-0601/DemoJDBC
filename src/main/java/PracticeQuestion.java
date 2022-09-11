import java.sql.*;

public class PracticeQuestion {
    public void getAllStudents(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            String user = "root";
            String password = "admin";
            Connection connection = DriverManager.getConnection(url,user,password);
            if(connection != null){
                System.out.println("Connection success");
                //statement
                Statement statement = connection.createStatement();

                String create = "Create table if not exists student(rollNo int,Name varchar(50),grades double)";
                boolean flag = statement.execute(create);

                if(flag){
                    System.out.println("table created");
                }
                else{
                    System.out.println("table not created");
                }
               
                String[] sql = {"Insert into student values(1,'Abhinav',250)","Insert into student values(2,'Vaibhav',500)","Insert into student values(3,'Mohit',300)","Insert into student values(4,'Gopal',345)",
                    "Insert into student values(5,'Diwakar',375)"};
                int rows = 0;
                for (int i = 0; i < sql.length; i++) {
                    rows = statement.executeUpdate(sql[i]);
                }

                if(rows == 5){
                    System.out.println("Data inserted");
                }
                else{
                    System.out.println("Not inserted");
                }

                ResultSet resultSet = statement.executeQuery("Select * from student");
                while(resultSet.next()){
                    System.out.println();
                    System.out.println("Roll No = " + resultSet.getInt(1));
                    System.out.println("Name = " + resultSet.getString(2));
                    System.out.println("Grades = "+ resultSet.getDouble(3));

                }
            }
            else{
                System.out.println("not connected");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PracticeQuestion practiceQuestion = new PracticeQuestion();
        practiceQuestion.getAllStudents();
    }
}
