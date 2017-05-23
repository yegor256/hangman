package hangman.checker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCheckerTest {

  private SimpleChecker simpleChecker;

  private final String word = "test";

  @Before
  public void setUp() {
    this.simpleChecker = new SimpleChecker();
  }

  @Test
  public void shouldMatch() {
    CheckResult actual = simpleChecker.check(word, 't');

    assertTrue(actual.isHit());
    assertEquals(4, actual.hits().length);
    assertTrue(actual.hits()[0]);
    assertFalse(actual.hits()[1]);
    assertFalse(actual.hits()[2]);
    assertTrue(actual.hits()[3]);
  }

  @Test
  public void shouldNotMatch_WhenNonExistingIsGiven() {
    CheckResult actual = simpleChecker.check(word, 'a');

    assertFalse(actual.isHit());
    assertEquals(4, actual.hits().length);
    assertFalse(actual.hits()[0]);
    assertFalse(actual.hits()[1]);
    assertFalse(actual.hits()[2]);
    assertFalse(actual.hits()[3]);
  }
}
