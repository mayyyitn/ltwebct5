package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DBConnectSQL {
			private	final String serverName = "MAYYY\\DUYTAN";
			private	final String dbName = "ltwebct5";
			private	final String portNumber = "1433";
			private	final String instance=""; //MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS	 SINGLE INSTANCE
			private	final String userID ="MAYYY\tnn03";
			private	final String password = "huathachthao1810";
			
			public Connection getConnection() {
				Connection conn = null;
				
				try {
					String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
					
					if(instance == null ||instance.trim().isEmpty())
						
						url = "jdbc:sqlserver://"+serverName+":"+portNumber + ";databaseName="+dbName;
					
					conn = DriverManager.getConnection(url, userID, password);
					
					if (conn != null) {
						DatabaseMetaData dm= (DatabaseMetaData) conn.getMetaData();
						System.out.println("Driver name: " + dm.getDriverName());
						System.out.println("Driver version: " + dm.getDriverVersion());
						System.out.println("Product name: " + dm.getDatabaseProductName());
						System.out.println("Product version: " + dm.getDatabaseProductVersion());
						
						
						return conn;
					}
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			return null;
}
			// Test chương trình. Kích chuột phải chọn run as->java application
			public static void main(String[] args) {
				try {
					System.out.println(new DBConnectSQL().getConnection());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
}
