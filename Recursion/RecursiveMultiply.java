package il.co.ilrd.book.Recursion;

public class RecursiveMultiply {
    public static int MultiplyMe(int a, int b) {
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            if (a > 0) {
                return MultiplyMeHelperSub(a, b);
            } else {
                return MultiplyMeHelperSub(b, a);
            }

        } else {
            if (a < 0) {
                return MultiplyMeHelperAdd(-b, -a);
            }
            return MultiplyMeHelperAdd(b, a);
        }
    }

    private static int MultiplyMeHelperAdd(int a, int b) {
        if (b <= 0) {
            return 0;
        }

        return MultiplyMeHelperAdd(a, b - 1) + a;

    }

    private static int MultiplyMeHelperSub(int a, int b) {
        if (a <= 0) {
            return 0;
        }

        return MultiplyMeHelperSub(a - 1, b) + b;

    }


    public static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProd = minProductHelper(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }


    public static void main(String[] args) {
        System.out.println(MultiplyMe(3, 5));
        System.out.println(MultiplyMe(3, -5));
        System.out.println(MultiplyMe(-3, -5));
        System.out.println(MultiplyMe(-3, 5));


        System.out.println(minProduct(10, 20));


    }
}
