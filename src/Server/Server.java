package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server implements Hello {

    public Server() {
    }

    public String sayHello(){
        return "hello beautiful world";
    }

    public static void main(String args[]){
        Hello stub = null;
        Registry registry = null;

        try {
            Server obj = new Server();
            stub = (Hello) UnicastRemoteObject.exportObject(obj,0);
            registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            System.err.println("System ready.");

        } catch (Exception e){
            System.err.println("Server exception:"+e.toString());
            e.printStackTrace();
        }
    }
}
