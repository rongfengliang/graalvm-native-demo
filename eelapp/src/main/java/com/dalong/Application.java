package com.dalong;

//import org.apache.commons.jexl.Expression;
//import org.apache.commons.jexl.ExpressionFactory;
//import org.apache.commons.jexl.JexlHelper;
import org.apache.commons.jexl3.*;

public class Application {
    public static void main(String[] args) throws Exception {
       //elDemo();
       // appdemo();
       appdemo2();
    }


    // for exec expression
    public static void appdemo2(){
        JexlEngine jexl = new JexlBuilder().create();
        String conent = "pereson ${size(person.name)} and ${person.age}";
        String jexlExp =  "`"+conent+"`";

        JexlScript jexlExpression = jexl.createScript(jexlExp);
        JexlContext jexlContext = new MapContext();
        Person person = new Person("aaa", "20");
        jexlContext.set("person", person);
        jexlContext.set("name","dddd");
        Object o = jexlExpression.execute(jexlContext);
        System.out.println(o);
    }

    // for exec script
    public static void appdemo(){
        JexlEngine jexl = new JexlBuilder().create();
        String jexlExp = "// this is a content \r\n"
                + "name=\"daloddddddddng\";\r\n"
                + "age=\"33333\"; \r\n"
                + "person.setName(name);\r\n"
                + "person.setAge(age);\r\n"
                + "person.getName();"
                + "person.getAge();";

        JexlScript jexlExpression = jexl.createScript(jexlExp);
        JexlContext jexlContext = new MapContext();
        Person person = new Person("aaa", "20");
        jexlContext.set("person", person);
        jexlContext.set("name","dddd");
        Object o = jexlExpression.execute(jexlContext);
        System.out.println(o);
    }
//    public  static void elDemo() throws Exception {
//        Opera opera = new Opera( );
//        opera.setName("The Magic Flute");
//        opera.setComposer("Mozart");
//        opera.setYear(1791);
//
//        String expr =
//                "${opera.name} was composed by ${opera.composer} in " +
//                        "${opera.year}.";
//
//        Expression e = ExpressionFactory.createExpression(expr);
//        org.apache.commons.jexl.JexlContext jc = JexlHelper.createContext( );
//        jc.getVars( ).put("opera", opera);
//        String message = (String) e.evaluate(jc);
//
//        System.out.println( message );
//    }
}
