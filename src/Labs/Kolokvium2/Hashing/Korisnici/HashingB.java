package Labs.Kolokvium2.Hashing.Korisnici;

import java.util.Scanner;

public class HashingB {


    static class Person {
        String name, surname, ipAddress, time, city;
        int budget, price;

        public Person(String name, String surname, int budget, String ipAdress, String time, String city, int price) {
            this.name = name;
            this.surname = surname;
            this.ipAddress = ipAdress;
            this.time = time;
            this.city = city;
            this.budget = budget;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " " + surname + " with salary " + budget + " from address " + ipAddress + " who logged in at " + time;
        }
    }

    public static boolean compareTimes(String time, String target) {
        String[] hAndM = time.split(":");
        int h = Integer.parseInt(hAndM[0]);
        int m = Integer.parseInt(hAndM[1]);
        int hT = Integer.parseInt(target.split(":")[0]);
        int mT = Integer.parseInt(target.split(":")[1]);

        if (h < hT) return false;
        if (h == hT) {
            if (m < mT) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        CBHT<String, Integer> numPeopleToCity = new CBHT<>(2 * N - 1);
        CBHT<String, Person> earliest = new CBHT<>(2 * N - 1);

        for (int i = 0; i < N; i++) {
            String[] red = sc.nextLine().split("\\s+");
            String name = red[0].trim();
            String surname = red[1].trim();
            int budget = Integer.parseInt(red[2].trim());
            String ipAdress = red[3].trim();
            String time = red[4].trim();
            String city = red[5].trim();
            int price = Integer.parseInt(red[6].trim());

            SLLNode<MapEntry<String, Integer>> curr = numPeopleToCity.search(city);
            if (compareTimes(time, "12:00")) {
                if (curr == null) {
                    numPeopleToCity.insert(city, 1);
                } else {
                    numPeopleToCity.insert(city, curr.element.value + 1);
                }
            }


            Person p = new Person(name, surname, budget, ipAdress, time, city, price);
            SLLNode<MapEntry<String, Person>> curr2 = earliest.search(city);
            if (compareTimes(time, "12:00")) {
                if (curr2 == null) {
                    earliest.insert(city, p);
                } else {
                    if (!compareTimes(time, curr2.element.value.time)) {
                        earliest.insert(city, p);
                    }
                }
            }
        }

        int M = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < M; i++) {
            String[] red = sc.nextLine().split("\\s+");
            String city = red[5].trim();
            SLLNode<MapEntry<String, Integer>> curr = numPeopleToCity.search(city);
            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(curr.element.value);

            SLLNode<MapEntry<String, Person>> curr2 = earliest.search(city);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(curr2.element.value.toString() + "\n");
        }

    }
}
