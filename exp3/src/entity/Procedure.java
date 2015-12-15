package entity;

import java.util.ArrayList;

public class Procedure {
	String procedure_id;//id
	ArrayList<ProcedureNode> procedure;//
	
	public Procedure() {
		super();
	}
	
	public Procedure(String procedure_id,ArrayList<ProcedureNode> procedure) {
		super();
		this.procedure_id = procedure_id;
		this.procedure = procedure;
	}
	
	
	public String getProcedure_id() {
		return procedure_id;
	}
	public void setProcedure_id(String procedure_id) {
		this.procedure_id = procedure_id;
	}
	public ArrayList<ProcedureNode> getProcedure() {
		return procedure;
	}
	public void setProcedure(ArrayList<ProcedureNode> procedure) {
		this.procedure = procedure;
	}
}
