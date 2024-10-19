package Auditoriski.Prvi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TelevisionSet tv = new TelevisionSet("LG", 43, true, "Android");


        Box<TelevisionSet> kt = new Box<TelevisionSet>();

        Box<Appliance> kt2 = new Box<Appliance>();

        Box<AirConditioner> kt4 = new Box<AirConditioner>();


        System.out.println(kt.toString() + '\n');

        kt.setContent(tv);
        kt.setDescription("LG televizor");

        System.out.println(kt.toString());


        System.out.println(kt2.toString());

        kt2.setDescription("LG TV");
        kt2.setContent(tv);


        //kt4.setContent(tv);
        kt4.setDescription("LG TV");


        //  Box<Appliance>[]kutii = new Box<Appliance>[5];

        OrderedPair<Integer, String> pair = new OrderedPair<Integer, String>("C", 2);
        OrderedPair<String, String> pair1 = new OrderedPair<String, String>("s", "ss");
    }

    public static void helloWorld() {
        System.out.println("Hello World");

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int x = a + b;

        System.out.println("Zbirot e: " + x);

    }
}
