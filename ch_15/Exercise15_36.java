package ch_15;

/**
 * **15.36 (Simulation: self-avoiding random walk) Write a simulation program to show
 * that the chance of getting dead-end paths increases as the grid size increases.
 * Your program simulates lattices with size from 10 to 80. For each lattice size,
 * simulate a self-avoiding random walk 10,000 times and display the probability
 * of the dead-end paths, as shown in the following sample output:
 */
public class Exercise15_36 {
    public static void main(String[] args) {
        new Exercise15_36();
    }

    private int N = 16; // The number of lattice cells in one row
    private Point[][] lattice; // Represent the lattice with a 2D array

    private boolean getAPath() {
        resetLattice(lattice);
        // Reset i, j to the center of the lattice
        // (i, j) is the current path point. Initially it is at the center
        int i1 = (N + 1) / 2;
        int j1 = (N + 1) / 2;

        while (i1 > 0 && i1 < N && j1 > 0 && j1 < N) {
            if (lattice[i1 - 1][j1] != null && lattice[i1 + 1][j1] != null &&
                    lattice[i1][j1 - 1] != null && lattice[i1][j1 + 1] != null) {
                return false; // Dead end
            }

            double r = Math.random();
            if (r < .25 && lattice[i1][j1 + 1] == null) {
                lattice[i1][j1] = new Point(i1, j1 + 1); // Right
                j1++;
            } else if (r < .50 && lattice[i1 + 1][j1] == null) {
                lattice[i1][j1] = new Point(i1 + 1, j1); // Down
                i1++;
            } else if (r < .75 && lattice[i1][j1 - 1] == null) {
                lattice[i1][j1] = new Point(i1, j1 - 1); // Left
                j1--;
            } else if (lattice[i1 - 1][j1] == null) {
                lattice[i1][j1] = new Point(i1 - 1, j1); // Up
                i1--;
            }
        }

        return true;
    }

    private static void resetLattice(Point[][] lattice) {
        for (int i = 0; i < lattice.length; i++) {
            for (int j = 0; j < lattice.length; j++) {
                lattice[i][j] = null;
            }
        }
    }

    public Exercise15_36() {
        for (N = 10; N <= 80; N += 5) {
            lattice = new Point[N + 1][N + 1];

            // Run simulation 10000 times
            int count = 0;
            for (int i = 0; i < 10000; i++) {
                if (!getAPath()) {
                    count++;
                }
            }
            System.out.printf("For lattice of size %2d, the probability of dead-end paths is %.2f%%\n", N, (count / 10000.0) * 100);
        }
    }


    static class Point {

        int x;
        int y;

        Point(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
