package praktikum;

import static org.junit.Assert.assertEquals;

import net.datafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

  private final String name;
  private final float price;
  private Bun bun;

  private static final Faker faker = new Faker();

  public BunTest(String name, float price) {
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Object[][] createBuns() {
    return new Object[][]{
        {faker.food().ingredient(), (float) faker.number().randomDouble(2, 0, 100)},
        {faker.food().ingredient(), (float) faker.number().randomDouble(2, 0, 100)},
        {faker.food().ingredient(), (float) faker.number().randomDouble(2, 0, 100)}
    };
  }

  @Before
  public void setUp() {
    bun = new Bun(name, price);
  }

  @Test
  public void getNameTest() {
    assertEquals(name, bun.getName());
  }

  @Test
  public void getPriceTest() {
    assertEquals(price, bun.getPrice(), 0.01);
  }
}
