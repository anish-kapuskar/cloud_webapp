import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class testmsgbuilder {

    @Test
    public void testHelloWorld() {
        Assertions.assertEquals("hello world", msgbuilder.getHelloWorld());
    }

    @Test
    public void testNumber10() {
        assertEquals(10, msgbuilder.getNumber10());
    }

}
