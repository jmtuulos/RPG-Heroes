package heroes;

import attributes.HeroAttribute;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
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
        this.setStartAttributes(5, 1, 1);
    }

    @Override
    public boolean equipItem(Armor armor) throws InvalidArmorException {
        if (armor.getRequiredLevel() > this.getLevel())
            throw new InvalidArmorException("You cannot equip this item, (lvl " + armor.getRequiredLevel() + " required)");
        if (armor.getArmorType() != Armor.ArmorType.CLOTH)
            throw new InvalidArmorException("Not a valid armor for " + getHeroType());
        this.getEquipment().put(armor.getSlot(), armor);
        this.setTotalAttributes(armor.getArmorAttribute().getStrength(), armor.getArmorAttribute().getDexterity(), armor.getArmorAttribute().getIntelligence());
        this.damageAttribute = this.getTotal().getIntelligence();
        return true;
    }

    @Override
    public boolean equipItem(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getRequiredLevel() > this.getLevel())
            throw new InvalidWeaponException("You cannot equip this item, (lvl " + weapon.getRequiredLevel() + " required)");
        else if (weapon.getWeaponType() != Weapon.WeaponType.STAFF && weapon.getWeaponType() != Weapon.WeaponType.WAND)
            throw new InvalidWeaponException("Not a valid weapon for Mage");
        this.getEquipment().put(weapon.getSlot(), weapon);
        return true;
    }

    @Override
    public double damage() {
        return 0;
    }
}
