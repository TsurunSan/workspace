package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VTSYS_UI_AUTH {

	static private JFrame frame;
	private JTextField text_id;
	private JTextField text_pass;
	static private JPanel panel = new JPanel();
	static private JPanel jopa = new JPanel();
	static private VTSYS_PANEL_JOIN_AUTH join = new VTSYS_PANEL_JOIN_AUTH();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VTSYS_UI_AUTH window = new VTSYS_UI_AUTH();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VTSYS_UI_AUTH() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 600, 500);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		getPanel().setBounds(0, 0, 584, 461);
		getFrame().getContentPane().add(getPanel());
		getPanel().setLayout(null);

		text_id = new JTextField();
		text_id.setBounds(313, 98, 96, 19);
		getPanel().add(text_id);
		text_id.setColumns(10);

		text_pass = new JTextField();
		text_pass.setBounds(313, 137, 96, 19);
		getPanel().add(text_pass);
		text_pass.setColumns(10);

		JButton btn_login = new JButton("ログイン");
		btn_login.setBounds(235, 214, 91, 21);
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VTSYS_DTO_AUTH vrb_dto = new VTSYS_DTO_AUTH(
						text_id.getText(),
						text_pass.getText());
				VTSYS_BL_AUTH vrb_bl = new VTSYS_BL_AUTH();
				vrb_bl.login(vrb_dto);
			}
		});
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getPanel().add(btn_login);

		JButton btn_initialize = new JButton("入力初期化");
		btn_initialize.setBounds(72, 214, 91, 21);
		btn_initialize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_id.setText(null);
				text_pass.setText(null);
			}
		});
		btn_initialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getPanel().add(btn_initialize);

		JButton btn_close = new JButton("終了");
		btn_close.setBounds(398, 214, 91, 21);
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getPanel().add(btn_close);

		JLabel lblNewLabel = new JLabel("ユーザーID");
		lblNewLabel.setBounds(210, 101, 79, 13);
		getPanel().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASS");
		lblNewLabel_1.setBounds(210, 140, 50, 13);
		getPanel().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("仮想システム-認証ー");
		lblNewLabel_2.setBounds(210, 31, 155, 20);
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 19));
		getPanel().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("必要情報を入力設定の上、該当処理を実地してください。");
		lblNewLabel_3.setBounds(145, 61, 427, 13);
		getPanel().add(lblNewLabel_3);

		JLabel label = new JLabel("システムサイトについて");
		label.setBounds(21, 318, 229, 13);
		getPanel().add(label);

		JLabel lblNewLabel_4 = new JLabel("・本サイトは「サイト利用規約」に同意頂いた上でご利用ください。");
		lblNewLabel_4.setBounds(68, 347, 465, 13);
		lblNewLabel_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 11));
		getPanel().add(lblNewLabel_4);

		JLabel lblid = new JLabel("・デモサイトには以下のユーザーIDとパスワードでログインしてください。");
		lblid.setBounds(68, 370, 465, 13);
		lblid.setFont(new Font("MS UI Gothic", Font.PLAIN, 11));
		getPanel().add(lblid);

		JLabel label_1 = new JLabel("・本サイトはユーザーの権限変更など、一部機能の利用に制限を設けております。");
		label_1.setBounds(68, 393, 463, 13);
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 11));
		getPanel().add(label_1);

		JLabel lblNewLabel_5 = new JLabel("ユーザー登録がまだの方はこちら");
		lblNewLabel_5.setBounds(99, 273, 226, 13);
		getPanel().add(lblNewLabel_5);

		JButton button = new JButton("ユーザー登録");
		button.setBounds(302, 269, 121, 21);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelChange("join");

			}
		});
		getPanel().add(button);

		setJopa(join.getJoinPanel());
		getFrame().getContentPane().add(getJopa());
		getJopa().setVisible(false);

	}

	public static void PanelChange(String s) {
		if (s == "join") {
			getPanel().setVisible(false);
			getJopa().setVisible(true);

		}
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		VTSYS_UI_AUTH.frame = frame;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		VTSYS_UI_AUTH.panel = panel;
	}

	public static JPanel getJopa() {
		return jopa;
	}

	public static void setJopa(JPanel jopa) {
		VTSYS_UI_AUTH.jopa = jopa;
	}

}
