import java.lang.reflect.Method;

public class DiscordBurpTest {
    public static void main(String[] args) {
        try {
            Method main =  Class.forName("burp.StartBurp").getMethod("main", String[].class);
            main.invoke(null, (Object) args);
        } catch (Exception e){
            System.err.println("Cant find Burp in the defined path");
        }
    }
}
