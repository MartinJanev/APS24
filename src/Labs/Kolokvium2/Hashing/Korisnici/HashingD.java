package Labs.Kolokvium2.Hashing.Korisnici;


import java.util.Scanner;

public class HashingD {


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
            return name + " " + surname + " with salary " + budget + " from address " + ipAdress + " who spent " + price + "\n";
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> numConnectedUsers = new CBHT<>(2 * n - 1);
        CBHT<String, Person> biggestSpender = new CBHT<>(2 * n - 1);

        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String name = token[0];
            String surname = token[1];
            int budget = Integer.parseInt(token[2]);
            String wholeIp = token[3];
            String[] ipToken = wholeIp.split("\\.");
            String ipAddress = ipToken[0] + "." + ipToken[1] + "." + ipToken[2]; // Use network as key
            String host = ipToken[3];
            String time = token[4];
            String city = token[5];
            int price = Integer.parseInt(token[6]);

            SLLNode<MapEntry<String, Integer>> curr1 = numConnectedUsers.search(ipAddress);
            if (budget >= price) {
                if (curr1 == null) {
                    numConnectedUsers.insert(ipAddress, 1);
                } else {
                    numConnectedUsers.insert(ipAddress, curr1.element.value + 1);
                }
            }

            Person person = new Person(name, surname, budget, ipAddress, host, time, city, price);
            SLLNode<MapEntry<String, Person>> curr2 = biggestSpender.search(ipAddress);

            if (budget >= price) {
                if (curr2 == null) {
                    biggestSpender.insert(ipAddress, person);
                } else {
                    if (price > curr2.element.value.price) { // Compare price, not budget
                        biggestSpender.insert(ipAddress, person);
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
            String ipNetwork = ipC[0] + "." + ipC[1] + "." + ipC[2];

            SLLNode<MapEntry<String, Integer>> curr1 = numConnectedUsers.search(ipNetwork);
            System.out.println("IP network: " + ipNetwork + " has the following number of users:");
            System.out.println(curr1.element.value);
            SLLNode<MapEntry<String, Person>> curr2 = biggestSpender.search(ipNetwork);
            System.out.println("The user who spent the most from that network is:");
            System.out.println(curr2.element.value.toString());
        }
    }
}
