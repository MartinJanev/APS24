//На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно за соседниот
// град МинТаун. Цената на еден билет е 100 денари. Ако некој возрасен сака да патува со k деца, треба да плати еден
// билет за него и k-1 билети за децата (за едно дете не мора да плаќа билет). Исто така, возрасен може да се вози и
// сам, во тој случај ќе си плати еден билет за него. Дополнително знаеме дека децата не можат да се возат без да се
// придружени од некој возрасен.
//
// Во првиот ред од влезот е даден бројот N.
// Во вториот ред е даден бројот M.
// Потребно е да пресметате колкав е минималниот и максималниот број на денари што може да ги платат патниците за билети
// и да ги испечатите во две линии. Во автобусот ќе има најмалку еден возрасен.

package Kolokviumski;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Avtobus {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        br.close();
        // Vasiot kod tuka
        int maxcount = 0;
        int mincount = 0;


        if (M == 0) {
            mincount = N * 100;
            maxcount = N * 100;
        } else {
            if (M > N) {
                mincount = M * 100;
                maxcount = (M - 1) * 100 + (N * 100);
            } else {
                mincount = N * 100;
                maxcount = (M - 1) * 100 + (N * 100);
            }
        }


        System.out.println(mincount);
        System.out.println(maxcount);

    }

}

