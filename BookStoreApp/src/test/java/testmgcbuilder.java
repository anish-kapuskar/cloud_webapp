import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class testmgcbuilder {

    @Test
    public void testLucky() {
        Assertions.assertEquals(7, mgcbuilder.getLucky());
    }


}
