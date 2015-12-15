package entity;

import java.util.ArrayList;

public class Document {
	String doc_id;//����id
	String writer;//�����id-->user_id
	String type;//��������
	Procedure procedure;
	String title;//����,~50
	String document_number;//�ĺ�
	int rank;//�ܼ�
	String remark;//��ע
	//Date AlterTime;//Alter Time ###################################################################
	String enclosure_dir;//����·��
	ArrayList<NodeLog> procedurelog;

	public Document() {
		super();
	}
	
	public Document(String doc_id,String writer,String type,Procedure procedure,String title,
			String document_number,int rank,String remark,
			String enclosure_dir,ArrayList<NodeLog> procedurelog){
		super();
		this.doc_id = doc_id;
		this.writer = writer;
		this.type = type;
		this.procedure = procedure;
		this.title = title;
		this.document_number = document_number;
		this.rank = rank;
		this.remark = remark;
		this.enclosure_dir = enclosure_dir;
		this.procedurelog = procedurelog;
	}
	
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDocument_number() {
		return document_number;
	}
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEnclosure_dir() {
		return enclosure_dir;
	}
	public void setEnclosure_dir(String enclosure_dir) {
		this.enclosure_dir = enclosure_dir;
	}
	public ArrayList<NodeLog> getprocedurelog() {
		return procedurelog;
	}
	public void setprocedurelog(ArrayList<NodeLog> procedurelog) {
		this.procedurelog = procedurelog;
	}
}