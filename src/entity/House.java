package entity;

/**
 * 房屋实体类
 */
public class House {

    private int houseId;

    private String title;

    private double area;

    private double price;

    private String info;

    private int typeId;

    public House() {}

    public House(int houseId, String title, double area, double price, String info, int typeId) {
        this.houseId = houseId;
        this.title = title;
        this.area = area;
        this.price = price;
        this.info = info;
        this.typeId = typeId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
