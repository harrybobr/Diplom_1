package praktikum;

import static org.junit.Assert.assertEquals;

import net.datafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTest {

  private final IngredientType ingredientType;
  private final String name;
  private final float price;
  private Ingredient ingredient;

  private static final Faker faker = new Faker();

  public IngredientTest(IngredientType ingredientType, String name, float price) {
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Object[][] createIngredient() {
    return new Object[][]{
        {IngredientType.FILLING, faker.food().ingredient(), (float) faker.number().randomDouble(2, 0, 100)},
        {IngredientType.SAUCE, faker.food().spice(), (float) faker.number().randomDouble(2, 0, 100)}
    };
  }

  @Before
  public void setUp() {
    ingredient = new Ingredient(ingredientType, name, price);
  }

  @Test
  public void getTypeTest() {
    assertEquals(ingredientType, ingredient.getType());
  }

  @Test
  public void getNameTest() {
    assertEquals(name, ingredient.getName());
  }

  @Test
  public void getPriceTest() {
    assertEquals(price, ingredient.getPrice(), 0.01);
  }
}
