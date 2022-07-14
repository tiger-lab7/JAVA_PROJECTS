import lombok.Lombok;
import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {
        //new TestSneaky().run();

        System.out.println(new TestSneaky2()
                .utfToString(new byte[] {0b01000011, 0b01100001, 0b01010100, 0b01100001}));
    }
}


class TestSneaky implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        throw new Throwable("Critical exception");
    }
}

class TestSneaky2 {

    public String utfToString(byte[] byteStr) {
        try {
            return new String(byteStr, "UTF-8"); // If 2 arg is string, not StandardCharsets.UTF_8
        } catch (UnsupportedEncodingException ex) {
            throw Lombok.sneakyThrow(ex);
        }
    }
}