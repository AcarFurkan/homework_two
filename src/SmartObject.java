

abstract public class SmartObject {
	private String alias;
	private String macID;
	private String IP;
	private boolean connectionStatus;

	// SmartObject(){}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacID() {
		return macID;
	}

	public void setMacID(String macID) {
		this.macID = macID;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public boolean connect(String IP) {
		setConnectionStatus(true);
		setIP(IP);
		System.out.println(getAlias() + "conenction established");
		return isConnectionStatus();
	}

	public boolean disconnect() {
		setConnectionStatus(false);
		// IP??
		return isConnectionStatus();
	}

	public void SmartObjectToString() {
		System.out.println("This is SmartCamera device " + alias + "\n" + "\t MacId: " + macID + "\n" + "\t IP:" + IP);
	}

	public boolean controlConnection() {
		if (!connectionStatus) {
			System.out.println("This device is not connected. SmartCamera -> " + alias);
		}
		return connectionStatus;
	}

	public abstract boolean testObject();

	public abstract boolean shutDownObject();

}
