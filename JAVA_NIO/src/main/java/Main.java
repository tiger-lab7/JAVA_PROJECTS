import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        System.out.println(byteBuffer.capacity() + " " + byteBuffer.limit() + " " + byteBuffer.position());
        System.out.println(byteBuffer);
    }
}
