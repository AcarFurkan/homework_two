

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
	private boolean status;
	private int batteryLife;
	private boolean nightVision;

	public SmartCamera(String alias, String macID, boolean nightVision, int batteryLife) {
		super();
		setMacID(macID);
		setAlias(alias);
		setBatteryLife(batteryLife);
		setNightVision(nightVision);
	}

	public void recordOn(boolean isDay) {
		if (isConnectionStatus() && isDay) {
			if (!isStatus()) {
				setStatus(true);
				System.out.println("Smart Camera -" + getAlias() + " is turned on now ");// TİME GİR
			} else {
				System.out.println("Smart Light - " + getAlias() + " has been already turned on");
			}
		} else if (isConnectionStatus() && !isDay) {
			if (isNightVision()) {
				if (!isStatus()) {
					setStatus(true);
					System.out.println("Smart Camera -" + getAlias() + " is turned on now ");// TİME GİR
				} else {
					System.out.println("Smart Light - " + getAlias() + " has been already turned on");
				}
			} else {
				System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
			}

		}
	}

	public void recordOff() {
		if (isConnectionStatus()) {
			if (isStatus()) {
				setStatus(false);
				System.out.println("Smart Camera -" + getAlias() + " is turned off now ");// TİME GİR
			} else {
				System.out.println("Smart Light - " + getAlias() + " has been already turned off");
			}
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}

	@Override
	public boolean testObject() {
		if (isConnectionStatus()) {
			System.out.println("Test is starting for SmartCamera day time");
			SmartObjectToString();
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(true);
			recordOff();
			System.out.println("Test completed for SmartCamera Test completed for SmartCamera");

		}
		return isConnectionStatus();
	}

	@Override
	public boolean shutDownObject() {
		if (isConnectionStatus()) {
			recordOff();
			SmartObjectToString();
			// Connection da kopartılacak mı ????
		}
		return isConnectionStatus();
	}

	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {// HER İKİ DURUMDA DA ÇALIŞACAK MI YOK SA SADECE
																	// HAREKET DURUMUNDA MIO
		if (!hasMotion) {
			System.out.println("Motion not detected!");
		} else {
			System.out.println("Motion detected!");
			recordOn(isDay);
		}
		return hasMotion;
	}

	@Override
	public int compareTo(SmartCamera o) {
		if (batteryLife > o.batteryLife) {
			return 1;
		} else if (batteryLife < o.batteryLife) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "SmartCamera -> " + getAlias() + "'s battery life is " + getBatteryLife() + " status is "
				+ (status == true ? "recording" : "not recording");
	}

}
