import com.dropbox.core.v2.DbxClientV2;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class JavaSoundRecorder {

    private DbxClientV2 client;
    private AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    private AudioFormat format;
    private TargetDataLine line;
    private DataLine.Info info;

    // Конструктор, одноименный с классом, запускается при создании объекта
    public JavaSoundRecorder (DbxClientV2 client) {
        this.client = client;
        this.format = getAudioFormat();
        this.info = new DataLine.Info(TargetDataLine.class, format);
    }

    // Управляющий метод
    public void recordAudio (int milliseconds) {
        //TODO: File name look like 20201023_173412.wav
        //Use: SimpleDateFormat
        String filePath = "D:/Record.wav";
        File file = new File (filePath);
        start (file);
        stop (milliseconds);


    }

    private void start (File file) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // checks if system supports the data line
                    if (!AudioSystem.isLineSupported(info)) {
                        System.out.println("Line not supported");
                        System.exit(0);
                    }
                    System.out.println("Идет запись звука!");
                    line = (TargetDataLine) AudioSystem.getLine(info);
                    line.open(format);
                    line.start();   // start capturing
                    AudioInputStream ais = new AudioInputStream(line);
                    AudioSystem.write(ais, fileType, file); // start recording
                } catch (Exception ex) { ex.printStackTrace(); }
            }
        };
        thread.start();
    }


    private void stop(int milliseconds) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(milliseconds);
                    line.stop();
                    line.close();
                    //recordAudio(milliseconds);
                    //TODO: Upload file to Dropbox
                    //TODO: Remove file from PC
                    System.out.println("Запись остановлена");
                    uploader();
                } catch (Exception ex) { ex.printStackTrace(); }
            }
        };
        thread.start();
    }

    // Upload "Record.wav" to Dropbox
    private void uploader() {
        System.out.println("Метод загрузки вызван!");
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Метод загрузки вызван!");
                    InputStream in = new FileInputStream("D:/Record.wav");
                    client.files().uploadBuilder("/Record.wav").uploadAndFinish(in);
                    System.out.println("Загрузка завершена!");

                } catch (Exception ex) {ex.printStackTrace();}
            }
        };
        thread.start();

    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(   sampleRate,
                                                sampleSizeInBits,
                                                channels,
                                                signed,
                                                bigEndian);
        return format;
    }
}
