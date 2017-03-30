package tests;

import interfaces.Target;
import interfaces.Weapon;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {

    private static final int TARGET_XP = 5;
    private static final String HERO_NAME = "Miki Mouse";

    @Test
    public void attackGainsExperienceIfTargetIsDeath() {
        // Arrange
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        // Act
        hero.attack(targetMock);
        // Assert
        Assert.assertEquals("Expect experience to increase", TARGET_XP, hero.getExperience());
    }
}