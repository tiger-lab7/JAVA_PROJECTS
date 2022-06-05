import java.io.*;
import java.util.Random;

public class BigFileCreator {
    private File bigFile;

    public BigFileCreator(File bigFile) {
        this.bigFile = bigFile;
    }

    // Writes random byte array to a file with provided size and return number
    // of successful megabytes that has been written
    public long createFile(long sizeInMb) throws IOException {

        try (BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(bigFile), Properties.BUFFER_SIZE)) {
            Random random = new Random();
            byte[] bytes = new byte[Properties.MB1];
            //Arrays.fill(bytes, (byte) 1);

            for (long i = 0; i < sizeInMb; i++) {
                random.nextBytes(bytes); // Special method to fill a bytes array with a random bytes sequence
                bos.write(bytes);
                Util.messageDigest.update(bytes);
            }
        }
        return sizeInMb;
    }
}
