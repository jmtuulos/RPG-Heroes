package heroes;

import attributes.HeroAttribute;
import items.Armor;
import items.Weapon;

public abstract class Hero {
    private String name;
    private int level = 1;
    private HeroAttribute attribute;
    protected int damageAttribute;
    private HeroAttribute total = new HeroAttribute(0, 0, 0);
    private HeroAttribute start;
    private String heroType;
    public Hero (String name, String heroType, HeroAttribute attribute){
        this.name = name;
        this.attribute = attribute;
        this.heroType = heroType;
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
    public void setTotalAttributes(int intelligence, int strength, int dexterity) {
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
                + "Damage: " + total.getDamage();
    }

}
