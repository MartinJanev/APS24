package Zadaci.GreedyAndOther;

public class Chess {
    int daliSeNapagjaat(int i1, int j1, int i2, int j2) {
        if (i1 == i2)
            return 1;
        if (j1 == j2)
            return 1;
        if (Math.abs(i1 - i2) == Math.abs(j1 - j2))
            return 1;
        else
            return 0;
    }

    int brojNacini() {
        int res = 0;

        for (int i1 = 0; i1 < 8; i1++) {
            for (int i2 = 0; i2 < 8; i2++) {
                for (int j1 = 0; j1 < 8; j1++) {
                    for (int j2 = 0; j2 < 8; j2++) {
                        if (daliSeNapagjaat(i1, j1, i2, j2) == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    int brojNaciniGreedy(){
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < 8) {
            while (j < 8) {
                if (daliSeNapagjaat(i, j, i + 1, j + 1) == 0) {
                    res++;
                }
                j++;
            }
            i++;
        }
        return res;
    }
}
