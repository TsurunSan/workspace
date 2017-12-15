package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsConfiguration implements I_DAO {

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

}
