import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {

        File bigFile = new File(Properties.PATH);

        BigFileCreator bfc = new BigFileCreator(bigFile);
        bfc.createFile(Properties.FILE_SIZE);
        Util.logger.info(String.format("Hash of the created file: %x",
                new BigInteger(1, Util.messageDigest.digest())));
        Util.messageDigest.reset();

        BigFileReader bfr = new BigFileReader(bigFile);
        Util.logger.info(bfr.readFile() + "*" + Properties.MB1 + " bytes successfully read");
        Util.logger.info(String.format("Hash of the read file: %x",
                new BigInteger(1, Util.messageDigest.digest())));

        Util.logger.info(bigFile.delete()? "File has been deleted" : "File has not been deleted");
    }
}
