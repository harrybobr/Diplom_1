package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngredientTypeTest {

  public static final String SAUCE = "SAUCE";
  public static final String FILLING = "FILLING";

  @Test
  public void sauceTest() {
    assertEquals(IngredientType.SAUCE, IngredientType.valueOf(SAUCE));
  }

  @Test
  public void fillingTest() {
    assertEquals(IngredientType.FILLING, IngredientType.valueOf(FILLING));
  }
}
