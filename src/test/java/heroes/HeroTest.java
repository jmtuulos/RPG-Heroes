package heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @org.junit.jupiter.api.Test
    void createMage_validAttributes_createNewMage() {
        String name = "Mr.Magic";

        int expectedIntelligence = 8;
        int expectedStrength = 1;
        int expectedDexterity = 1;

        Mage mage = new Mage(name);
        assertEquals(name, mage.getName());
        assertEquals(expectedStrength, mage.getTotal().getStrength());
        assertEquals(expectedIntelligence, mage.getTotal().getIntelligence());
        assertEquals(expectedDexterity, mage.getTotal().getDexterity());
    }

    @Test
    void createWarrior_validAttributes_createNewWarrior() {
        String name = "Mrs.Warrior";
        int expectedIntelligence = 1;
        int expectedStrength = 5;
        int expectedDexterity = 2;
        Warrior warrior = new Warrior(name);
        assertEquals(name, warrior.getName());
        assertEquals(expectedStrength, warrior.getTotal().getStrength());
        assertEquals(expectedIntelligence, warrior.getTotal().getIntelligence());
        assertEquals(expectedDexterity, warrior.getTotal().getDexterity());
    }

    @Test
    void createRanger_validAttributes_createNewRanger() {
        String name = "Mr.Ranger";
        int expectedIntelligence = 1;
        int expectedStrength = 1;
        int expectedDexterity = 7;
        Ranger ranger = new Ranger(name);
        assertEquals(name, ranger.getName());
        assertEquals(expectedStrength, ranger.getTotal().getStrength());
        assertEquals(expectedIntelligence, ranger.getTotal().getIntelligence());
        assertEquals(expectedDexterity, ranger.getTotal().getDexterity());
    }

    @Test
    void createRogue_validAttributes_createNewRogue() {
        String name = "Mr.Rogue";
        int expectedIntelligence = 1;
        int expectedStrength = 2;
        int expectedDexterity = 6;
        Rogue rogue = new Rogue(name);
        assertEquals(name, rogue.getName());
        assertEquals(expectedStrength, rogue.getTotal().getStrength());
        assertEquals(expectedIntelligence, rogue.getTotal().getIntelligence());
        assertEquals(expectedDexterity, rogue.getTotal().getDexterity());
    }

    //Level up, correct attributes
    @org.junit.jupiter.api.Test
    void levelUpMage_validParameters_correctAttributes() {
        int expectedIntelligence = 13;
        int expectedStrength = 2;
        int expectedDexterity = 2;

        Mage mage = new Mage("name");
        mage.levelUp();
        assertEquals(expectedStrength, mage.getTotal().getStrength());
        assertEquals(expectedIntelligence, mage.getTotal().getIntelligence());
        assertEquals(expectedDexterity, mage.getTotal().getDexterity());
    }

    @org.junit.jupiter.api.Test
    void levelUpWarrior_validParameters_correctAttributes() {
        int expectedIntelligence = 2;
        int expectedStrength = 8;
        int expectedDexterity = 4;

        Warrior warrior = new Warrior("name");
        warrior.levelUp();
        assertEquals(expectedStrength, warrior.getTotal().getStrength());
        assertEquals(expectedIntelligence, warrior.getTotal().getIntelligence());
        assertEquals(expectedDexterity, warrior.getTotal().getDexterity());
    }

    @org.junit.jupiter.api.Test
    void levelUpRanger_validParameters_correctAttributes() {
        int expectedIntelligence = 2;
        int expectedStrength = 2;
        int expectedDexterity = 12;

        Ranger ranger = new Ranger("name");
        ranger.levelUp();
        assertEquals(expectedStrength, ranger.getTotal().getStrength());
        assertEquals(expectedIntelligence, ranger.getTotal().getIntelligence());
        assertEquals(expectedDexterity, ranger.getTotal().getDexterity());
    }

    @org.junit.jupiter.api.Test
    void levelUpRogue_validParameters_correctAttributes() {
        int expectedIntelligence = 2;
        int expectedStrength = 3;
        int expectedDexterity = 10;

        Rogue rogue = new Rogue("name");
        rogue.levelUp();
        assertEquals(expectedStrength, rogue.getTotal().getStrength());
        assertEquals(expectedIntelligence, rogue.getTotal().getIntelligence());
        assertEquals(expectedDexterity, rogue.getTotal().getDexterity());
    }


    //Level up tests
    @org.junit.jupiter.api.Test
    void levelUpMage_validParameters_correctLevel() {
        int expectedLevel = 2;

        Mage mage = new Mage("name");
        mage.levelUp();
        assertEquals(expectedLevel, mage.getLevel());
    }

    @org.junit.jupiter.api.Test
    void levelUpWarrior_validParameters_correctLevel() {
        int expectedLevel = 2;

        Warrior warrior = new Warrior("name");
        warrior.levelUp();
        assertEquals(expectedLevel, warrior.getLevel());

    }

    @org.junit.jupiter.api.Test
    void levelUpRanger_validParameters_correctLevel() {
        int expectedLevel = 2;

        Ranger ranger = new Ranger("name");
        ranger.levelUp();
        assertEquals(expectedLevel, ranger.getLevel());
    }

    @org.junit.jupiter.api.Test
    void levelUpRogue_validParameters_correctLevel() {
        int expectedLevel = 2;

        Rogue rogue = new Rogue("name");
        rogue.levelUp();
        assertEquals(expectedLevel, rogue.getLevel());
    }

    //Hero display
    @org.junit.jupiter.api.Test
    void displayHero_validParameters_correctDisplay() {
        String expectedDisplay =
            """
            Hero: Mr.Rogue
            Class: Rogue
            Level: 1
            Strength: 2
            Dexterity: 6
            Intelligence: 1
            Damage: 1.06""";
        Rogue rogue = new Rogue("Mr.Rogue");
        assertEquals(expectedDisplay, rogue.display());
    }
    @org.junit.jupiter.api.Test
    void displayHero_validParameters_correctDisplay2() {
        String expectedDisplay =
            """
            Hero: Mr.Warrior
            Class: Warrior
            Level: 2
            Strength: 8
            Dexterity: 4
            Intelligence: 2
            Damage: 1.02""";
        Warrior warrior = new Warrior("Mr.Warrior");
        warrior.levelUp();
        assertEquals(expectedDisplay, warrior.display());
    }



}