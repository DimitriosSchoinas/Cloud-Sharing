package Cloud;

public interface File {

	/**
	 * 
	 * @return returns the name of the file's owner
	 */
	String getOwnerName();
	/**
	 * 
	 * @return returns the size in megabytes of the file
	 */
	int getSize();
	/**
	 * 
	 * @return return the name of the file
	 */
	String getName();
	void changeIsShared(boolean value);
	boolean isShared();

}
