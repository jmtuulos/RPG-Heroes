package items;

import attributes.HeroAttribute;

public class Armor extends Item {

    private final ArmorType armorType;
    private final HeroAttribute armorAttribute;
    public enum ArmorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE,
    }
    public Armor (String name, int levelRequired, Slot slot, ArmorType armorType, int dexterity, int strength, int intelligence) {
        this.setName(name);
        this.setRequiredLevel(levelRequired);
        this.armorType = armorType;
        this.setSlot(slot);
        this.armorAttribute = new HeroAttribute(strength, dexterity, intelligence);
    }
    public ArmorType getArmorType() {
        return armorType;
    }


    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }
}
