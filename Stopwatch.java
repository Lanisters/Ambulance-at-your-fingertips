package ambulance;
import java.io.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
class Stopwatch {
	static int interval;
	static Timer timer;
	void arrivalTime(){
		Random time= new Random();
		int secs = time.nextInt(10-5)+5;
	    int delay = 60000;
	    int period = 60000;
	    timer = new Timer();
	    interval = secs;
	    if(interval==0){
	    	System.out.println("Ambulance has arrived.");
	    }
	    System.out.println("The ambulance will arrive in "+secs+" min(s)");
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            if(interval==0){
	    	   	System.out.println("Ambulance has arrived.");
	            }
	            System.out.println("The ambulance will arrive in "+setInterval()+" min(s)");
	        }
	    }, delay, period);
	}
	private static final int setInterval() {
	    if (interval == 1)
		        timer.cancel();
	    return --interval;
	}
	void info(){
		Random n = new Random();
		String a[] = {"K.R. Hospital","B.G.S","Apollo Hospital","Radhakrishna Hospital","Victoria Hospital","Vivek Hospital","Shrisha Hospital","Qumber Hospital"};
		System.out.println("Nearest hospital : "+a[n.nextInt(7-0)+0]);
	}
}
class Booking extends Stopwatch{
	public static void main(String args[])throws IOException{
	int ch; int choice, menu=0;
	String location;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Press 1 to book an ambulance.");
	ch= Integer.parseInt(br.readLine());
	System.out.println("Enter your location");
	location=br.readLine();
	System.out.println("Searching for ambulances nearby...");
	try {
		//sleep 5 seconds
		Thread.sleep(6000);
	}   catch (InterruptedException e) {
		e.printStackTrace();
	}

	
	if(ch==1){
		Stopwatch sw = new Stopwatch();
		Stopwatch in = new Stopwatch();
		in.info();
		sw.arrivalTime();
		do{
		System.out.println("\n What is the medical emergency?");
		
		System.out.println("1. Heart attack.");
		System.out.println("2. Accident");
		System.out.println("3. Drowning");
		System.out.println("4. Exit.");
		choice=Integer.parseInt(br.readLine());
		switch(choice){
		case 1: System.out.println("-First aid until ambulance arrives");
				System.out.println("-Have the person sit down, rest, and try to keep calm. ");
				System.out.println("-Loosen any tight clothing");
				System.out.println("-Ask if the person takes any chest pain medicine, such as nitroglycerin, for a known heart condition, and help them take it.");
				System.out.println("-Keep the person calm and reassure him that help is on the way.");
				System.out.println("\n  Press 5 to go back to the menu.");
				menu=Integer.parseInt(br.readLine());
				break;
		case 2: System.out.println("-First aid until ambulance arrives");
				System.out.println("-Stop the bleeding (if any) with the help of a cloth and apply pressure with your palms.");
				System.out.println("-If the person is unconscious do not feed him/her as it may result in choking.");
				System.out.println("-If the neck is in an unusual position don't move it as it may lead to further damage.");
				System.out.println("-If the person is conscious keep him warm and awake. Reassure him help is on the way.");
				System.out.println("\n  Press 5 to go back to the menu.");
				menu=Integer.parseInt(br.readLine());
				break;
		case 3: System.out.println("-First aid until ambulance arrives");
				System.out.println("-Get Help. Notify a lifeguard, if one is close");
				System.out.println("-Move the Person. Take the person out of the water");
				System.out.println("-Check for Breathing. Place your ear next to the person's mouth and nose");
				System.out.println("-If There is No Pulse, Start CPR.");
				System.out.println("-Repeat CPR if necessary");
				System.out.println("\n  Press 5 to go back to the menu.");
				menu=Integer.parseInt(br.readLine());
				break;
		case 4: System.exit(1);
	  }
	}while(menu==5);
  }	
		
	else
		System.out.println("Thanks for using.");
 }
} 





