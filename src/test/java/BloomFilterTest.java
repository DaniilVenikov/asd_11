import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BloomFilterTest {
    BloomFilter bloomFilter = new BloomFilter(32);

    @Before
    public void setUp() {
        bloomFilter.add("0123456789");
        bloomFilter.add("1234567890");
        bloomFilter.add("2345678901");
        bloomFilter.add("3456789012");
        bloomFilter.add("4567890123");
        bloomFilter.add("5678901234");
        bloomFilter.add("6789012345");
        bloomFilter.add("7890123456");
        bloomFilter.add("8901234567");
        bloomFilter.add("9012345678");
    }
    @Test
    public void testAddAndIsValue() {
        assertTrue(bloomFilter.isValue("0123456789"));
        assertTrue(bloomFilter.isValue("6789012345"));
    }

    @Test
    public void testIsValueForNonAddedString() {
        assertFalse(bloomFilter.isValue("9012345670"));
        assertFalse(bloomFilter.isValue("0000000000"));
        assertFalse(bloomFilter.isValue("9999999999"));
    }

    @Test
    public void testHash1() {
        int hashValue = bloomFilter.hash1("0123456789");
        assertEquals(13, hashValue);
    }

    @Test
    public void testHash2() {
        int hashValue = bloomFilter.hash2("0123456789");
        assertEquals(5, hashValue);
    }
}
