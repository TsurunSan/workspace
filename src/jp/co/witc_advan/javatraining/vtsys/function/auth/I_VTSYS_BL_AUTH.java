package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.util.List;

public interface I_VTSYS_BL_AUTH {

	public boolean isNull(List<String> _param);

	public boolean isMatch(List<String> _param);

	public List<String> trimSpace(List<String> _param);

	public boolean checkUser(List<String> _param);

	public void showResult(boolean _user);

	String CONST_NUMERIC_ID="^[0-9a-zA-Z]{5,8}+$";
	String CONST_NUMERIC_PASS="^[0-9a-zA-Z]{5,8}+$";
}
