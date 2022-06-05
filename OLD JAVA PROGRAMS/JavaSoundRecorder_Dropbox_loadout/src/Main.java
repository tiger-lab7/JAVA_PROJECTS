import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class Main {

    public static void main(String[] args) {

       String ACCESS_TOKEN = "Rzrrq-uUHNAAAAAAAAAAAWg8qvrnO-N5R0diZ2bJUU5zwP98KLjVr-RI2jpB8P71";

       DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
       DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

       JavaSoundRecorder recorder = new JavaSoundRecorder(client);
       recorder.recordAudio(10000);

    }
}
