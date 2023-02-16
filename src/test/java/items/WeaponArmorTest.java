package items;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import heroes.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponArmorTest {

    @Test
    void createNewSword_validParameters_NewWeapon() {
        Weapon sword = new Weapon("Sword", 5, Item.Slot.WEAPON, Weapon.WeaponType.SWORD, 10);
        assertEquals("Sword", sword.getName());
        assertEquals(5, sword.getRequiredLevel());
        assertEquals(10, sword.getDamage());
        assertEquals(Weapon.WeaponType.SWORD, sword.getWeaponType());
        assertEquals(Item.Slot.WEAPON, sword.getSlot());
    }
    @Test
    void createNewWand_validParameters_NewWeapon() {
        Weapon wand = new Weapon("Wand", 10, Item.Slot.WEAPON, Weapon.WeaponType.WAND, 5);
        assertEquals("Wand", wand.getName());
        assertEquals(10, wand.getRequiredLevel());
        assertEquals(5, wand.getDamage());
        assertEquals(Weapon.WeaponType.WAND, wand.getWeaponType());
        assertEquals(Item.Slot.WEAPON, wand.getSlot());
    }
    @Test
    void createNewHelmet_validParameters_NewArmor() {
        Armor helmet = new Armor("Helmet", 2, Item.Slot.HEAD, Armor.ArmorType.MAIL, 0, 3, 4);
        assertEquals("Helmet", helmet.getName());
        assertEquals(2, helmet.getRequiredLevel());
        assertEquals(Armor.ArmorType.MAIL, helmet.getArmorType());
        assertEquals(Item.Slot.HEAD, helmet.getSlot());
        assertEquals(3, helmet.getArmorAttribute().getStrength());
        assertEquals(4, helmet.getArmorAttribute().getIntelligence());
        assertEquals(0, helmet.getArmorAttribute().getDexterity());
    }
    @Test
    void createNewBody_validParameters_NewArmor() {
        Armor bodyArmor = new Armor("Body Armor", 5, Item.Slot.BODY, Armor.ArmorType.PLATE, 0, 3 ,2);
        assertEquals("Body Armor", bodyArmor.getName());
        assertEquals(5, bodyArmor.getRequiredLevel());
        assertEquals(Armor.ArmorType.PLATE, bodyArmor.getArmorType());
        assertEquals(Item.Slot.BODY, bodyArmor.getSlot());

    }

    // Exceptions
    @Test
    void equipInvalidWeapon_invalidWeapon_InvalidWeaponException() {
        Weapon wand = new Weapon("Wand", 10, Item.Slot.WEAPON, Weapon.WeaponType.WAND, 5);
        Warrior warrior = new Warrior("Warrior");
        assertThrows(InvalidWeaponException.class, () -> warrior.equipItem(wand));
    }
    @Test
    void equipInvalidArmor_invalidArmor_InvalidArmorException() {
        Armor bodyArmor = new Armor("Body Armor", 5, Item.Slot.BODY, Armor.ArmorType.PLATE, 0, 3 ,2);
        Warrior warrior = new Warrior("Warrior");
        assertThrows(InvalidArmorException.class, () -> warrior.equipItem(bodyArmor));
    }

    // Two pieces of armor

    @Test
    void equipTwoArmors_validArmor_CorrectAttributes() throws InvalidArmorException {
        Armor helmet = new Armor("Helmet", 1, Item.Slot.HEAD, Armor.ArmorType.MAIL, 0, 3, 4);
        Armor bodyArmor = new Armor("Body Armor", 1, Item.Slot.BODY, Armor.ArmorType.PLATE, 0, 3 ,2);
        Warrior warrior = new Warrior("Warrior");
        assertEquals(5, warrior.getTotal().getStrength());
        warrior.equipItem(helmet);
        warrior.equipItem(bodyArmor);
        assertEquals(11, warrior.getTotal().getStrength());
        assertEquals(2, warrior.getTotal().getDexterity());
        assertEquals(7, warrior.getTotal().getIntelligence());
        Armor helmet2 = new Armor("Helmet", 1, Item.Slot.HEAD, Armor.ArmorType.MAIL, 0, 55, 4);
        warrior.equipItem(helmet2);
        assertEquals(66, warrior.getTotal().getStrength());
        assertEquals(2, warrior.getTotal().getDexterity());
        assertEquals(11, warrior.getTotal().getIntelligence());
    }

    // Hero damage
    @Test
    void heroDamage_validWeapon_CorrectDamage() throws InvalidWeaponException {
        Weapon sword = new Weapon("Sword", 1, Item.Slot.WEAPON, Weapon.WeaponType.SWORD, 10);
        Warrior warrior = new Warrior("Warrior");
        assertEquals(5, warrior.getTotal().getStrength());
        warrior.equipItem(sword);
        double damage = 10 * (1 + 5 / 100d);
        assertEquals(damage, warrior.getHeroDamage());
    }
    //equipped weapon with higher damage
    @Test
    void heroDamage_validWeapon_CorrectDamage2() throws InvalidWeaponException {
        Weapon sword = new Weapon("Sword", 1, Item.Slot.WEAPON, Weapon.WeaponType.SWORD, 10);
        Weapon sword2 = new Weapon("Sword", 1, Item.Slot.WEAPON, Weapon.WeaponType.SWORD, 130);
        Warrior warrior = new Warrior("Warrior");
        warrior.equipItem(sword);
        warrior.equipItem(sword2);
        double damage = 130 * (1 + 5 / 100d);
        assertEquals(damage, warrior.getHeroDamage());
    }
    //weapon and armor equipped
    @Test
    void heroDamage_validWeaponAndArmor_CorrectDamage() throws InvalidWeaponException, InvalidArmorException {
        Weapon sword = new Weapon("Sword", 1, Item.Slot.WEAPON, Weapon.WeaponType.SWORD, 10);
        Armor helmet = new Armor("Helmet", 1, Item.Slot.HEAD, Armor.ArmorType.MAIL, 0, 3, 4);
        Warrior warrior = new Warrior("Warrior");
        warrior.equipItem(sword);
        warrior.equipItem(helmet);
        double damage = 10 * (1 + (5 + 3) / 100d);
        assertEquals(damage, warrior.getHeroDamage());
    }
}