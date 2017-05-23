package hangman.checker;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    assertThat(actual.isHit()).isTrue();
    assertThat(actual.hits().length).isEqualTo(4);
    assertThat(actual.hits()[0]).isTrue();
    assertThat(actual.hits()[1]).isFalse();
    assertThat(actual.hits()[2]).isFalse();
    assertThat(actual.hits()[3]).isTrue();
  }

  @Test
  public void shouldNotMatch_WhenNonExistingIsGiven() {
    CheckResult actual = simpleChecker.check(word, 'a');

    assertThat(actual.isHit()).isFalse();
    assertThat(actual.hits().length).isEqualTo(4);
    assertThat(actual.hits()[0]).isFalse();
    assertThat(actual.hits()[1]).isFalse();
    assertThat(actual.hits()[2]).isFalse();
    assertThat(actual.hits()[3]).isFalse();
  }
}
