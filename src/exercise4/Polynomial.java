package exercise4;

/**
 * Polynomial is a class which implements a polynomial of degree 2 
 * (ax^2 + bx + c) with operations like addition and subtraction. Also it's 
 * able to calculate real roots if they exist.
 *
 * @author Jorge Sanz
 */

public class Polynomial {
	private double a, b, c;

    /**
     * Initializes a polynomial by specified values of a, b and c.
     *
     * @param a first coefficient
     * @param b second coefficient
     * @param c third coefficient
     */
    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Initializes a polynomial with zero values.
     */
    public Polynomial() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }

    /**
     * Gets a value.
     *
     * @return a	first coefficient of the polynomial
     */
    public double getA() {
        return a;
    }

    /**
     * Sets a value.
     *
     * @param a	first coefficient of the polynomial
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Gets b value.
     *
     * @return b	second coefficient of the polynomial
     */
    public double getB() {
        return b;
    }

    /**
     * Sets a value.
     *
     * @param b second coefficient of the polynomial
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Gets c value.
     *
     * @return c	third coefficient of the polynomial
     */
    public double getC() {
        return c;
    }

    /**
     * Set c value.
     *
     * @param c third coefficient of the polynomial
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Returns a Polynomial whose value is (this + addedPolynomial).
     *
     * @param addedPolynomial polynomial to be added
     * @return (this + addedPolynomial)
     */
    public Polynomial add(Polynomial addedPolynomial) {
        double a, b, c;

        a = getA() + addedPolynomial.getA();
        b = getB() + addedPolynomial.getB();
        c = getC() + addedPolynomial.getC();

        return new Polynomial(a, b, c);
    }

    /**
     * Returns a Polynomial whose value is (- this)
     *
     * @return (- this)
     */
    public Polynomial negate(){
        double a, b, c;

        a = - getA();
        b = - getB();
        c = - getC();

        return new Polynomial(a, b, c);
    }

    /**
     * Returns a Polynomial whose value is (this - subtractedPolynomial)
     *
     * @param subtractedPolynomial polynomial to be subtracted
     * @return (this - subtractedPolynomial)
     */
    public Polynomial subtract(Polynomial subtractedPolynomial) {
        double a, b, c;

        a = getA() - subtractedPolynomial.getA();
        b = getB() - subtractedPolynomial.getB();
        c = getC() - subtractedPolynomial.getC();

        return new Polynomial(a, b, c);
    }

    /**
     * Returns a string representation of the polynomial roots.
     *
     * @return string representation of the roots
     */
    public String getRoots(){
        double firstRoot;
        double secondRoot;

        if (Math.pow(getB(), 2) - 4 * getA() * getC() >= 0) {
            firstRoot = (- getB() + Math.sqrt(Math.pow(getB(), 2) 
            		- 4 * getA() * getC())) / (2 * getA());
            secondRoot = (- getB() - Math.sqrt(Math.pow(getB(), 2) 
            		- 4 * getA() * getC())) / (2 * getA());
            if (Math.pow(getB(), 2) - 4 * getA() * getC() == 0) {
                return "The only real root of the polynomial is " + firstRoot;
            } else {
                return "The first root is " + firstRoot + " and the second one "
                		+ "is " + secondRoot;
            }
        } else {
            return "This polynomial hasn't real roots.";
        }
    }
    
}
