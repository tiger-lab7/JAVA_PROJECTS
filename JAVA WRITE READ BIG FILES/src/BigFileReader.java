import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BigFileReader {
    private final File bigFile;

    public BigFileReader(File bigFile) {
        this.bigFile = bigFile;
    }

    public long readFile() throws IOException {
        long i = 0;
        int result = -1;
        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(bigFile), Properties.BUFFER_SIZE)) {
            byte[] bytes = new byte[Properties.MB1];
            while (result != 0) {
                result = bis.readNBytes(bytes, 0, Properties.MB1);
                if (result != 0) {
                    Util.messageDigest.update(bytes);
                    i++;
                }
            }
        }
        return i;
    }
}
