import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Rational class
 *
 * Summary of the group work:
 * Yuyan Lei is responsible for tests for method norminalize(), toString(), and equals().
 * Jie Zhang is responsible for tests for method multiply and divide. 
 * Xiao Xu is responsible for tests for method SetNumerator(), SetDenominator().
 * Qian Lang is responsible for tests for method add() and substract().
 */
public class RationalTest {
    private Rational r1, r2, r3, r4, r5, r6, r7, r8;


    @Test
    public void testSetNumerator() {    
        r1 = new Rational(4, 8);
        r2 = new Rational(1, 2);
        r3 = new Rational(-3, 5);
        r4 = new Rational(-4, -5);
        r5 = new Rational(-2);

        r1.setNumerator(5);
        r2.setNumerator(-1);
        r3.setNumerator(0);
        r4.setNumerator(10);
        r5.setNumerator(1);

        assertEquals(5,r1.getNumerator());
        assertEquals(-1,r2.getNumerator());
        assertEquals(0,r3.getNumerator());
        r4.normalize();
        assertEquals(-10,r4.getNumerator());
        assertEquals(1, r5.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        r1 = new Rational(4, 8);
        r2 = new Rational(1, 2);
        r3 = new Rational(-3, 5);
        r4 = new Rational(-4, -5);
        r5 = new Rational(-2);

        r1.setDenominator(5);
        r2.setDenominator(-1);
        r3.setDenominator(0);
        r4.setDenominator(1);
        r5.setDenominator(3);

        assertEquals(5,r1.getDenominator());
        r2.normalize();
        assertEquals(1,r2.getDenominator());
        assertEquals(5, r3.getDenominator());
        assertEquals(1,r4.getDenominator());
        assertEquals(3,r5.getDenominator());
    }

    @Test
    public void testNormalize() {
        r1 = new Rational(4, 8);
        r2 = new Rational(1, 2);
        r3 = new Rational(-3, 5);
        r4 = new Rational(-4, -5);
        r5 = new Rational(-2);

        r1.normalize();
        r2.normalize();
        r3.normalize();
        r4.normalize();
        r5.normalize();

        assertEquals("4/8", r1.toString());
        assertEquals("1/2", r2.toString());
        assertEquals("-3/5", r3.toString());
        assertEquals("4/5", r4.toString());
        assertEquals("-2/1", r5.toString());
    }

    @Test
    public void testTestToString() {
        r1 = new Rational(1, 2);
        r2 = new Rational(1, -2);
        r3 = new Rational(-3, 4);
        r4 = new Rational(-4, -5);
        r5 = new Rational(-2);
        r6 = new Rational();

        assertEquals("1/2", r1.toString());
        assertEquals("-1/2", r2.toString());
        assertEquals("-3/4", r3.toString());
        assertEquals("4/5", r4.toString());
        assertEquals("-2/1", r5.toString());
        assertEquals("0/1",r6.toString());
    }

    @Test
    public void testTestEquals() {
        r1 = new Rational(1, 2);
        r2 = new Rational(-1, -2);
        r3 = new Rational(4, 8);
        r4 = new Rational(-4, -5);
        r5 = new Rational(0, 1);
        r6 = new Rational(0, 2);

        assertTrue(r1.equals(r3));
        assertTrue(r1.equals(r2));
        assertTrue(r2.equals(r3));
        assertTrue(r5.equals(r6));
        assertFalse(r1.equals(r4));
        assertFalse(r2.equals(r5));
        assertFalse(r3.equals(r6));
    }

    @Test
    public void testAdd() {
        r1 = new Rational(1, 1);
        r2 = new Rational(2,1);
        assertEquals("3/1", Rational.add(r1, r2).toString());

        r3 = new Rational(1, 8);
        r4 = new Rational(2,8);
        assertEquals("24/64", Rational.add(r3, r4).toString());

        r5 = new Rational(-3, 5);
        r6 = new Rational(2,5);
        assertEquals("-5/25", Rational.add(r5, r6).toString());

        r7 = new Rational(1, 2);
        r8 = new Rational(-1,2);
        assertEquals("0/4", Rational.add(r7, r8).toString());
    }

    @Test
    public void testSubtract() {
        r1 = new Rational(1, 3);
        r2 = new Rational(1,3);
        assertEquals("0/9", Rational.subtract(r1, r2).toString());

        r3 = new Rational(4, 5);
        r4 = new Rational(6,5);
        assertEquals("-10/25", Rational.subtract(r3, r4).toString());

        r5 = new Rational(2, 7);
        r6 = new Rational(1,7);
        assertEquals("7/49", Rational.subtract(r5, r6).toString());

        r7 = new Rational(-3, 2);
        r8 = new Rational(-5,2);
        assertEquals("4/4", Rational.subtract(r7, r8).toString());
    }

    @Test
    public void testMultiply() {
      //edge case:
        //                multiply( 0/3, 1/2) -> 0;
        //                multiply( 1/2,1/1) -> 1/2;
        //                multiply(-1/8,-2/5) -> 2/40;
        //                multiply(-1/2,2/5) -> -2/10;

        r1 = new Rational(0, 3);
        r2 = new Rational(1, 2);
        r3 = new Rational(1, 2);
        r4 = new Rational(1, 1);
        r5 = new Rational(-1, 8);
        r6 = new Rational(-2, 5);
        r7 = new Rational(-1,2);
        r8 = new Rational(2,5);
        //assertEquals(0, Rational.multiply(r1, r2));
        assertTrue(Rational.multiply(r1, r2).equals(new Rational(0)));
        assertTrue(Rational.multiply(r3, r4).equals(new Rational(1,2)));
        assertTrue(Rational.multiply(r5, r6).equals(new Rational(2,40)));
        assertTrue(Rational.multiply(r7, r8).equals(new Rational(-2,10)));
    }

    @Test
    //edge cases:
    //               divide(0/1,1/2)   -> 0
    //               divide(1/2, 3/5)  -> 5/6;
    //               divide(-1/5,-5/1) -> 1/25;
    //               divide(1/1, 5/1)  -> 1/5
    public void testDivide() {
        r1 = new Rational(0, 1);
        r2 = new Rational(1, 2);
        r3 = new Rational(1, 2);
        r4 = new Rational(3, 5);
        r5 = new Rational(-1, 5);
        r6 = new Rational(-5, 1);
        r7 = new Rational(1,1);
        r8 = new Rational(5,1);
        assertTrue(Rational.divide(r1, r2).equals(new Rational(0)));
        assertTrue(Rational.divide(r3, r4).equals(new Rational(5,6)));
        assertTrue(Rational.divide(r5, r6).equals(new Rational(1,25)));
        assertTrue(Rational.divide(r7, r8).equals(new Rational(1,5)));
    }
}
