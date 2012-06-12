import java.rmi.*;

public interface StockInterface extends Remote {
	public String getPrice(String strStockCode) throws RemoteException;
}