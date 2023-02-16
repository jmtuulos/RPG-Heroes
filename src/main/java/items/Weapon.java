package items;

public class Weapon extends Item {
    private final WeaponType weaponType;
    private int damage;

    public enum WeaponType {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND,
    }
    public Weapon(String name, Integer requiredLevel, Slot slot, WeaponType weaponType, int damage){
        this.setName(name);
        this.setRequiredLevel(requiredLevel);
        this.damage = damage;
        this.weaponType = weaponType;
        this.setSlot(slot);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

}
