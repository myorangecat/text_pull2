import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static final String URL="jdbc:mysql://localhost:3306/student1";
    public static final String USER="root";
    public static final String PASSWORD="dodo";

    public static void main(String[] args) throws Exception{
        //加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得数据库连接
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        //操作数据库，实现增删查改
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT id,name,phone_num,address,brithday,sex FROM student");
        //如果有数据，rs.next()返回true
        System.out.println("序号   姓名   电话号码  地址  生日  性别");
        while(rs.next()){
            System.out.println(
                    rs.getInt("id")
                            +rs.getString("name")
                            +rs.getString("phone_num")
                            +rs.getString("address")
                            +rs.getString("brithday")
                            +rs.getString("sex")
            );
        }
    }
}
