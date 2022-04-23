package beans;

import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String email;
	private Date created_date;
	private Date updated_date;
	
	public Customer() {
		super();
	}

	public Customer(int id, String name, String email, Date created_date, Date updated_date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
}
