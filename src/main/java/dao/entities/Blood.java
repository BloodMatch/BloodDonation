package dao.entities;

public class Blood {
	private Long id;
	private String type;
	private String description;
	
	public Blood() {
		super();
	}
	
	public Blood(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Blood [id=" + id + ", type=" + type + ", description=" + description + "]";
	}
}
