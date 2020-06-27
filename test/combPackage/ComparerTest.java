package combPackage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparerTest {
    @Test
    public void testTheThing() {
        new combPackage.Comparer(null, null);
        assertThat(42).isEqualTo(40);
    }
}