/**
  * This class represents a Rational. The Rational has a numerator
  * and a denominator.
  */

public class Rational {
    private int numerator;
    private int denominator;

    /**
     * Constructs a Rational object and initializes it
     * to the given numerator and denominator.
     * @param numerator the numerator for this rational.
     * @param denominator the denominator for this rational, 
     * which should not be zero.
     */
    public Rational(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    /**
     * Constructs a Rational object and initializes 
     * its numerator as the given wholeNumber. 
     * Then sets its denominator as 1.
     * @param wholeNumber the wholenumber set as the numerator.
     */
    public Rational(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * Construct a Rational object and initializes 
     * its numerator as 0 and its denominator as 1.
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }
    /**
     * Construct mutators for the numerator and denominator
     * @param numerator the numerator for this rational.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    /**
     * Construct a conner case when denominator is zero, system will exits and give a message
     * @param denominator the denominator for this rational.
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("The value of the denominator passed in is zero.");
            //System.exit(0); if the programming exits here, I cannot continue testing the rest of the code. -Xiao
        }
        else {
            this.denominator = denominator;
        }
    }
    /**
     * Construct accessors for denominator and numerator
     */
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    /**
    * Normalize the sign of the rational number so that 
    * the denominator is positive and the numerator
    * is either positive or negative. 
    * edge cases: 1/(-1) , -1/(-1), -4/8, 4/8
    */
    public void normalize() {
        if (denominator < 0) {
            numerator = numerator * (-1);
            denominator = denominator * (-1);
        }
    }
    
    /**
    * Return a formatted string of this Rational number.
    * @return the formatted string as above.
    * edge cases: 1/(-1) , -1/(-1), -4/8, 4/8
    */
    public String toString() {
        if (denominator < 0) {
            normalize();
            return (numerator + "/" + denominator);
        }
        else {
            return (numerator + "/" + denominator);
        }
    }
    
    /**
    * Check if the rational numbers are equal.
    * @Return true if they are equal, false otherwise.
    * 1/2, 4/8
    * 2/3, 1/3
    * -1/-2, 1/2
    * 0/1, 0/2
    */
    public boolean equals(Rational r2){
      /** old version
      if (r2.denominator != 0){
        int a = numerator * r2.getDenominator();
        int b = r2.getNumerator() * denominator;
        return (a % b == 0 && a / b > 0);
      }
      else{
        system.out.println("Invalid denominator");
        return;
      }
      */
      int a = numerator * r2.getDenominator();
      int b = r2.getNumerator() * denominator;
      return (a == b);
    }


    // Part One:
    /**
     * Add two rational numbers and return their sum.
     * @param r1 the first rational number
     * @param r2 the second rational number
     * @return the sum of the two rational numbers
    edge case:
    multiply( 0/3, 1/2) -> 0;
    multiply( 1/2,1/1) -> 1/2;
    multiply(-1/8,-2/5) -> 2/40;
    multiply(-1/2,2/5) -> -2/10;
     */
    public static Rational add(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator() + r2.getNumerator() * r1.getDenominator();
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }
    
    /**
     * subtract two rational numbers and return their subtraction.
     * @param r1 the first rational number
     * @param r2 the second rational number
     * @return the subtraction of the two rational numbers
     edge case : subtract(1/3, 1/3) --> 0
                 subtract(4/5, 6/5) --> -2/5
                subtract(2/7, 1/7) --> 1/7
                subtract(-3/2, -5/2) --> 2/2
     */
    public static Rational subtract(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator() - r2.getNumerator() * r1.getDenominator();
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }
    
    /**
     * multiply two rational numbers and return their multiplication.
     * @return the multiplication of the two rational numbers

    //edge cases:
    divide(0/1,1/2)   -> 0(whole number)
    divide(1/2, 3/5)  -> 5/6;
    divide(-1/5,-5/1) -> 1/25;
    divide(1/1, 5/1)  -> 1/5
     */
    public static Rational multiply(Rational r1, Rational r2) {

        int numerator = r1.getNumerator() * r2.getNumerator();
        if(r1.getNumerator() == 0 && r2.getNumerator()== 0){
            return new Rational(0,0);
        }
        int denominator = r1.getDenominator() * r2.getDenominator();
        return new Rational(numerator, denominator);
    }

    /**
     * divide two rational numbers and return their division.
     * @param r1 the first rational number
     * @param r2 the second rational number
     * @return the division of the two rational numbers
     edge cases: 
               divide(0/0, print out the message)
               divide(1/2, 3/5)  -> 5/6;
               divide(-1/5,-5/1) -> 1/25;
               divide(1/1, 5/1)  -> 5/1;
     */
    public static Rational divide(Rational r1, Rational r2) {
        int numerator = r1.getNumerator() * r2.getDenominator();
        int denominator = r1.getDenominator() * r2.getNumerator();
        return new Rational(numerator, denominator);
    }

    // Part Two
    /**
     * Add other rational numbers and return their sum.
     * @param other rational number
     * @return the sum of the two rational numbers
     */
    public Rational add(Rational other) {
        return add(this, other);
    }
    /**
     * subtract other rational numbers and return their subtraction.
     * @param other rational number
     * @return the subtraction of the two rational numbers
     */

    public Rational subtract(Rational other) {
        return subtract(this, other);
    }

    /**
     * multiply other rational numbers and return their multiplication.
     * @param other rational number
     * @return the multiplication of the two rational numbers
     */
    public Rational multiply(Rational other) {
        return multiply(this, other);
    }

    /**
     * divide other rational numbers and return their division.
     * @param other rational number
     * @return the divis of the two rational numbers
     */
    public Rational divide(Rational other) {
        return divide(this, other);
    }

}
