

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
	private boolean status;
	private Calendar programTime;
	private boolean programAction;

	public SmartPlug(String alias, String macId) {
		super();
		setAlias(alias);
		setMacID(macId);

	}

	public void turnOn() {
		if (isConnectionStatus()) {
			if (!isStatus()) {
				System.out.println("Smart Plug - " + getAlias() + " is turned on now " + currentTime());
				setStatus(true);
			} else {
				System.out.println("Smart Plug - " + getAlias() + " Kitchen Plug 1 has been already turned on");
			}

		}
	}

	public void turnOff() {
		if (isConnectionStatus()) {
			if (isStatus()) {
				System.out.println("Smart Plug - " + getAlias() + " is turned off now  " + currentTime());
				setStatus(false);
			} else {
				System.out.println("Smart Plug - " + getAlias() + " Kitchen Plug 1 has been already turned off");
			}

		}
	}

	public String currentTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		String date = simpleDateFormat.format(Calendar.getInstance().getTime());
		return "(Current time: " + date + ")";
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}

	@Override
	public void setTimer(int seconds) {
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.SECOND, seconds);
		setProgramTime(calender);
		if (isConnectionStatus()) {
			if (isStatus()) {
				System.out.println("Smart plug - " + getAlias() + " Light will be turned off " + seconds
						+ " seconds later! " + currentTime());
			} else {
				System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later! "
						+ currentTime());
			}
		}

	}

	@Override
	public void cancelTimer() {
		if (isConnectionStatus()) {
			setProgramTime(null);
		}

	}

	public boolean isSameDateTime(Calendar cal1, Calendar cal2) {
		// compare if is the same ERA, YEAR, DAY, HOUR, MINUTE and SECOND
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
				&& cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
				&& cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)
				&& cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND));
	}

	@Override
	public void runProgram() {// I DİDNT USE PROGRAMACTİON PROPERTY BUT INSTRUCTOR WANT TO USE
		if (isConnectionStatus()) {
			if (getProgramTime() != null) {
				if (isSameDateTime(getProgramTime(), Calendar.getInstance())) {
					System.out.println("RunProgram -> Smart Plug - " + getAlias());
					if (isStatus()) {
						turnOff();
					} else {
						turnOn();
					}
					setProgramTime(null);
				}
			}

		}
	}

	@Override
	public boolean testObject() {
		if (isConnectionStatus()) {
			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed $a for SmartLight");
		}
		return isConnectionStatus();
	}

	@Override
	public boolean shutDownObject() {
		if (isConnectionStatus()) {
			SmartObjectToString();
			if (isStatus()) {
				turnOff();
			}
		}
		return isConnectionStatus();
	}

}
