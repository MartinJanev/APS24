package Auditoriski.Prvi;

public class AirConditioner extends Appliance {

    private float power;
    private String color;

    public AirConditioner(String producer, float power, String color) {
        super(producer);
        this.power = power;
        this.color = color;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                super.toString() +
                "power=" + power +
                ", color='" + color + '\'' +
                '}';
    }
}
