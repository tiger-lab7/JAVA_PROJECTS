import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileChannelReading {
    private static int bufferCapacity = 48;

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open(Path.of("src/main/resources/testfile.txt"));
        ByteBuffer textBuffer = ByteBuffer.allocate(bufferCapacity);

        int bytesReadCount = 0;

        while (bytesReadCount != 1) {
            bytesReadCount = fileChannel.read(textBuffer);
            System.out.println(bytesReadCount);
            System.out.println(new String(textBuffer.array(), StandardCharsets.UTF_8));
            textBuffer.flip();
        }

    }

    static boolean bufferFull(int bytesRead) {
        return bytesRead < bufferCapacity;
    }

}
