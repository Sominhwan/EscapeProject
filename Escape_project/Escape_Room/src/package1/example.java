package package1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class example {

	JFrame frame;

	/**
	 * 어플리케이션 시작
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					example window = new example();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 어플리케이션 만들기
	 */
	public example() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//아이콘 로고 넣기
		ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/ClearTime.png").getImage());//메인 화면 이미지 불러오기
		frame.setSize(MainPanel.getWidth(),MainPanel.getWidth());
		frame.getContentPane().add(MainPanel);
		
		frame.setResizable(false);//화면크기 조절 불가
		frame.setLocationRelativeTo(null);//화면 중앙
		frame.setTitle("\uBC29 \uD0C8\uCD9C\r\n");//프로그램 이름 지정	
		frame.setBounds(100, 100, 800, 600);//화면 크기 지정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JButton LoginButton = new JButton("");//login 레이블 생성
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		LoginButton.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\\uC0C8\uB85C\uD558\uAE30.png"));
		LoginButton.setFont(new Font("궁서체", Font.PLAIN, 29));//글씨체 선정
		LoginButton.setForeground(new Color(139, 0, 0));
		LoginButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		LoginButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		LoginButton.setBounds(463, 224, 33, 36);
		MainPanel.add(LoginButton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\Hammer.png"));
		btnNewButton.setBounds(306, 280, 190, 41);
		btnNewButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		btnNewButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MainPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Vault_Password_Hint1.png"));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(484, 294, 29, 27);
		MainPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_1.setIcon(null);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(626, 397, 23, 21);
		MainPanel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Menu_Button\\BackButton_Menu.png"));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(662, 514, 107, 36);
		MainPanel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1_2 = new JButton("");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\\uADF8\uB9BC1.png"));
		btnNewButton_1_1_2.setContentAreaFilled(false);
		btnNewButton_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_2.setBounds(195, 499, 45, 30);
		MainPanel.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(33, 189, 33, 63);
		MainPanel.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_2_1 = new JButton("");
		btnNewButton_1_1_2_1.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Safe_On_False.png"));
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_1_2_1.setContentAreaFilled(false);
		btnNewButton_1_1_2_1.setBorderPainted(false);
		btnNewButton_1_1_2_1.setBounds(531, 174, 45, 30);
		MainPanel.add(btnNewButton_1_1_2_1);
		
		JButton LoginButton_1 = new JButton("");
		LoginButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		LoginButton_1.setForeground(new Color(139, 0, 0));
		LoginButton_1.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_1.setContentAreaFilled(false);
		LoginButton_1.setBorderPainted(false);
		LoginButton_1.setBounds(510, 224, 33, 36);
		MainPanel.add(LoginButton_1);
		
		JButton LoginButton_2 = new JButton("");
		LoginButton_2.setForeground(new Color(139, 0, 0));
		LoginButton_2.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_2.setContentAreaFilled(false);
		LoginButton_2.setBorderPainted(false);
		LoginButton_2.setBounds(557, 224, 33, 36);
		MainPanel.add(LoginButton_2);
		
		JButton LoginButton_3 = new JButton("");
		LoginButton_3.setForeground(new Color(139, 0, 0));
		LoginButton_3.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_3.setContentAreaFilled(false);
		LoginButton_3.setBorderPainted(false);
		LoginButton_3.setBounds(463, 270, 33, 36);
		MainPanel.add(LoginButton_3);
		
		JButton LoginButton_4 = new JButton("");
		LoginButton_4.setForeground(new Color(139, 0, 0));
		LoginButton_4.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_4.setContentAreaFilled(false);
		LoginButton_4.setBorderPainted(false);
		LoginButton_4.setBounds(510, 270, 33, 36);
		MainPanel.add(LoginButton_4);
		
		JButton LoginButton_5 = new JButton("");
		LoginButton_5.setForeground(new Color(139, 0, 0));
		LoginButton_5.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_5.setContentAreaFilled(false);
		LoginButton_5.setBorderPainted(false);
		LoginButton_5.setBounds(557, 270, 33, 36);
		MainPanel.add(LoginButton_5);
		
		JButton LoginButton_6 = new JButton("");
		LoginButton_6.setForeground(new Color(139, 0, 0));
		LoginButton_6.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_6.setContentAreaFilled(false);
		LoginButton_6.setBorderPainted(false);
		LoginButton_6.setBounds(463, 316, 33, 36);
		MainPanel.add(LoginButton_6);
		
		JButton LoginButton_7 = new JButton("");
		LoginButton_7.setForeground(new Color(139, 0, 0));
		LoginButton_7.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_7.setContentAreaFilled(false);
		LoginButton_7.setBorderPainted(false);
		LoginButton_7.setBounds(510, 316, 33, 36);
		MainPanel.add(LoginButton_7);
		
		JButton LoginButton_8 = new JButton("");
		LoginButton_8.setForeground(new Color(139, 0, 0));
		LoginButton_8.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_8.setContentAreaFilled(false);
		LoginButton_8.setBorderPainted(false);
		LoginButton_8.setBounds(557, 316, 33, 36);
		MainPanel.add(LoginButton_8);
		
		JButton LoginButton_9 = new JButton("");
		LoginButton_9.setForeground(new Color(139, 0, 0));
		LoginButton_9.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_9.setContentAreaFilled(false);
		LoginButton_9.setBorderPainted(false);
		LoginButton_9.setBounds(463, 362, 33, 36);
		MainPanel.add(LoginButton_9);
		
		JButton LoginButton_10 = new JButton("");
		LoginButton_10.setForeground(new Color(139, 0, 0));
		LoginButton_10.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_10.setContentAreaFilled(false);
		LoginButton_10.setBorderPainted(false);
		LoginButton_10.setBounds(510, 362, 33, 36);
		MainPanel.add(LoginButton_10);
		
		JButton LoginButton_11 = new JButton("");
		LoginButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		LoginButton_11.setForeground(new Color(139, 0, 0));
		LoginButton_11.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_11.setContentAreaFilled(false);
		LoginButton_11.setBorderPainted(false);
		LoginButton_11.setBounds(557, 362, 33, 36);
		MainPanel.add(LoginButton_11);
		
		JButton LoginButton_6_1 = new JButton("");
		LoginButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		LoginButton_6_1.setForeground(new Color(139, 0, 0));
		LoginButton_6_1.setFont(new Font("궁서체", Font.PLAIN, 29));
		LoginButton_6_1.setContentAreaFilled(false);
		LoginButton_6_1.setBorderPainted(false);
		LoginButton_6_1.setBounds(220, 270, 101, 104);
		MainPanel.add(LoginButton_6_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(287, 189, 45, 47);
		MainPanel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1.setContentAreaFilled(false);
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBounds(531, 136, 17, 15);
		MainPanel.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1_1.setContentAreaFilled(false);
		btnNewButton_2_1_1_1.setBorderPainted(false);
		btnNewButton_2_1_1_1.setBounds(236, 183, 39, 15);
		MainPanel.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_2.setContentAreaFilled(false);
		btnNewButton_2_1_2.setBorderPainted(false);
		btnNewButton_2_1_2.setBounds(339, 189, 45, 47);
		MainPanel.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_1_1_2_2 = new JButton("");
		btnNewButton_1_1_2_2.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Ingame_inventory\\Inventory.png"));
		btnNewButton_1_1_2_2.setContentAreaFilled(false);
		btnNewButton_1_1_2_2.setBorderPainted(false);
		btnNewButton_1_1_2_2.setBounds(142, 475, 488, 70);
		MainPanel.add(btnNewButton_1_1_2_2);
				
	}
}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {//이미지 추가
		this.img=img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));//넓이 높이 최대값 지정
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}	
	public int getWidth() {
		return img.getWidth(null);
		
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {//이미지가 자동으로 비춰짐
		g.drawImage(img, 0, 0, null);
	}
}
