package LeetCode;

public class gasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//
//        if (len == 1) {
//            if(gas[0] >= cost[0]){
//                return gas[0] - cost[0];
//            }
//        }
//
//        int completeCircuit = 0;
//
//        for (int start = 0; start < len; start++) {
//            if (gas[start] > cost[start] ) {
//                completeCircuit = tryCompleteCircuit(gas,cost,start);
//                if (completeCircuit >= 0) {
//                    return start;
//                }
//            }
//        }
//        return -1;

        int totalTank = 0;
        int currTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;


            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }


    private static int tryCompleteCircuit(int[] gas, int[] cost, int index) {

        int tank = gas[index];
        int gasCost = cost[index];

        for (int i = index +1 ; i < gas.length ; i++) {
            tank -= gasCost;
            if (tank < 0) {
                return -1;
            }
            tank += gas[i];
            gasCost = cost[i];
        }

        for (int i = 0 ; i <= index ; i++) {
            tank -= gasCost;
            if (tank < 0) {
                return -1;
            }
            tank += gas[i];
            gasCost = cost[i];;
        }
        return tank;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {1,2,3,4,5} , new int[] {3,4,5,1,2}));

        System.out.println(canCompleteCircuit(new int[] {2,3,4} , new int[] {3,4,3}));

        System.out.println(canCompleteCircuit(new int[] {2} , new int[] {2}));
    }
}
