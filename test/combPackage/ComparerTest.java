package combPackage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparerTest {
    @ParameterizedTest
    @MethodSource("provideValues")
    public void comparesValues(Object first, Object second, boolean expected) {
        boolean actual = new combPackage.Comparer(first, second).getIsEqual();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of(1,                  1,                  true),
                Arguments.of(1,                  0,                  false),
                Arguments.of(1.0d,               1.0d,               true),
                Arguments.of(1.0d,               1.1d,               false),
                Arguments.of(Integer.valueOf(1), Integer.valueOf(1), true),
                Arguments.of(Integer.valueOf(1), Integer.valueOf(0), false),
                Arguments.of(Double.valueOf(1),  Double.valueOf(1),  true),
                Arguments.of(Double.valueOf(1),  Double.valueOf(0),  false),
                Arguments.of("one",              "one",              true),
                Arguments.of("one",              "onex",             false)
        );
    }
}