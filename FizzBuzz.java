package il.co.ilrd.book;

public class FizzBuzz extends Thread {
    /*
     * FizzBuzz: Multithreaded version of FizzBuzz. Four threads:
     * - One thread prints "Fizz" for numbers divisible by 3.
     * - Another prints "Buzz" for numbers divisible by 5.
     * - A third prints "FizzBuzz" for numbers divisible by both 3 and 5.
     * - A fourth prints numbers not divisible by 3 or 5.
     */

    private static final Object lock = new Object();
    private static int current = 1; // Shared number counter
    private final int max; // Upper limit
    private final boolean div3;
    private final boolean div5; // Conditions for divisibility
    private final String toPrint; // Text to print if conditions match

    // Constructor
    public FizzBuzz(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 = div3;
        this.div5 = div5;
        this.toPrint = toPrint;
        this.max = max;
    }

    public void PrintMe() {
        System.out.println(toPrint);
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (current > max) {
                    return;
                }

                if ((current % 3 == 0) == div3 && (current % 5 == 0) == div5) {
                    PrintMe();
                    current++;
                }
            }
        }
    }

    public static void main(String[] args) {

        int n = 100;
        FizzBuzz fizzBuzz;

        Thread[] threads = {new FizzBuzz(true,true,n,"FizzBuzz"),
                              new FizzBuzz(true,false,n,"Fizz"),
                              new FizzBuzz(false,true,n,"Buzz"),
                                new NumberThread(false,false,n)};

        for (Thread thread : threads){
            thread.start();
        }
    }

    public static class NumberThread extends FizzBuzz {

        public NumberThread(boolean div3, boolean div5, int max) {
            super(div3, div5, max, null);
        }

        public void PrintMe() {
            System.out.println(current);
        }

    }


}





