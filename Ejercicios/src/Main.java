import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) {


        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String infix = "3+2*(4+5)";
        try {
            System.out.println(engine.eval(infix));
        } catch (ScriptException e) {
            System.out.println("error");
        }


    }
}