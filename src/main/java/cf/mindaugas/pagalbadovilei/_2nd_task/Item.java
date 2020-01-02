package cf.mindaugas.pagalbadovilei._2nd_task;

// Item item = new Item("XX", 2.55);
// item.name = ""; -- can't do that
// item.setName("");
public class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.equals("") || name != null) throw new Exception("Name can't be empty");
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}