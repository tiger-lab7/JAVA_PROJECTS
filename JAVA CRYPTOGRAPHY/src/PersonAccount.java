import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class PersonAccount {
    // contains list of friends names and its own public keys
    private final Map<String, PublicKey> contacts = new HashMap<>();
    // for reading encrypted messages only by this person
    private PrivateKey privateKey;
    // broadcasting key for friends who wants send the message to this person
    private PublicKey publicKey;
    // size of key for the encrypting
    private final int KEY_SIZE = 1024;

    public PersonAccount() {
        generateKeyPair();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator =
                    KeyPairGenerator.getInstance("RSA");

            keyPairGenerator.initialize(KEY_SIZE);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();

        } catch (java.security.NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void addFriend(final String name, final PublicKey publicKey) {

        contacts.put(name, publicKey);
    }

    public String receiveMessage(final String cipherMessage) {
        byte[] encryptedMessage = Base64.getDecoder().decode(cipherMessage);

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

            return new String(decryptedMessage, StandardCharsets.UTF_8);

        } catch (java.security.NoSuchAlgorithmException
                | javax.crypto.NoSuchPaddingException
                | java.security.InvalidKeyException
                | javax.crypto.IllegalBlockSizeException
                | javax.crypto.BadPaddingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String sendMessage(final String recipient, final String message) {
        PublicKey recipientPublicKey = contacts.get(recipient);

        if (publicKey == null) throw new RuntimeException("Unknown recipient!");

        try {
            byte[] decryptedMessage = message.getBytes("UTF-8");

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, recipientPublicKey);

            byte[] encryptedMessage = cipher.doFinal(decryptedMessage);

            return Base64.getEncoder().encodeToString(encryptedMessage);

        } catch (java.security.NoSuchAlgorithmException
                | javax.crypto.NoSuchPaddingException
                | java.security.InvalidKeyException
                | java.io.UnsupportedEncodingException
                | javax.crypto.IllegalBlockSizeException
                | javax.crypto.BadPaddingException ex) {
            throw new RuntimeException(ex);
        }
    }

}
