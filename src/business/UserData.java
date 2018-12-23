package business;




import org.primefaces.model.StreamedContent;

public class UserData {
	private int Id;
	private String filename;
	private StreamedContent file;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public StreamedContent getFile() {
		return file;
	}
	public void setFile(StreamedContent file) {
		this.file = file;
	}

	
	
	
}
