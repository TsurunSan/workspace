package jp.co.witc_advan.javatraining.vtsys.function.auth;

public class VTSYS_DTO_AUTH {

	public VTSYS_DTO_AUTH() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private String db_id;
	private String db_name;
	private String db_pass;
	private String db_lvl;
	private int db_dept;
	private int db_delete;
	private int db_date;
	private String db_create;

	private String input_id;
	private String input_pass;

	private String input_join_id;
	private String input_join_pass;
	private String input_join_name;

	public VTSYS_DTO_AUTH(
			String db_id,
			String db_name,
			String db_pass,
			String db_lvl,
			int db_dept,
			int db_delete,
			int db_date,
			String db_create) {
		this.db_id = db_id;
		this.db_name = db_name;
		this.db_pass = db_pass;
		this.db_lvl = db_lvl;
		this.db_dept = db_dept;
		this.db_delete = db_delete;
		this.db_date = db_date;
		this.db_create = db_create;

	}

	public VTSYS_DTO_AUTH(
			String input_id,
			String input_pass) {
		this.input_id = input_id;
		this.input_pass = input_pass;
	}

	public VTSYS_DTO_AUTH(
			String input_join_id,
			String input_join_pass,
			String input_join_name) {
		this.input_join_id = input_join_id;
		this.input_join_pass = input_join_pass;
		this.input_join_name = input_join_name;
	}

	public String getDb_id() {
		return db_id;
	}

	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}

	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public String getDb_pass() {
		return db_pass;
	}

	public void setDb_pass(String db_pass) {
		this.db_pass = db_pass;
	}

	public String getDb_lvl() {
		return db_lvl;
	}

	public void setDb_lvl(String db_lvl) {
		this.db_lvl = db_lvl;
	}

	public int getDb_dept() {
		return db_dept;
	}

	public void setDb_dept(int db_dept) {
		this.db_dept = db_dept;
	}

	public int getDb_delete() {
		return db_delete;
	}

	public void setDb_delete(int db_delete) {
		this.db_delete = db_delete;
	}

	public int getDb_date() {
		return db_date;
	}

	public void setDb_date(int db_date) {
		this.db_date = db_date;
	}

	public String getDb_create() {
		return db_create;
	}

	public void setDb_create(String db_create) {
		this.db_create = db_create;
	}

	public String getInput_id() {
		return input_id;
	}

	public void setInput_id(String input_id) {
		this.input_id = input_id;
	}

	public String getInput_pass() {
		return input_pass;
	}

	public void setInput_pass(String input_pass) {
		this.input_pass = input_pass;
	}

	public String getInput_join_id() {
		return input_join_id;
	}

	public void setInput_join_id(String input_join_id) {
		this.input_join_id = input_join_id;
	}

	public String getInput_join_pass() {
		return input_join_pass;
	}

	public void setInput_join_pass(String input_join_pass) {
		this.input_join_pass = input_join_pass;
	}

	public String getInput_join_name() {
		return input_join_name;
	}

	public void setInput_join_name(String input_join_name) {
		this.input_join_name = input_join_name;
	};

}
