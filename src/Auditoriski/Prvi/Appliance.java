package Auditoriski.Prvi;

public class Appliance {
    private String producer;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Appliance(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Appliance {" +
                "producer='" + producer + '\'' +
                '}';
    }
}
