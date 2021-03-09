package ru.thever4;

import ru.thever4.forms.components.*;
import ru.thever4.forms.layouts.*;

public class Main {

    public static void main(String[] args) {

        Frame frame = new Frame("Login",
                new HorizontalLayout(
                        new VerticalLayout(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(
                                        new Rectangle(new Text("Ok")),
                                        new Rectangle(new Text("Cancel"))
                                )
                        ),
                        new Frame("Help",
                                new VerticalLayout(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")
                                )
                        )
                )
        );
        System.out.println(frame);
    }
}
