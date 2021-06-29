/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extern;

import java.io.IOException;
import java.io.ObjectInput;

/**
 *
 * @author Pikachu
 */
public class PreventOverExtern {
    private final Object lock = new Object();
    private boolean initialized = false;
    private String name;
    private int UID;
 
public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    synchronized (lock) {
        if (!initialized) {
            // Read instance fields
            this.name = (String) in.readObject();
            this.UID = in.readInt();
            // ... 
            initialized = true;
        } else {
            throw new IllegalStateException();
        }
    }
}
}

