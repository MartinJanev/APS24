package Zadaci.NiziListi;

//Input: code = [5,7,1,4], k = 3
//Output: [12,10,16,13]
//Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is
// [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.


public class DefuseBomb1652 {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = code[i];
            extended[i + n] = code[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += extended[i + j];
                }
            } else if (k < 0) {
                for (int j = -1; j >= k; j--) {
                    sum += extended[i + n + j];
                }
            }
            result[i] = sum;
        }
        return result;
    }
}
