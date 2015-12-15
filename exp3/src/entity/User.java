package entity;

public class User {
	String user_id;
	String password;//6~20
	String username;//~20
	boolean sex;//true男  false女
	String job;//职位
	String depart;//部门
	
	public User() {
		super();
	}
	
	public User(String user_id,String password,String username, boolean sex, String job,String depart){
		super();
		this.user_id = user_id;
		this. password =  password;
		this.username =username;
		this.sex = sex;
		this. job = job;
		this.depart=depart;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	}
