import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.sql.*;

public 	class StockServer extends UnicastRemoteObject implements StockInterface {
	String url = "jdbc:mysql://192.168.159.132/Stock";
	Connection conn;

	public StockServer() throws RemoteException {
		System.out.println("Initializing the Server");
	}

	public String getPrice(String strStockCode) {
		int intCurrentPrice = 0;
		int intTargetPrice = 0;
		String strCompanyName = "";
		String strReturnValue = "";
		System.out.println("Stock Code is " + strStockCode);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "123456");
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM Stocks WHERE StockCode = '" + strStockCode + "'");
			while (rs.next()) {
				intCurrentPrice = rs.getInt("CurrentPrice");
				intTargetPrice = rs.getInt("TargetPrice");
				strCompanyName = rs.getString("CompanyName");
			}
			strReturnValue = "Company Name: " + strCompanyName + ".\nThe Current Price of " + strStockCode + " is " + intCurrentPrice + ".\nThe Target Price of " + strStockCode + " is " + intTargetPrice + ".";
		}
		catch(Exception e) {
		}

		if (intCurrentPrice > 0)
			return strReturnValue;
		else
			return "No information available for " + strStockCode;
	}

	public static void main(String args[]) {
		try 	{
		/* Creating an instance of the Server object to export */
		/* stockServer is the name under which the server registers itself in the RMI registry */
			StockServer stockServer = new StockServer();
			Naming.rebind("StockMarket", stockServer);
			System.out.println("Server Ready");
		}
		catch (RemoteException re) 	{
			System.out.println("Remote Server Error: " + re.getMessage());
			System.exit(0);
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(0);
		}
	}
}