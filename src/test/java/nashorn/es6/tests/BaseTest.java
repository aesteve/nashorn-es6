package nashorn.es6.tests;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Before;

public class BaseTest {

    protected ScriptEngine nashorn;

    @Before
    public void prepareEngine() throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        nashorn = mgr.getEngineByName("nashorn");
        nashorn.eval(getScript("nashorn-polyfill.js"));
        nashorn.eval(getScript("es6-shim.js"));
    }

    protected void readScript(String scriptPath) throws Exception {
        new String(Files.readAllBytes(Paths.get(getClass().getResource(scriptPath).toURI())));
    }

    protected Reader getScript(String path) {
        return new InputStreamReader(BaseTest.class.getClassLoader().getResourceAsStream(path));
    }

}
