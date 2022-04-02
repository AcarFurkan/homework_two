
public class Test {
	public final static boolean onCome = true;
	public final static boolean isDay = true;
	public final static boolean hasMotion = true;
	public final static int NUM_OF_SECONDS = 5000;

	public static void main(String[] args) throws Exception  {

		// Creates a new smart home object
		SmartHome smartHome = new SmartHome();

		// Creates two smart light objects with the given aliases and macIds
		SmartLight livingRoomLight = new SmartLight("Living Room Light", "AA:BB:CC");
		SmartLight kitchenLight = new SmartLight("Kitchen Light", "AA:LL:CC");

		// Creates four smart plug objects with the given aliases and macIds
		SmartPlug kitchenPlug1 = new SmartPlug("Kitchen Plug 1", "DD:KK:FF");
		SmartPlug kitchenPlug2 = new SmartPlug("Kitchen Plug 2", "DD:LL:FF");
		SmartPlug livingRoomPlug1 = new SmartPlug("Living Room Plug 1", "DD:GG:FF");
		SmartPlug livingRoomPlug2 = new SmartPlug("Living Room Plug 2 ", "DD:EE:FF");

		// Creates three smart camera objects with the given aliases, macIds, nightVision properties, and battery life amounts
		SmartCamera gardenCam = new SmartCamera("Garden Cam", "GG:HH:II", true,  60);
		SmartCamera childRoomCam = new SmartCamera("Child Room Cam", "JJ:KK:LL", false,  30);
		SmartCamera gateCam = new SmartCamera("Gate Cam", "MM:NN:SS", true,  50);


		// Add these smart objects to the smartHome
		smartHome.addSmartObject(livingRoomLight);
		smartHome.addSmartObject(kitchenLight);

		smartHome.addSmartObject(kitchenPlug1);
		smartHome.addSmartObject(kitchenPlug2);
		smartHome.addSmartObject(livingRoomPlug1);
		smartHome.addSmartObject(livingRoomPlug2);

		smartHome.addSmartObject(gardenCam);
		smartHome.addSmartObject(childRoomCam);
		smartHome.addSmartObject(gateCam);

		//Invoke controlLocation method of smartHome with the given onCome = true.
		// You can also invoke this method as --> smartHome.controlLocation(!onCome);
		smartHome.controlLocation(onCome);


		//Invoke controlMotion method of smartHome with the given hasMotion = true and isDay = true.
		// You can also invoke this method as --> smartHome.controlMotion(!hasMotion, !isDay);
		smartHome.controlMotion(hasMotion, isDay);


		//Invoke controlTimerRandomly method of smartHome
		// You can also invoke the method  --> smartHome.controlTimer(10);
		smartHome.controlTimerRandomly();

		//the system is sleeping for 5 seconds
		sleepSystem();


		//Invoke controlProgrammable method of smartHome
		smartHome.controlProgrammable();

		//the system is sleeping for another 5 seconds
		sleepSystem();


		//Invoke controlProgrammable method of smartHome
		smartHome.controlProgrammable();


		//Invoke sortCameras method of smartHome
		smartHome.sortCameras();


		System.out.println("System exiting..");

	}

	public static void sleepSystem() throws Exception{
		System.out.println("System sleeping for " + (NUM_OF_SECONDS/1000) +" seconds");
		Thread.sleep(NUM_OF_SECONDS);
		System.out.println("System starting");
	}

}
