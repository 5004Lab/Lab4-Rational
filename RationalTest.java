import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Rational class
 *
 * Summary of the group work:
 * Yuyan Lei is responsible for tests for method norminalize(), toString(), and equals().
 * Jie Zhang is responsible for tests for method ... // Please fill your contributions here
 * Xiao Xu is responsible for tests for method SetNumerator(), SetDenominator().
 * Qian Lang is responsible for tests for method ... // Please fill your contributions here
 */
public class RationalTest {

    private Rational r1, r2, r3, r4, r5, r6;

    @Test
    public void testSetNumerator() {
        
        r1 = new Rational(4, 8);
        r2 = new Rational(1, 2);
        r3 = new Rational(-3, 5);
        r4 = new Rational(-4, -5);
        r5 = new Rational(-2);

        r1.setNumerator(5);
        assertEquals(5,r1.getNumerator());
        r2.setNumerator(-1);
        assertEquals(-1,r2.getNumerator());
        r3.setNumerator(0);
        assertEquals(0,r3.getNumerator());
        r4.setNumerator(10);
        r4.normalize();
        assertEquals(-10,r4.getNumerator());
        r5.setNumerator(1);
        assertEquals(1, r5.getNumerator());
    }

    @Test
    public void testSetDenominator() {
    }

    @Test
    public void testGetNumerator() {
    }

    @Test
    public void testGetDenominator() {
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
    }

    @Test
    public void testSubtract() {
    }

    @Test
    public void testMultiply() {
    }

    @Test
    public void testDivide() {
    }
}
