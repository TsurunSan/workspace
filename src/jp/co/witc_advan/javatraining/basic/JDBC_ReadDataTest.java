package jp.co.witc_advan.javatraining.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_ReadDataTest implements I_DAO {

	public JDBC_ReadDataTest() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;//接続するやつ
		ResultSet rst = null;//SQLからの結果を受け取るやつ
		PreparedStatement pstmt = null;//ステートメントをSQLに送るやつ
		PropsConfiguration vrb = new PropsConfiguration();//変更箇所
		vrb.loadPropsConfiguration(path);//変更箇所

		try {
			// ①JDBCドライバのロード
			// JDBCドライバを読みこむ。Classクラスの静的メソッドでJDBCドライバをロードする(JDBC Driver登録)

			Class.forName(vrb.getProperty("CONST_DB_DRIVER_NAME"));//変更箇所

			// ②ドライバーマネージャーから、データベースへ接続
			// コネクションの取得
			// MySQLデータベースへの接続取得・引数の設定
			// [mySql固定情報]jdbc:mysql://localhost
			// [開発環境により変動する情報]
			// ・スキーマ名 ：witcsi_kenshu?
			// ・DB認証情報1：user=root(ユーザーID=実際使用するユーザーID)
			// ・DB認証情報2：password=root(パスワード=実際使用するパスワード)
			// String url =
			// "jdbc:mysql://localhost/witcsi_kenshu9th?user=root&password=root";
			// con = DriverManager.getConnection(CONST_DB_AUTH_INFORMATION);
			// コネクションの取得
			// String url = CONST_DB_AUTH_INFOMATION;
			con = DriverManager.getConnection(vrb.getProperty("CONST_DB_AUTH_INFOMATION"));//変更箇所

			// SQLステートメントを作成
			StringBuilder sbrSql = new StringBuilder();
			sbrSql.append("SELECT");// 抽出する
			sbrSql.append(" sample_id,sample_name,sample_dept");// 抽出項目
			sbrSql.append(" FROM");// どこから
			sbrSql.append(" t_sample");// テーブル名

			// ③Connectionオブジェクトから取得したPreparedStatement
			pstmt = con.prepareStatement(sbrSql.toString());

			rst = pstmt.executeQuery();
//			System.out.println(pstmt);
//			System.out.println(rst.getString("sample_id"));
			while (rst.next()) {
				String rsCol_Id = rst.getString("sample_id");
				String rsCol_Namae = rst.getString("sample_name");
				String rsCol_Dept = rst.getString("sample_dept");
				System.out.println(rsCol_Id + "\t|" + rsCol_Namae + "\t|" + rsCol_Dept);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}

}
