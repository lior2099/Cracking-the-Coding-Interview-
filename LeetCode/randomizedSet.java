package LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class randomizedSet {
    Set<Integer> set;
    int size;


    public void randomizedSet() {
        set = new HashSet<>();
        size = 0;
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        if (size == 0) {
            return -1;
        }

        int random = (int) (Math.random() * size);

        Iterator<Integer> iterator = set.iterator();

        while (random > 0) {
            iterator.next();
            random--;
        }

        return iterator.next();
    }


    public static void main(String[] args) {

        randomizedSet rs = new randomizedSet();

        if (rs.insert(1)) {
            System.out.println("1");
        }
        if (rs.insert(2)) {
            System.out.println("2");
        }
        if (rs.remove(3)) {
            System.out.println("3");
        }
        System.out.println(rs.getRandom());
    }


//
//public class RandomizedSet {
//    private List<Integer> list;
//    private Map<Integer, Integer> mapCtoI;
//
//    public RandomizedSet() {
//        list = new ArrayList<>();
//        mapCtoI = new HashMap<>();
//    }
//
//    public boolean insert(int val) {
//        if (mapCtoI.containsKey(val)) return false;
//
//        list.add(val);
//        mapCtoI.put(val, list.size() - 1);
//        return true;
//    }
//
//    public boolean remove(int val) {
//        if (!mapCtoI.containsKey(val)) return false;
//
//        int index = mapCtoI.get(val);
//        int lastElement = list.getLast();
//
//        list.set(index, lastElement);
//        mapCtoI.put(lastElement, index);
//
//        list.removeLast();
//        mapCtoI.remove(val);
//
//        return true;
//    }
//
//    public int getRandom() {
//        if (list.isEmpty()) return -1;
//        int index = (int) (Math.random() * list.size());
//        return list.get(index);
//    }
//
//    public static void main(String[] args) {
//        RandomizedSet rs = new RandomizedSet();
//
//        System.out.println("Insert 1: " + rs.insert(1));  // true
//        System.out.println("Insert 2: " + rs.insert(2));  // true
//        System.out.println("Insert 2 again: " + rs.insert(2));  // false
//        System.out.println("Remove 1: " + rs.remove(1));  // true
//        System.out.println("Remove 3: " + rs.remove(3));  // false
//        System.out.println("Random: " + rs.getRandom()); // 2 or -1
//    }
}



