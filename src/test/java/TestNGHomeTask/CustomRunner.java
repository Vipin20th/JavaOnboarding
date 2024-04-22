package TestNGHomeTask;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class CustomRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] {CalculatorTest.class});

        // Adding custom listener
        testNG.addListener(new CustomListener());

        testNG.run();
    }
}

