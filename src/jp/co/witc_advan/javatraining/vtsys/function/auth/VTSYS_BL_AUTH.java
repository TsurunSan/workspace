package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class VTSYS_BL_AUTH implements I_VTSYS_BL_AUTH {

	public VTSYS_BL_AUTH() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean isNull(List<String> _param) {
		// TODO 自動生成されたメソッド・スタブ
		int cnt = 0;
		String containt = "ID";
		for (String data : _param) {
			if (data.isEmpty()) {
				if (cnt == 1)
					containt = "PASS";
				if (cnt == 2)
					containt = "NAME";
				JOptionPane.showMessageDialog(null, "入力内容を見直してください", containt, JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			cnt++;
		}
		return true;
	}

	@Override
	public boolean isMatch(List<String> _param) {
		// TODO 自動生成されたメソッド・スタブ
		Pattern ptrn = null;
		Matcher mtr = null;
		boolean result = true;
		int cnt = 0;
		for (String data : _param) {
			if (cnt == 0) {
				ptrn = Pattern.compile(CONST_NUMERIC_ID);
			} else {
				ptrn = Pattern.compile(CONST_NUMERIC_PASS);
			}
			mtr = ptrn.matcher(data);
			if (!mtr.find()) {
				try {
					result = false;
					JOptionPane.showMessageDialog(
							null,
							"入力データ書式に誤りがあります。見直してください。",
							"エラー",
							JOptionPane.INFORMATION_MESSAGE);
					throw new Exception("入力データ書式に誤りがあります。見直してください。");
				} catch (Exception e) {
					e.printStackTrace();
				} //catch
			} //if
		} //for

		return result;
	}

	public List<String> trimSpace(List<String> _param) {

		List<String> inputDataList = new ArrayList<String>();
		for (String s : _param) {
			int len = s.length();
			char c = 0;
			StringBuilder sbdr = new StringBuilder();
			for (int i = 0; i < len; i++) {
				c = s.charAt(i);
				if (c != '\u00A0' && c != '\u0020' && c != '\u3000') {
					sbdr.append(s.charAt(i));
				}
			}
			inputDataList.add(sbdr.toString());
		}
		return inputDataList;
	}

	@Override
	public boolean checkUser(List<String> _param) {
		// TODO 自動生成されたメソッド・スタブ
		VTSYS_DAO_AUTH dao = new VTSYS_DAO_AUTH();
		for (VTSYS_DTO_AUTH vrb_dto : dao.updateDTO()) {
			if (_param.get(0).equals(vrb_dto.getDb_id()) && _param.get(1).equals(vrb_dto.getDb_pass()))
				return true;
		}
		return false;
	}

	@Override
	public void showResult(boolean _user) {
		// TODO 自動生成されたメソッド・スタブ
		if (_user) {
			JOptionPane.showMessageDialog(
					null,
					"認証完了しました。",
					"完了",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(
					null,
					"認証できませんでした",
					"エラー",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void login(VTSYS_DTO_AUTH _param_dto) {
		// TODO 自動生成されたメソッド・スタブ
		boolean result = false;
		List<String> inputList = new ArrayList<String>();
		inputList.add(_param_dto.getInput_id());
		inputList.add(_param_dto.getInput_pass());
		VTSYS_BL_AUTH login_bl = new VTSYS_BL_AUTH();
		if (login_bl.isNull(inputList)) {
			List<String> trimSpacedInputList = new ArrayList<String>(login_bl.trimSpace(inputList));
			if (login_bl.isMatch(trimSpacedInputList)) {
				if (login_bl.checkUser(trimSpacedInputList)) {
					result = true;
				}
			}
		}
		login_bl.showResult(result);
	}

	public void join(VTSYS_DTO_AUTH vrb_dto) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> input_join_data = new ArrayList<String>();
		input_join_data.add(vrb_dto.getInput_join_id());
		input_join_data.add(vrb_dto.getInput_join_pass());
		input_join_data.add(vrb_dto.getInput_join_name());
		VTSYS_BL_AUTH join_bl = new VTSYS_BL_AUTH();
		if(join_bl.isNull(input_join_data)) {
			List<String> trimSpacedInputJoinList = new ArrayList<String>(join_bl.trimSpace(input_join_data));
			if(join_bl.isMatch(trimSpacedInputJoinList)) {
				
			}
		}

	}

	public static void main(String[] args) {
		//		VTSYS_BL_AUTH vrb_bl = new VTSYS_BL_AUTH();
		//		List<String> list = new ArrayList<String>();
		//		list.add(" wmjtp ");
		//		list.add("23456 ");
		//		String str = (" 2345 　");
		//		//System.out.println(vrb_bl.isMatch(list));
		//		System.out.println(vrb_bl.trimSpace(list));
		//		System.out.println(list.get(1));
		//		VTSYS_DAO_AUTH dao = new VTSYS_DAO_AUTH();
		//		for (VTSYS_DTO_AUTH vrb_dto : dao.updateDTO()) {
		//			//System.out.println(vrb_dto.getDb_name());
		//		}
		//				List<String> list = new ArrayList<String>();
		//				list.add("wmjtpgj");
		//				list.add("234567");
		//				VTSYS_BL_AUTH bbb =new VTSYS_BL_AUTH();
		//		bbb.showResult(bbb.checkUser(list));
		//
		//		List<String> list = new ArrayList<String>();
		//		list.add("aaaaaaa aa");
		//		list.add("bbbbbbb bbbbb");
		//		VTSYS_BL_AUTH bl = new VTSYS_BL_AUTH();
		//		List<String> nlist = new ArrayList<String>(bl.trimSpace(list));
		//
		//		System.out.println(list);
		//		System.out.println(nlist);
		//					VTSYS_DTO_AUTH dto =new VTSYS_DTO_AUTH("wmjtpgj", "234567");
		//		bbb.login(dto);
	}

}
