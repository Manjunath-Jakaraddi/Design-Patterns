package beverage;

public abstract class Beverage {
    // already given by the starbuzz cannot modify this code
    // could've improved from abstract class to interface for
    // better implementation of decorator pattern
    String description = "Unknown beverage.Beverage";

    // modification add charging to condiments according to different sizes
    public enum Size { TALL, GRANDE, VENTI };
    // default to TALL
    Size size = Size.TALL;

    public void setDescription(String description) {
        this.description = description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getDescription() {
        return size + description;
    }

    public abstract double cost();
}
