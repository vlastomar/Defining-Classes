package SpeedRacing;

public class Drive {
    private String model;
    private int distance;

    public Drive(String model, int distance) {
        this.model = model;
        this.distance = distance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
