package entity;
import java.util.Date;

public class NodeLog {
	ProcedureNode procedure;
	String operator_id;
	Date starttime;
	Date endtime;
	
	public NodeLog(){
		super();
	}
	
	public NodeLog(ProcedureNode procedure,String operator_id,Date starttime,Date endtime){
		this.procedure = procedure;
		this.operator_id = operator_id;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	
	public NodeLog getProNodeLog(ProcedureNode procedure,String operator_id,Date starttime,Date endtime){
		this.procedure = procedure;
		this.operator_id = operator_id;
		this.starttime = starttime;
		this.endtime = endtime;
		return this;
	}
	
	public ProcedureNode getProcedure() {
		return procedure;
	}

	public void setProcedure(ProcedureNode procedure) {
		this.procedure = procedure;
	}

	public String getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
}

	
