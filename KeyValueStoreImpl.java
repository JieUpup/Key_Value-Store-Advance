import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class KeyValueStoreImpl extends UnicastRemoteObject implements KeyValueStore {

    private static Database database = new Database();
    protected KeyValueStoreImpl() throws RemoteException {
        super();
    }

    @Override
    public String put(String key, String value) throws RemoteException {
        //return database.put(key, value);
        return database.put(key, value);
    }

    @Override
    public String delete(String key) throws RemoteException {
        return database.delete(key);
    }

    @Override
    public String get(String key) throws RemoteException {
        return database.get(key);
    }

}
