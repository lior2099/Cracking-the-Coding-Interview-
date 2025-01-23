package fromWeb;

import java.util.HashMap;

public class FolderNames {

    public static String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] result = new String[n];
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (nameCount.containsKey(name)) {

                int k = nameCount.get(name);
                String newName;
                do {
                    k++;
                    newName = name + "(" + k + ")";
                } while (nameCount.containsKey(newName));

                result[i] = newName;
                nameCount.put(newName, 0);
                nameCount.put(name, k);
            } else {
                result[i] = name;
                nameCount.put(name, 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"gta", "nfs", "gta(1)", "gta", "gta", "gta(1)", "gta(1)"};
        String[] result = getFolderNames(names);

        for (String name : result) {
            System.out.println(name);
        }
    }
}
