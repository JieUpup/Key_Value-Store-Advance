import java.rmi.Naming;

public class KeyValueStoreCmd {
    public static Logger logger = new Logger("client.log");


    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("usage: cmd <op> <key> [<value>]");
            System.exit(-1);
        }

        // input parameter is not valid
        if (!DBCommandParser.validateCommandInArray(args, logger)) {
            System.exit(-1);
        }

        String op = args[0].toUpperCase();
        try {
            KeyValueStore keyValueStore = (KeyValueStore) Naming.lookup("rmi://localhost/KeyValueStoreService");
            if (op.equals("PUT")) {
                String ret = keyValueStore.put(args[1], args[2]);
                logger.debugLog("PUT key:" + args[1] + ",value:" + args[2] + ". ret:" + ret);
            } else if (op.equals("GET")) {
                String ret = keyValueStore.get(args[1]);
                logger.debugLog("GET key:" + args[1] +  ". ret:" + ret);
            } else if (op.equals("DELETE")) {
                String ret = keyValueStore.delete(args[1]);
                logger.debugLog("DELETE key:" + args[1] +  ". ret:" + ret);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
