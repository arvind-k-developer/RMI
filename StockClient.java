import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import java.awt.event.*;

public class StockClient extends Frame implements ActionListener {
	Button btnPrice = new Button("Get Quote");

/* Creating Labels */
	Label lblStockCode = new Label("Enter Stock Code:");
	Label lblStockDetails = new Label("Stock Details:");

/* Creating a text area */
	TextArea txtareaStockDetails = new TextArea();

/* Creating text items */
	TextField txtStockCode = new TextField(25);

	public StockClient() {
		super("Finance Tracker(Remote Client - RMI)");
		setLayout(null);
		lblStockCode.setBounds(10, 70, 100, 25);
		add(lblStockCode);
		txtStockCode.setBounds(150, 70, 150, 25);
		add(txtStockCode);
		lblStockDetails.setBounds(20, 120, 100,25);
		add(lblStockDetails);
		txtareaStockDetails.setBounds(150, 120, 350, 100);
		add(txtareaStockDetails);
		btnPrice.setBounds(175, 275, 150, 25);
		add(btnPrice);
	/* Adding listeners for the buttons */
		btnPrice.addActionListener(this);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public void processWindowEvent(WindowEvent winEvt) {
		if(winEvt.getID() == WindowEvent.WINDOW_CLOSING) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

/* Trapping events for each buttons */
	public void actionPerformed(ActionEvent actEvt) {
		if (actEvt.getSource() == btnPrice) {
			stockCheck();
		}
	}

	public void stockCheck() {
		String Stock = txtStockCode.getText();
		String val;
 		try {
			String ServerURL = "//192.168.159.132/StockMarket";
			StockInterface stockInterface = (StockInterface)Naming.lookup(ServerURL);
			val = stockInterface.getPrice(Stock);
			txtareaStockDetails.setText(val);
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public static void main(String[] args) {
	/* Invoking the constructor of the StockClient class */
		StockClient stockClient = new StockClient();
		stockClient.setVisible(true);
		stockClient.setSize(550, 350);
	}
}