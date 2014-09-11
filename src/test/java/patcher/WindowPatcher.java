package patcher;

import com.google.gwt.user.client.Window;
import com.googlecode.gwt.test.patchers.PatchClass;
import com.googlecode.gwt.test.patchers.PatchMethod;

/**
 * Created by Andrienko Alexander on 11.09.14.
 */
@PatchClass(Window.class)
public class WindowPatcher {

    @PatchMethod(override = true)
    public static void alert(String message) {
        System.out.println("Window alert with message '" + message + "' done.");
    }
}
