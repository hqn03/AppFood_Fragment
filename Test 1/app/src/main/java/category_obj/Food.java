package category_obj;

public class Food {
    String name;
    Double rate;
    int count_rate;
    double price;
    int image;

    public Food(String name, Double rate, int count_rate, double price, int image) {
        this.name = name;
        this.rate = rate;
        this.count_rate = count_rate;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getCount_rate() {
        return count_rate;
    }

    public void setCount_rate(int count_rate) {
        this.count_rate = count_rate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
