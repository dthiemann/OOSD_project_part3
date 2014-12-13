package org.uiowa.cs2820.engine;

import java.io.IOException;

/**
 * Main class.
 *
 */

public class rClient {
    // Base URI the client will use
    public static final String BASE_URI = "http://webdev.cs.uiowa.edu/~hmmnd/";
    public static final String BASE_PATH = "~hmmnd";

    public static void main(String[] args) throws IOException {
        new MyClient(BASE_URI,BASE_PATH);
    }
}
