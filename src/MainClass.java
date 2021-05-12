public class MainClass {

    public static void main(String[] args){
        Encryptor enc = new Encryptor("ENCRYPTION TEST");
        enc.encryptROT13();
        String encr = enc.getEncryptedText();
        System.out.println(encr);
        ActionEventDemo aed = new ActionEventDemo();

        /*swingTest st = new swingTest();
        st.createWindow();*/



    }


}
