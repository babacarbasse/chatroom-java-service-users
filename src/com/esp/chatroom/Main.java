package com.esp.chatroom;

import java.rmi.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

public class Main {
	
	public static void main(String[] args) {
		try {
			// dynamic launch of the RMI name register
			LocateRegistry.createRegistry(1099);
			// instantiation of an object of the remote class
			ChatRoomUserImp chatRoomImpl = new ChatRoomUserImp();
			// registration in the RMI name register
			// String url = "rmi: //" + InetAddress.getLocalHost (). GetHostAddress () + "/users";
			// System.out.println("Saving the object with : : " + url);
			Naming.rebind("users", chatRoomImpl);
			System.out.println("server start");
		}catch(RemoteException e){
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
