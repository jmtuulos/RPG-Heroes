package heroes;

import attributes.HeroAttribute;
import items.Armor;
import items.Weapon;

public class Mage extends Hero {

    public Mage(String name) {
        super(name, "Mage", new HeroAttribute(1, 1, 8));
        this.damageAttribute = this.getTotal().getIntelligence();
        this.setStartAttributes(1,1,5);
        this.setTotalAttributes(0,0,0); // try without 0,0,0 here
    }
    @Override
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setStartAttributes(1, 1, 5);

    }

    @Override
    public boolean equipItem(Armor armor) throws InvalidArmorException {
        return false;
    }

    @Override
    public boolean equipItem(Weapon weapon) throws InvalidWeaponException {
        return false;
    }

    @Override
    public double damage() {
        return 0;
    }
}
