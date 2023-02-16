package heroes;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Weapon;

public class Rogue extends Hero{
    public Rogue(String name) {
        super(name, "Rogue");
        this.setTotalAttributes(2,6,1);
        this.damageAttribute = this.getTotal().getDexterity();
    }
    @Override
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setTotalAttributes(1,4,1);
        this.damageAttribute = this.getTotal().getIntelligence();
    }

    @Override
    public void equipItem(Armor armor) throws InvalidArmorException {
        if (armor.getRequiredLevel() > this.getLevel())
            throw new InvalidArmorException("You cannot equip this item, (lvl " + armor.getRequiredLevel() + " required)");
        else if (armor.getArmorType() != Armor.ArmorType.LEATHER && armor.getArmorType() != Armor.ArmorType.MAIL)
            throw new InvalidArmorException("Not a valid armor for " + this.getHeroType());
        this.getEquipment().put(armor.getSlot(), armor);
        this.setTotalAttributes(armor.getArmorAttribute().getStrength(), armor.getArmorAttribute().getDexterity(), armor.getArmorAttribute().getIntelligence());
        this.damageAttribute = this.getTotal().getDexterity();
    }

    @Override
    public void equipItem(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getRequiredLevel() > this.getLevel())
            throw new InvalidWeaponException("You cannot equip this item, (lvl " + weapon.getRequiredLevel() + " required)");
        else if (weapon.getWeaponType() != Weapon.WeaponType.DAGGER && weapon.getWeaponType() != Weapon.WeaponType.SWORD)
            throw new InvalidWeaponException("Not a valid weapon for" + getHeroType());
        this.getEquipment().put(weapon.getSlot(), weapon);
    }
}
