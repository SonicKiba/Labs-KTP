// Main.java
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Лабораторная работа №2 - ООП ===");
        System.out.println("Вариант 8: Иерархия классов Мебель\n");

        Table table = new Table("Дерево", 12500, "Коричневый", 6, "прямоугольный");
        Chair chair = new Chair("Пластик", 2500, "Чёрный", true, 150);
        Bed bed = new Bed("Дерево", 28900, "Белый", 180, 200, "двуспальная");

        System.out.println("=== Информация об объектах ===");

        table.showInfo();
        table.use();
        System.out.println();

        chair.showInfo();
        chair.use();
        System.out.println();

        bed.showInfo();
        bed.use();
        System.out.println();

        System.out.println("=== Работа геттеров и сеттеров ===");
        System.out.println("Цена стола до изменения: " + table.getPrice() + " руб.");
        table.setPrice(14000);
        System.out.println("Цена стола после изменения: " + table.getPrice() + " руб.\n");

        System.out.println("=== Полиморфизм ===");
        Furniture[] furnitureArray = {table, chair, bed};

        for (Furniture item : furnitureArray) {
            item.showInfo();
            item.use();
            System.out.println();
        }

        System.out.println("=== Upcasting и instanceof ===");
        Furniture furniture = new Table("Стекло", 18500, "Прозрачный", 4, "круглый");

        if (furniture instanceof Table) {
            Table temp = (Table) furniture;
            System.out.println("Это стол с " + temp.getSeats() + " местами.");
        }

        System.out.println("=====================================");
        Furniture.showObjectCount();

        System.out.println("\nПрограмма завершена успешно!");
    }
} 