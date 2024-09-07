package Cloud;

import dataStructures.*;

public class CloudSharingClass implements CloudSharing {
	
	private static final String PREMIUM = "Premium";
	private static final String BASIC = "Basic";

	private Array<User> users;

	public CloudSharingClass() {

		users = new ArrayClass<>();

	}

	
	@Override
	public boolean hasUser(String email) {

		int numberOfUsers = users.size();
		boolean result = false;

		for (int i = 0; i < numberOfUsers; i++) {
			if (users.get(i).getEmail().equals(email)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public void addUser(String email, String type) {

		User user = new UserClass(email, type);
		users.insertLast(user);
	}

	@Override
	public boolean hasOwnedFile(String user, String file) {

		boolean result = false;

		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(user)) {
			if (users.get(i).hasAlreadyFile(file)) {
				result = true;
			}
			}
		}

		return result;
	}

	@Override
	public boolean hasCapacity(String user, int size) {

		boolean result = false;
		int accountCapacity = 0;

		// finds the capacity of the account
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(user)) {
				accountCapacity = users.get(i).getStorageSpace();

			}
		}
		// verifies if there is enough capacity
		if (size <= accountCapacity) {
			result = true;
		}

		return result;

	}

	@Override
	public void addFile(String user, String file, int size) {

		// deletes the space used
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(user)) {
				users.get(i).addFile(user, file, size);
			}
		}

	}

	@Override
	public boolean allowsSharing(String owner) {

		boolean result = false;

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(owner)) {
				if (users.get(i).canShare()) {
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean hasSharedFile(String owner, String other, String file) {

		boolean result = false;
		
		return result;

	}

	@Override
	public boolean hasSharingCapacity(String owner, String other, String file) {
		
		boolean result = false;
		int originalFileSize = 0;
		int sharedFileSize = 0;
		int capacityOfTheAccount = 0;
		
		//finds the size of the file that we want to share
		for(int i = 0;i < users.size(); i++) {
			if(users.get(i).getEmail().equals(owner)) {
				originalFileSize = users.get(i).getFileSize(file);
			}
		}
		//calculates the size of the file after sharing depending on the type of account
		for(int i = 0;i < users.size(); i++) {
			if(users.get(i).getEmail().equals(other)) {
			
				if(users.get(i).getType().equals(PREMIUM)) {
					sharedFileSize = 0;
				}
				if(users.get(i).getType().equals(BASIC)) {
					sharedFileSize = originalFileSize/2;
				}
				capacityOfTheAccount = users.get(i).getStorageSpace();
			}
		}
		
		if(sharedFileSize <= capacityOfTheAccount) {
			result = true;
		}
		
		return result;
		
	}

	@Override
	public void shareFile(String owner, String other, String file) {
		
		int originalFileSize = 0;
		
		
		for(int i = 0;i < users.size(); i++) {
			if(users.get(i).getEmail().equals(owner)) {
				originalFileSize = users.get(i).getFileSize(file);
			}
		}
		
		for(int i = 0;i < users.size(); i++) {
			if(users.get(i).getEmail().equals(other)) {
				users.get(i).addSharedFile(owner, file, originalFileSize);
			}
		}
		
	}

	@Override
	public Iterator<File> listFiles(String user) {
		
		User targetUser = new UserClass(user, "teste");
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(user)) {
				targetUser = users.get(i);
			}
		}
		
		return targetUser.listFiles();
	}

	@Override
	public Iterator<User> listAll() {
		
		return users.iterator();
	}

}
