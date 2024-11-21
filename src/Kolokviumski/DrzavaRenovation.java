//Некоја држава одлучила да започне процес на реновирање на патишта помеѓу грдовите. Помеѓу секои два града постои
//пат кој или веќе е реновиран или треба да се реновира.
//Притоа, за реновирањето да биде извршено побрзо, потребно е да се најдат најприоритетните патишта што треба да се реновираат,
//со што сите градови би имале пристап до барем еден реновиран пат до другите градови.
//Реновирањето треба да се направи по најниска можна цена.
//Процесот на реновирање е веќе започнат.
//Ваша задача е да се заврши тој процес, а притоа да се потрошат најмалку пари за поврзување на сите градови.
//
//Влез:
//Во првиот ред е даден бројот на градови, M.
//Во вториот ред е даден бројот на патишта меѓу градовите, N
//Во третиот ред е даден бројот на веќе реновирани патишта. P.
//Во наредните M реда се дадени имињата на градовите.
//Во следните N реда се дадени парови на имиња на градови, проследени со цел број што претставува цена на реновирање
// на патот меѓу тие два града.
//Во последните P реда се дадени парови од градови помеѓу кои веќе постои  реновиран пат и за кои не треба ние да
// трошиме дополнителни пари.
//
//Излез:
//Во првиот ред се печатат два броја: бројот на патишта кои се останати да се реновираат, и цената на реновирање
// на тие патишта.
//Потоа се печатат сите парови на градови помеѓу кои треба да бидат реновирани патиштата, секој во посебен ред.
//
//Пример:
//
//Влез:
//5
//6
//3
//Skopje
//Kumanovo
//SvetiNikole
//Veles
//Shtip
//Skopje Veles 5
//Skopje Kumanovo 3
//Skopje SvetiNikole 6
//Kumanovo SvetiNikole 4
//Shtip Veles 4
//Shtip SvetiNikole 2
//Skopje SvetiNikole
//Shtip SvetiNikole
//Kumanovo SvetiNikole
//
//Излез:
//1 4
//Veles Shtip

package Kolokviumski;

import java.util.Scanner;

public class DrzavaRenovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        String[] cities = new String[M];
        String[][] paths = new String[N][3];
        String[][] renovatedPaths = new String[P][2];

        for (int i = 0; i < M; i++) {
            cities[i] = scanner.next();
        }

        for (int i = 0; i < N; i++) {
            paths[i][0] = scanner.next();
            paths[i][1] = scanner.next();
            paths[i][2] = scanner.next();
        }

        for (int i = 0; i < P; i++) {
            renovatedPaths[i][0] = scanner.next();
            renovatedPaths[i][1] = scanner.next();
        }

        int price = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean renovated = false;
            for (int j = 0; j < P; j++) {
                if (paths[i][0].equals(renovatedPaths[j][0]) && paths[i][1].equals(renovatedPaths[j][1])) {
                    renovated = true;
                    break;
                }
            }
            if (!renovated) {
                price += Integer.parseInt(paths[i][2]);
                count++;
                System.out.println(paths[i][0] + " " + paths[i][1]);
            }
        }
        System.out.println(count + " " + price);

    }
}
