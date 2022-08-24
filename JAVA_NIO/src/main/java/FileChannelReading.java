import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class FileChannelReading {
    private static int bufferCapacity = 48;

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open(Path.of("src/main/resources/testfile.txt"));
        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferCapacity);

        StringBuilder stringBuilder = new StringBuilder();
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            stringBuilder.delete(0, stringBuilder.length());
            for (int i = 0; i < byteBuffer.limit(); i++) {
                stringBuilder.append((char)byteBuffer.get());
            }
            System.out.println(stringBuilder);
            byteBuffer.clear();
        }
    }
}
