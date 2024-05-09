package cn.wygplay.java8feature.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NashornTest {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval(new FileReader("/test.js"));

        Invocable invocable = (Invocable) engine;
        System.out.println(invocable.invokeFunction("hello", null));
    }
}
