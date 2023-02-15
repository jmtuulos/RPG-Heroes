package items;

public class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

    enum Slot {
        WEAPON,
        HEAD,
        BODY,
        LEGS,
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }
}
