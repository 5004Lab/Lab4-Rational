public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Rational(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("The value of the denominator passed in is zero.");
            System.exit(0);
        }
        else {
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void normalize() {
        if (denominator < 0) {
            numerator = numerator * (-1);
            denominator = denominator * (-1);
        }
    }

    public String toString() {
        if (denominator < 0) {
            normalize();
            return (numerator + "/" + denominator);
        }
        else {
            return (numerator + "/" + denominator);
        }
    }

    public boolean equals(Rational r2){
        int a = numerator * r2.getDenominator();
        int b = r2.getNumerator() * denominator;
        return (a % b == 0 && a / b > 0);
    }


    // Part One:
    public static Rational add(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator() + r2.getNumerator() * r1.getDenominator();
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    public static Rational subtract(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator() - r2.getNumerator() * r1.getDenominator();
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    public static Rational multiply(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getNumerator();
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    public static Rational divide(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator();
        int denominator = r1.getDenominator() * r2.getNumerator();
        return new Rational(numerator, denominator);
    }

    // Part Two
    public Rational add(Rational other) {
        return add(this, other);
    }

    public Rational subtract(Rational other) {
        return subtract(this, other);
    }

    public Rational multiply(Rational other) {
        return multiply(this, other);
    }

    public Rational divide(Rational other) {
        return divide(this, other);
    }

}
