package csc202.FinalProject.util;

import org.junit.Test;

public class ValidationTest {
    @Test
    public void isEmailFormat() throws Exception {
        String base = "hello";

        for (int i = 33; i<=122;i++ ) {
            System.out.println(Character.toString((char)i));
            base = "hello";
            base = Character.toString((char)i)+base;
            System.out.println("The value of " + base + " is " + Validation.isEmailFormat(base));

        }

        System.out.println("last one " + Validation.isEmailFormat("www1234.343@"));
    }

    @Test
    public void hasUppercase() throws Exception {
        String base = "hello";

        for (int i = 33; i<=122;i++ ) {
            System.out.println(Character.toString((char)i));
            base = "hello";
            base += Character.toString((char)i);
            System.out.println("The value of " + base + " is " + Validation.hasUppercase(base));

        }
    }

    @Test
    public void hasLowercase() throws Exception {
        String base = "HELLO";

        for (int i = 33; i<=123;i++ ) {
            System.out.println(Character.toString((char)i));
            base = "HELLO";
            base += Character.toString((char)i);
            System.out.println("The value of " + base + " is " + Validation.hasLowercase(base));

        }
    }

    @Test
    public void hasSpecialCharacter() throws Exception {
        String base = "hello";

        for (int i = 33; i<=122;i++ ) {
            System.out.println(Character.toString((char)i));
            base = "hello";
            base += Character.toString((char)i);
            System.out.println("The value of " + base + " is " + Validation.hasSpecialCharacter(base));

        }
    }

    @Test
    public void hasDecimal() throws Exception {
        String base = "hello";

        for (int i = 48; i<=122;i++ ) {
            System.out.println(Character.toString((char)i));
            base = "hello";
            base += Character.toString((char)i);
            System.out.println("The value of " + base + " is " + Validation.hasDecimal(base));

        }
    }

}