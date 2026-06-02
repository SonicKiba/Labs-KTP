// Furniture.java
public abstract class Furniture {

    // Поля
    private String material;      
    private double price;         
    private String color;         

    // Статический счетчик созданных объектов
    private static int objectCount = 0;
    // Конструкторы
    public Furniture() {
        this("Неизвестный материал", 0.0, "Неизвестный цвет");
    }

    public Furniture(String material, double price, String color) {
        this.material = material;
        this.price = price;
        this.color = color;
        objectCount++;                 
    }

    // Геттеры и сеттеры
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //(демонстрация абстракции)
    public abstract void use();

    public void showInfo() {
        System.out.println("Мебель: " + getClass().getSimpleName());
        System.out.println("Материал: " + material);
        System.out.println("Цвет: " + color);
        System.out.println("Цена: " + price + " руб.");
    }

    // Статический метод для показа счетчика
    public static void showObjectCount() {
        System.out.println("Всего создано объектов мебели: " + objectCount);
    }
}