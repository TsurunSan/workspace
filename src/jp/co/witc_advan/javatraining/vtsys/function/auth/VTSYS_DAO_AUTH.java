package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jp.co.witc_advan.javatraining.basic.PropsConfiguration;

public class VTSYS_DAO_AUTH extends DAOSuperUtil{

	public VTSYS_DAO_AUTH() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public List<VTSYS_DTO_AUTH> updateDTO() {
		List<VTSYS_DTO_AUTH> DBList = new ArrayList<VTSYS_DTO_AUTH>();
		//int sqlExeCnt= 0;
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		PropsConfiguration vrb = new PropsConfiguration();
		vrb.loadPropsConfiguration(path);

		try {
			Class.forName(vrb.getProperty("CONST_DB_DRIVER_NAME"));
			con = DriverManager.getConnection(vrb.getProperty("CONST_DB_AUTH_INFOMATION"));
			//トランザクション設定、自動コミット解除
			con.setAutoCommit(false);
			// SQLステートメントを作成
			StringBuilder sbrSb = new StringBuilder();
			sbrSb.append("SELECT");
			sbrSb.append(" *");
			sbrSb.append(" FROM");
			sbrSb.append(" t_auth_account");

			pstmt = con.prepareStatement(sbrSb.toString());
			rst=pstmt.executeQuery();
			while(rst.next()) {
		        VTSYS_DTO_AUTH dto = new VTSYS_DTO_AUTH();
		        dto.setDb_id(rst.getString("AUTH_USER_ID"));
		        dto.setDb_name(rst.getString("AUTH_USER_NAME"));
		        dto.setDb_pass(rst.getString("AUTH_USER_PASSWORD"));
		        dto.setDb_lvl(rst.getString("AUTH_USER_LVL"));
		        dto.setDb_dept(rst.getInt("AUTH_DEPT_CD"));
		        dto.setDb_delete(rst.getInt("AUTH_DELETE_FLG"));
		        dto.setDb_date(rst.getInt("CREATE_DATE"));
		        dto.setDb_create(rst.getString("CREATE_USER"));
		        DBList.add(dto);
		      }

			con.commit();

		}catch(Exception e) {
			if(e instanceof ClassNotFoundException) {
				e.printStackTrace();
			}
			if(e instanceof SQLException) {
				try {
					con.rollback();
				}catch(SQLException e_sql) {
					e_sql.printStackTrace();
				}
			}
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		return DBList;
	}
	public void userJoinToDB(List<String> _param) {
		List<VTSYS_DTO_AUTH> DBList = new ArrayList<VTSYS_DTO_AUTH>();
		int sqlExeCnt= 0;
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		PropsConfiguration vrb = new PropsConfiguration();
		vrb.loadPropsConfiguration(path);
System.out.println(3);
		try {
			System.out.println(2);
			Class.forName(vrb.getProperty("CONST_DB_DRIVER_NAME"));
			con = DriverManager.getConnection(vrb.getProperty("CONST_DB_AUTH_INFOMATION"));
			//トランザクション設定、自動コミット解除
			con.setAutoCommit(false);
			// SQLステートメントを作成
			System.out.println(4);
			StringBuilder sbrSb = new StringBuilder();
//			sbrSb.append("INSERT INTO");
//			sbrSb.append(" t_auth_account");
//			sbrSb.append(" VALUES");
//			sbrSb.append("( '?', '?', '?', 0, 0, 0, '2017-12-12', 'admin')");
//			System.out.println(sbrSb.toString());
//System.out.println(_param.get(0));
//			pstmt = con.prepareStatement(sbrSb.toString());
//			System.out.println(_param.get(1));
//			pstmt.setString(1, _param.get(0));
//			System.out.println(_param.get(2));
//			pstmt.setString(2, _param.get(1));
//			pstmt.setString(3, _param.get(2));
			
			sbrSb.append("INSERT IGNORE INTO");
			sbrSb.append(" t_auth_account");
			sbrSb.append(" VALUES(");
			sbrSb.append("?");
			sbrSb.append(",?");
			sbrSb.append(",?");
			sbrSb.append(",0");
			sbrSb.append(",0");
			sbrSb.append(",0");
			sbrSb.append(",2017-12-12");
			sbrSb.append(",'admin'");
			sbrSb.append(")");

			System.out.println(sbrSb);
			pstmt = con.prepareStatement(sbrSb.toString());

			pstmt.setString(1, _param.get(0));
			pstmt.setString(2, _param.get(1));
			pstmt.setString(3, _param.get(2));

			
			sqlExeCnt=pstmt.executeUpdate();
			System.out.println(sqlExeCnt);
			if(sqlExeCnt>0) {
				System.out.println("[処理結果]登録正常終了");
				JOptionPane.showMessageDialog(null, "登録が完了しました。", "完了", JOptionPane.INFORMATION_MESSAGE);
			}else if(sqlExeCnt<=0) {
				System.out.println("[処理結果]登録異常終了");
				JOptionPane.showMessageDialog(null, "登録できませんでした。", "エラー", JOptionPane.INFORMATION_MESSAGE);
			}else {
				System.out.println("error");
			}
			con.commit();

		}catch(Exception e) {
			if(e instanceof ClassNotFoundException) {
				e.printStackTrace();
			}
			if(e instanceof SQLException) {
				try {
					con.rollback();
				}catch(SQLException e_sql) {
					e_sql.printStackTrace();
				}
			}
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	public static void main(String[] args) {
//		List<VTSYS_DTO_AUTH> dtoList = new ArrayList<VTSYS_DTO_AUTH>();
		VTSYS_DAO_AUTH dao = new VTSYS_DAO_AUTH();
//		for(VTSYS_DTO_AUTH vrb_dto : dao.updateDTO() ) {
//			System.out.println(vrb_dto.getDb_name());
//		}

		List<String> list =new ArrayList<String>();
		list.add("www");
		list.add("wwwwww");
		list.add("wwwwww");
		dao.userJoinToDB(list);
		

		

	}

}
