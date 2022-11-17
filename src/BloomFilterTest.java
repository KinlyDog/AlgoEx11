import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    BloomFilter bf = new BloomFilter(32);
    String str = "0123456789";

    BloomFilterTest() {
    }

    @Test
    void add() {
        for (int i = 0; i < 10; ++i) {
            String var10001 = str.substring(1);
            str = var10001 + str.charAt(0);
            bf.add(str);
        }

    }

    @Test
    void isValue() {
        new Random();

        for (int j = 0; j < 10; ++j) {
            String tmp = str.substring(1);
            str = tmp + str.charAt(0);
            bf.add(str);
        }

        for (int j = 0; j < 10; ++j) {
            String tmp = str.substring(1);
            str = tmp + str.charAt(0);
            assertTrue(bf.isValue(str));
        }

    }
}