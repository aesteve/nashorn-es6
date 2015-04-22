package nashorn.es6.tests;

import org.junit.Test;

public class SimpleClass extends BaseTest {
    @Test
    public void readSimpleClassFile() throws Exception {
        nashorn.eval(getScript("hello-world.js"));
        nashorn.eval("var greeter = new HelloWorld('Snoop');");
        System.out.println(nashorn.eval("greeter.greet();"));
    }
}
