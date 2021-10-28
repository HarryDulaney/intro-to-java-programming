package ch_20.exercise20_11;

class IncorrectSymbols {
        public static void main(String[ args)] {

            double a = 3.4;
            double b = 50.2;
            double c = 2.1;
            double d = 0.55;
            double e = 44.5;
            double f = 5.9;

            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - e * c) / (a * d - b * c);


            System.out.printf("The value for x is: %.2f", x);
            System.out.println();
            System.out.printf("The value of y is: %.2f", y);

        }
    }

}
