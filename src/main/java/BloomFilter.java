public class BloomFilter {
    public int filter_len;
    private int number;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        number = 0;

    }

    public int hash1(String str1) {
        int hash = 0;
        int a = 17;
        for (int i = 0; i < str1.length(); i++) {
            hash = (hash * a + (int) str1.charAt(i)) % filter_len;
        }
        return hash;
    }

    public int hash2(String str1) {
        int hash = 0;
        int a = 223;
        for (int i = 0; i < str1.length(); i++) {
            hash = (hash * a + (int) str1.charAt(i)) % filter_len;
        }
        return hash;
    }

    public void add(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);
        setBit(hash1);
        setBit(hash2);
    }

    public boolean isValue(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);
        return getBit(hash1) && getBit(hash2);
    }

    private void setBit(int hash) {
        int bitOffset = 1 << hash;
        number |= bitOffset;
    }

    private boolean getBit(int hash) {
        int bitOffset = 1 << hash;
        return (number & bitOffset) != 0;
    }
}

