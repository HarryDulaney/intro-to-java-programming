package ch_31.exercise31_02;

/**
 * Data Transfer Object for BMI data
 * <p>
 * This class is used to transfer data from the client to the server.
 * For Exercise31_02, the client sends the weight and height for a person to the server.
 */
public class BmiDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private double weight;
    private double height;

    public BmiDto() {
    }

    public BmiDto(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
