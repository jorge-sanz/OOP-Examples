package exercise5;

/** 
 * Rational is the class which represents rational numbers
 * and implements some operations for them.
 * 
 * @author Jorge Sanz
 */
public class Rational {
	private static Rational zero = new Rational(0, 1);

    private int numerator;
    private int denominator;

    /**
     * Creates and initializes a new Rational object reducing fraction
     * by using greatest common divisor method. Also fixes
     * error of negative number at denominator position.
     * 
     * @param numerator
     * @param denominator
     */
    public Rational(int numerator, int denominator) {
        int g = greatestCommonDivisor(numerator, denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;

        // only needed for negative numbers
        if (this.denominator < 0) { 
        	this.denominator = - this.denominator; 
        	this.numerator = - this.numerator; 
    	}
    }

    /**
     * Returns the numerator of the rational number.
     * 
     * @return numerator	numerator of the rational number
     */
    public int getNumerator() {
    	return numerator; 
	}
    
    /**
     * Sets the numerator of the rational number.
     * 
     * @param numerator	numerator of the rational number to set
     */
    public void setNumerator(int numerator) {
    	this.numerator = numerator;
    }
    
    /**
     * Returns the denominator of the rational number.
     * 
     * @return denominator	denominator of the rational number
     */
    public int getDenominator() {
    	return denominator; 
	}

    /**
     * Returns double precision representation of the rational number.
     * 
     * @return double precision representation of the rational number
     */
    public double toDouble() {
        return (double) getNumerator() / getDenominator();
    }

    /**
     * Returns string representation of the rational number.
     * 
     * @return	string representation of the rational number
     */
    public String toString() { 
        if (getDenominator() == 1) {
        	return getNumerator() + "";
        } else {          
        	return getNumerator() + "/" + getDenominator();
        }
    }

    /**
     * Returns { -1, 0, +1 } if a < b, a = b, or a > b
     * 
     * @param b	rational number to compare
     * @return { -1, 0, +1 } if a < b, a = b, or a > b
     */
     public int compareTo(Rational b) {
        int lhs = getNumerator() * b.getDenominator();
        int rhs = getDenominator() * b.getNumerator();
        if (lhs < rhs) return -1;
        if (lhs > rhs) return +1;
        return 0;
    }
    
    /**
     * Returns greatest common divisor of two integer numbers.
     * 
     * @param m	integer number
     * @param n	integer number
     * @return greatest common divisor
     */
    private static int greatestCommonDivisor(int m, int n) {
        if (m < 0) m = - m;
        if (n < 0) n = - n;
        if (0 == n) return m;
        else return greatestCommonDivisor(n, m % n);
    }

    /**
     * Calculates least common multiple.
     * 
     * @param m	integer number
     * @param n	integer number
     * @return least common multiple
     */
    private static int lcm(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n / greatestCommonDivisor(m, n));
    }

    /**
     * Returns (this) * b, staving off overflow as much as possible by 
     * cross-cancellation.
     * 
     * @param b	rational to multiply
     * @return (this) * b
     */
    public Rational times(Rational b) {
        Rational c = new Rational(getNumerator(), b.getDenominator());
        Rational d = new Rational(b.getNumerator(), getDenominator());
        return new Rational(c.getNumerator() * d.getNumerator(),
        		c.getDenominator() * d.getDenominator());
    }

    /**
     * Returns (this) + b
     * 
     * @param b	rational number to plus
     * @return (this) + b
     */
    public Rational plus(Rational b) {
        // special cases
        if (compareTo(zero) == 0) return b;
        if (b.compareTo(zero) == 0) return this;

        // Find gcd of numerators and denominators
        int f = greatestCommonDivisor(getNumerator(), b.getNumerator());
        int g = greatestCommonDivisor(getDenominator(), b.getDenominator());

        // add cross-product terms for numerator
        Rational s = new Rational((getNumerator() / f) 
        		* (b.getDenominator() / g) + (b.getNumerator() / f) 
        		* (getDenominator() / g), lcm(getDenominator(),
        		b.getDenominator()));

        // multiply back in
        s.setNumerator(getNumerator() * f);
        return s;
    }

    /**
     * Returns - (this)
     */
    public Rational negate() {
        return new Rational(- numerator, denominator);
    }

    /**
     * Returns (this) - b
     * 
     * @param b	rational number to minus
     */
    public Rational minus(Rational b) {
        return plus(b.negate());
    }

    /**
     * Returns reciprocal rational number.
     * 
     * @return	reciprocal rational number
     */
    public Rational reciprocal() {
    	return new Rational(denominator, numerator); 
	}

    /**
     * Divides two rational numbers.
     * 
     * @param b	rational number to divide
     * @return (this) / b
     */
    public Rational divides(Rational b) {
        return times(b.reciprocal());
    }
}
