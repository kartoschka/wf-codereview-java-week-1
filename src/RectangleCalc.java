public class RectangleCalc {
    private static String HELPMSG = String.join(System.getProperty("line.separator"),
        "Welcome to rectangle-calculator. Usage notes: ",
            "  rect-calc <side_length>     ...calculate area and perimeter for a square",
            "  rect-calc <side_a> <side_b> ...calculate area and perimeter for a rectangle",
            "  rect-calc examples          ...run example calculations"
    );

    private static double[][] RECT_EXAMPLES = {
            {20, 30},
            {40, 50},
            {10, 70},
            {90, 100},
            {10.5, 20.5},
            {2.5, 4.5}
    };

    private static double[] SQUARE_EXAMPLES = {
            10, 15, 33, 64, 1.5, 10.5
    };

    public static void main(String[] args) {
        switch(args.length) {
            case 0:
                System.out.println(HELPMSG);
                break;
            case 1:
                if(args[0].equals("examples")) {
                    runExamples();
                } else {
                    try {
                        double side = Double.parseDouble(args[0]);
                        runAndPrint(side);
                    } catch(NumberFormatException e) {
                        System.err.println("unsupported arg: " + args[0]);
                    }
                }
                break;
            case 2:
                try {
                    double sideA = Double.parseDouble(args[0]);
                    double sideB = Double.parseDouble(args[1]);
                    runAndPrint(sideA, sideB);
                } catch(NumberFormatException e) {
                    System.err.println("unsupported arg: " + args[0]);
                }
                break;
            default:
                System.err.println("Too many arguments!");
        }
    }

    private static void runAndPrint(double side) {
        double a = area(side);
        double p = perimeter(side);
        System.out.println("Input: " + side);
        System.out.println("Output: " + formatResults(a, p));
    }

    private static void runAndPrint(double sideA, double sideB) {
        double a = area(sideA, sideB);
        double p = perimeter(sideA, sideB);
        System.out.println("Input: " + sideA + ", " + sideB);
        System.out.println("Output: " + formatResults(a, p));
    }

    private static String formatResults(double area, double perimeter) {
        return String.format("area A = %.2f; perimeter P = %.2f", area, perimeter);
    }

    private static double area(double side) {
        return side * side;
    }
    private static double area(double sideA, double sideB) {
        return sideA * sideB;
    }

    private static double perimeter(double side) {
        return 4 * side;
    }

    private static double perimeter(double sideA, double sideB) {
        return 2 * sideA + 2 * sideB;
    }

    private static void runExamples() {
        System.out.println("Examples for Rectangles:");
        for(double[] ex: RECT_EXAMPLES) {
            double sideA_arg = ex[0];
            double sideB_arg = ex[1];
            runAndPrint(sideA_arg, sideB_arg);
        }
        System.out.println();
        System.out.println("Examples for Squares:");
        for(double side: SQUARE_EXAMPLES) {
            runAndPrint(side);
        }
    }
}
