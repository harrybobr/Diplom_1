package praktikum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

  private Burger burger;

  @Mock
  private Ingredient ingredient_1;

  @Mock
  private Ingredient ingredient_2;

  @Mock
  private Bun bun;

  @Before
  public void setUp() {
    burger = new Burger();
    burger.setBuns(bun);
  }

  @Test
  public void addIngredientTest() {
    burger.addIngredient(ingredient_1);

    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void removeIngredientTest() {
    burger.addIngredient(ingredient_1);
    burger.removeIngredient(0);

    assertEquals(0, burger.ingredients.size());
  }

  @Test
  public void moveIngredientTest() {
    burger.addIngredient(ingredient_1);
    burger.addIngredient(ingredient_2);
    burger.moveIngredient(0, 1);

    assertEquals(ingredient_1, burger.ingredients.get(1));
  }

  @Test
  public void getPriceTest() {
    burger.addIngredient(ingredient_1);
    burger.addIngredient(ingredient_2);
    when(bun.getPrice()).thenReturn(2.0f);
    when(ingredient_1.getPrice()).thenReturn(2.0f);
    when(ingredient_2.getPrice()).thenReturn(1.0f);
    float expected = (2.0f * 2) + 1.0f + 2.0f;

    assertEquals(expected, burger.getPrice(), 0.001f);
  }

  @Test
  public void getReceiptTest() {
    burger.addIngredient(ingredient_1);
    burger.addIngredient(ingredient_2);
    when(bun.getName()).thenReturn("Burger Boom");
    when(ingredient_1.getName()).thenReturn("onion");
    when(ingredient_2.getName()).thenReturn("mustard");

    when(ingredient_2.getType()).thenReturn(IngredientType.SAUCE);
    when(ingredient_1.getType()).thenReturn(IngredientType.FILLING);

    when(bun.getPrice()).thenReturn(2.0f);
    when(ingredient_1.getPrice()).thenReturn(2.0f);
    when(ingredient_2.getPrice()).thenReturn(1.0f);

    StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
    receipt.append(String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), ingredient_1.getName()));
    receipt.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), ingredient_2.getName()));
    receipt.append(String.format("(==== %s ====)%n", bun.getName()));
    receipt.append(String.format("%nPrice: %f%n", 7.0f));
    String expectedReceipt = receipt.toString();

    assertEquals(expectedReceipt, burger.getReceipt());
  }

}
