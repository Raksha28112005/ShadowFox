package shadowfoxcalculator;
import java.util.Scanner;
public class EnhancedCalculatorSimple {
	private static double INR_PER_USD = 83.50;
    private static double INR_PER_EUR = 90.00;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        println("Welcome to Enhanced Console-based Calculator!");

        while (!exit) {
            printMainMenu();
            int choice = readInt(sc, "Choose an option (1-4): ");
            switch (choice) {
                case 1 -> arithmeticMenu(sc);
                case 2 -> scientificMenu(sc);
                case 3 -> conversionMenu(sc);
                case 4 -> {
                    println("Goodbye! Thanks for using the calculator.");
                    exit = true;
                }
                default -> println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    // ---------- Menus ----------
    static void printMainMenu() {
        println("\n--- MAIN MENU ---");
        println("1) Arithmetic Operations");
        println("2) Scientific Calculations");
        println("3) Unit Conversions");
        println("4) Exit");
    }

    static void arithmeticMenu(Scanner sc) {
        while (true) {
            println("\n-- ARITHMETIC --");
            println("1) Add");
            println("2) Subtract");
            println("3) Multiply");
            println("4) Divide");
            println("5) Back to main menu");
            int c = readInt(sc, "Choose (1-5): ");
            if (c == 5) return;
            double a = readDouble(sc, "Enter first number: ");
            double b = readDouble(sc, "Enter second number: ");
            switch (c) {
                case 1 -> println("Result: " + (a + b));
                case 2 -> println("Result: " + (a - b));
                case 3 -> println("Result: " + (a * b));
                case 4 -> {
                    if (b == 0) println("Error: Division by zero is not allowed.");
                    else println("Result: " + (a / b));
                }
                default -> println("Invalid choice.");
            }
        }
    }

    static void scientificMenu(Scanner sc) {
        while (true) {
            println("\n-- SCIENTIFIC --");
            println("1) Square root");
            println("2) Power (base^exponent)");
            println("3) Natural log (ln)");
            println("4) Back to main menu");
            int c = readInt(sc, "Choose (1-4): ");
            if (c == 4) return;
            switch (c) {
                case 1 -> {
                    double x = readDouble(sc, "Enter number (≥ 0): ");
                    if (x < 0) println("Error: square root of negative number is not supported in this demo.");
                    else println("sqrt(" + x + ") = " + Math.sqrt(x));
                }
                case 2 -> {
                    double base = readDouble(sc, "Enter base: ");
                    double exp = readDouble(sc, "Enter exponent: ");
                    println(base + " ^ " + exp + " = " + Math.pow(base, exp));
                }
                case 3 -> {
                    double x = readDouble(sc, "Enter number (> 0): ");
                    if (x <= 0) println("Error: ln(x) is defined for x > 0 only.");
                    else println("ln(" + x + ") = " + Math.log(x));
                }
                default -> println("Invalid choice.");
            }
        }
    }

    static void conversionMenu(Scanner sc) {
        while (true) {
            println("\n-- UNIT CONVERSIONS --");
            println("1) Temperature");
            println("2) Currency (sample static rates)");
            println("3) Back to main menu");
            int c = readInt(sc, "Choose (1-3): ");
            if (c == 3) return;
            switch (c) {
                case 1 -> temperatureMenu(sc);
                case 2 -> currencyMenu(sc);
                default -> println("Invalid choice.");
            }
        }
    }

    static void temperatureMenu(Scanner sc) {
        println("\nTemperature conversions:");
        println("1) Celsius -> Fahrenheit");
        println("2) Fahrenheit -> Celsius");
        int ch = readInt(sc, "Choose (1-2): ");
        if (ch == 1) {
            double c = readDouble(sc, "Enter Celsius: ");
            double f = c * 9.0 / 5.0 + 32.0;
            println(String.format("%.2f °C = %.2f °F", c, f));
        } else if (ch == 2) {
            double f = readDouble(sc, "Enter Fahrenheit: ");
            double c = (f - 32.0) * 5.0 / 9.0;
            println(String.format("%.2f °F = %.2f °C", f, c));
        } else {
            println("Invalid choice.");
        }
    }

    static void currencyMenu(Scanner sc) {
        println("\nCurrency conversions (demo — static rates):");
        println("Rates: 1 USD = " + INR_PER_USD + " INR, 1 EUR = " + INR_PER_EUR + " INR");
        println("1) INR -> USD");
        println("2) USD -> INR");
        println("3) INR -> EUR");
        println("4) EUR -> INR");
        int ch = readInt(sc, "Choose (1-4): ");
        switch (ch) {
            case 1 -> {
                double inr = readDouble(sc, "Enter amount in INR: ");
                println(String.format("%.2f INR = %.4f USD", inr, inr / INR_PER_USD));
            }
            case 2 -> {
                double usd = readDouble(sc, "Enter amount in USD: ");
                println(String.format("%.2f USD = %.2f INR", usd, usd * INR_PER_USD));
            }
            case 3 -> {
                double inr = readDouble(sc, "Enter amount in INR: ");
                println(String.format("%.2f INR = %.4f EUR", inr, inr / INR_PER_EUR));
            }
            case 4 -> {
                double eur = readDouble(sc, "Enter amount in EUR: ");
                println(String.format("%.2f EUR = %.2f INR", eur, eur * INR_PER_EUR));
            }
            default -> println("Invalid choice.");
        }
        println("Note: Currency rates are static in this demo. For live rates integrate a currency API.");
    }

    // ---------- Input helpers (reads strings and parses) ----------
    static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (Exception e) {
                println("Invalid number. Please enter a valid decimal or integer (e.g. 12.34).");
            }
        }
    }

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                println("Invalid integer. Try again.");
            }
        }
    }

    // ---------- small utility ----------
    static void println(String s) {
        System.out.println(s);
    }

}
