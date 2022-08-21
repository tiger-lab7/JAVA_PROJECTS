import java.nio.ByteBuffer;

public class WrapMethod {


    public static void main(String[] args) {

        byte[] arr = {123, 12, 54, 67, 7, 32, 23};
        ByteBuffer byteBuffer = ByteBuffer.wrap(arr);

        System.out.println("Initial buffer: " + byteBuffer);
        System.out.println("Read first byte: " + byteBuffer.get());
        System.out.println("New buffer state: " + byteBuffer);
        System.out.println("Second read: " + byteBuffer.get());
        System.out.println("New buffer state: " + byteBuffer);
        System.out.println("Double read: " + byteBuffer.getDouble());
        System.out.println("New buffer state: " + byteBuffer);

    }
}
