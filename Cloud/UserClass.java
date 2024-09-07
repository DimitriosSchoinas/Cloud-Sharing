package Cloud;
import dataStructures.*;

public class UserClass implements User {
	
	private static final String PREMIUM = "premium";
	private static final String BASIC = "basic";
	private static final int PREMIUM_CAPACITY = 5120;
	private static final int BASIC_CAPACITY = 2048;

	private String email;
	private String type;
	private int storageCapacity;
	private Array<File> filesArray;
	
	public UserClass(String email, String type) {
		
		this.email = email;
		this.type = type;
		filesArray = new ArrayClass<>();
		
		if(type.equals(PREMIUM)) {
			this.storageCapacity = PREMIUM_CAPACITY;
		}
		if(type.equals(BASIC)) {
			this.storageCapacity = BASIC_CAPACITY;
		}
	}
	

	@Override
	public String getType() {
		
		String result = "";
		
		if(type.equals(PREMIUM)) {
			result = "Premium";
		}
		if(type.equals(BASIC)) {
			result = "Basic";
		}
		return result;
	}


	@Override
	public String getEmail() {
		return this.email;
	}


	@Override
	public int getStorageSpace() {
		return this.storageCapacity;
	}


	@Override
	public void changeStorageSpace(int amountToAdd) {
		
		this.storageCapacity = this.storageCapacity + amountToAdd;
		
		
	}


	@Override
	public boolean canShare() {
		
		boolean result = false;
		if(this.type.equals(PREMIUM)) {
			result = true;
		}
		return result;
	}


	@Override
	public void addFile(String fileOwnerName, String fileName, int fileCapacity) {
		File fileToAdd = new FileClass(fileOwnerName,fileName,fileCapacity);
		filesArray.insertLast(fileToAdd);
		changeStorageSpace(-fileCapacity);
	}


	@Override
	public boolean hasAlreadyFile(String file) {
		
		boolean result = false;
		
		for(int i = 0; i < filesArray.size(); i++) {
			if(filesArray.get(i).getName().equals(file)) {
				result = true;
			}
		}
		
		return result;
	}


	@Override
	public int getFileSize(String fileName) {
		
		int size = 0;
		
		for(int i = 0; i < filesArray.size(); i++) {
			if(filesArray.get(i).getName().equals(fileName)) {
				size = filesArray.get(i).getSize();
			}
		}
		
		return size;
	}

	@Override
	public void changeIsShared(String fileName, boolean value) {
		
		for(int i = 0; i < filesArray.size(); i++) {
			if(filesArray.get(i).getName().equals(fileName)) {
				
			}
		}
	}
	@Override
	public void addSharedFile(String fileOwnerName, String fileName, int fileCapacity) {
		
		int originalFileSize = fileCapacity;
		int sharedFileSize = 0;
		
		File fileToAdd = new FileClass(fileOwnerName,fileName,fileCapacity);
		filesArray.insertLast(fileToAdd);
		
		
				if(this.getType().equals(PREMIUM)) {
					sharedFileSize = 0;
				}
				if(this.getType().equals(BASIC)) {
					sharedFileSize = originalFileSize/2;
				}
				
				changeStorageSpace(-sharedFileSize);		
	}


	@Override
	public Iterator<File> listFiles() {
	
		return filesArray.iterator();
	}


	


	


	
	

}
