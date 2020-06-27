package combPackage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparerTest {
    @ParameterizedTest
    @MethodSource("provideValues")
    public void comparesValues(boolean expected, String comment, combPackage.Comparer comparer) {
        boolean actual = comparer.getIsEqual();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of(true,  "equal ints",         new combPackage.Comparer(1, 1)),
                Arguments.of(false, "different ints",     new combPackage.Comparer(1, 0)),
                Arguments.of(true,  "equal doubles",      new combPackage.Comparer(1.0d, 1.0d)),
                Arguments.of(false, "different doubles",  new combPackage.Comparer(1.0d, 1.1d)),
                Arguments.of(true,  "equal Integers",     new combPackage.Comparer(Integer.valueOf(1), Integer.valueOf(1))),
                Arguments.of(false, "different Integers", new combPackage.Comparer(Integer.valueOf(1), Integer.valueOf(0))),
                Arguments.of(true,  "equal Doubles",      new combPackage.Comparer(Double.valueOf(1), Double.valueOf(1))),
                Arguments.of(false, "different Doubles",  new combPackage.Comparer(Double.valueOf(1), Double.valueOf(0))),
                Arguments.of(true,  "equal Strings",      new combPackage.Comparer("one", "one")),
                Arguments.of(false, "different Strings",  new combPackage.Comparer("one", "onex")),

                Arguments.of(true,  "equal Integer[]",     new combPackage.Comparer(new Integer[]{1,2,3}, new Integer[]{1,2,3})),
                Arguments.of(false, "different Integer[]", new combPackage.Comparer(new Integer[]{1,2,3}, new Integer[]{1,2,9})),
                Arguments.of(true,  "equal Double[]",      new combPackage.Comparer(new Double[]{1d,2d,3d}, new Double[]{1d,2d,3d})),
                Arguments.of(false, "different Double[]",  new combPackage.Comparer(new Double[]{1d,2d,3d}, new Double[]{1d,2d,9d})),
                Arguments.of(true,  "equal String[]",      new combPackage.Comparer(new String[]{"one","two"}, new String[]{"one","two"})),
                Arguments.of(false, "different String[]",  new combPackage.Comparer(new String[]{"one","two"}, new String[]{"one","nope"})),

                Arguments.of(true,  "equal Integer[][]",
                        new combPackage.Comparer(
                                new Integer[][]{new Integer[]{1,2,3},new Integer[]{1,2,3}},
                                new Integer[][]{new Integer[]{1,2,3},new Integer[]{1,2,3}})),
                Arguments.of(false, "different Integer[][]",
                        new combPackage.Comparer(
                                new Integer[][]{new Integer[]{1,2,3},new Integer[]{1,2,3}},
                                new Integer[][]{new Integer[]{1,2,3},new Integer[]{1,2,9}})),
                Arguments.of(true,  "equal Double[][]",
                        new combPackage.Comparer(
                                new Double[][]{new Double[]{1.0d,2.0d,3.0d},new Double[]{1.0d,2.0d,3.0d}},
                                new Double[][]{new Double[]{1.0d,2.0d,3.0d},new Double[]{1.0d,2.0d,3.0d}})),
                Arguments.of(false, "different Double[][]",
                        new combPackage.Comparer(
                                new Double[][]{new Double[]{1.0d,2.0d,3.0d},new Double[]{1.0d,2.0d,3.0d}},
                                new Double[][]{new Double[]{1.0d,2.0d,3.0d},new Double[]{1.0d,2.0d,9.0d}})),
                Arguments.of(true,  "equal String[][]",
                        new combPackage.Comparer(
                                new String[][]{new String[]{"one","two"},new String[]{"one","two"}},
                                new String[][]{new String[]{"one","two"},new String[]{"one","two"}})),
                Arguments.of(false, "different String[][]",
                        new combPackage.Comparer(
                                new String[][]{new String[]{"one","two"},new String[]{"one","two"}},
                                new String[][]{new String[]{"one","two"},new String[]{"one","nope"}}))
        );
    }
}
