package gr.softwarecraftsmanship;


import org.junit.Assert;
import org.junit.Test;

public class EuVatCalculatorTest {

  private static final String invalidVatId = "ThisCannotPossiblyBeAValidVatId";

  @Test
  public void testInvalidVatId(){
    EuVatCalculator calc = new EuVatCalculator();
    Assert.assertFalse(calc.isValidVatId(invalidVatId));
  }
}
