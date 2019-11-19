package con.dalong;

import org.graalvm.polyglot.*;

/**
 * @author dalong
 */
public class Application {
    /**
     * main  for test graalvm exec js
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello Java!");
        try (Context context = Context.create()) {
            context.eval("js", "print('Hello JavaScript!');");
        }
    }
}

