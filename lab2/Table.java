// Table.java
public class Table extends Furniture {

    private int seats;           
    private String shape;        

    // Конструктор
    public Table() {
        super();                 
        this.seats = 4;
        this.shape = "прямоугольный";
    }

    public Table(String material, double price, String color, int seats, String shape) {
        super(material, price, color);
        this.seats = seats;
        this.shape = shape;
    }

    // Геттеры и сеттеры
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    // Переопределение метода
    @Override
    public void use() {
        System.out.println("За этим столом можно работать или обедать.");
    }

    // Переопределение showInfo
    @Override
    public void showInfo() {
        super.showInfo();                    
        System.out.println("Количество мест: " + seats);
        System.out.println("Форма: " + shape);
        System.out.println("-----------------------------");
    }
}