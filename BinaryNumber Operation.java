import java.util.Arrays;



class BinaryNumber {
    private int[] data;
    private int length;

    
    public BinaryNumber(int length) {
        this.length = length;
        this.data = new int[length];
    }
    
    public BinaryNumber(String str) {
        this.length = str.length();
        this.data = new int[this.length];
        for (int i = 0; i < this.length; i++) {
            data[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    public int getLength() {
        return length;
    }

    public int getDigit(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return data[index];
    }

    public int[] getData() {
        return data;
    }

    public int toDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < length; i++) {
            decimalValue += data[length - 1 - i] * Math.pow(2, i);
        }
        return decimalValue;
    }

    public void shiftR(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Shift amount cannot be negative.");
        }
        int[] newData = new int[length];
        for (int i = 0; i < length - amount; i++) {
            newData[i + amount] = data[i];
        }
        this.data = newData;
    }

    public void add(BinaryNumber other) {
        int maxLength = Math.max(this.length, other.length);
        int carry = 0;
        int[] result = new int[maxLength + 1];

        for (int i = 0; i < maxLength; i++) {
            int a = i < this.length ? this.data[this.length - 1 - i] : 0;
            int b = i < other.length ? other.data[other.length - 1 - i] : 0;
            int sum = a + b + carry;
            result[maxLength - i] = sum % 2;
            carry = sum / 2;
        }
        result[0] = carry;

        if (result[0] == 0) {
            this.data = Arrays.copyOfRange(result, 1, result.length);
        } else {
            this.data = result;
        }
        this.length = this.data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int bit : data) {
            sb.append(bit);
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        
        BinaryNumber binaryNumber = new BinaryNumber(9);
        System.out.println("The output of length 9 and consisting only of zeros is: " + binaryNumber + "\n");

       
        BinaryNumber binaryNumber1 = new BinaryNumber("11101");
        System.out.println("Initialized binary number is: " + Arrays.toString(binaryNumber1.getData()) + "\n");

       
        System.out.println("The length of binary number 11101 is: " + binaryNumber1.getLength() + "\n");

       
        System.out.println("The 4th digit in the binary number is: " + binaryNumber1.getDigit(3) + "\n");

        System.out.println("The binary number 11101 in decimal form is: " + binaryNumber1.toDecimal() + "\n");

       
        binaryNumber1.shiftR(2);
        System.out.println("Binary number after right shift operation is: " + binaryNumber1 + "\n");

        
        BinaryNumber binaryAddition1 = new BinaryNumber("10110");
        BinaryNumber binaryAddition2 = new BinaryNumber("11100");

       
        binaryAddition1.add(binaryAddition2);
        System.out.println("Binary addition of 10110 and 11100 is: " + binaryAddition1);
    }
}
