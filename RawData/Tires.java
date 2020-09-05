package RawData;

public class Tires {
    private  double press1,  press2,  press3,  press4;
    private int age1,age2,age3,age4;

    public Tires(double press1, int age1, double press2, int age2, double press3, int age3, double press4, int age4) {
        this.press1 = press1;
        this.age1 = age1;
        this.press2 = press2;
        this.age2 = age2;
        this.press3 = press3;
        this.age3 = age3;
        this.press4 = press4;
        this.age4 = age4;
    }

    public double getPress1() {
        return press1;
    }

    public void setPress1(double press1) {
        this.press1 = press1;
    }

    public double getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public double getPress2() {
        return press2;
    }

    public void setPress2(double press2) {
        this.press2 = press2;
    }

    public double getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public double getPress3() {
        return press3;
    }

    public void setPress3(double press3) {
        this.press3 = press3;
    }

    public double getAge3() {
        return age3;
    }

    public void setAge3(int age3) {
        this.age3 = age3;
    }

    public double getPress4() {
        return press4;
    }

    public void setPress4(double press4) {
        this.press4 = press4;
    }

    public double getAge4() {
        return age4;
    }

    public void setAge4(int age4) {
        this.age4 = age4;
    }
}
