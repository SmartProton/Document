package entity;

import java.util.ArrayList;

public class DocumentType {
	int type_id;//
	String type;//��������
	ArrayList<Procedure> procedurelist;//��������
	
	public DocumentType() {
		super();
	}
	
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<Procedure> getProcedurelist() {
		return procedurelist;
	}
	public void setProcedurelist(ArrayList<Procedure> procedurelist) {
		this.procedurelist = procedurelist;
	}

}