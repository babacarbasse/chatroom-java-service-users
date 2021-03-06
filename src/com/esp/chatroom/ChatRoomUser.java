package com.esp.chatroom;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatRoomUser extends Remote{
	public ArrayList<String> subscribe(String pseudo) throws RemoteException;
	public ArrayList<String> unsubscribe(String pseudo) throws RemoteException;
	public Boolean isUserConnected(String pseudo) throws RemoteException;
}