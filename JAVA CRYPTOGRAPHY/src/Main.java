public class Main {

    public static void main(String... args) {

        PersonAccount john = new PersonAccount();
        PersonAccount jack = new PersonAccount();

        // John adds the new friend Jack
        //john.addFriend("JACK", jack.getPublicKey());

        // Jack adds the new friend John
        jack.addFriend("JOHN", john.getPublicKey());

        // Jack sends a message to John
        String encryptedMessage = jack.sendMessage("JOHN",
                "Hello John, how are you doing?");
        System.out.println("Sent encrypted message: " + encryptedMessage);

        // John reads the message
        String decryptedMessage = john.receiveMessage(encryptedMessage);
        System.out.println("Decrypted received message: " + decryptedMessage);
    }
}
