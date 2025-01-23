package fromWeb;

class Parachutist {
    int position; // Current position
    int flag;     // Flag position
    int step;     // Current step count
    boolean forward; // Direction of movement

    public Parachutist(int flag , boolean forward) {
        this.position = flag;
        this.flag = flag;
        this.step = 1; // Start with step size 1
        this.forward = forward; // Initially moving forward
    }

    public void move() {
        if (forward) {
            position = flag + step; // Move to the right relative to the flag
        } else {
            position = flag - step; // Move to the left relative to the flag
            step++; // Increase step size after moving left
        }
        forward = !forward; // Alternate direction
    }
}

public class MeetParachutists {
    public static void main(String[] args) {
        Parachutist p1 = new Parachutist(0 , true );   // Parachutist 1 at position 0
        Parachutist p2 = new Parachutist(10 , false);  // Parachutist 2 at position 10

        while (p1.position != p2.position && p1.position < 100) { // Loop until they meet
            p1.move();
            p2.move();
            System.out.println("P1: " + p1.position + ", P2: " + p2.position);
        }

        System.out.println("Parachutists met at position: " + p1.position);
    }
}

