package heroes;

import attributes.HeroAttribute;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Item;
import items.Armor;
import items.Weapon;

import java.util.HashMap;


public abstract class Hero {
    private final String name;
    private final HeroAttribute total = new HeroAttribute(0, 0, 0);
    private final HashMap<Item.Slot, Item> equipped = new HashMap<>();
    private final String heroType;
    protected int damageAttribute = 0;
    private int level = 1;

    public Hero(String name, String heroType) {
        this.name = name;
        this.heroType = heroType;
    }

    public HashMap<Item.Slot, Item> getEquipment() {
        return equipped;
    }

    public abstract void levelUp();

    public abstract void equipItem(Armor armor) throws InvalidArmorException;

    public abstract void equipItem(Weapon weapon) throws InvalidWeaponException;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public HeroAttribute getTotal() {
        return total;
    }

    public String getHeroType() {
        return heroType;
    }

    public double getHeroDamage() {
        Weapon weapon = (Weapon) this.equipped.get(Item.Slot.WEAPON);

        double heroDamage;
        if (weapon == null)
            heroDamage = 1 + (this.damageAttribute / 100d);
        else
            heroDamage = weapon.getDamage() * (1 + this.damageAttribute / 100d);
        return heroDamage;
    }

    public void setTotalAttributes(int strength, int dexterity, int intelligence) {
        this.total.setDexterity(this.total.getDexterity() + dexterity);
        this.total.setIntelligence(this.total.getIntelligence() + intelligence);
        this.total.setStrength(this.total.getStrength() + strength);
    }

    public String display() {
        return
                "Hero: " + this.name + "\n"
                        + "Class: " + this.heroType + "\n"
                        + "Level: " + this.level + "\n"
                        + "Strength: " + total.getStrength() + "\n"
                        + "Dexterity: " + total.getDexterity() + "\n"
                        + "Intelligence: " + total.getIntelligence() + "\n"
                        + "Damage: " + this.getHeroDamage();
    }
}
