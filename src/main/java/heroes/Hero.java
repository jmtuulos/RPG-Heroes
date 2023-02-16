package heroes;

import attributes.HeroAttribute;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Item;
import items.Armor;
import items.Weapon;

import java.util.HashMap;


public abstract class Hero {
    private String name;
    private int level = 1;
    private HeroAttribute attribute;
    protected int damageAttribute;
    private HeroAttribute total = new HeroAttribute(0, 0, 0);
    private HeroAttribute start;
    private HashMap<Item.Slot, Item> equipped = new HashMap<>();
    private String heroType;
    private double heroDamage;

    public Hero (String name, String heroType, HeroAttribute start){
        this.name = name;
        this.heroType = heroType;
        this.start = start;
    }
    public HashMap<Item.Slot, Item> getEquipment() {
        return equipped;
    }
    public abstract void levelUp();
    public abstract boolean equipItem (Armor armor) throws InvalidArmorException;
    public abstract boolean equipItem (Weapon weapon) throws InvalidWeaponException;
    public abstract double damage();
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    public HeroAttribute getTotal(){
        return total;
    }

    public String getHeroType() {
        return heroType;
    }

    public double getHeroDamage() {
        Weapon weapon = (Weapon) this.equipped.get(Item.Slot.WEAPON);

        if (weapon == null)
            this.heroDamage = (1 + (this.damageAttribute / 100d));
        else
            this.heroDamage = weapon.getDamage() * (1 + (this.damageAttribute / 100d));
        return heroDamage;
    }

    public void setTotalAttributes(int strength, int dexterity, int intelligence) {
        this.total.setDexterity(this.start.getDexterity() + dexterity);
        this.total.setIntelligence(this.start.getIntelligence() + intelligence);
        this.total.setStrength(this.start.getStrength() + strength);
    }
    public void setStartAttributes(int intelligence, int strength, int dexterity) {
        this.start.setDexterity(dexterity);
        this.start.setIntelligence(intelligence);
        this.start.setStrength(strength);
    }
    public String display(){
        return
                "Hero: " + this.name + "\n"
                + "Class: " + this.heroType + "\n"
                + "Level: " + this.level + "\n"
                + "Strength: " + total.getStrength() + "\n"
                + "Dexterity: " + total.getDexterity() + "\n"
                + "Intelligence" + total.getIntelligence() + "\n"
                + "Damage: " + heroDamage;
    }

}
