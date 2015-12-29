package exercise4;

/**
 * Polynomial is a class which implements a polynomial of degree 2 (ax^2 + bx + c)
 * with operations like addition and subtraction. Also it's able to calculate real roots
 * if they exist.
 *
 * @author Jorge Sanz
 */

public class Polynomial {

	private double a, b, c;

    /**
     * Initializes a polynomial by specified values of a, b and c
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
     * Initializes a polynomial with zero values
     */
    public Polynomial() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }

    /**
     * Get a value
     *
     * @return a
     */
    public double getA() {
        return a;
    }

    /**
     * Set a value
     *
     * @param a first coefficient of the polynomial
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Get b value
     *
     * @return b
     */
    public double getB() {
        return b;
    }

    /**
     * Set a value
     *
     * @param b second coefficient of the polynomial
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Get c value
     *
     * @return c
     */
    public double getC() {
        return c;
    }

    /**
     * Set c value
     *
     * @param c third coefficient of the polynomial
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Returns a Polynomial whose value is (this + addedPolynomial)
     *
     * @param addedPolynomial polynomial to be added
     * @return (this + addedPolynomial)
     */
    public Polynomial add(Polynomial addedPolynomial) {
        double a, b, c;

        a = this.getA() + addedPolynomial.getA();
        b = this.getB() + addedPolynomial.getB();
        c = this.getC() + addedPolynomial.getC();

        return new Polynomial(a, b, c);
    }

    /**
     * Returns a Polynomial whose value is (- this)
     *
     * @return (- this)
     */
    public Polynomial negate(){
        double a, b, c;

        a = - this.getA();
        b = - this.getB();
        c = - this.getC();

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

        a = this.getA() - subtractedPolynomial.getA();
        b = this.getB() - subtractedPolynomial.getB();
        c = this.getC() - subtractedPolynomial.getC();

        return new Polynomial(a, b, c);
    }

    /**
     * Returns two different root values if they both exist. If the polynomial has
     * only one root, it returns two equal values. If the polynomial has not roots, it returns
     * two zero values.
     *
     * @return firstRoot
     * @return secondRoot
     */
    public String getRoots(){
        double firstRoot;
        double secondRoot;

        if (Math.pow(getB(), 2) - 4 * getA() * getC() >= 0) {
            firstRoot = (- getB() + Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC()))
                    / (2 * getA());
            secondRoot = (- getB() - Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC()))
                    / (2 * getA());
            if (Math.pow(getB(), 2) - 4 * getA() * getC() == 0) {
                return "La raíz real única del polinomio es " + firstRoot;
            } else {
                return "Las raíces reales del polinomio son " + firstRoot + " y " + secondRoot;
            }
        } else {
            return "Este polinomio no tiene raíces reales";
        }
    }
    
}
