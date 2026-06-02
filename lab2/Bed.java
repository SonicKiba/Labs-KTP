// Bed.java
public class Bed extends Furniture {

    private int width;     
    private int length;     
    private String type;    

    public Bed() {
        super();
        this.width = 90;
        this.length = 200;
        this.type = "односпальная";
    }

    public Bed(String material, double price, String color, int width, int length, String type) {
        super(material, price, color);
        this.width = width;
        this.length = length;
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("На этой кровати можно спать.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Размер: " + width + "x" + length + " см");
        System.out.println("Тип: " + type);
        System.out.println("-----------------------------");
    }
}