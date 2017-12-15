package jdbc_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import jp.co.witc_advan.javatraining.basic.PropsConfiguration;

public class JDBC_InsertDataTest_ignore{

	public JDBC_InsertDataTest_ignore() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		int sqlExeCnt= 0;
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		//↓あとで移したい
		String path="C:\\Users\\User\\Desktop\\pleiades\\workspace\\WITC_SI_KENSHU_PTHPeriod(DAO_JDBC)\\src\\jp\\co\\witc_advan\\javatraining\\basic\\test.Properties";
		PropsConfiguration vrb = new PropsConfiguration();
		vrb.loadPropsConfiguration(path);

		try {
			Class.forName(vrb.getProperty("CONST_DB_DRIVER_NAME"));
			con = DriverManager.getConnection(vrb.getProperty("CONST_DB_AUTH_INFOMATION"));
			//トランザクション設定、自動コミット解除
			con.setAutoCommit(false);
			// SQLステートメントを作成
			StringBuilder sbrSb = new StringBuilder();
			sbrSb.append("INSERT IGNORE INTO");
			sbrSb.append(" T_SAMPLE(");
			sbrSb.append(" SAMPLE_ID, SAMPLE_NAME, SAMPLE_DEPT, CREATE_DATE, CREATE_USER");
			sbrSb.append(" )");
			sbrSb.append(" VALUES(");
			sbrSb.append(" ?");
			sbrSb.append(" ,?");
			sbrSb.append(" ,?");
			sbrSb.append(" ,?");
			sbrSb.append(" ,?");
			sbrSb.append(" )");
System.out.println(sbrSb);
			pstmt = con.prepareStatement(sbrSb.toString());

			pstmt.setString(1, "test_id_20171211");
			pstmt.setString(2, "test_name_00X");
			pstmt.setString(3, "test_dept_00X");
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(5, "admin");
			//System.out.println(pstmt);
			sqlExeCnt = pstmt.executeUpdate();
			System.out.println(sqlExeCnt);
			if(sqlExeCnt>0) {
				System.out.println("[処理結果]登録正常終了");
			}else if(sqlExeCnt<=0) {
				System.out.println("[処理結果]登録異常終了");
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
}



