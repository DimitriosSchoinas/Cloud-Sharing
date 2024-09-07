package Cloud;

import dataStructures.*;

public interface CloudSharing {

	/**
	 * verifyies if the user exists in the system
	 * @param email of the user
	 * @return returns if the user exists in the system
	 */
	boolean hasUser(String email);
	/**
	 * adds an user to the system
	 * @param email of the user
	 * @param type of account
	 */
	void addUser(String email, String type);
	/**
	 * true if the user has already the file
	 * @param user owner of the file
	 * @param file size of the file
	 * @return true if the user has already the file
	 */
	boolean hasOwnedFile(String user, String file);
	/**
	 * true if there is enough capacity
	 * @param user owner of the file
	 * @param size size of the file
	 * @return true if there is enough capacity
	 */
	boolean hasCapacity(String user, int size);
	/**
	 * adds a file in the system
	 * @param user name of the owner of the file
	 * @param file name of the file
	 * @param size size of the file in MB
	 */
	void addFile(String user, String file, int size);
	/**
	 * return if the account can share files
	 * @param owner owner of the file
	 * @return  return if the account can share files
	 */
	boolean allowsSharing(String owner);
	
	/**
	 * 
	 * @param owner owner of the file
	 * @param other receiver of the file
	 * @param file name of the file
	 * @return return true if the file already exists in the other account
	 */
	boolean hasSharedFile(String owner, String other, String file);

	boolean hasSharingCapacity(String owner, String other, String file);

	void shareFile(String owner, String other, String file);

	Iterator<File> listFiles(String user);

	Iterator<User> listAll();

	

}
