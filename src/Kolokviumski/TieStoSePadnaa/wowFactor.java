package Kolokviumski.TieStoSePadnaa;

//Да се потсетиме дека стринг А е подсеквенца на стринг В доколку А може да се добие од В со бришење на неколку знаци од било кое место во стрингот В, на пример:
//Некои подсеквенци на стрингот “wowwo” се стринговите "wowwo", "wowo", "oo", "wow", "", но следните стрингови не се: "owoo", "owwwo", "ooo", бидејќи НЕ моде да се додаваат знаци.
//
//Забележете дека има различни подсеквенци од знаци кои што го даваат истиот резултат, на пример од “wowwo” можеме да ги земеме знаците на индекси 0, 1 и 2 или пак 0, 1 и 3, и за двете подсеквенци ќе добиеме стринг “wow”.
//Всушност, WOW фактор на даден стринг е дефиниран како бројот на подсеквенци кои го даваат стрингот “wow” како резултат. Вие треба да го пресметате WOW факторот на стринг што ќе ви биде даден на влезот.
//
//Влез: Стрингот за кој што треба да го пресметате WOW факторот.
//Излез: Бараниот резултат.
//Пример:
//Влез:                Излез:
//wwoww             4
//
//Објаснување за првиот пример :
//-wow-
//w-ow-
//w-o-w
//-wo-w


//Input	Result
//wwoww
//wooooowooooowwwoowwo
//owoowwowwwoowwoowwoowoo
//wooowwoowwowwowowowwwowowowwowooww
//wwwwwwwwwwwoooooooooooo
//wowwwooowwwwwwwwwwwww
//woowooooowwwowowoooowwo
//owowwoowwoowowwooowwowwoo
//wwwwwwwwoooooooowwwwwwwww
//oooooooooooowwwwwwwwwwwooooooooo
//oooowwwwwwwwowwwoooooooowww

//4
//100
//172
//830
//0
//172
//180
//287
//576
//0
//312

import java.util.Scanner;

public class wowFactor {

    public static int numDistinct(String s) {
        int n = s.length();
        int[][] dp = new int[3][n + 1]; // 3 rows for "w", "wo", and "wow"

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);

            dp[0][i] = dp[0][i - 1];
            dp[1][i] = dp[1][i - 1];
            dp[2][i] = dp[2][i - 1];

            if (c == 'w') {
                dp[0][i]++; // Increment count of 'w's
                dp[2][i] += dp[1][i - 1]; // Update count of "wow" using "wo"
            } else if (c == 'o') {
                dp[1][i] += dp[0][i - 1]; // Update count of "wo" using "w"
            }
        }

        return dp[2][n]; // The count of "wow" at the end of the string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numDistinct(s));
    }
}
