package System;
import java.sql.*;
//数据库连接类
class JDBCConnection{
	private java.sql.Connection con=null;
	private final String url="jdbc:sqlserver://";
	private final String serverName="127.0.0.1";
	private final String portNumber="1433";
	private final String databaseName="student";
	private final String userName="sa";
	private final String password="123";
	private final String selectMethod="cursor";
	public java.sql.Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=java.sql.DriverManager.getConnection(getConnectionUrl(),userName,password);
			if(con!=null);
				System.out.println("数据库链接成功！");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection():"+e.getMessage());
		}
		return con;
	}
	public String getConnectionUrl() {
		return url+serverName+":"+portNumber+";databaseName="+databaseName+";selectMethod="+selectMethod+";";
	}
	public void closeConnection() {
		try {
			if(con!=null)
				con.close();
			con=null;
			System.out.println("数据库链接关闭！");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

