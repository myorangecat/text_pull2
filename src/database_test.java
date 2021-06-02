import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database_test {
    public static final String URL="jdbc:mysql://localhost:3306/db1";
    public static final String USER="root";
    public static final String PASSWORD="dodo";
    public static void main(String[] args) throws Exception{

        //创建用户对象
        User user =new User();
        //加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得数据库连接
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        //操作数据库，查询数据库里面的内容并接受返回
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select id,Cpu_utilization,Memory_utilization,Disk_IO,Network_bandwidth,Number_users,Transaction_success_rate from amb_server_info");
        while(rs.next()){
            System.out.println(
                    "id："+rs.getInt("id")
                            +"\n中央处理器利用率："+rs.getInt("Cpu_utilization")
                            +"\n内存利用率："+rs.getInt("Memory_utilization")
                            +"\n磁盘IO：" +rs.getInt("Disk_IO")
                            +"\n网路带宽："+rs.getInt("Network_bandwidth")
                            +"\n并发用户数："+rs.getInt("Number_users")
                            +"\n事务成功率："+rs.getInt("Transaction_success_rate")
            );
        }

    }
}
