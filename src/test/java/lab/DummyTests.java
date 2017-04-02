package lab;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int DUMMY_ATTACK_TAKE_POINTS = 5;
    private static final int DUMMY_EXPECTED_HEALTH = 5;

    private Dummy dummy;

    @Before
    public void initializeObjects() {
        // Arrange
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealth() {
        // Act
        dummy.takeAttack(DUMMY_ATTACK_TAKE_POINTS);
        // Assert
        Assert.assertEquals("Expect dummy health to decrease", dummy.getHealth(), DUMMY_EXPECTED_HEALTH);
    }

    @Test (expected = IllegalStateException.class)
    public void deadDummyThrowException() {
        // Act
        for (int i = 0; i < 3; i++) {
            dummy.takeAttack(DUMMY_ATTACK_TAKE_POINTS);
        }
        // Assert not needed exception expected
    }

    @Test
    public void deadDummyGivesXp() {
        // Act
        for (int i = 0; i < 2; i++) {
            dummy.takeAttack(DUMMY_ATTACK_TAKE_POINTS);
        }
        int dummyXp = dummy.giveExperience();
        // Assert not needed we just expect int to have value
    }

    @Test (expected = IllegalStateException.class)
    public void aliveDummyCantGivesXp() {
        // Act
        int dummyXp = dummy.giveExperience();
        // Assert not needed we expect exception
    }
}