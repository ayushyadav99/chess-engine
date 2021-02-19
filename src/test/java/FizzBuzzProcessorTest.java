import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzProcessorTest {
    @Test
    public void Normal() {
        Assertions.assertEquals("1", FizzBuzzProcessor.convert(1));
    }

    @Test
    public void FizzBuzzThreeNumbers() {
        Assertions.assertEquals("Fizz", FizzBuzzProcessor.convert(3));
    }

    @Test
    public void FizzBuzzFiveNumbers() {
        Assertions.assertEquals("Buzz", FizzBuzzProcessor.convert(5));
    }

    @Test
    public void FizzBuzzThreeAndFiveNumbers() {
        Assertions.assertEquals("Buzz", FizzBuzzProcessor.convert(5));
    }
}