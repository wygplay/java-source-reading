package cn.wygplay.java8feature.nashorn;

import org.junit.jupiter.api.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvokeJavaScript {
    @Test
    public void invokeJavaScript() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
    }

    @Test
    public void test() throws ScriptException, NoSuchMethodException {
        String scriptCode = "function sqrt(num) { return num * num }";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(scriptCode);
        Invocable invocable = (Invocable) engine;
        // 执行结果浮点数
        assertEquals(4.0, invocable.invokeFunction("sqrt", 2));
    }

    @Test
    public void invokeJavaScriptFile() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval(new FileReader("res/test.js"));

        Invocable invocable = (Invocable) engine;
        assertEquals("hello world", invocable.invokeFunction("hello", null));

    }
}
