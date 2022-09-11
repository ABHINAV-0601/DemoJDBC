import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/carsales";
            String user = "root";
            String password = "admin";
            Connection connection = DriverManager.getConnection(url,user,password);
            if(connection != null){
                System.out.println("Connection success");
                //statement
                Statement statement = connection.createStatement();

                String create = "Create table if not exists salesperson2(SalesId int,SalesPerson_Name varchar(20),City varchar(20),Comission_Rate double)";
                boolean flag = statement.execute(create);
                //String name = Boolean.toString(flag);

                //System.out.println(flag);
                if(flag){
                    System.out.println("table created");
                }
                else{
                    System.out.println("table not created");
                }
                //statement.execute(create);
                //System.out.println("table created");
                String[] sql = {"Insert into salesperson2 values(1001,'Mary','Berlin',24.0)","Insert into salesperson2 values(1002,'Sam','Stockholm',25.0)","Insert into salesperson2 values(1003,'Dave','Rome',12.0)","Insert into salesperson2 values(1004,'Gary','Stockholm',13.5)"};
                int rows = 0;
                for (int i = 0; i < sql.length; i++) {
                    rows = statement.executeUpdate(sql[i]);
                }

                if(rows == 4){
                    System.out.println("Data inserted");
                }
                else{
                    System.out.println("Not inserted");
                }

                ResultSet resultSet = statement.executeQuery("Select * from salesperson2");
                while(resultSet.next()){
                    System.out.println();
                    System.out.println("Sales Id = " + resultSet.getInt(1));
                    System.out.println("SalesPerson Name = " + resultSet.getString(2));
                    System.out.println("City = "+ resultSet.getString(3));
                    System.out.println("Comission Rate = "+ resultSet.getDouble(4));

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
}
