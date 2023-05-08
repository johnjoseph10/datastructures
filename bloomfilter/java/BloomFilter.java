import java.util.BitSet;
import java.util.Random;

public class BloomFilter {
    private final int size;
    private final int[] hashSeeds;
    private final BitSet bitArray;

    public BloomFilter(int size, int[] hashSeeds) {
        this.size = size;
        this.hashSeeds = hashSeeds;
        this.bitArray = new BitSet(size);
    }

    public void add(String element) {
        for (int seed : hashSeeds) {
            int index = hash(element, seed);
            bitArray.set(index);
        }
    }

    public boolean contains(String element) {
        for (int seed : hashSeeds) {
            int index = hash(element, seed);
            if (!bitArray.get(index)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int seed) {
        int hash = seed;
        for (char c : element.toCharArray()) {
            hash = hash * 31 + c;
        }
        return Math.abs(hash % size);
    }

    public static void main(String[] args) {
        // Create a Bloom filter with a size of 100 and two hash functions
        BloomFilter bloomFilter = new BloomFilter(100, new int[]{3, 5});

        // Add some elements to the filter
        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("cherry");

        // Test if some elements are in the filter
        System.out.println("Is apple in the filter? " + bloomFilter.contains("apple"));    // true
        System.out.println("Is banana in the filter? " + bloomFilter.contains("banana"));  // true
        System.out.println("Is cherry in the filter? " + bloomFilter.contains("cherry"));  // true
        System.out.println("Is date in the filter? " + bloomFilter.contains("date"));      // false

        // Generate 10 random strings and check if they are in the filter
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String randomString = String.valueOf(random.nextInt(100));
            System.out.println("Is " + randomString + " in the filter? " + bloomFilter.contains(randomString));
        }
    }
}

