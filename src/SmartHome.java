

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SmartHome {
	private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();

	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}

	public boolean addSmartObject(SmartObject smartObject) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "Adding new SmartObject\n"
				+ "--------------------------------------------------------------------------");
		smartObject.connect("10.0.0." + (smartObjectList.size() + 100));
		smartObject.testObject();

		return smartObjectList.add(smartObject);
	};

	public boolean removeSmartObject(SmartObject smartObject) {
		return smartObjectList.remove(smartObject);
	}

	public void controlLocation(boolean onCome) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "LocationControl : OnCome\n"
				+ "--------------------------------------------------------------------------");
		smartObjectList.forEach((temp) -> {
			if (LocationControl.class.isAssignableFrom(temp.getClass())) {
				if (onCome) {
					((LocationControl) temp).onCome();
				} else {
					((LocationControl) temp).onLeave();
				}
			}

		});

	}

	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "MotionControl: HasMotion, isDay\n"
				+ "--------------------------------------------------------------------------");
		smartObjectList.forEach((temp) -> {
			if (MotionControl.class.isAssignableFrom(temp.getClass())) {
				((MotionControl) temp).controlMotion(hasMotion, isDay);
			}
		});
	}

	public void controlProgrammable() {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "Programmable: runProgram\n"
				+ "--------------------------------------------------------------------------");

		smartObjectList.forEach((temp) -> {
			if (Programmable.class.isAssignableFrom(temp.getClass())) {
				((Programmable) temp).runProgram();
			}
		});
	}

	public void controlTimer(int seconds) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "Programmable: Timer = " + seconds + " seconds\n"
				+ "--------------------------------------------------------------------------");

		smartObjectList.forEach((temp) -> {
			if (Programmable.class.isAssignableFrom(temp.getClass())) {
				if (seconds > 0) {
					((Programmable) temp).setTimer(seconds);

				} else {
					((Programmable) temp).cancelTimer();

				}
			}
		});
	}

	public void controlTimerRandomly() {
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(0, 5, 10));
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "Programmable: Timer = 0, 5 or 10 seconds randomly\n"
				+ "--------------------------------------------------------------------------");

		smartObjectList.forEach((temp) -> {
			if (Programmable.class.isAssignableFrom(temp.getClass())) {
				int random = ((int) (Math.random() * 3));
				int number = numbers.get(random);
				if (number == 0) {
					((Programmable) temp).cancelTimer();
				} else {
					((Programmable) temp).setTimer(number);
				}

			}
		});
	}

	public void sortCameras() {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n"
				+ "Sort Smart Cameras\n"
				+ "--------------------------------------------------------------------------");

		ArrayList<SmartCamera> smartCameras = new ArrayList<SmartCamera>();
		smartObjectList.forEach((temp) -> {
			if (Comparable.class.isAssignableFrom(temp.getClass())) {
				smartCameras.add((SmartCamera) temp);
			}
		});
		Collections.sort(smartCameras);
		smartCameras.forEach((temp) -> {
			System.out.println(temp);
		});
	}

}
