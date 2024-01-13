
/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package Race;

public class Racer implements Runnable {

	 private static int globalId = 1;
	    private int id;
	    private int speed;
	    private Track track;

	    public Racer(int speed, Track track) {
	        if (speed < 1 || speed > 10) {
	            throw new IllegalArgumentException("Speed must be between 1 and 10.");
	        }
	        this.id = globalId++;
	        this.speed = speed;
	        this.track = track;
	    }


	    public void go() {
	        int distance = 0;
	        for (int i = 1; i <= 100; i++) {
	            distance += speed;
	            System.out.println("Runner " + id + " ran " + distance + " meters");

	            if (distance >= 100) {
	                int place = track.getFinishedRacers();
	                System.out.println("Runner " + id + " finished in " + place + getPlace(place));
	                track.racerFinished();
	                break;
	            }
	        }
	    }
	    

	    private static String getPlace(int place) {
	        if (place % 100 >= 11 && place % 100 <= 13) {
	            return "th";
	        }
	        switch (place % 10) {
	            case 1:
	                return "st";
	            case 2:
	                return "nd";
	            case 3:
	                return "rd";
	            default:
	                return "th";
	        }
	    }

	
	
	@Override
	public void run() {
		go();
	}
	
	public int getId() {
        return id;
    }

}
