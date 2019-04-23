package com.esp.chatroom;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ChatRoomUserImp extends UnicastRemoteObject implements ChatRoomUser {

	private static final long serialVersionUID = -4174498417430362926L;
	ArrayList<String> utilisateurs;

	protected ChatRoomUserImp() throws RemoteException {
		super();
		utilisateurs = new ArrayList<String>();
	}
	
	@Override
	public ArrayList<String> subscribe(String pseudo) throws RemoteException {
		if(utilisateurs.indexOf(pseudo) == -1) {
			utilisateurs.add(pseudo);
		}
		System.out.println("new user " + pseudo);
		return this.utilisateurs;
	}


	@Override
	public ArrayList<String> unsubscribe(String pseudo) throws RemoteException {
		String message = pseudo + " disconnected";
		System.out.println(message);
		if(utilisateurs.indexOf(pseudo) != -1) {
			utilisateurs.remove(pseudo);
		}
		System.out.println( pseudo + " leave");
		return this.utilisateurs;
	}
	
	@Override
	public Boolean isUserConnected(String pseudo) throws RemoteException {
		Boolean isConnected = false;
		if(utilisateurs.indexOf(pseudo) != -1) {
			isConnected = true;
		}
		return isConnected;
	}

}