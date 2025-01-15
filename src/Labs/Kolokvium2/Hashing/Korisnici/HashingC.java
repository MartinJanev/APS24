package Labs.Kolokvium2.Hashing.Korisnici;


import java.util.Scanner;

public class HashingC {


    static class Person {

        String name, surname;
        int budget;
        String ipAdress, time, city;
        int price;

        public Person(String name, String surname, int budget, String ipAdress, String host, String time, String city, int price) {
            this.name = name;
            this.surname = surname;
            this.budget = budget;
            this.ipAdress = ipAdress + "." + host;
            this.time = time;
            this.city = city;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " " + surname + " with salary " + budget + " from address " + ipAdress + " who logged in at " + time + "\n";
        }
    }

    public static boolean after12(String time, String target) {
        int timeH = Integer.parseInt(time.split(":")[0]);
        int minH = Integer.parseInt(time.split(":")[1]);
        int tH = Integer.parseInt(target.split(":")[0]);
        int minT = Integer.parseInt(target.split(":")[1]);

        if (timeH < tH) return false;
        if (timeH == tH) {
            if (minH < minT) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> numConnected = new CBHT<>(2 * n - 1);
        CBHT<String, Person> earliestConnected = new CBHT<>(2 * n - 1);

        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String name = token[0];
            String surname = token[1];
            int budget = Integer.parseInt(token[2]);
            String ipAdressW = token[3];
            String[] ipC = ipAdressW.split("\\.");
            String ipNetwork = ipC[0] + "." + ipC[1] + "." + ipC[2]; // Use network part as key
            String host = ipC[3];
            String time = token[4];
            String city = token[5];
            int price = Integer.parseInt(token[6]);

            SLLNode<MapEntry<String, Integer>> curr1 = numConnected.search(ipNetwork);

            if (after12(time, "11:59")) {
                if (curr1 == null) {
                    numConnected.insert(ipNetwork, 1);
                } else {
                    numConnected.insert(ipNetwork, curr1.element.value + 1);
                }
            }

            Person person = new Person(name, surname, budget, ipNetwork, host, time, city, price);
            SLLNode<MapEntry<String, Person>> curr2 = earliestConnected.search(ipNetwork);
            if (after12(time, "11:59")) {
                if (curr2 == null) {
                    earliestConnected.insert(ipNetwork, person);
                } else {
                    if (!after12(time, curr2.element.value.time)) {
                        earliestConnected.insert(ipNetwork, person);
                    }
                }
            }
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String ipAdressW = token[3];
            String[] ipC = ipAdressW.split("\\.");
            String ipNetwork = ipC[0] + "." + ipC[1] + "." + ipC[2]; // Use network part for search

            SLLNode<MapEntry<String, Integer>> curr = numConnected.search(ipNetwork);
            System.out.println("IP network: " + ipNetwork + " has the following number of users:");
            System.out.println(curr != null ? curr.element.value : 0);

            SLLNode<MapEntry<String, Person>> curr2 = earliestConnected.search(ipNetwork);
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(curr2 != null ? curr2.element.value.toString() : "No users found\n");
        }
    }
}
