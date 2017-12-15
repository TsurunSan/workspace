package jp.co.witc_advan.javatraining.vtsys.function.auth;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VTSYS_PANEL_JOIN_AUTH extends JPanel {
	static JPanel panel_join = new JPanel();
	private JTextField text_join_id;
	private JTextField text_join_pass;
	private JTextField text_join_name;
	/**
	 * Create the panel.
	 */
	public VTSYS_PANEL_JOIN_AUTH() {
		System.out.println(1);
		panel_join.setBounds(0, 0, 584, 461);
		panel_join.setLayout(null);

		JButton btnNewButton = new JButton("戻る");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VTSYS_UI_AUTH.getPanel().setVisible(true);
				VTSYS_UI_AUTH.getJopa().setVisible(false);
			}
		});
		btnNewButton.setBounds(376, 317, 91, 21);
		panel_join.add(btnNewButton);
		text_join_id = new JTextField();
		text_join_id.setBounds(306, 127, 96, 19);
		panel_join.add(text_join_id);
		text_join_id.setColumns(10);

		JLabel lblId = new JLabel("ID(5~8桁の英数字）");
		lblId.setBounds(148, 130, 134, 13);
		panel_join.add(lblId);

		JLabel label_1 = new JLabel("仮想システム-新規登録ー");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 19));
		label_1.setBounds(178, 31, 224, 20);
		panel_join.add(label_1);

		text_join_pass = new JTextField();
		text_join_pass.setColumns(10);
		text_join_pass.setBounds(306, 156, 96, 19);
		panel_join.add(text_join_pass);

		text_join_name = new JTextField();
		text_join_name.setColumns(10);
		text_join_name.setBounds(306, 185, 96, 19);
		panel_join.add(text_join_name);

		JLabel lblPass = new JLabel("PASS(5~8桁の英数字）");
		lblPass.setBounds(148, 159, 134, 13);
		panel_join.add(lblPass);

		JLabel label_3 = new JLabel("名前(姓名)");
		label_3.setBounds(148, 188, 134, 13);
		panel_join.add(label_3);

		JButton button = new JButton("初期化");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(111, 317, 91, 21);
		panel_join.add(button);

		JButton button_1 = new JButton("登録");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VTSYS_DTO_AUTH vrb_dto=new VTSYS_DTO_AUTH(
						text_join_id.getText(),
						text_join_pass.getText(),
						text_join_name.getText());
				VTSYS_BL_AUTH vrb_bl = new VTSYS_BL_AUTH();
				vrb_bl.join(vrb_dto);
			}
		});
		button_1.setBounds(241, 317, 91, 21);
		panel_join.add(button_1);
	}
	public JPanel getJoinPanel() {
		return panel_join;
	}
}
