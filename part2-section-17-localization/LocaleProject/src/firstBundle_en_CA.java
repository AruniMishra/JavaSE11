/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  ListResourceBundle
*/

import java.util.ListResourceBundle;

public class firstBundle_en_CA extends ListResourceBundle {

    protected Object[][] getContents() {
        return new Object[][]{
                {"yes", "Yea"},
                {"no", "Nah"},
                {"unsure", "Not sure!"}
        };
    }
}
