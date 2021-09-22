/**
 * Tests for class Finder.
 *
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class BasicTest {

    @Test
    public final void basicTest() throws IOException {

        byte data[] = {123,1,112};
        FileOutputStream out = new FileOutputStream("first-test-file");
        out.write(data);
        out.close();

        data[0] = 122;
        out = new FileOutputStream("second-test-file");
        out.write(data);
        out.close();

        data[0] = 121;
        out = new FileOutputStream("third-test-file");
        out.write(data);
        out.close();

        MagnetLink magnetLink = new MagnetLink("./first-test-file");

        MagnetLink magnetLink2 = new MagnetLink("./second-test-file");

        MagnetLink magnetLink3 = new MagnetLink("./third-test-file");

        assertTrue(magnetLink.getMagnetLink().equals("magnet:?xt=urn:btih:14d411991f6c2fe5bb5de3b78c5a02bdbe24fcd18e235257d6cab1d0cadf2b79&xl:3&dn:first-test-file"));
        assertTrue(magnetLink2.getMagnetLink().equals("magnet:?xt=urn:btih:916e699925743360209adc288ce979837680ab83410d5bf30f1bff792d50275d&xl:3&dn:second-test-file"));
        assertTrue(magnetLink3.getMagnetLink().equals("magnet:?xt=urn:btih:d1ffbb1e55b0bf4c35dfb8dea44afb22c4f9281cf85d28ba19572ae88438b3c1&xl:3&dn:third-test-file"));

    }
}