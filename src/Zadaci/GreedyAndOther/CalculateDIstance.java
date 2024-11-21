package Zadaci.GreedyAndOther;

public class CalculateDIstance {
    class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    class BruteForse {
        int INFINITY = Integer.MAX_VALUE;

        double min(double a, double b) {
            if (a < b) return a;
            else return b;
        }

        double distance(Point a, Point b) {
            return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
        }

        double smallestD(Point[] points, int n) {
            int i, j;
            double best = INFINITY;
            for (i = 0; i < n - 1; i++) {
                for (j = i + 1; j < n; j++) {
                    best = Math.min(best, distance(points[i], points[j]));
                }
            }
            return best;
        }
    }


}
