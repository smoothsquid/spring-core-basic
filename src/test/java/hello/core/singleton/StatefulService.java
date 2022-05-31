package hello.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        // 싱글톤 사용시 여기가 문제!
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StatefulService{" +
                "price=" + price +
                '}';
    }
}
