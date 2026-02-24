import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //Кратно 3, возвращать 'T'
    //Кратно 5, возвращать 'M'
    //Кратно 3 И 5, возвращать 'S'
    //Возвращать 'FAIL'
    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "S";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "FAIL";
    }

    @Test
    public void checkMethod() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "S");
    }

    @Test
    public void checkMethod1() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkMethod2() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkMethod3() {
        String actualResult = trialCode(1);
        assertEquals(actualResult, "FAIL");
    }
}
