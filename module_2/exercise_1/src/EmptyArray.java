import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        AVG elem = new AVG();
        elem.main();
    }
}

class EmptyArray extends Exception {
    List<String> messages;
    EmptyArray() {}
    EmptyArray(List<String> messages) {
        this.messages = messages;
        print();
    }

    void print() {
        for (String message : this.messages) {
            System.out.println(message);
        }
    }
}

class AVG {
    String suffix(int i) {
        int n = i + 1;
        if (n % 100 >= 11 && n % 100 <= 13) return n + "-th";
        switch (n % 10) {
            case 1: return n + "-st";
            case 2: return n + "-nd";
            case 3: return n + "-rd";
            default: return n + "-th";
        }
    }

    float avg(int[] nums) throws EmptyArray { // 1
        int sum = 0;
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                String message = "The " + suffix(i) + "-th number " + String.valueOf(nums[i]) + " in your array is invalid";
                messages.add(message);
            }
        }
        if (!messages.isEmpty()) {
            throw new EmptyArray(messages);
        }
        if (nums == null || nums.length == 0)
            throw new EmptyArray(); // 2
        for(int n: nums) sum += n;
        return (float) sum / nums.length;
    }

    void main() {
        int[] nums = new int[] { 1, 2, -4 };
        Float result;
        try { result = avg(nums);
        System.out.println(result);} // 3
        catch(EmptyArray e) {} // 3
    }
}