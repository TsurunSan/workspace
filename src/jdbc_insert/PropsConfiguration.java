package jdbc_insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsConfiguration{

	private Properties conf;

	public PropsConfiguration() {
		// TODO 自動生成されたコンストラクター・スタブ
		conf = new Properties();
	}

	public void loadPropsConfiguration(String filename) {
		conf = new Properties();
		try {
			conf.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.err.println("Cannot open " + filename + ".");
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		if (conf.containsKey(key)) {
			return conf.getProperty(key);
		} else {
			System.err.println("[異状終了]登録対象のキーデータ検索結果、存在しません。key = " + key);
			return "";
		}
	}

	public static void main(String[] args) {
		String path = null;
		String vrb_innr_propsData_jdbc_driver = null;
		String vrb_innr_propsData_jdbc_connectAuth = null;
		path = "C:\\Users\\User\\Desktop\\pleiades\\workspace\\WITC_SI_KENSHU_PTHPeriod(DAO_JDBC)\\src\\jp\\co\\witc_advan\\javatraining\\basic\\test.Properties";
		PropsConfiguration vrb = new PropsConfiguration();
		vrb.loadPropsConfiguration(path);

		vrb_innr_propsData_jdbc_driver = vrb.getProperty("CONST_DB_DRIVER_NAME");
		System.out.println("[DEBUG情報/設定ファイル内キー]\n CONST_DB_DRIVER_NAME=" + vrb_innr_propsData_jdbc_driver);
		vrb_innr_propsData_jdbc_connectAuth = vrb.getProperty("CONST_DB_AUTH_INFOMATION");
		System.out.println("[DEBUG情報/設定ファイル内キー]\n CONST_DB_AUTH_INFOMATION=" + vrb_innr_propsData_jdbc_connectAuth);
	}
}
