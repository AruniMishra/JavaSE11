import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public void myPublic() {
    }

    private void myPrivate() {
    }



    public static void main(String[] args)  {
        Main ob = new Main();
        Method method = null;
        try {
            method = ob.getClass().getDeclaredMethod("myPrivate");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            method.invoke(ob);
            System.out.println("method invoked");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}