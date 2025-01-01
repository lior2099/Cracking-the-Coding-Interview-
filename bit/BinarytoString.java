package il.co.ilrd.book.bit;

public class BinarytoString {

    /*
    Binary to String: Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print
    the binary representation. If the number cannot be represented accurately in binary with at most 32
    characters, print "ERROR:'
     */

    public String printBinary(double num){
        if (num >= 1 | num <= 0){
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder("0.");
        double frac = 0.5;

        while (num > 0){
            if (binary.length() > 34){
                return "ERROR";
            }
            if (num >= frac){
                binary.append('1');
                num -= frac;
            } else {
                binary.append("0");
            }
            frac /= 2;

        }
        return binary.toString();
    }
}
