// Chair.java
public class Chair extends Furniture {

    private boolean hasBackrest;     
    private int maxWeight;           

    public Chair() {
        super();
        this.hasBackrest = true;
        this.maxWeight = 120;
    }

    public Chair(String material, double price, String color, boolean hasBackrest, int maxWeight) {
        super(material, price, color);
        this.hasBackrest = hasBackrest;
        this.maxWeight = maxWeight;
    }

    public boolean isHasBackrest() {
        return hasBackrest;
    }

    public void setHasBackrest(boolean hasBackrest) {
        this.hasBackrest = hasBackrest;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public void use() {
        System.out.println("На этом стуле можно сидеть.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Есть спинка: " + (hasBackrest ? "Да" : "Нет"));
        System.out.println("Макс. вес: " + maxWeight + " кг");
        System.out.println("-----------------------------");
    }
}