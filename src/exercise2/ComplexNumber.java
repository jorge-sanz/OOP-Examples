package exercise2;

/**
 * ComplexNumber is a class which represents a complex number and implements basic
 * operations.
 *
 * @author Jorge Sanz
 */

public class ComplexNumber {
	
	private double real, imaginary;

    /**
     * Initializes a complex number by the specified values of real and imaginary
     *
     * @param real number which represents the real part of the complex number
     * @param imaginary number which represents the imaginary part of the complex number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Initializes a complex number by other specified complex number
     *
     * @param complexNumber existing complex number
     */
    public ComplexNumber(ComplexNumber complexNumber) {
        this.real = complexNumber.getReal();
        this.imaginary = complexNumber.getImaginary();
    }

    /**
     * Initializes a complex number without defining values
     */
    public ComplexNumber() {
        new ComplexNumber();
    }

    /**
     * Gets the value of real
     */
    public double getReal() {
        return real;
    }

    /**
     * Sets the value of real
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Gets the value of imaginary
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Sets the value of imaginary
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * Prints a representation of the complex number in natural language
     */
    @Override
    public String toString() {
        return getReal() + " + " + getImaginary() + "j";
    }

    /**
     * Returns a ComplexNumber whose value is (this + addedComplexNumber)
     *
     * @param addedComplexNumber complex number to be added
     * @return this + addedComplexNumber
     */
    public ComplexNumber add(ComplexNumber addedComplexNumber) {
        double real, imaginary;

        real = this.getReal() + addedComplexNumber.getReal();
        imaginary = this.getImaginary() + addedComplexNumber.getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    /**
     * Returns a ComplexNumber whose value is (-this)
     *
     * @return negatedComplexNumber
     */
    public ComplexNumber negate(){
        double real, imaginary;

        real = - this.getReal();
        imaginary = - this.getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    /**
     * Returns a ComplexNumber whose value is (this - subtractedComplexNumber)
     *
     * @param subtractedComplexNumber complex number to be subtracted
     * @return this - subtractedComplexNumber
     */
    public ComplexNumber subtract(ComplexNumber subtractedComplexNumber) {
        return this.add(subtractedComplexNumber.negate());
    }

    /**
     * Returns a ComplexNumber whose value is (this * multipliedComplexNumber)
     *
     * @param multipliedComplexNumber complex number to be multiplied
     * @return this * multipliedComplexNumber
     */
    public ComplexNumber multiply(ComplexNumber multipliedComplexNumber) {
        double real, imaginary;

        real = this.getReal() * multipliedComplexNumber.getReal()
                - this.getImaginary() * multipliedComplexNumber.getImaginary();
        imaginary = this.getReal() * multipliedComplexNumber.getImaginary()
                + this.getImaginary() * multipliedComplexNumber.getReal();

        return new ComplexNumber(real, imaginary);
    }

    /**
     * Returns a ComplexNumber whose value is the reciprocal of this
     *
     * @return reciprocalComplexNumber reciprocal complex number
     */
    public ComplexNumber reciprocal(){
        double scale;

        scale = this.getReal() * this.getReal() + this.getImaginary() * this.getImaginary();

        return new ComplexNumber(this.getReal() / scale, - this.getImaginary() / scale);
    }

    /**
     * Returns a ComplexNumber whose value is the conjugate of this
     *
     * @return conjugateComplexNumber conjugate complex number
     */
    public ComplexNumber conjugate() {
        double real, imaginary;

        real = this.getReal();
        imaginary = - this.getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    /**
     * Returns a ComplexNumber whose value is (this / dividedComplexNumber)
     *
     * @param dividedComplexNumber complex number to be divided
     * @return this / dividedComplexNumber
     */
    public ComplexNumber divide(ComplexNumber dividedComplexNumber) {
        return this.multiply(dividedComplexNumber.reciprocal());
    }

}
