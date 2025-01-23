package fromWeb;

public class MultipleAll {

    public static int[] multipleAll(int[] arr) {

        int[] arrMult = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int mult = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                mult *= arr[j];
            }
            arrMult[i] = mult;
        }

        return arrMult;
    }

    public static int[] multipleAllBetter(int[] arr) {

        int[] arrMult = new int[arr.length];
        int mult = 1;
        int countZero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero++;
            } else {
                mult *= arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (countZero > 0) {
                if (countZero > 1) {
                    arrMult[i] = 0;
                } else {
                    if (arr[i] == 0) {
                        arrMult[i] = mult;
                    } else {
                        arrMult[i] = 0;
                    }
                }
            } else {
                arrMult[i] = mult / arr[i];
            }
        }

        return arrMult;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 0};
        int[] arrMult = multipleAll(arr);
        int[] arrMultBetter = multipleAllBetter(arr);

        for (int i : arrMult) {
            System.out.println(i);
        }

        System.out.println("Use better");
        for (int i : arrMultBetter) {
            System.out.println(i);
        }
    }

}

