package combinatorics.operations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LexMinRotationOpTest {
    @ParameterizedTest
    @MethodSource("getTestParameters")
    public void returnsLexicographicallyMinimalRotation(String comment, Integer[] input, Integer[] expectedOutput) {
        LexMinRotationOp operation = new LexMinRotationOp();
        operation.setInput(input);
        Integer[] output = operation.operateTypeIntegerArray(new Integer[]{});
        assertThat(output).as(comment).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> getTestParameters() {
        return Stream.of(
            Arguments.of("list of equal values are unchanged", new Integer[]{1,1,1}, new Integer[]{1,1,1}),
            Arguments.of("decreasing lists are rotated right once", new Integer[]{3,2,1}, new Integer[]{1,3,2}),
            Arguments.of("the empty list is returned", new Integer[]{}, new Integer[]{}),
            Arguments.of("a list with one item is returned", new Integer[]{1}, new Integer[]{1})
        );
    }
}