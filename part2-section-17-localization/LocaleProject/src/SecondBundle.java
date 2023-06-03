
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  ListResourceBundle
*/

import java.util.ListResourceBundle;

public class SecondBundle extends ListResourceBundle {

    protected Object[][] getContents() {
        return new Object[][]{
                {"default", "Yes"},
                {"synonyms", new String[]{"Yea", "Yep", "Sure", "Of course"}},
                {"jane", new Employee("Jane", "HR", "Manager")},
                {"age", 40}
        };
    }
}
