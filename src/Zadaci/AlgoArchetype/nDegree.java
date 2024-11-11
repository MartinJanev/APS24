package Zadaci.AlgoArchetype;


public class nDegree {

    // O(log n)
//    int pow(int x, int n) {
//        int r;
//
//        if (n == 0) {
//            return (1);
//        } else if (n % 2 == 0) {
//            r = pow(x, (n / 2));
//            return r * r;
//        } else {
//            r = pow(x, (n / 2));
//            return x * r * r;
//        }
//    }

    int pow(int k, int n) {//k^n
        if (n == 0) {
            return 1; //k^0=1
        }
        if (n == 1) {
            return k;//k^1=k
        }

        int p = pow(k, n / 2); //delime na pola
        //tuka dolu gi kombinirame
        if (n % 2 == 0) {//ako e paren
            return p * p;
        } else {//ako ne e
            return k * p * p;
        }
    }


    // O(n)
//    int pow(int x, int n) {
//        int r;
//        if (n == 0) return 1;
//        else if (n % 2 == 0) {
//            return pow(x, n / 2) * pow(x, n / 2);
//        } else {
//            return x * pow(x, n / 2) * pow(x, n / 2);
//        }
//    }

    public static void main(String[] args) {

        nDegree dac = new nDegree();

        System.out.println("pow: " + dac.pow(2, 10));


    }
}
