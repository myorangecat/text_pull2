import jdk.internal.dynalink.beans.StaticClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test2 {
    /////////////////////JDBC连接数据库所需的静态数据常量///////////////////////////
    public static final String URL="jdbc:mysql://localhost:3306/student1";
    public static final String USER="root";
    public static final String PASSWORD="dodo";
    public static void main(String[] args) throws Exception{

        //创建用户对象
        User user =new User();
        //加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得数据库连接
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        //操作数据库，将用户对象数据写入数据库
        Statement stmt=conn.createStatement();
        //增加向student表中增加两个字段
        /*？？？？？？？这里出现问题.................
        为什么sql语句中不能引用java类对象的成员变量？是数据不兼容吗
        * stmt.execute("insert into student values (15,user.name,user.phone_number,user.address,null,user.sex)");
        * */
        stmt.execute("insert into student values (15,'吴大','17693360684','河北邦德','2012-02-12','男')");
        //在student表中带条件的修改一个字段的值
        stmt.execute("update student set phone_num='13728637286' where id=14");
    }
}
