package lab;

import lab.interfaces.Target;
import lab.interfaces.Weapon;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AxeTests {

    private static final int DUMMY_HEALTH = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY_POINTS = 9;

    private Weapon axe;
    private Target dummy;

    @Before
    public void createAxeAndDummy() {
        // Arrange
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

    }

    @Test
    public void axeLosesDurability() {
        // Act
        axe.attack(dummy);
        // Assert
        Assert.assertEquals("Expect durability points to decrease by 1",
                this.axe.getDurabilityPoints(), EXPECTED_DURABILITY_POINTS);
        // Act
        axe.attack(dummy);
        Assert.assertEquals("Expect durability points to decrease by 1",
                this.axe.getDurabilityPoints(), EXPECTED_DURABILITY_POINTS - 1);
    }

    @Test (expected = IllegalStateException.class)
    public void axeAttackWithBrokenWeapon() {
        // Act
        while (true) {
            axe.attack(dummy);
        }
        // Assert not needed exception expected
    }
}