package Cloud;

public class FileClass implements File {
	
	private String fileName;
	private int fileCapacity;
	private String fileOwnerName;
	private boolean isSharedFile;

	
	public FileClass(String fileOwnerName, String fileName, int fileCapacity) {
		this.fileName = fileName;
		this.fileCapacity = fileCapacity;
		this.fileOwnerName = fileOwnerName;
		this.isSharedFile = false;
	}

	@Override
	public String getOwnerName() {
		
		return this.fileOwnerName;
	}

	@Override
	public int getSize() {
		return this.fileCapacity;
	}

	@Override
	public String getName() {
		return this.fileName;
	}

	@Override
	public void changeIsShared(boolean value) {
		isSharedFile = value;
		
	}

	@Override
	public boolean isShared() {
		return isSharedFile;
	}

}
