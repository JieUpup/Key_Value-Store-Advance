import java.util.concurrent.ConcurrentHashMap;

public class Database {
    // Concurrent HashMap to support multi-thread
    private static final Logger logger = new Logger("server.log");
    private ConcurrentHashMap<String, String> store;

    public Database() {
        this.store = new ConcurrentHashMap<>();
    }

    /*
     *  Return success when everything went well
     */
    public synchronized String put(String key, String value) {
        logger.debugLog("put key:" + key +  ",value:" + value);
        return store.put(key, value);
    }

    public synchronized String delete(String key) {
        logger.debugLog("delete key:" + key);

        return store.remove(key);
    }

    public synchronized String get(String key) {
        logger.debugLog("get key:" + key);

        if (!store.containsKey(key)) {

            return  "Key not existed";
        }

        String ret = store.get(key);

        return ret;
    }
}
