import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseInputStreamTest {

    @Test
    public void testLowerCaseDecorator() {
        int c,i=0;
        char[] result = new char[26];
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            while((c = in.read()) >= 0) {
                result[i++]=(char)c;
            }
            assertEquals("this is in capital letters", String.valueOf(result));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}