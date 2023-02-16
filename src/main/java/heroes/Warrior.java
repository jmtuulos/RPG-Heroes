package heroes;

import attributes.HeroAttribute;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Weapon;

public class Warrior extends Hero{
    public Warrior(String name) {
        super(name, "Warrior", new HeroAttribute(5, 2, 1));
        this.damageAttribute = this.getTotal().getStrength();
        this.setTotalAttributes(0,0,0); // try without 0,0,0 here
    }
    @Override
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setStartAttributes(1, 3, 2);
        this.setTotalAttributes(0,0,0);
    }

    @Override
    public boolean equipItem(Armor armor) throws InvalidArmorException {
        if (armor.getRequiredLevel() > this.getLevel())
            throw new InvalidArmorException("You cannot equip this item, (lvl " + armor.getRequiredLevel() + " required)");
        if (armor.getArmorType() != Armor.ArmorType.PLATE && armor.getArmorType() != Armor.ArmorType.MAIL)
            throw new InvalidArmorException("Not a valid armor for " + this.getHeroType() + armor.getArmorType());
        this.getEquipment().put(armor.getSlot(), armor);
        this.setTotalAttributes(armor.getArmorAttribute().getStrength(), armor.getArmorAttribute().getDexterity(), armor.getArmorAttribute().getIntelligence());
        this.damageAttribute = this.getTotal().getStrength();
        return true;
    }

    @Override
    public boolean equipItem(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getRequiredLevel() > this.getLevel())
            throw new InvalidWeaponException("You cannot equip this item, (lvl " + weapon.getRequiredLevel() + " required)");
        else if (weapon.getWeaponType() != Weapon.WeaponType.AXE && weapon.getWeaponType() != Weapon.WeaponType.SWORD && weapon.getWeaponType() != Weapon.WeaponType.HAMMER)
            throw new InvalidWeaponException("Not a valid weapon for" + getHeroType());
        this.getEquipment().put(weapon.getSlot(), weapon);
        return true;
    }

    @Override
    public double damage() {
        return 0;
    }
}
