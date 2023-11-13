import java.rmi.Naming;

public class KeyValueStoreClient {
    public static void main(String[] args) {
        try {
            KeyValueStore keyValueStore = (KeyValueStore) Naming.lookup("rmi://localhost/KeyValueStoreService");

            for (int i = 0; i < 10; i++) {
                System.out.println(keyValueStore.put("key" + i, "value" + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}