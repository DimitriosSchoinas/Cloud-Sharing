package Cloud;

import dataStructures.Iterator;

public interface User {

	/**
	 * 
	 * @return return the email of the account
	 */
	String getEmail();
	/**
	 * 
	 * @return returns the type of the account
	 */
	String getType();
	/**
	 * 
	 * @return return the storage available in the account
	 */
	int getStorageSpace();
	/**
	 * changes the amount of storage space in the account
	 * @param amountToAdd amount to add or remove from the storage
	 */
	void changeStorageSpace(int amountToAdd);
	/**
	 * return if the account is premium
	 * @return return if the account is premium
	 */
	boolean canShare();
	/**
	 * adds a file
	 * @param fileOwnerName
	 * @param fileName
	 * @param fileCapacity
	 */
	void addFile(String fileOwnerName, String fileName, int fileCapacity);
	/**
	 * true if the file already exists in the array
	 * @param file
	 * @return
	 */
	boolean hasAlreadyFile(String file);
	/**
	 * 
	 * @param fileName name of the file
	 * @return the size of the file
	 */
	int getFileSize(String fileName);
	/**
	 * 
	 * @param fileOwnerName
	 * @param fileName
	 * @param fileCapacity
	 * @param isShared
	 */
	
	void addSharedFile(String fileOwnerName, String fileName, int fileCapacity);
	/**
	 * changes if the file is shared or not
	 * @param value true if the file is shared
	 */
	void changeIsShared(String fileName, boolean value);
	/**
	 * 
	 * @return iterates all the files
	 */
	Iterator<File> listFiles();

}
