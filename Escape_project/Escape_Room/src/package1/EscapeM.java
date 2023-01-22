package package1;

import javax.swing.border.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;	
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;	
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;

/*************************************************************************************************************************************************************************
 * 
 * 
 *								                                        시작화면		
 *		
 *			
 *************************************************************************************************************************************************************************/

public class EscapeM {
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Start_Background.png").getImage());//메인 화면 이미지 불러오기
	static Clip clip;
	static JFrame frame=new JFrame();
	int count=-1;
	int flag=0;
    static int Data_Load=0;
    private JTextField ID_textField;
    static  private JPasswordField Password_textField;
	public  static Object []object=null;
	static boolean music=true;
    public static void Map_Move(Object []arr){
    
    EscapeM.frame.getContentPane().removeAll();
    EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
			
	for(int i=0; i<arr.length; i++)
	{
		EscapeM.frame.getContentPane().add((Container)arr[i]);
	}
		EscapeM.frame.repaint();
	}
    
    static void sound(String file, boolean Loop) {
		// TODO Auto-generated method stub
		try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));

		if ( Loop) {
			clip.loop(-1);
		}
		else 
		clip.stop();

		} catch (Exception e) {

		e.printStackTrace();
		}
	}
	static void Button_Shape(JButton button)
	{

		button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		button.setFocusPainted(false);
	}

/************************************************************************************************************
* 							                     	메인함수
* ***********************************************************************************************************/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscapeM window = new EscapeM();
					window.frame.setVisible(true);
					frame.setLocationRelativeTo(null);//프레임 중앙에 표시
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 어플리케이션 만들기
	 */
	
	public EscapeM() {
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setFocusable(true);
		frame.requestFocus();
			
	    new gamedata();
	    
	    File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Main_bgm.wav");
	    System.out.println(file.exists()); //true
	     
	     try {     
	    	 AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         clip=AudioSystem.getClip();
	         clip.open(stream);
	         clip.start();
	         sound("C:\\Escape_project\\Escape_Room\\sound\\Main_bgm.wav",true);
	     } catch(Exception e) {
	         
	         e.printStackTrace();
	     }

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//아이콘 로고 넣기
		frame.setSize(MainPanel.getWidth(),MainPanel.getWidth());
		frame.getContentPane().add(MainPanel);	
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("학교탈출");//프로그램 이름 지정	
		frame.setBounds(100, 100, 800, 600);//화면 크기 지정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JLabel ID_Label = new JLabel("ID");//ID레이블 생성
		ID_Label.setForeground(new Color(128, 0, 0));//ID 색 지정
		ID_Label.setFont(new Font("궁서체", Font.PLAIN, 25));//폰트 지정
		ID_Label.setBounds(206, 236, 40, 34);//위치 지정
		MainPanel.add(ID_Label);//ID레이블 추가
		
		ID_textField = new JTextField();
		ID_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));//폰트 지정
		ID_textField.setToolTipText("");
		ID_textField.setBounds(261, 235, 277, 34);//위치 지정
		MainPanel.add(ID_textField);
		
		ID_textField.setColumns(10);
		
		JLabel Password_Label = new JLabel("Password");//Password 레이블 생성
		Password_Label.setForeground(new Color(128, 0, 0));//Password 색 지정
		Password_Label.setFont(new Font("궁서체", Font.PLAIN, 25));//글씨체 선정
		Password_Label.setBounds(143, 293, 110, 34);//위치선정
		MainPanel.add(Password_Label);//Password레이블 추가
			
		Password_textField = new JPasswordField();//암호화된 Password 텍스트 필드 선언
		Password_textField.setBounds(261, 293, 277, 34);
		MainPanel.add(Password_textField);
			
		JButton LoginButton = new JButton("Login");//login 레이블 생성
		LoginButton.setFont(new Font("궁서체", Font.PLAIN, 29));//글씨체 선정
		LoginButton.setForeground(new Color(139, 0, 0));
		LoginButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		LoginButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		LoginButton.setBounds(550, 247, 158, 65);
		MainPanel.add(LoginButton);
	
		LoginButton.setFocusPainted(false);
				
		JButton ID_Find_Button = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		ID_Find_Button.setFocusPainted(false);//ID찾기 버튼 추가
		ID_Find_Button.addActionListener(new ActionListener() {//ID찾기 버튼 누를시 이밴트 발생
			
			public void actionPerformed(ActionEvent arg0) {
				new ID_FIND();
			}
		});
		
		LoginButton.addActionListener(new ActionListener() {//로그인 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				String id=ID_textField.getText().trim();
				String pw=Password_textField.getText().trim();
			    
				if(id.equals("Admin")&&pw.equals("123456789"))
				{	    
					JOptionPane.showMessageDialog(null,"관리자로그인","",JOptionPane.INFORMATION_MESSAGE);
					new gamedata();
				}
				else if(id.equals(""))
				{		
					JOptionPane.showMessageDialog(null,"아이디를 입력해주세요","",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(pw.equals(""))			
				{
					JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					  for(int i=0; i<gamedata.table.getRowCount(); i++)
						 {
						  System.out.println(gamedata.table.getRowCount());
							 if(gamedata.table.getValueAt(i, 1).equals(id)&&gamedata.table.getValueAt(i, 2).equals(pw))
							 {
			                  new IN_GAME();//메뉴 화면 이동
			                  break;                  
							 }
							 else if(i==7) 
							 {
								 
								  System.out.println(gamedata.table.getRowCount());
									 if(gamedata.table.getValueAt(i, 1).equals(id)&&gamedata.table.getValueAt(i, 2).equals(pw))
									 {
										 
									 }
								 JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 일치하지 않습니다.","",JOptionPane.INFORMATION_MESSAGE);
							 }	
						 }
				}    
			}
		});
	        	
		ID_Find_Button.setForeground(Color.WHITE);//글씨 색깔 흰색 
		ID_Find_Button.setFont(new Font("넥슨Lv1고딕", Font.BOLD, 12));
		ID_Find_Button.setContentAreaFilled(false);
		ID_Find_Button.setBorderPainted(false);
		ID_Find_Button.setBounds(261, 334, 103, 21);
		MainPanel.add(ID_Find_Button);
		
		JLabel Stick_Label1 = new JLabel("             |");//수직선(기호)레이블 추가
		Stick_Label1.setForeground(Color.WHITE);
		Stick_Label1.setFont(new Font("넥슨Lv1고딕", Font.BOLD, 12));
		Stick_Label1.setBounds(306, 337, 58, 15);
		MainPanel.add(Stick_Label1);
		
		JButton Password_Find_Button = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");//Password찾기 버튼 추가
		Password_Find_Button.addActionListener(new ActionListener() {//Password찾기 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new PW_FIND();
			}
		});
		
		Password_Find_Button.setFocusPainted(false);
		Password_Find_Button.setForeground(Color.WHITE);
		Password_Find_Button.setFont(new Font("넥슨Lv1고딕", Font.BOLD, 12));
		Password_Find_Button.setContentAreaFilled(false);
		Password_Find_Button.setBorderPainted(false);
		Password_Find_Button.setBounds(351, 334, 115, 21);
		MainPanel.add(Password_Find_Button);
		
		JLabel Stick_Label2 = new JLabel("             |");//수직선(기호)레이블 추가
		Stick_Label2.setForeground(Color.WHITE);
		Stick_Label2.setFont(new Font("넥슨Lv1고딕", Font.BOLD, 12));
		Stick_Label2.setBounds(408, 337, 58, 15);
		MainPanel.add(Stick_Label2);
		
		JButton SignUP_Button = new JButton("\uD68C\uC6D0\uAC00\uC785");//회원가입 버튼 추가
		SignUP_Button.setForeground(Color.WHITE);
		SignUP_Button.setFocusPainted(false);
		SignUP_Button.setFont(new Font("넥슨Lv1고딕", Font.BOLD, 12));
		SignUP_Button.setBounds(454, 334, 87, 21);
		SignUP_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		LoginButton.setFocusPainted(false);
		
		SignUP_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MainPanel.add(SignUP_Button);
		
		JButton btnNewButton_4 = new JButton("\uAD00\uB9AC\uC790\uAD8C\uD55C");
		btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton_4.setForeground(new Color(128, 128, 128));
		btnNewButton_4.setContentAreaFilled(false);//버튼 색 투명하게 하기
		btnNewButton_4.setBorderPainted(false);//버튼 선 색 투명하게 하기

		btnNewButton_4.setBounds(-20, 10, 178, 54);
		btnNewButton_4.addActionListener(new ActionListener() {//ID찾기 버튼 누를시 이밴트 발생
						public void actionPerformed(ActionEvent arg0) {
				new gamedata();
			}
		});
		MainPanel.add(btnNewButton_4);
		ImageIcon icon =new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Option_Sound_Off.png");
	    ImageIcon icon2=new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Option_Sound_On.png");
		JButton btnNewButton_5 = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Option_Sound_On.png"));
		JButton btnNewButton_6 = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Option_Sound_Off.png"));
		btnNewButton_6.setForeground(new Color(128, 128, 128));
		btnNewButton_6.setContentAreaFilled(false);//버튼 색 투명하게 하기
		btnNewButton_6.setBorderPainted(false);//버튼 선 색 투명하게 하기
		btnNewButton_6.setBounds(12, 523, 33, 21);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
                if(count%2==1)				{
                	btnNewButton_5.setIcon(icon2);
				sound("C:\\Escape_project\\Escape_Room\\sound\\Main_bgm.wav",true);
                }
                else {
                	btnNewButton_5.setIcon(icon);
                sound("C:\\Escape_project\\Escape_Room\\sound\\\\Main_bgm.wav",false);
                }
			}
		});
		  
		btnNewButton_5.setForeground(new Color(128, 128, 128));
		btnNewButton_5.setContentAreaFilled(false);//버튼 색 투명하게 하기
		btnNewButton_5.setBorderPainted(false);//버튼 선 색 투명하게 하기
		btnNewButton_5.setBounds(12, 490, 92, 54);
		btnNewButton_5.setFocusPainted(false);
		MainPanel.add(btnNewButton_5);
		
		SignUP_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new join();
				
			}
		});
				
	}
}



/************************************************************************************************************
* 							                     	회원가입 데이터 저장
* ***********************************************************************************************************/

class Data
{
   private String ID;
   private String PW;
   private String NAME;
   private int flag;
   
   public Data(String id,String pw,String name) 
   {
	   for(int i=0; i<gamedata.table.getRowCount(); i++)
		 {
			 if(gamedata.table.getValueAt(i, 0).equals(name))
			 {
				JOptionPane.showMessageDialog(null,"이름중복","중복메시지",JOptionPane.INFORMATION_MESSAGE);
                flag=1;
                break;
                
			 }
			if(gamedata.table.getValueAt(i,1).equals(id))
			 {
				JOptionPane.showMessageDialog(null,"아이디중복","중복메시지",JOptionPane.INFORMATION_MESSAGE);
				flag=1;
				break;
			 }
			 if(gamedata.table.getValueAt(i,2).equals(pw))
			 {
				JOptionPane.showMessageDialog(null,"비밀번호중복","중복메시지",JOptionPane.INFORMATION_MESSAGE);
				flag=1;
				break;
			 }		 
		 }
	
	   try {
		   if(flag!=1) {
		    
			   JOptionPane.showMessageDialog(null,"가입완료","",JOptionPane.INFORMATION_MESSAGE);
		   File file = new File("D:\\Data.txt");
	   FileWriter writer=new FileWriter(file,true);

	   writer.write("\r\n"+name+" "+id+" "+pw);	  
	   writer.flush();

       // 객체 닫기
	   writer.close();
		   }	   
	   }
  catch(Exception e){
       e.printStackTrace();
   }
   }
}

/************************************************************************************************************
* 							                     	회원가입
* ***********************************************************************************************************/

class join 
{ 
	private static final String JPasswordField = null;
	JFrame frame;	
	private static JPasswordField makePasswordField() {
    JPasswordField pf = new JPasswordField(20);
    pf.setText("tutorialspoint");
    pf.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    return pf;
    }
	join(){
		frame = new JFrame();
	    frame.getContentPane().setBackground(Color.WHITE);
	    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//아이콘 로고 넣기
	    frame.getContentPane().setForeground(new Color(119, 136, 153));
	    frame.getContentPane().setLayout(null); 
	    frame.setResizable(false);
	    JLabel lblNewLabel = new JLabel("\uAC00\uC785\uD558\uAE30");
	    lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 29));
	    lblNewLabel.setBounds(88, 10, 122, 54);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JTextField textArea = new JTextField("\uC774\uB984");
	    textArea.setOpaque(false);
	    textArea.addMouseListener(new MouseAdapter(){
	    	@Override 
	    	public void mouseClicked(MouseEvent e)
	    	{
	    		textArea.setForeground(new Color(3, 7, 0));
	    		textArea.setText("");	
	    		}		
	    	});
	    
	    textArea.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	    textArea.setForeground(Color.LIGHT_GRAY);
	    textArea.setBounds(59, 74, 177, 29);
	    frame.getContentPane().add(textArea);
	
        JTextField textField = new JTextField("아이디");
	    textField.setOpaque(false);
	    textField.setForeground(Color.LIGHT_GRAY);
	    textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	    textField.setBounds(59, 130, 177, 29);
	    textField.addMouseListener(new MouseAdapter(){
	    	@Override 
	    	public void mouseClicked(MouseEvent e){
	    		textField.setForeground(new Color(3, 7, 0));
	            textField.setText("");
	            }	
	    	});	
	    frame.getContentPane().add(textField);
	
	    JPasswordField textField_1 =new JPasswordField("비밀번호");
	    textField_1.setEchoChar((char)0);
	    textField_1.setOpaque(false);
	    textField_1.setForeground(Color.LIGHT_GRAY);
	    textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	    textField_1.setBounds(59, 191, 177, 29);

	    textField_1.addMouseListener(new MouseAdapter(){
	    	@Override 
	    	public void mouseClicked(MouseEvent e){
	    		textField_1.setForeground(new Color(3, 7, 0));
	            textField_1.setText("");
	            textField_1.setEchoChar('*');	
	            }	
	    	});
	    
	    frame.getContentPane().add(textField_1);
	    JButton btnNewButton = new JButton("\uAC00\uC785\uD558\uAE30");
	    btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	    btnNewButton.setForeground(Color.WHITE);
	    btnNewButton.setBackground(Color.black);
	    btnNewButton.addActionListener(new ActionListener() {//ID찾기 버튼 누를시 이밴트 발생
	    	public void actionPerformed(ActionEvent arg0) {
	    		String str=textField.getText().trim();     //아이디
			    String str2=textField_1.getText().trim();  //비밀번호
			   String str3=textArea.getText().trim();    //이름
			   new Data(str,str2,str3);
			   }
	    	});
	    
	    btnNewButton.setBounds(53, 319, 183, 45);
	    btnNewButton.setFocusPainted(false);//ID찾기 버튼 추가
	    frame.getContentPane().add(btnNewButton);
	
	    JLabel lblNewLabel_1 = new JLabel("\uC774\uBBF8 \uACC4\uC815\uC774 \uC788\uC2B5\uB2C8\uAE4C?");
	    lblNewLabel_1.setForeground(Color.GRAY);
	    lblNewLabel_1.setBounds(59, 369, 130, 21);
	    frame.getContentPane().add(lblNewLabel_1);
	
	    JLabel lblNewLabel_2 = new JLabel("\uB85C\uADF8\uC778\uD558\uAE30");
	    lblNewLabel_2.setForeground(Color.BLACK);
	    lblNewLabel_2.setBounds(181, 372, 60, 15);
	    frame.getContentPane().add(lblNewLabel_2);
			
	    TextArea textPane_2 = new TextArea();
	    frame.setBounds(100, 100, 305, 464);
	    frame.setLocationRelativeTo(null);//프레임 중앙에 표시
        frame.setVisible(true);
        }
	}

/************************************************************************************************************
* 							                     	아이디 찾기
* ***********************************************************************************************************/

class ID_FIND
{
	JFrame frame;	
	ID_FIND()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 342, 320);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//프레임 중앙에 표시
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//아이콘 로고 넣기
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel.setBounds(83, 10, 189, 71);
		
		frame.getContentPane().add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("굴림", Font.PLAIN, 12));
		textField.setText("이름");
		textField.setOpaque(false);
	   
		textField.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				textField.setForeground(new Color(3, 7, 0));
		        textField.setText("");
		        }	
			});
		
		textField.setBounds(61, 104, 203, 21);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
	
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.black);		
		btnNewButton.setFocusPainted(false);
		
		btnNewButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textField.getText().trim();
				 for(int i=0; i<gamedata.table.getRowCount(); i++)
				 {
					 if(gamedata.table.getValueAt(i, 0).equals(str))
					 {
						JOptionPane.showMessageDialog(null,gamedata.table.getValueAt(i, 1)+"입니다","",JOptionPane.INFORMATION_MESSAGE);      
					 }
			}
			}
		});
		btnNewButton.setBounds(61, 160, 203, 45);
		frame.getContentPane().add(btnNewButton);	
		frame.setVisible(true);	
	}
}

/************************************************************************************************************
* 							                     	비밀번호 찾기
* ***********************************************************************************************************/

class PW_FIND
{
	JFrame frame;

	PW_FIND(){
	frame = new JFrame();
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//아이콘 로고 넣기
	frame.setBounds(100, 100, 342, 320);
	frame.setLocationRelativeTo(null);//프레임 중앙에 표시
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.WHITE);
	
	JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
	lblNewLabel.setBounds(75, 10, 177, 71);
	frame.getContentPane().add(lblNewLabel);
	lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 27));

	JTextField	textField = new JTextField();
	textField.setText("\uC774\uB984");
	
	frame.getContentPane().add(textField);
	textField.setColumns(10);
    textField.setOpaque(false);
	textField.setForeground(Color.LIGHT_GRAY);
	textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	textField.setBounds(75, 79, 177, 29);
	textField.addMouseListener(new MouseAdapter(){
		@Override 
		public void mouseClicked(MouseEvent e){
			textField.setText("");
			}
		});
	JTextField textField_1 = new JTextField();
	textField_1.setText("\uC544\uC774\uB514");
	textField_1.setOpaque(false);
	textField_1.setForeground(Color.LIGHT_GRAY);
	textField_1.setColumns(10);
	textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	textField_1.setBounds(75, 118, 177, 29);
    textField_1.addMouseListener(new MouseAdapter()
    {
    	@Override 
    	public void mouseClicked(MouseEvent e){
    		textField_1.setText("");
    		}
    	});

	frame.getContentPane().add(textField_1);
	
	JButton btnNewButton_2 = new JButton("\uD655\uC778\uD558\uAE30");
	btnNewButton_2.setFocusPainted(false);//ID찾기 버튼 추가
	btnNewButton_2.setBounds(75, 191, 177, 40);
	btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	btnNewButton_2.setForeground(Color.WHITE);
	btnNewButton_2.setBackground(Color.black);
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String str=textField.getText().trim();
			String str2=textField_1.getText().trim();
			 for(int i=0; i<gamedata.table.getRowCount(); i++)
			 {
				 if(gamedata.table.getValueAt(i, 0).equals(str)&&gamedata.table.getValueAt(i, 1).equals(str2))
				 {
					JOptionPane.showMessageDialog(null,gamedata.table.getValueAt(i, 2)+"입니다","",JOptionPane.INFORMATION_MESSAGE);
        
				 }
			 }
		}
	});
	frame.getContentPane().add(btnNewButton_2);	
	frame.setVisible(true);
	}
}

/*************************************************************************************************************************************************************************
 * 
 * 
 *								                                        메뉴화면	
 *		
 *			
 *************************************************************************************************************************************************************************/

class IN_GAME extends JFrame
{  
	JLabel Menu_Label=new JLabel();
	static ImagePanel Menu_Background=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Menu_Background.png").getImage());//메뉴 배경 이미지
	JButton New_Button = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\New_Menu.png"));
	JButton Rank_Button = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Rank_Menu.png"));
    JButton Exit_Button = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Exit_Menu.png"));
    
	IN_GAME()
	{
		EscapeM.object=null;
	
		New_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		New_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		New_Button.setFocusPainted(false);
		New_Button.setBounds(341, 248, 137, 41);
	
		Rank_Button.addActionListener(new ActionListener() {//로그인 버튼 누를시 이벤트 발생
				public void actionPerformed(ActionEvent arg0) {
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Button_Sound.wav");
					System.out.println(file.exists()); //true
					
					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					    Clip clip = AudioSystem.getClip();
					    clip.open(stream);
					    clip.start();
					    } catch(Exception e) {
					    	e.printStackTrace();
					     }
					JFrame frame=new JFrame();
				    new Rank(frame);		  	
				}
			});
		New_Button.addActionListener(new ActionListener() {//게임시작 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.sound("C:\\Escape_project\\Escape_Room\\sound\\Main_bgm.wav",false);
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Button_Sound.wav");
				System.out.println(file.exists()); //true
				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				    Clip clip = AudioSystem.getClip();
				    clip.open(stream);
				    clip.start();
				    } catch(Exception e) {
				    	e.printStackTrace();
				     }
				new C817();  	
				}
			});
		Rank_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Rank_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Rank_Button.setFocusPainted(false);
		Rank_Button.setBounds(341, 311, 137, 41);

		Exit_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Exit_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Exit_Button.setFocusPainted(false);
		Exit_Button.setBounds(341, 374, 137, 41);
		
		Exit_Button.addActionListener(new ActionListener() {//메뉴 종료 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Button_Sound.wav");
				System.out.println(file.exists()); //true
				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				    Clip clip = AudioSystem.getClip();
				    clip.open(stream);
				    clip.start();
				    } catch(Exception e) {
				    	e.printStackTrace();
				     }
				System.exit(0);
			}
		});
	
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.frame.repaint();
		EscapeM.object =new Object[] {New_Button,Rank_Button,Exit_Button,Menu_Background};
		EscapeM.Map_Move(EscapeM.object);
		  
	}
}

/************************************************************************************************************
* 							                     	메뉴 랭킹 데이터
* ***********************************************************************************************************/

class gamedata
{
	static JTable table;
	JFrame frame = new JFrame();
	
	gamedata()
	{	
		 table = new JTable(new DefaultTableModel(	 
			 	new Object[][] {
			 		{"xxx","Admin","123456789"}
				},
			 	new String[] {
			 		"이름","아이디","비밀번호"
			 	}
			 )); 
		 int j=1;
		 JScrollPane scroll=new JScrollPane(table);
		 frame.getContentPane().add(scroll);
		 String filepath="C:\\Data.txt";
		 int count=0;
		 File file=new File(filepath);
		 try{
			 BufferedReader br=new BufferedReader(new FileReader(file));
			 DefaultTableModel model=(DefaultTableModel)table.getModel();
			 Object []obj= br.lines().toArray();
			 
			 for(int i=0; i<obj.length; i++)
				{
					String line =obj[i].toString().trim();
			
					System.out.println(j);
					String[] datarow=line.split(" ");
				
					model.insertRow(j,datarow);
	
					j++;
				}
			}
			catch(Exception e){	
			}
		 if(EscapeM.Data_Load!=0) {
			 frame.setSize(500,500);
			 frame.setBounds(100, 100, 450, 300);
	         frame.setVisible(true);
	         }
		 EscapeM.Data_Load=1;
		 }
	}

/************************************************************************************************************
* 							                     	메뉴 랭킹화면
* ***********************************************************************************************************/

class Rank
{
	JTable table2 = new JTable();
    private JScrollPane scrollPane;
	ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\LankBackground.png").getImage());//메인 화면 이미지 불러오기

	Rank(JFrame frame)
	{		
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton_Menu.png"));
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(662, 514, 107, 36);
		
		EscapeM.frame.setSize(MainPanel.getWidth(),MainPanel.getWidth());
		EscapeM.object=null;
		table2.setFont(new Font("넥슨Lv1고딕", Font.PLAIN, 15));
		table2.setForeground(Color.WHITE);
		table2.setRowHeight(30);
		table2.setBackground(new Color(0,0,0,0));
		table2.setModel(new DefaultTableModel(
				new Object[][] {
					{"\uC21C\uC704","\uACC4\uC815","\uD074\uB9AC\uC5B4\uC2DC\uAC04","\uB0A0\uC9DC"},
				    {"   1", null, null, null},
				    {"   2", null, null, null},
				    {"   3", null, null, null},
				    {"   4", null, null, null},
				    {"   5", null, null, null},
				    {"   6", null, null, null},
				    {"   7", null, null, null},
				    {"   8", null, null, null},
				    {"   9", null, null, null},
				    {"   10", null, null, null},
				    },
				new String[] {
						"\uC21C\uC704", "\uACC4\uC815", "\uD074\uB9AC\uC5B4 \uC2DC\uAC04", "\uB0A0\uC9DC"
						}
				    ));
		table2.getColumnModel().getColumn(0).setPreferredWidth(59);
		table2.getColumnModel().getColumn(1).setPreferredWidth(62);
		table2.getColumnModel().getColumn(2).setPreferredWidth(85);
		table2.getColumnModel().getColumn(3).setPreferredWidth(83);
	    table2.setBounds(145, 160, 500, 550);
        scrollPane = new JScrollPane(table2);
	    MainPanel.setSize(30,30);
	    
	    BackButton.addActionListener(new ActionListener() {//랭킹 나가기 버튼 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Button_Sound.wav");
				System.out.println(file.exists()); //true
				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				    Clip clip = AudioSystem.getClip();
				    clip.open(stream);
				    clip.start();
				    } catch(Exception e) {
				    	e.printStackTrace();
				     }
				new IN_GAME();
			}
		});
	    
	    EscapeM.frame.getContentPane().removeAll();
	    EscapeM.frame.getContentPane().update(EscapeM.frame.getContentPane().getGraphics());
        EscapeM.frame.setSize(800,600);
	    EscapeM.object=new Object[]{BackButton,table2,MainPanel};
	    EscapeM.Map_Move(EscapeM.object);

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

/*************************************************************************************************************************************************************************
 * 
 * 
 *								                                        인게임 구현		
 *		
 *			
 *************************************************************************************************************************************************************************/

/************************************************************************************************************
* 							                     	인벤토리
* ***********************************************************************************************************/

class setInventory{ //인벤토리 배치를 위한 클래스
	static boolean back_of_C817_key = false;
	static boolean beam_usb = false;
	static boolean hammer = false;
	static boolean bbaru = false; // 빠루
	static boolean paperA = false; // 4층 화장실 앞 종이
	static boolean paperB = false; // 1층 빠루 옆의 종이
	static boolean keyA = false; // 소화전에 있는 키, 4층 정문에 쓰이는 열쇠
	static boolean keyB = false; // 화장실 안의 열쇠, 4층 정문에 쓰이는 열쇠
	static boolean keyC = false; // 8층 사물함 안 금고 속 열쇠, 4층 정문에 쓰이는 열쇠
	static JPanel first=new JPanel();
	static JPanel second=new JPanel();
	static JPanel third =new JPanel();
	static JPanel fourth=new JPanel();
	static JPanel fifth=new JPanel();
	static JPanel sixth=new JPanel();
	static JPanel sventh=new JPanel();
	static JPanel eighth=new JPanel();
	static int c=-1;
	static int index=0;
	static Inven_event1 e=new Inven_event1();
	JButton button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\CellPhone.png"));
	
	setInventory(JButton item){  	
		Container contentpane=first.getRootPane();
		
		if(0==first.getComponentCount())
		{
			first.setBounds(208,510,40,40);
			item.setBounds(3,3,40,40);
			first.add(item);
		}
		else if(0==second.getComponentCount())
		{
			second.setBounds(255,510,40,40);
			item.setBounds(3,3,40,40);
			second.add(item);
		
		}
		else if(0==third.getComponentCount())
		{
			third.setBounds(304,510,40,40);
			item.setBounds(3,3,40,40);
			third.add(item);
		}
		else if(0==fourth.getComponentCount())
		{
			fourth.setBounds(352,510,40,40);
		      item.setBounds(3,3,40,40);
			fourth.add(item);
		}
		else if(0==fifth.getComponentCount())
		{
			fifth.setBounds(403,510,40,40);
			item.setBounds(3,3,40,40);
			fifth.add(item);
		}
		else if(0==sixth.getComponentCount())
		{
			sixth.setBounds(450,510,40,40);
			item.setBounds(3,3,40,40);
			sixth.add(item);
		}
		
		else if(0==sventh.getComponentCount())
		{	
			sventh.setBounds(500,510,40,40);
		    item.setBounds(3,3,40,40);
			sventh.add(item);
		}
		else if(0==eighth.getComponentCount())
		{
			eighth.setBounds(548,510,40,40);
		     item.setBounds(3,3 ,40,40);
			eighth.add(item);
		}
		
	 EscapeM.frame.getContentPane().repaint();	
	}
}

/************************************************************************************************************
* 							                     	인벤토리 이벤트1
* ***********************************************************************************************************/

class Inven_event1
{
	public Inven_event1()
	{
		Toilet. phone2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
					Toilet.c++;
		
					if(0==Toilet.c%2){
						new Phone();
						}
					else {
						EscapeM.frame.getContentPane().removeAll();
						EscapeM.frame.getContentPane().repaint();
						for(int i=0; i<EscapeM.object.length; i++)
						{
							EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
						}
						EscapeM.frame.getContentPane().repaint();	 
					}
					}			
				}
			});
		}
}

/************************************************************************************************************
* 							                     	인벤토리 이벤트2
* ***********************************************************************************************************/

class Inven_event2
{
	static int f=-1;
	static ImagePanel hint1=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Vault_Password_Hint1_Background.png").getImage());//메뉴 배경 이미지
	
	public Inven_event2()
	{
		Floor1_Hallway.Vault_Password_Hint1_Desk_Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
					f++;				//	EscapeM.Map_Move(EscapeM.object);
					if(0==f%2){
						EscapeM.frame.getContentPane().removeAll();
						EscapeM.frame.getContentPane().repaint();
						hint1.setBounds(200,100,100,100);
						EscapeM.frame.getContentPane().add(hint1);
							
						for(int i=0; i<EscapeM.object.length; i++)
						{
							EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
						}
						EscapeM.frame.getContentPane().repaint();	 
						}
					else {
						EscapeM.frame.getContentPane().removeAll();
						EscapeM.frame.getContentPane().repaint();
						
						for(int i=0; i<EscapeM.object.length; i++)
						{
							EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
						}
						EscapeM.frame.getContentPane().repaint();	
						}
					}
				}
			});
		}
}
	   
/************************************************************************************************************
* 							                     	인벤토리 이벤트3
* ***********************************************************************************************************/

class Inven_event3
{
	static int f3=-1;
	static ImagePanel hint2=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Vault_Password_Hint2_Background.png").getImage());//메뉴 배경 이미지

	public Inven_event3()
	{
		Floor4_Hallway.Vault_Password_Hint2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
				f3++;				//	EscapeM.Map_Move(EscapeM.object);
				if(0==f3%2){
					EscapeM.frame.getContentPane().removeAll();
					EscapeM.frame.getContentPane().repaint();
					hint2.setBounds(200,100,100,100);
					EscapeM.frame.getContentPane().add(hint2);
							
					for(int i=0; i<EscapeM.object.length; i++)
					{
						EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
					}
					EscapeM.frame.getContentPane().repaint();	 
					}
				else {
					EscapeM.frame.getContentPane().removeAll();
				    EscapeM.frame.getContentPane().repaint();
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();	
				}
				}
				}
			});
		}
}

/************************************************************************************************************
* 							                     	휴대폰
* ***********************************************************************************************************/

class Phone
{
	static ImagePanel Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Main.png").getImage());
	JPanel panel=new JPanel();
	JButton note=new JButton();
	JButton contect=new JButton();
	JButton currency=new JButton();
	JButton message=new JButton();
	JButton gallery=new JButton();
	JButton option=new JButton();
	JButton note_first=new JButton();
	JButton note_second=new JButton();
	JButton note_third=new JButton();
	JButton main_back=new JButton();
	JButton p1=new JButton();
    JButton p2=new JButton();
	JButton p3=new JButton();
	JButton p4=new JButton();
	JButton p5=new JButton();
	JButton p6=new JButton();
	JButton p7=new JButton();
	JButton p8=new JButton();
	JButton p9=new JButton();
	JButton p10=new JButton();
	JButton p11=new JButton();
	JButton message1=new JButton();
	JButton message2=new JButton();
	JButton message3=new JButton();
	JButton message4=new JButton();
	JButton message5=new JButton();
	JButton gallery1=new JButton();
	JButton gallery2=new JButton();
	JButton gallery3=new JButton();
	JButton gallery4=new JButton();
	JButton gallery5=new JButton();
	JButton option1=new JButton();
	JButton option2=new JButton();
	JButton option3=new JButton();
	JButton option4=new JButton();
	JButton option5=new JButton();
	JButton option6=new JButton();
 
	static int f=1;
	Object []obj=null;
	
	public Phone()
	{
		EscapeM.frame.getContentPane().remove(Toilet.phone);
	    EscapeM.frame.getContentPane().repaint(); 
	    EscapeM.Button_Shape(note);
	    EscapeM.Button_Shape(contect);
	    EscapeM.Button_Shape(currency);
	    EscapeM.Button_Shape(message);
	    EscapeM.Button_Shape(gallery);
	    EscapeM.Button_Shape(option);
	    EscapeM.Button_Shape(note_first);
	    EscapeM.Button_Shape(note_second);
	    EscapeM.Button_Shape(note_third);
	    EscapeM.Button_Shape(main_back);
		EscapeM.Button_Shape(p1);
		EscapeM.Button_Shape(p2);
		EscapeM.Button_Shape(p3);
		EscapeM.Button_Shape(p4);
		EscapeM.Button_Shape(p5);
		EscapeM.Button_Shape(p6);
		EscapeM.Button_Shape(p7);
		EscapeM.Button_Shape(p8);
		EscapeM.Button_Shape(p9);
		EscapeM.Button_Shape(p10);
		EscapeM.Button_Shape(p11);
		EscapeM.Button_Shape(message1);
		EscapeM.Button_Shape(message2);
		EscapeM.Button_Shape(message3);
		EscapeM.Button_Shape(message4);
		EscapeM.Button_Shape(message5);
		EscapeM.Button_Shape(gallery1);
		EscapeM.Button_Shape(gallery2);
		EscapeM.Button_Shape(gallery3);
		EscapeM.Button_Shape(gallery4);
		EscapeM.Button_Shape(gallery5);
		EscapeM.Button_Shape(option1);
		EscapeM.Button_Shape(option2);
		EscapeM.Button_Shape(option3);
		EscapeM.Button_Shape(option4);
		EscapeM.Button_Shape(option5);
		EscapeM.Button_Shape(option6);
		
	    Main.setLayout(null);
	    Main.setLocation(305,29);
	
		note.setBounds(44, 110, 37, 39);
		contect.setBounds(90, 110, 37, 39);
		message.setBounds(90,351,37,39);
		currency.setBounds(44, 355, 37, 39);
		gallery.setBounds(137, 353, 37, 39);
		option.setBounds(180, 353, 37, 39);
	
		Main.add(note);
		Main.add(contect);
		Main.add(currency);
		Main.add(gallery);
		Main.add(message);
		Main.add(option);
		
		main_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Main.png").getImage());
				Main.setLocation(305,29);
				Main.add(note);
				Main.add(contect);
				Main.add(currency);
				Main.add(gallery);
				Main.add(message);
				Main.add(option);
			 
				EscapeM.frame.getContentPane().removeAll();
			    EscapeM.frame.getContentPane().repaint();
			    EscapeM.frame.getContentPane().add(Main);
			    
			    for(int i=0; i<EscapeM.object.length; i++)
			    {
			    	EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
			    }
			    EscapeM.frame.getContentPane().repaint();
				}
		});
		
		note.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Notes.png").getImage());
				f=0;
				main_back.setBounds(31,97,26,23);
				Main.setLocation(305,29);
				note_first.setBounds(37,147,186,59);
				note_second.setBounds(38,216,186,69);
				note_third.setBounds(38,298,186,83);
				Main.add(note_first);
				Main.add(note_second);
				Main.add(note_third);
				Main.add(main_back);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					

				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
			    }
			});
		
		note_first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Notes_Content1.png").getImage());
				f=0;
				
				note.setBounds(31,97,26,23);
				Main.setLocation(305,29);
				Main.add(note);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		note_second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Notes_Content2.png").getImage());
				note.setBounds(31,97,26,23);
				Main.add(note);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		note_third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Notes_Content3_Password.png").getImage());
				JPasswordField password = new JPasswordField();
				note.setBounds(31,97,26,23);
				password.setBounds(58, 167, 147, 29);
				Main.add(note);
				Main.add(password);
				Main.setLocation(305,29);
			
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		 message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message.png").getImage());
				 main_back.setBounds(31,97,26,23);
				 f=0;
				 message1.setBounds(31, 173, 196, 38);
	             message2.setBounds(32, 214, 196, 46);
	             message3.setBounds(31, 263, 196, 41);
	             message4.setBounds(31, 309, 196, 41);
	             message5.setBounds(31, 358, 196, 41);
	             Main.add(main_back);
	             Main.add(message1);
	             Main.add(message2);
	             Main.add(message3);
	             Main.add(message4);
	             Main.add(message5);
				 Main.setLocation(305,29);
				 Main.add(main_back);
		
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		 
		 message1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message_LMH.png").getImage());
				 message.setBounds(31,97,26,23);
				 Main.add(message);
				 Main.setLocation(305,29);
		
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
						
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}	
		 	});
		 
		 message2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message_1588.png").getImage());
				 message.setBounds(31,97,26,23);
				 Main.add(message);
				 Main.setLocation(305,29);
			
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
		
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}	
			 });
		 
		 message3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message_070.png").getImage());
				 message.setBounds(31,97,26,23);
				 Main.add(message);
				 Main.setLocation(305,29);
					
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}	
		 	});

		 message4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message_HKS.png").getImage());
				 message.setBounds(31,97,26,23);
				 Main.add(message);
				 Main.setLocation(305,29);
			
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}	
		 	});
		 
		 message5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Message_222.png").getImage());
				 message.setBounds(31,97,26,23);
				 Main.add(message);
				 Main.setLocation(305,29);
				
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				 
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();		
				 }	
		 	});				
		  
		 gallery.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary.png").getImage());
				 Main.add(main_back);
				 f=0;
				 Main.setLocation(305,29);
				 gallery1.setBounds(31, 132, 65, 68);
				 gallery2.setBounds(96, 134, 65, 68);
				 gallery3.setBounds(163, 133, 65, 68);
				 gallery4.setBounds(31, 203, 65, 68);
				 gallery5.setBounds(98, 204, 65, 68);
				 Main.add(gallery1);
				 Main.add(gallery2);
				 Main.add(gallery3);
				 Main.add(gallery4);
				 Main.add(gallery5);
				 Main.add(main_back);
			
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);

				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }	
			 });	
		 
		 gallery1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary1.png").getImage());
				 gallery.setBounds(31,97,26,23);
				 Main.setLocation(305,29);
				 Main.add(gallery);
					
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
			
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
			 });
		 
		 gallery2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary2.png").getImage());
				 gallery.setBounds(31,97,26,23);
				 Main.setLocation(305,29);
				 Main.add(gallery);
					
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
						
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
			 });
		 
		 gallery3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary3.png").getImage());
				 gallery.setBounds(31,97,26,23);
				 Main.setLocation(305,29);
				 Main.add(gallery);
				
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
			
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 } 
			 });
		 
		 gallery4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary4.png").getImage());
				 gallery.setBounds(31,97,26,23);
				 Main.setLocation(305,29);
				 Main.add(gallery);
		
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
						
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
		 	});
		 
		 gallery5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Gallary5.png").getImage());
				 gallery.setBounds(31,97,26,23);
				 Main.setLocation(305,29);
				 Main.add(gallery);
					
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
			 });
		 
		 option.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting.png").getImage());
                 f=0;
                 main_back.setBounds(31,97,26,23);
                 Main.add(main_back);
                 
                 EscapeM.frame.getContentPane().removeAll();
      			 EscapeM.frame.getContentPane().repaint();
      			 EscapeM.frame.getContentPane().add(Main);
      		
      			 for(int i=0; i<EscapeM.object.length; i++)
      			 {
      				 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
      			 }
      			 EscapeM.frame.getContentPane().repaint();
      			 Main.setLocation(305,29);
      			 option1.setBounds(31, 165, 195, 30);
      			 option2.setBounds(31, 206, 195, 30);
      			 option3.setBounds(31, 241, 195, 30);
      			 option4.setBounds(31, 284, 195, 40);
      			 option5.setBounds(31, 320, 195, 34);
      			 option6.setBounds(31, 355, 195, 41);
      			 Main.add(option1);
      			 Main.add(option2);
      			 Main.add(option3);
      			 Main.add(option4);
      			 Main.add(option5);
      			 Main.add(option6);
      			 }
			 });
		 
		 option1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_Wifi.png").getImage());
                 f=0;
                 Main.setLocation(305,29);
                 option.setBounds(31,97,26,23);
                 Main.add(option);
                   
                 EscapeM.frame.getContentPane().removeAll();
                 EscapeM.frame.getContentPane().repaint();
                 EscapeM.frame.getContentPane().add(Main);
   				
                 for(int i=0; i<EscapeM.object.length; i++)
                 {
                	 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
                 }
                 EscapeM.frame.getContentPane().repaint();
                 }
			 });
		 
		 option2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_Background.png").getImage());
				 f=0;
				 Main.setLocation(305,29);
				 option.setBounds(31,97,26,23);
				 Main.add(option);
                
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
					}
			 });
		 
		 option3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_Display.png").getImage());
				 f=0;
				 Main.setLocation(305,29);
				 Main.setLocation(305,29);
				 option.setBounds(31,97,26,23);
				 Main.add(option);
               
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
			
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
					}
			 });
		 
		 option4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_SoftUpdate.png").getImage());
				 f=0;
				 Main.setLocation(305,29);
				 option.setBounds(31,97,26,23);
				 Main.add(option);
             
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
			
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
		 	});
		 
		 option5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_Information.png").getImage());
				 f=0;
				 Main.setLocation(305,29);
				 option.setBounds(31,97,26,23);
				 Main.add(option);
             
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
				
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
			 });
		 
		 option6.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_Setting_Developer.png").getImage());
				 f=0;
				 Main.setLocation(305,29);
				 option.setBounds(31,97,26,23);
				 Main.add(option);
          
				 EscapeM.frame.getContentPane().removeAll();
				 EscapeM.frame.getContentPane().repaint();
				 EscapeM.frame.getContentPane().add(Main);
			
	
				 for(int i=0; i<EscapeM.object.length; i++)
				 {
					 EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				 }
				 EscapeM.frame.getContentPane().repaint();
				 }
			 });
		 
		contect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber.png").getImage());
				p1.setBounds(31, 124, 199, 30);
				p2.setBounds(31, 149, 199, 30);
				p3.setBounds(31,174,199,30);
				p4.setBounds(31,199,199,30);
				p5.setBounds(31,224,199,30);
				p6.setBounds(31,249,199,30);
				p7.setBounds(31,274,199,30);
				p8.setBounds(31,299,199,30);
				p9.setBounds(31,324,199,30);
				p10.setBounds(31,349,199,30);
				p11.setBounds(31,374,199,30);
				f=0;
				Main.add(p1);
				Main.add(p2);
				Main.add(p3);
				Main.add(p4);
				Main.add(p5);
				Main.add(p6);
				Main.add(p7);
				Main.add(p8);
				Main.add(p9);
				Main.add(p10);
				Main.add(p11);
				main_back.setBounds(31,97,26,23);
				Main.add(main_back);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_KNH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_KSH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
		
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_KLH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_BCS.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
			
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_SAH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
			
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_LMJ.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_LMH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
			
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_LSH.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);

				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
			
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_CHW.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
		
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
			
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_CHW.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
			
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		p11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_ContactNumber_HKS.png").getImage());
				f=0;
				contect.setBounds(31,97,26,23);
				Main.add(contect);
				Main.setLocation(305,29);
				
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
					
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});

		currency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/CellPhone_CallLog.png").getImage());
				f=0;
				main_back.setBounds(31,97,26,23);
				Main.add(main_back);
				Main.setLocation(305,29);
			
				EscapeM.frame.getContentPane().removeAll();
				EscapeM.frame.getContentPane().repaint();
				EscapeM.frame.getContentPane().add(Main);
						
				for(int i=0; i<EscapeM.object.length; i++)
				{
					EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
				}
				EscapeM.frame.getContentPane().repaint();
				}
			});
		
		    EscapeM.frame.getContentPane().removeAll();
		    EscapeM.frame.getContentPane().repaint();
		    EscapeM.frame.getContentPane().add(Main);
			
	
		for(int i=0; i<EscapeM.object.length; i++)
		{
			EscapeM.frame.getContentPane().add((Container)EscapeM.object[i]);
		}
		EscapeM.frame.getContentPane().repaint();	
	}
}

/************************************************************************************************************
* 							                     	817호
* ***********************************************************************************************************/

class C817 { // 첫 시작지점인 817호 구현
	static JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));
	ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Class817.png").getImage());//817호 화면 이미지 불러오기
    static  Clip clip ;
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
    static int END_KEY1;
    static int END_KEY2;
    static int END_KEY3;
	C817() {
		EscapeM.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
	
		//인벤토리 배치
		ItemPanel.setLocation(200, 500);

		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(1, 500, 141, 38);
		
		//문 버튼 배치
		JButton DoorButton=new JButton();
		DoorButton.addActionListener(new ActionListener() {//문 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new DoorOfC817();
			}
		});
		
		DoorButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		DoorButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		DoorButton.setFocusPainted(false);
		DoorButton.setBounds(120, 100, 50, 80);
		
		//게시판 버튼 배치
		JButton NoticeButton=new JButton();
		NoticeButton.addActionListener(new ActionListener() {//게시판 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new Notice();
			}
		});
		
		NoticeButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		NoticeButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		NoticeButton.setFocusPainted(false);
		NoticeButton.setBounds(50, 90, 40, 50);
		
		//화이트보드 버튼 배치
		JButton WBoardButton=new JButton();
		WBoardButton.addActionListener(new ActionListener() {//화이트보드 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new WhiteBoard();
			}
		});
		
		WBoardButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		WBoardButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		WBoardButton.setFocusPainted(false);
		WBoardButton.setBounds(523, 87, 155, 80);
		
		//빔프로젝터 스크린 버튼 배치
		JButton ScreenButton=new JButton();
		ScreenButton.addActionListener(new ActionListener() {//화이트보드 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				if (Beam.BeamPower && Beam.Usb) {//빔프로젝터의 전원이 켜져있고 usb가 꽂혀있을 경우
					new Screen();
				}
			}
		});
		
		ScreenButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		ScreenButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		ScreenButton.setFocusPainted(false);
		ScreenButton.setBounds(362, 74, 134, 93);

		//컴퓨터 버튼 배치
		JButton ComputerButton=new JButton();
		ComputerButton.addActionListener(new ActionListener() {//화이트보드 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new ComputerOfC817();
			}
		});
		
		ComputerButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		ComputerButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		ComputerButton.setFocusPainted(false);
		ComputerButton.setBounds(504, 193, 77, 44);
		
		//빔 프로젝터 버튼 배치
		JButton BeamButton=new JButton();
		BeamButton.addActionListener(new ActionListener() {//빔 프로젝터 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\프로젝터 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }
				     new Beam();
				}
			});
		
		BeamButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BeamButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BeamButton.setFocusPainted(false);
		BeamButton.setBounds(400, 10, 50, 25);
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new	BackOfC817();	
			}
		});
	
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(-25, 510, 141, 38);
		
		//817호 배경 배치
		MainPanel.setLocation(1, 1);
		if (Beam.BeamPower && Beam.Usb) { //빔프로젝터의 전원이 켜져있고 usb가 꽃혀있는 경우
			MainPanel =new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Class817_2.png").getImage());//817호 화면 이미지 불러오기	
		}
		EscapeM.frame.setFocusable(true);
		EscapeM.frame.requestFocus();
	    EscapeM.frame.addKeyListener(new KeyListener() { // List에 액션리스너를 달음.
	    	public void keyTyped(KeyEvent e) {
	    		System.out.println(e.getKeyChar()+" keyTyped key"); 
           //shift가 같이 눌렸는지 확인하는 방법
	    		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
             
	    			}
	    		else{
               
	    			}
	    		}
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		
	    	}
          // 모든 키에 반응하지만 대소문자 구분을 못한다.
	    	public void keyPressed(KeyEvent e) {
	    		
	    	}
	    	});
	    EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,ItemPanel,NoticeButton,DoorButton,BeamButton,WBoardButton,ComputerButton
	    		,ScreenButton,MainPanel};
        EscapeM.Map_Move(EscapeM.object);
        }
}


/****************************************************************************
 *								 817호 컴퓨터							
 ****************************************************************************/

class ComputerOfC817 { // 817호 컴퓨터
	Clip clip;
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Computer_Login.png").getImage());;
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
	
	ComputerOfC817() {
		EscapeM.object = null;
		JFrame Notice_frame = new JFrame();
		Notice_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Notice_frame.getContentPane().setLayout(null);
		Notice_frame.setBounds(100, 100, 800, 600);
		Notice_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//아이디 레이블
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(257, 224, 36, 36);
		
		//비밀번호 레이블
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(246, 274, 50, 36);
		
		//로그인 실패 시 레이블
		JLabel lblNewLabel_2 = new JLabel("\uC554\uD638\uAC00 \uC62C\uBC14\uB974\uC9C0\uC54A\uC2B5\uB2C8\uB2E4.\uB2E4\uC2DC \uC2DC\uB3C4\uD558\uC138\uC694.");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(257, 321, 264, 29);
		lblNewLabel_2.setVisible(false);
		
		//ID 입력 텍스트필드
		JTextField textField = new JTextField();
		textField.setBounds(305, 231, 171, 21);
		textField.setColumns(10);
		
		//Password 입력 텍스트필드
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(305, 282, 171, 21);
		
		//컴퓨터 로그인 버튼 배치
		JButton LoginButton=new JButton();
		LoginButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("deu1234") && textField_1.getText().equals("a1234")) {
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Windows(로그인 성공).wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	   
					new LoggedInComputerOfC817();
				}
				else {
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Windows(로그인 실패시).wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	   
					lblNewLabel_2.setVisible(true);
				}
			}
		});
		
		LoginButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		LoginButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		LoginButton.setFocusPainted(false);
		LoginButton.setBounds(486, 277, 24, 29);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//컴퓨터 배경 배치
		MainPanel.setLocation(1, 1);
		EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,textField,textField_1,LoginButton,lblNewLabel,lblNewLabel_1,lblNewLabel_2,MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	}
}

/****************************************************************************
 *							817호 컴퓨터 로그인 성공 시					
 ****************************************************************************/

class LoggedInComputerOfC817{
	Clip clip;
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Computer_Start.png").getImage());;
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
	
	LoggedInComputerOfC817() {
		EscapeM.object = null;
		JFrame Notice_frame = new JFrame();
		Notice_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Notice_frame.getContentPane().setLayout(null);
		Notice_frame.setBounds(100, 100, 800, 600);
		Notice_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//메모장
		ImagePanel MemoPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Computer_File_Text.png").getImage());
		MemoPanel.setLocation(203, 89);
		MemoPanel.setVisible(false);
		JLabel lblNewLabel = new JLabel("\uD14D\uC2A4\uD2B8.txt");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 11));
		lblNewLabel.setBounds(124, 120, 52, 15);
		
		//메모장 암호 입력
		ImagePanel PassPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Computer_File_Password.png").getImage());
		PassPanel.setLocation(203, 130);
		PassPanel.setVisible(false);
		JTextField textField = new JTextField();
		textField.setBounds(278, 199, 184, 23);
		textField.setColumns(10);
		textField.setVisible(false);
		
		//메모장 확인버튼 배치
		JLabel lblNewLabel_1 = new JLabel("\uC554\uD638\uAC00 \uD2C0\uB838\uC2B5\uB2C8\uB2E4.");
		JButton ExitButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Computer_File_Text_Cancel.png"));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(335, 241, 115, 30);
		lblNewLabel_1.setVisible(false);
		JButton PassExitButton = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Computer_File_Text_Cancel.png"));
		JButton PassCheckButton = new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Computer_File_Password_Check.png"));
		PassCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e1) {	         
			         e1.printStackTrace();
			     }	   
				if(textField.getText().equals("583a@b1414")) {
					PassPanel.setVisible(false);
					textField.setVisible(false);
					PassCheckButton.setVisible(false);
					PassExitButton.setVisible(false);
					lblNewLabel_1.setVisible(false);
					MemoPanel.setVisible(true);
					ExitButton.setVisible(true);
				}
				else
					lblNewLabel_1.setVisible(true);
			}
		});
		PassCheckButton.setBounds(492, 182, 70, 52);
		PassCheckButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		PassCheckButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		PassCheckButton.setFocusPainted(false);
		PassCheckButton.setVisible(false);
		
		//메모장 암호 입력창 끄기 버튼 배치
		PassExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e1) {	         
			         e1.printStackTrace();
			     }	    
				PassPanel.setVisible(false);
				textField.setVisible(false);
				PassCheckButton.setVisible(false);
				PassExitButton.setVisible(false);
				lblNewLabel_1.setVisible(false);
				textField.setText("");
			}
		});
		PassExitButton.setBounds(539, 139, 26, 23);
		PassExitButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		PassExitButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		PassExitButton.setFocusPainted(false);
		PassExitButton.setVisible(false);
		
		
		//메모장 끄기 버튼 배치
		ExitButton.setBounds(544, 92, 20, 20);
		ExitButton.addActionListener(new ActionListener() {//메모장 끄기 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				MemoPanel.setVisible(false);
				ExitButton.setVisible(false);
			}
		});
		ExitButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		ExitButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		ExitButton.setFocusPainted(false);
		ExitButton.setVisible(false);
		
		//메모장 버튼 배치
		JButton MemoButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Computer_Icon.png"));
		MemoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				PassPanel.setVisible(true);
				textField.setVisible(true);
				PassCheckButton.setVisible(true);
				PassExitButton.setVisible(true);
			}
		});
		
		MemoButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		MemoButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MemoButton.setFocusPainted(false);
		MemoButton.setBounds(124, 63, 50, 54);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//컴퓨터 배경 배치
		MainPanel.setLocation(1, 1);
		EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MemoButton,lblNewLabel_1,textField,PassExitButton,PassCheckButton,
				PassPanel,ExitButton,MemoPanel,lblNewLabel,MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	}
}

/************************************************************************************************************
* 							                     	프로젝터 빔
* ***********************************************************************************************************/

class Beam {
	static ImagePanel MainPanel;
// 빔프로젝터
	
	int count=-1;
	static boolean BeamPower = false; // 빔프로젝터 전원버튼 On/Off 설정 (초기값 : Off)
	static boolean Usb = false; //Usb가 꽂혀있는지 여부

	Beam() {
		EscapeM.object=null;
		JFrame Beam_frame = new JFrame();

		if (Usb) //Usb가 꽂혀있는 경우
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Beam_Projector2.png").getImage());
		else
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Beam_Projector.png").getImage());
		EscapeM.frame.getContentPane().removeAll();
		ImageIcon icon1=new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Beam_Projector_PowerOFF.png");
		ImageIcon icon2=new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Beam_Projector_PowerOn.png");
		JButton button=new JButton(); //빔프로젝터 버튼
		if(BeamPower) 
			button.setIcon(icon2);
		else 
			button.setIcon(icon1);
		
		Beam_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Beam_frame.getContentPane().setLayout(null);
		Beam_frame.setBounds(100, 100, 800, 600);
		
		Beam_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		button.setBounds(192,305,50,80);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BeamPower = BeamPower ? false : true;
				if(BeamPower) {
					button.setIcon(icon2);
				}
				else {
					button.setIcon(icon1);
				}
			}});
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				C817.clip.stop();
				new C817();
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//Usb 삽입버튼 배치
		JButton UsbButton = new JButton();
		UsbButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (setInventory.beam_usb) { //Usb를 갖고있는 경우
					Usb = true;
					if(setInventory.first.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.first.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.second.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.second.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.third.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.third.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.fourth.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.fourth.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.fifth.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.fifth.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.sixth.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.sixth.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.sventh.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.sventh.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					else if(setInventory.eighth.getComponent(0)==LockerOfC817.Inven_USB)
					{
						setInventory.eighth.remove(LockerOfC817.Inven_USB);
						EscapeM.frame.repaint();
					}
					MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Beam_Projector2.png").getImage());
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,button,MainPanel};
					EscapeM.Map_Move(EscapeM.object);
					setInventory.beam_usb = false;
				}
			}
		});
		
		UsbButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		UsbButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		UsbButton.setFocusPainted(false);
		UsbButton.setBounds(399, 311, 16, 36);
		
		//빔 프로젝터 배경 배치
		//MainPanel.setLocation(1, 1);	
		EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,button,UsbButton,MainPanel};
		EscapeM.Map_Move(EscapeM.object);

	}
}

/****************************************************************************
 *								817호 뒤								
 ****************************************************************************/

class BackOfC817 { // 817호 뒤
	static ImagePanel MainPanel;
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
	
	BackOfC817() {
		if (LockerOfC817.LockerOpened)  //사물함이 열려있을 경우
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Back_Class817_Open.png").getImage());
		else {
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Back_Class817.png").getImage());
		   
		}
		ItemPanel.setLocation(200, 500);
		EscapeM.object = null;
		JFrame BackOfC817_frame = new JFrame();
		BackOfC817_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		BackOfC817_frame.getContentPane().setLayout(null);
		BackOfC817_frame.setBounds(100, 100, 800, 600);
		BackOfC817_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//사물함 버튼 배치
		JButton LockerButton=new JButton();
		LockerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LockerOfC817();	
			}
		});
		
		LockerButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		LockerButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		LockerButton.setFocusPainted(false);
		LockerButton.setBounds(437, 125, 54, 174);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Right_Shifting_Button.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//817호 뒤 배경 배치
		MainPanel.setLocation(1, 1);
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,LockerButton,ItemPanel, MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	
	}
}

/****************************************************************************
 *								817호 뒤	사물함							
 ****************************************************************************/

class LockerOfC817 { // 817호 뒤 사물함
	Clip clip;
	static ImagePanel MainPanel;
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
	static boolean LockerOpened = false; // 사물함이 열려있는지 여부
         static JButton Inven_USB=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory_UsbCable.png"));
	LockerOfC817() {
		if (LockerOpened) { //사물함이 열려있을 경우
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Locker_Open.png").getImage());
		}
		else {
			MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Locker.png").getImage());
		}
		EscapeM.object = null;
		JFrame BackOfC817_frame = new JFrame();
		BackOfC817_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		BackOfC817_frame.getContentPane().setLayout(null);
		BackOfC817_frame.setBounds(100, 100, 800, 600);
		BackOfC817_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//인벤토리 배치
		//new setInventory();
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new BackOfC817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		Inven_USB.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Inven_USB.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Inven_USB.setFocusPainted(false);
		
		//사물함이 열려있을 경우 Usb 버튼 배치
		JButton UsbButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\UsbCable.png"));
		UsbButton.addActionListener(new ActionListener() { //Usb 클릭 시
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			    	 new setInventory(Inven_USB);
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	  
				setInventory.beam_usb = true;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton, MainPanel};
				EscapeM.Map_Move(EscapeM.object);
			}
		});
		
		UsbButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		UsbButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		UsbButton.setFocusPainted(false);
		UsbButton.setBounds(498, 406, 67, 82);
		
		//사물함이 닫혀있을 경우 열쇠구멍 버튼 배치
		JButton KeyButton=new JButton();
		KeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(setInventory.back_of_C817_key) { //사물함 열쇠를 갖고있을 경우 : 사물함 열기
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\사물함 여는 소리.wav");
				     System.out.println(file.exists()); //true
				  
				     try {
				    		if(setInventory.first.getComponent(0)==Notice.key_817)
							{
								setInventory.first.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.second.getComponent(0)==Notice.key_817)
							{
								setInventory.second.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.third.getComponent(0)==Notice.key_817)
							{
								setInventory.third.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.fourth.getComponent(0)==Notice.key_817)
							{
								setInventory.fourth.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.fifth.getComponent(0)==Notice.key_817)
							{
								setInventory.fifth.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.sixth.getComponent(0)==Notice.key_817)
							{
								setInventory.sixth.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.sventh.getComponent(0)==Notice.key_817)
							{
								setInventory.sventh.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
							else if(setInventory.eighth.getComponent(0)==Notice.key_817)
							{
								setInventory.eighth.remove(Notice.key_817);
								EscapeM.frame.repaint();
							}
				    	   EscapeM.frame.getContentPane().repaint();
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	   
					LockerOpened = true;
					MainPanel = new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Locker_Open.png").getImage());
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel
				,BackButton,UsbButton, MainPanel};
					EscapeM.Map_Move(EscapeM.object);
					setInventory.back_of_C817_key = false;
				}
			}
			
		});
		
		KeyButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		KeyButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		KeyButton.setFocusPainted(false);
		KeyButton.setBounds(409, 338, 45, 48);
		
		//817호 뒤 배경 배치
		MainPanel.setLocation(1, 1);
		if (LockerOpened && setInventory.beam_usb) { //사물함이 열려있고, Usb를 갖고있을 경우
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton, MainPanel,ItemPanel};
		}
		else if (LockerOpened) { //사물함이 열려있고, Usb를 갖고있을지 않을 경우// EscapeM.frame.remove(Notice.key_817);
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,UsbButton, MainPanel};
		}
		else { //사물함이 닫혀있을 경우
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,KeyButton, MainPanel};
		}
		EscapeM.Map_Move(EscapeM.object);
	
	}
}

/****************************************************************************
 *							   817호 화이트보드					
 ****************************************************************************/

class WhiteBoard { // 817호 화이트보드
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Whiteboard.png").getImage());
	
	WhiteBoard() {
		EscapeM.object = null;
		JFrame Notice_frame = new JFrame();
		Notice_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Notice_frame.getContentPane().setLayout(null);
		Notice_frame.setBounds(100, 100, 800, 600);
		Notice_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//화이트보드 배경 배치
		MainPanel.setLocation(1, 1);
		EscapeM.object=new Object[] {C817.ItemPanel,BackButton, MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	
	}
}

/****************************************************************************
 *							   817호 스크린				
 ****************************************************************************/

class Screen { // 817호 빔프로젝터 스크린
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Screen.png").getImage());
	
	Screen() {
		EscapeM.object = null;
		JFrame Notice_frame = new JFrame();
		Notice_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Notice_frame.getContentPane().setLayout(null);
		Notice_frame.setBounds(100, 100, 800, 600);
		Notice_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//화이트보드 배경 배치
		MainPanel.setLocation(1, 1);
		EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton, MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	
	}
}

/****************************************************************************
 *								817호 게시판						
 ****************************************************************************/

class Notice { // 817호 게시판
	static Clip clip;
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BulletinBoard.png").getImage());
	static JButton key_817=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Inventory_Gate_Key1.png"));
	Notice() {
		EscapeM.object = null;
		JFrame Notice_frame = new JFrame();
		Notice_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		Notice_frame.getContentPane().setLayout(null);
		Notice_frame.setBounds(100, 100, 800, 600);
		Notice_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		key_817.setContentAreaFilled(false);//버튼 색 투명하게 하기
		key_817.setBorderPainted(false);//버튼 선 색 투명하게 하기
		key_817.setFocusPainted(false);
		
		//열쇠 배치
		JButton KeyButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Key.png"));
		KeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			    	 new setInventory(Notice.key_817);
			    	 
			   
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	  
				setInventory.back_of_C817_key = true;
				EscapeM.object = new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton, MainPanel}; // 화면에서 키를 삭제
				EscapeM.Map_Move(EscapeM.object);
			}
		});
		
		KeyButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		KeyButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		KeyButton.setFocusPainted(false);
		KeyButton.setBounds(636, 103, 61, 90);
		
		//게시판 배경 배치
		MainPanel.setLocation(1, 1);
		if (setInventory.back_of_C817_key) // 키를 이미 갖고있을 경우
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton, MainPanel};
		else 
			EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,KeyButton,MainPanel};
		
		EscapeM.Map_Move(EscapeM.object);
	}
}

/****************************************************************************
 *								817호 문								
 ****************************************************************************/

class DoorOfC817 { // 문
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Class817_Door.png").getImage());
	static ImagePanel ItemPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room/image\\Inventory.png").getImage());
	
	DoorOfC817() {
		ItemPanel.setLocation(200, 500);
		JFrame DoorOfC817_frame = new JFrame();
		DoorOfC817_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		EscapeM.object=null;
		DoorOfC817_frame.getContentPane().setLayout(null);
		DoorOfC817_frame.setBounds(100, 100, 800, 600);	
		DoorOfC817_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				new C817();
				
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(-25, 510, 141, 38);
		
		//도어락 배치
		JButton DoorLockButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock.png"));
		DoorLockButton.addActionListener(new ActionListener() {//도어락 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				new DoorLock();
				
			}
		});
		DoorLockButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		DoorLockButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		DoorLockButton.setFocusPainted(false);
		DoorLockButton.setBounds(375, 200, 24, 50);
		
		//문 배치
		JButton DoorButton=new JButton();
		DoorButton.addActionListener(new ActionListener() {//문 누를 시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				if (DoorLock.DoorOpened) { // 문이 열려있을 경우
					new Floor8_Hallway(true,true);
				}
			}
		});
		DoorButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		DoorButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		DoorButton.setFocusPainted(false);
		DoorButton.setBounds(207,98,385,327);
		
		//817호 문 배경 배치
		MainPanel.setLocation(1, 1);
		
		EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,DoorLockButton,DoorButton,ItemPanel,MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	}
}

/****************************************************************************
 *								817호 도어락						
 ****************************************************************************/

class DoorLock { // 817호 도어락
	Clip clip;
	static ImagePanel MainPanel=new ImagePanel(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Class817_DoorLock.png").getImage());
	static String[] DoorLockPass = {""};//입력한 패스워드를 저장할 문자열
	static Boolean DoorOpened = false;//문이 열렸는지 닫혔는지 여부. 초기값 = false(닫힘) 
	
	DoorLock() {
		JButton B1=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number1_Off.png"));
		JButton B2=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number2_Off.png"));
		JButton B3=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number3_Off.png"));
		JButton B4=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number4_Off.png"));
		JButton B5=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number5_Off.png"));
		JButton B6=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number6_Off.png"));
		JButton B7=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number7_Off.png"));
		JButton B8=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number8_Off.png"));
		JButton B9=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number9_Off.png"));
		JButton BA=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_Asterisk_Off.png"));
		JButton B0=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number0_Off.png"));
		JButton BS=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_#_Off.png"));
		JButton DoorLockButton = new JButton();
		
		if (DoorOpened) // 문이 열려있을 경우
			DoorLockButton.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Button_On.png"));
		else
			DoorLockButton.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Button_Off.png"));
		
		EscapeM.object = null;
		JFrame DoorLock_frame = new JFrame();
		DoorLock_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Escape_project\\Escape_Room\\image\\logo.png"));//로고 설정
		
		DoorLock_frame.getContentPane().setLayout(null);
		DoorLock_frame.setBounds(100, 100, 800, 600);
		DoorLock_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1~# 버튼 배치
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "1 ";
				B1.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number1_On.png"));
			}
		});
		
		B1.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B1.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B1.setFocusPainted(false);
		B1.setBounds(335,124,45,45);
		
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "2 ";
				B2.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number2_On.png"));
			}
		});
		
		B2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B2.setFocusPainted(false);
		B2.setBounds(392,124,45,45);
		
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "3 ";
				B3.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number3_On.png"));
			}
		});
		
		B3.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B3.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B3.setFocusPainted(false);
		B3.setBounds(449,124,45,45);
		
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "4 ";
				B4.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number4_On.png"));
			}
		});
		
		B4.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B4.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B4.setFocusPainted(false);
		B4.setBounds(335,197,45,45);
		
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "5 ";
				B5.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number5_On.png"));
			}
		});
		
		B5.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B5.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B5.setFocusPainted(false);
		B5.setBounds(392,197,45,45);
		
		B6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "6 ";
				B6.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number6_On.png"));
			}
		});
		
		B6.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B6.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B6.setFocusPainted(false);
		B6.setBounds(449,197,45,45);
		
		B7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "7 ";
				B7.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number7_On.png"));
			}
		});
		
		B7.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B7.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B7.setFocusPainted(false);
		B7.setBounds(335,261,45,45);
		
		B8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "8 ";
				B8.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number8_On.png"));
			}
		});
		
		B8.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B8.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B8.setFocusPainted(false);
		B8.setBounds(392,261,45,45);
		
		B9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "9 ";
				B9.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number9_On.png"));
			}
		});
		
		B9.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B9.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B9.setFocusPainted(false);
		B9.setBounds(449,261,45,45);
		
		BA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "* ";
				BA.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_Asterisk_On.png"));
			}
		});
		
		BA.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BA.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BA.setFocusPainted(false);
		BA.setBounds(335,329,45,45);
		
		B0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "0 ";
				B0.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number0_On.png"));
			}
		});
		
		B0.setContentAreaFilled(false);//버튼 색 투명하게 하기
		B0.setBorderPainted(false);//버튼 선 색 투명하게 하기
		B0.setFocusPainted(false);
		B0.setBounds(392,329,45,45);
		
		BS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	   
				DoorLockPass[0] += "# ";
				BS.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_#_On.png"));
			}
		});
		
		BS.setContentAreaFilled(false);//버튼 색 투명하게 하기B
		BS.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BS.setFocusPainted(false);
		BS.setBounds(449,329,45,45);
		
		DoorLockButton.addActionListener(new ActionListener() { //도어락 잠금해제버튼 클릭 시
			public void actionPerformed(ActionEvent arg0) {
				if (DoorLockPass[0].equals("7 3 9 1 ")) { //패스워드가 맞을 시
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\도아락 및 금고 성공시.wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	   
					DoorOpened = true;
					DoorLockButton.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Button_On.png"));
				}
				else {
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\도아락 실패시.wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	   
				}
				DoorLockPass[0] = "";
				B1.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number1_Off.png"));
				B2.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number2_Off.png"));
				B3.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number3_Off.png"));
				B4.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number4_Off.png"));
				B5.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number5_Off.png"));
				B6.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number6_Off.png"));
				B7.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number7_Off.png"));
				B8.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number8_Off.png"));
				B9.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number9_Off.png"));
				BA.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_Asterisk_Off.png"));
				B0.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number0_Off.png"));
				BS.setIcon(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\DoorLock_Number_#_Off.png"));
			}
		});
		
		DoorLockButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		DoorLockButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		DoorLockButton.setFocusPainted(false);
		DoorLockButton.setBounds(445,405,45,45);
		
		//뒤로가기 화살표 배치
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));
		BackButton.addActionListener(new ActionListener() {//뒤로가기 화살표 버튼 누를시 이밴트 발생
			public void actionPerformed(ActionEvent arg0) {
				new DoorOfC817();	
			}
		});
		
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(650, 500, 141, 38);
		
		//817호 도어락 배경 배치
		MainPanel.setLocation(1, 1);
		EscapeM.object=new Object[] {C817.ItemPanel,setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,B1,B2,B3,B4,B5,B6,B7,B8,B9,BA,B0,BS,DoorLockButton,MainPanel};
		EscapeM.Map_Move(EscapeM.object);
	
	}
}

/*********************************************************************************************************
* 							                     	8층 복도
* ***********************************************************************************************************/

class Floor8_Hallway{
	static Clip clip;
	int back=0;
	int back2=0;
	ImagePanel Floor8_Hallway_Center=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Center.png").getImage());//8층 복도 중앙 이미지
	ImagePanel Floor8_Hallway_Left=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Left.png").getImage());//8층 복도 왼쪽 이미지
	ImagePanel Floor8_Hallway_Left2=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Left2.png").getImage());//8층 복도 왼쪽 이미지2
	ImagePanel Floor8_Hallway_Right=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Right.png").getImage());//8층 복도 으른쪽 이미지
	ImagePanel Floor8_Hallway_Right2=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Right2.png").getImage());//8층 복도 오른쪽 이미지2
	ImagePanel Floor8_Hallway_Right3=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Hallway_Right3.png").getImage());//8층 복도 오른쪽 이미지3
	ImagePanel Class811_Front_Door=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Front_Door.png").getImage());//811호 들어가기 전 화면 이미지
	ImagePanel Floor8_Elevator=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_Elevator.png").getImage());//8층 엘리베이터 이미지
	ImagePanel Floor8_Hydrant=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Hydrant.png").getImage());//8층 소화전 이미지
	ImagePanel Floor8_Hydrant_Open=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Hydrant_In.png").getImage());//8층 소화전 열린 이미지
	ImagePanel Hydrant_In_key2=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Hydrant_In_key.png").getImage());//8층 소화전 열린 이미지
static JButton In_key2=new JButton(new ImageIcon("C:/Escape_project/Escape_Room/image/Inventory_Gate_Key1.png"));
	static int get_key=0;
	
	
	Floor8_Hallway(Boolean Change,Boolean Change2) {
		
		In_key2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		In_key2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		In_key2.setFocusPainted(false);
		/************************************************************************************
		 *								  8층 중앙 복도 관련 버튼							
		 ************************************************************************************/
		JButton Straight_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Straight_Shifting_Button.png"));//4층 내려가는 버튼 이미지
		Straight_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Straight_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Straight_Shifting_Button.setFocusPainted(false);
		Straight_Shifting_Button.setBounds(225, 315, 45, 30);
		
		JButton Left_Diagonal_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Diagonal_Shifting_Button.png"));//8층 엘리버이터 가는 버튼 이미지
		Left_Diagonal_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Left_Diagonal_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Left_Diagonal_Shifting_Button.setFocusPainted(false);
		Left_Diagonal_Shifting_Button.setBounds(33, 378, 45, 30);
		
		JButton Left_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//8층 왼쪽 복도 가는 버튼 이미지
		Left_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Left_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Left_Shifting_Button.setFocusPainted(false);
		Left_Shifting_Button.setBounds(22, 518, 61, 17);
			
		JButton Right_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Right_Shifting_Button.png"));//8층 오른쪽 복도 가는 버튼 이미지
		Right_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Right_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Right_Shifting_Button.setFocusPainted(false);
		Right_Shifting_Button.setBounds(699, 518, 61, 17);	
		/************************************************************************************
		 *								  8층 복도 관련 버튼					
		 ************************************************************************************/
		JButton Floor8_Hallway_Left2_Button=new JButton();//왼쪽 복도2 화면 전환 버튼 
		Floor8_Hallway_Left2_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor8_Hallway_Left2_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor8_Hallway_Left2_Button.setFocusPainted(false);
		Floor8_Hallway_Left2_Button.setBounds(294, 260, 290, 122);
		
		JButton Hydrant_Button=new JButton();//소화전 이동 가는 버튼 이미지
		Hydrant_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Hydrant_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Hydrant_Button.setFocusPainted(false);
		Hydrant_Button.setBounds(590, 156, 51, 232);
		
		JButton Hydrant_Open_Button=new JButton();//소화전 여는 버튼 이미지
		Hydrant_Open_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Hydrant_Open_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Hydrant_Open_Button.setFocusPainted(false);
		Hydrant_Open_Button.setBounds(256, 278, 25, 122);
		
		JButton Break_Hammer_Button=new JButton();//인벤토리내 망치가 있을시 소화전내 유리를 깨뜨리는 버튼
		Break_Hammer_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Break_Hammer_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Break_Hammer_Button.setFocusPainted(false);
		Break_Hammer_Button.setBounds(459, 202, 39, 57);	
		/************************************************************************************
		 *								  8층 오른쪽 복도 관련 버튼					
		 ************************************************************************************/
		JButton Floor8_Hallway_Right2_Button=new JButton();//오른쪽 복도2 이동 버튼
		Floor8_Hallway_Right2_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor8_Hallway_Right2_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor8_Hallway_Right2_Button.setFocusPainted(false);
		Floor8_Hallway_Right2_Button.setBounds(235, 268, 219, 96);
		
		JButton Floor8_Hallway_Right3_Button=new JButton();//오른쪽 복도3 이동 버튼
		Floor8_Hallway_Right3_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor8_Hallway_Right3_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor8_Hallway_Right3_Button.setFocusPainted(false);
		Floor8_Hallway_Right3_Button.setBounds(282, 274, 236, 102);
		
		JButton Class811_Front_Door_Button=new JButton();//811호 문앞 이동 버튼
		Class811_Front_Door_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Class811_Front_Door_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Class811_Front_Door_Button.setFocusPainted(false);
		Class811_Front_Door_Button.setBounds(79, 109, 83, 307);
	
		JButton Class811_Button=new JButton();//811호 이동 버튼
		Class811_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Class811_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Class811_Button.setFocusPainted(false);
		Class811_Button.setBounds(348, 160, 114, 250);
		
		JButton Student_Locker_Button=new JButton();//사물함 이동 버튼
		Student_Locker_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Student_Locker_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Student_Locker_Button.setFocusPainted(false);
		Student_Locker_Button.setBounds(33, 189, 33, 63);
		/************************************************************************************
		 *								  8층 엘리베이터 관련 버튼					
		 ************************************************************************************/
		JButton Floor8_Elevator_Button=new JButton();//엘리베이터 안으로 이동하는 버튼
		Floor8_Elevator_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor8_Elevator_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor8_Elevator_Button.setFocusPainted(false);
		Floor8_Elevator_Button.setBounds(510, 133, 188, 308);	
		/************************************************************************************
		 *								  8층 전화면 이동 관련 버튼						
		 ************************************************************************************/
		JButton Hydrant_BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//소방전 전화면 이동 버튼
		Hydrant_BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Hydrant_BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Hydrant_BackButton.setFocusPainted(false);
		Hydrant_BackButton.setBounds(665, 504, 165, 57);

		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//왼쪽 복도 전화면 이동 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(-25, 492, 165, 57);
		
		JButton BackButton2=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//오른쪽 복도 전화면 이동 버튼
		BackButton2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton2.setFocusPainted(false);
		BackButton2.setBounds(-25, 492, 165, 57);
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		if(Change==true && Change2==true) {
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Straight_Shifting_Button,Left_Diagonal_Shifting_Button,Left_Shifting_Button,Right_Shifting_Button,Floor8_Hallway_Center};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		}
		else if(Change==false && Change2==true) {
			back=0;
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Floor8_Elevator_Button,Floor8_Elevator};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
			Floor8_Elevator_Button.addActionListener(new ActionListener() {//8층 엘리베이터 이동 버튼 이벤트
				public void actionPerformed(ActionEvent arg0) {
					 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 열리는 소리.wav");//소화전 여는 사운드 추가
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				        clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {
				         
				         e.printStackTrace();
				     }	     
					new Elevator(true);	
				}
			});	
		}
		else if(Change==true && Change2==false) {
			back2=3;
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Student_Locker_Button,Class811_Button,Class811_Front_Door};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트				
		}
		/************************************************************************************
		 *								  8층 왼쪽 복도						
		 ************************************************************************************/
		Left_Shifting_Button.addActionListener(new ActionListener() {//8층 왼쪽 복도 가는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {	
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Floor8_Hallway_Left2_Button,Floor8_Hallway_Left};
				EscapeM.Map_Move(EscapeM.object);								
			}		
		});	
		
		Floor8_Hallway_Left2_Button.addActionListener(new ActionListener() {//8층 왼쪽 복도2 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				back=1;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Hydrant_Button,Floor8_Hallway_Left2};
				EscapeM.Map_Move(EscapeM.object);		
			}
		});	
		
		Hydrant_Button.addActionListener(new ActionListener() {//소화전 이동 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				back=1;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Hydrant_BackButton,Hydrant_Open_Button,Floor8_Hydrant};
				EscapeM.Map_Move(EscapeM.object);		
			}
		});	
		
		Hydrant_Open_Button.addActionListener(new ActionListener() {//소화전 여는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {	
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\소화전 여는 소리.wav");//소화전 여는 사운드 추가
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	     
				EscapeM.object=null;
				if(get_key==0) {
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Hydrant_BackButton,Break_Hammer_Button,Floor8_Hydrant_Open};
				}
				else
				{
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Hydrant_BackButton,Break_Hammer_Button,	Hydrant_In_key2};
				
				}
			
					
				EscapeM.Map_Move(EscapeM.object);		
			}
		});		
		
		Break_Hammer_Button.addActionListener(new ActionListener() {//인벤토리내 망치가 있을시 소화전내 유리 클릭시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\유리 깨지는 소리.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			    	 get_key=1;
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	
			     
				new setInventory(In_key2);
			    C817.END_KEY1=1;
			    
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Hydrant_BackButton,Hydrant_In_key2};
				EscapeM.Map_Move(EscapeM.object);	
				
			}
		});		
		
		Hydrant_BackButton.addActionListener(new ActionListener() {//8층 왼쪽 복도2 소화전 뒤로가기 버튼 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Hydrant_Button,Floor8_Hallway_Left2};
				EscapeM.Map_Move(EscapeM.object);			
			}
		});	
		
		BackButton.addActionListener(new ActionListener() {//8층 복도 중앙 이동 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				if(back==0) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Straight_Shifting_Button,Left_Diagonal_Shifting_Button,Left_Shifting_Button,Right_Shifting_Button,Floor8_Hallway_Center};
					EscapeM.Map_Move(EscapeM.object);	
				}
				else if(back==1) {
					back=0;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Floor8_Hallway_Left2_Button,Floor8_Hallway_Left};
					EscapeM.Map_Move(EscapeM.object);		
				}
				else if(back==2) {
					back=1;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Hydrant_Button,Floor8_Hallway_Left2};
					EscapeM.Map_Move(EscapeM.object);						
				}
			}
		});			
		/************************************************************************************
		 *								  8층에서 4층 이동						
		 ************************************************************************************/
		Straight_Shifting_Button.addActionListener(new ActionListener() {//4층 내려가는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\계단소리.wav");//4층 내려가는 계단 소리 추가
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	     
				new Floor4_Hallway(true);//4층 복도 클래스 호출	
			}
		});	
		/************************************************************************************
		 *								  8층 엘리베이터						
		 ************************************************************************************/
		Left_Diagonal_Shifting_Button.addActionListener(new ActionListener() {//8층 엘리버이터 가는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Floor8_Elevator_Button,Floor8_Elevator};
				EscapeM.Map_Move(EscapeM.object);
				
				BackButton.addActionListener(new ActionListener() {//8층 왼쪽 복도2 소화전 누를시 이벤트 발생
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Hallway_Center};
						EscapeM.Map_Move(EscapeM.object);	
					}
				});	
				Floor8_Elevator_Button.addActionListener(new ActionListener() {//8층 왼쪽 복도2 소화전 누를시 이벤트 발생
					public void actionPerformed(ActionEvent arg0) {
						 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 열리는 소리.wav");//엘리베이터 열리는 소리
					     System.out.println(file.exists()); //true
					     
					     try {
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					        clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {
					         
					         e.printStackTrace();
					     }	     
						new Elevator(true);	
					}
				});	
			}
		});	
		/************************************************************************************
		 *								  8층 오른쪽 복도					
		 ************************************************************************************/
		Right_Shifting_Button.addActionListener(new ActionListener() {//8층 오른쪽 복도 가는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Floor8_Hallway_Right2_Button,Floor8_Hallway_Right};
				EscapeM.Map_Move(EscapeM.object);				
			}	
		});	
		
		Floor8_Hallway_Right2_Button.addActionListener(new ActionListener() {//오른쪽 복도2 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				back2=1;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Hallway_Right3_Button,BackButton2,Floor8_Hallway_Right2};
				EscapeM.Map_Move(EscapeM.object);			
			}
		});	
		
		Floor8_Hallway_Right3_Button.addActionListener(new ActionListener() {//오른쪽 복도3 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				back2=2;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Class811_Front_Door_Button,Floor8_Hallway_Right3};
				EscapeM.Map_Move(EscapeM.object);			
			}
		});	
		
		Class811_Front_Door_Button.addActionListener(new ActionListener() {//811호 문앞 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				back2=3;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Student_Locker_Button,Class811_Button,Class811_Front_Door};
				EscapeM.Map_Move(EscapeM.object);			
			}
		});	
		
		Class811_Button.addActionListener(new ActionListener() {//811호 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new C811();			
			}
		});	
		
		Student_Locker_Button.addActionListener(new ActionListener() {//사물함 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Locker();	
			}
		});	
			
		BackButton2.addActionListener(new ActionListener() {//오른쪽 복도 전화면 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				if(back2==0) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Straight_Shifting_Button,Left_Diagonal_Shifting_Button,Left_Shifting_Button,Right_Shifting_Button,Floor8_Hallway_Center};
					EscapeM.Map_Move(EscapeM.object);			
				}
				else if(back2==1) {
					back2=0;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Floor8_Hallway_Right2_Button,Floor8_Hallway_Right};
					EscapeM.Map_Move(EscapeM.object);		
				}
				else if(back2==2) {
					back2=1;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Floor8_Hallway_Right3_Button,Floor8_Hallway_Right2};
					EscapeM.Map_Move(EscapeM.object);			
				}
				else if(back2==3) {
					back2=2;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton2,Class811_Front_Door_Button,Floor8_Hallway_Right3};
					EscapeM.Map_Move(EscapeM.object);			
				}				
			}
		});			
	}	
}

/************************************************************************************************************
* 							                     	8층 사물함 & 금고
* **********************************************************************************************************/

class Locker{
	Clip clip;
	ImagePanel Student_Locker=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Student_Locker.png").getImage());//사물함 이미지
	ImagePanel Safe=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Safe.png").getImage());//사물함 안 금고 이미지
	ImagePanel Safe_Open=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Safe_Open.png").getImage());//열린 금고 이미지
    static JButton key=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Inventory_Gate_Key1.png"));
   static int get_key3=0;
	Locker(){
		/********************************************************************ㅊ****************
		 *								  사물함 버튼 & 금고 버튼			
		 ************************************************************************************/
		JButton Student_Locker_Button=new JButton();//사물함 여는 버튼 
		Student_Locker_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Student_Locker_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Student_Locker_Button.setFocusPainted(false);
		Student_Locker_Button.setBounds(123, 181, 195, 140);
		
		JButton Safe_On_False_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Safe_On_False.png"));//금고 비밀번호 맞을시 버튼 on
		Safe_On_False_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Safe_On_False_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Safe_On_False_Button.setFocusPainted(false);
		Safe_On_False_Button.setBounds(479, 174, 45, 30);
		
		JButton Safe_Off_False_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Safe_Off_False.png"));//금고 비밀번호 틀릴시 버튼 off
		Safe_Off_False_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Safe_Off_False_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Safe_Off_False_Button.setFocusPainted(false);
		Safe_Off_False_Button.setBounds(531, 174, 45, 30);
		
		JButton Safe_Off_On_Button=new JButton();//금고 비밀번호 틀릴시 버튼 on
		Safe_Off_On_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Safe_Off_On_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Safe_Off_On_Button.setFocusPainted(false);
		Safe_Off_On_Button.setBounds(531, 174, 45, 30);	
		/************************************************************************************
		 *								  아이템 버튼		
		 ************************************************************************************/
		JButton Gate_Key3_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Gate_Key3.png"));//정문 열쇠3 버튼 
		Gate_Key3_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Gate_Key3_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Gate_Key3_Button.setFocusPainted(false);
		Gate_Key3_Button.setBounds(333, 244, 118, 48);
		/**   			                  금고 비밀번호 버튼                                   **/
		int x=47;
		int num1=0,num2=0,num3=0,num4=0;
		JButton[] Safe_Password_Button=new JButton[12];//금고 비밀번호 버튼 담을 그릇 생성
		for(int i=0;i<Safe_Password_Button.length;i++) {
			Safe_Password_Button[i]=new JButton();
			Safe_Password_Button[i].setContentAreaFilled(false);//버튼 색 투명하게 하기
			Safe_Password_Button[i].setBorderPainted(false);//버튼 선 색 투명하게 하기
			Safe_Password_Button[i].setFocusPainted(false);
					
			if(i<3) {
				Safe_Password_Button[i].setBounds(463+(x*num1), 224, 33, 36);	
				num1++;
			}
			else if(i>2 && i<6) {
				Safe_Password_Button[i].setBounds(463+(x*num2), 270, 33, 36);
				num2++;
			}
			else if(i>5 && i<9) {
				Safe_Password_Button[i].setBounds(463+(x*num3), 316, 33, 36);
				num3++;
			}
			else {
				Safe_Password_Button[i].setBounds(463+(x*num4), 362, 33, 36);
				num4++;		
			}		
		}
		
		JButton Safe_Open_Button=new JButton();//금고 여는 버튼
		Safe_Open_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Safe_Open_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Safe_Open_Button.setFocusPainted(false);
		Safe_Open_Button.setBounds(220, 270, 101, 104);	
		/************************************************************************************
		 *								  전 화면 이동 버튼				
		 ************************************************************************************/
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//811호 문앞으로 이동하는 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Student_Locker_Button,Student_Locker};//이미지 업데이트
		EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		/************************************************************************************
		 *								  사물함 & 금고			
		 ************************************************************************************/
		String Password="10517E";//금고 비밀번호
		String []Password_True=new String[1];
		Password_True[0]="";
	
		Student_Locker_Button.addActionListener(new ActionListener() {//사물함 여는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<Safe_Password_Button.length;i++)
					Safe.add(Safe_Password_Button[i]);//금고 비밀번호 버튼 추가
				
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Safe_On_False_Button,Safe_Off_False_Button,Safe_Open_Button,Safe};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\사물함 여는 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	     
			}				
		});	
			
		Safe_Password_Button[0].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password1="1";
				Password_True[0]+=Password1;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[1].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password2="2";
				Password_True[0]+=Password2;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[2].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password3="3";
				Password_True[0]+=Password3;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[3].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password4="4";
				Password_True[0]+=Password4;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[4].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password5="5";
				Password_True[0]+=Password5;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[5].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password6="6";
				Password_True[0]+=Password6;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[6].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password7="7";
				Password_True[0]+=Password7;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[7].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password8="8";
				Password_True[0]+=Password8;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[8].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password9="9";
				Password_True[0]+=Password9;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[9].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String PasswordC="C";
				Password_True[0]+=PasswordC;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[10].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String Password0="0";
				Password_True[0]+=Password0;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		Safe_Password_Button[11].addActionListener(new ActionListener() {//금고 비밀번호 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				String PasswordE="E";
				Password_True[0]+=PasswordE;
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\금고 버튼 소리.wav");//사물함 여는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	     
			}
		});	
		
		Safe_Open_Button.addActionListener(new ActionListener() {//금고 문 여는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				if(Password.equals(Password_True[0])) {
					 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\도아락 및 금고 성공시.wav");//사물함 여는 소리
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	
				     EscapeM.object=null;
				     if(get_key3==0) {
					 EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Gate_Key3_Button,Safe_Open};
				     }
				     else
				    	 EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Safe_Open};
					 EscapeM.Map_Move(EscapeM.object);
				}
				else {
					 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\도아락 실패시.wav");//사물함 여는 소리
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	
				    	Password_True[0]="";
				}					
			}
		});	
		Gate_Key3_Button.addActionListener(new ActionListener() {//열쇠 누를시 인벤토리내 이동 
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
			     System.out.println(file.exists()); //true
			     
			     try {
			    	 get_key3=1;
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			         clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {	         
			         e.printStackTrace();
			     }	  
			    key.setContentAreaFilled(false);//버튼 색 투명하게 하기
			    key.setBorderPainted(false);//버튼 선 색 투명하게 하기
			    key.setFocusPainted(false);
			     C817.END_KEY3=1;
					EscapeM.frame.getContentPane().remove(Gate_Key3_Button);
					EscapeM.frame.getContentPane().repaint();
					new setInventory(key);
				

					
					
			}				
		});	
		/************************************************************************************
		 *								  811호 문앞으로 이동				
		 ************************************************************************************/
		BackButton.addActionListener(new ActionListener() {//811호 문앞으로 이동하는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Floor8_Hallway(true,false);
			}				
		});	
	}
}

/************************************************************************************************************
* 							                     	811호
* ***********************************************************************************************************/

class C811 {
	ImagePanel Class811=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811.png").getImage());//811호 이미지
	ImagePanel Lecture_Desk=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Lecture_Desk.png").getImage());
	static JButton hammer=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Hammer.png"));//교탁 밑 이미지
	static Clip clip;
	C811(){
		/************************************************************************************
		 *								  교탁 & 컴퓨터 이동 버튼				
		 ************************************************************************************/
		JButton Lecture_Desk_Button=new JButton();//교탁 밑 이동 버튼
		Lecture_Desk_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Lecture_Desk_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Lecture_Desk_Button.setFocusPainted(false);
		Lecture_Desk_Button.setBounds(220, 470, 391, 91);
		
		JButton Class811_Computer_Button=new JButton();//811호 컴퓨터 이동 버튼
		Class811_Computer_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Class811_Computer_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Class811_Computer_Button.setFocusPainted(false);
		Class811_Computer_Button.setBounds(707, 255, 75, 97);
		/************************************************************************************
		 *								  아이템 버튼				
		 ************************************************************************************/
		JButton Hammer_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Hammer.png"));//망치 아이템 버튼
		Hammer_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Hammer_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Hammer_Button.setFocusPainted(false);
		Hammer_Button.setBounds(339, 220, 112, 56);
		/************************************************************************************
		 *								  전 화면 이동 버튼				
		 ************************************************************************************/
		JButton Class811_Front_Door_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//811호 문앞 이동 버튼
		Class811_Front_Door_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Class811_Front_Door_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Class811_Front_Door_Button.setFocusPainted(false);
		Class811_Front_Door_Button.setBounds(-25, 492, 165, 57);
		
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//제작 이미지 뒤로가기 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);	
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Class811_Front_Door_Button,Lecture_Desk_Button,Class811_Computer_Button,Class811};//이미지 업데이트
		EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		/************************************************************************************
		 *								  전 화면 이동 			
		 ************************************************************************************/
		Class811_Front_Door_Button.addActionListener(new ActionListener() {//811호 문앞 이동 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Floor8_Hallway(true,false);
			}	
		});	
		/************************************************************************************
		 *								  교탁 밑 이동 			
		 ************************************************************************************/
		Lecture_Desk_Button.addActionListener(new ActionListener() {//교탁 밑 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Hammer_Button,Lecture_Desk};//이미지 업데이트
				EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
			}	
		});
	        hammer.addActionListener(new ActionListener() {//교탁 밑 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.frame.getContentPane().remove(Locker.key);	
				EscapeM.frame.getContentPane().repaint();
			}	
		});	
		
		/************************************************************************************
		 *								  컴퓨터 이동 			
		 ************************************************************************************/
		Class811_Computer_Button.addActionListener(new ActionListener() {//컴퓨터 화면으로 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Class811_Computer();
			}	
		});	
		/************************************************************************************
		 *								  교탁 전 화면 이동			
		 ************************************************************************************/
		BackButton.addActionListener(new ActionListener() {//교탁 밑 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Class811_Front_Door_Button,Lecture_Desk_Button,Class811_Computer_Button,Class811};//이미지 업데이트
				EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
			}	
		});	
		/************************************************************************************
		 *								  아이템 			
		 ************************************************************************************/
		Hammer_Button.addActionListener(new ActionListener() {//망치
			 JButton hammer=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Inventory_Hammer.png"));//교탁 밑 이미지
			 public void actionPerformed(ActionEvent arg0) {
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	  
				 hammer.setContentAreaFilled(false);//버튼 색 투명하게 하기
				 hammer.setBorderPainted(false);//버튼 선 색 투명하게 하기
				 hammer.setFocusPainted(false);
				 
				 EscapeM.frame.getContentPane().remove(Hammer_Button);

				 EscapeM.frame.getContentPane().repaint();
				 new setInventory(hammer);
			}	
		});	
	}
}

/************************************************************************************************************
* 							                     	811호 컴퓨터
* ***********************************************************************************************************/

class Class811_Computer{
	static  Clip clip ;
	ImagePanel Class811_Computer=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer.png").getImage());//811호 컴퓨터 이미지
	ImagePanel Class811_Computer_Developer=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_Developer.png").getImage());//컴퓨터 개발자이름 아이콘 이미지
	ImagePanel Class811_Computer_Developer_File=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_Developer_File.png").getImage());//컴퓨터 개발자 메모장 이미지 
	ImagePanel Class811_Computer_Home=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_Home.png").getImage());//컴퓨터 바탕화면
	ImagePanel Class811_Computer_Locker=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_Locker.png").getImage());//컴퓨터 사물함이름 아이콘 이미지
	ImagePanel Class811_Computer_Locker_File=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_Locker_File.png").getImage());//컴퓨터 사물함 메모장 이미지
	ImagePanel Class811_Computer_MyPc=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Class811_Computer_MyPc.png").getImage());//컴퓨터 파일탐색기 이미지
	
	Class811_Computer(){
		/************************************************************************************
		 *								  컴퓨터 관련 버튼				
		 ************************************************************************************/	
		JButton Computer_Power_Button=new JButton();//컴퓨터 전원 버튼 
		Computer_Power_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Computer_Power_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Computer_Power_Button.setFocusPainted(false);
		Computer_Power_Button.setBounds(626, 397, 23, 21);	
		
		JButton MyPc_Button=new JButton();//내컴퓨터 아이콘 이동 버튼
		MyPc_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		MyPc_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MyPc_Button.setFocusPainted(false);
		MyPc_Button.setBounds(178, 111, 45, 45);	
		
		JButton MyPc_Exit_Button=new JButton();//내컴퓨터 폴더 끄기 버튼
		MyPc_Exit_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		MyPc_Exit_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MyPc_Exit_Button.setFocusPainted(false);
		MyPc_Exit_Button.setBounds(552, 131, 16, 15);	
		
		JButton Locker_Button=new JButton();//Locker 폴더 이동 버튼
		Locker_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Locker_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Locker_Button.setFocusPainted(false);
		Locker_Button.setBounds(287, 189, 45, 47);
		
		JButton Developer_Button=new JButton();//Developer 폴더 이동 버튼
		Developer_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Developer_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Developer_Button.setFocusPainted(false);
		Developer_Button.setBounds(339, 189, 45, 47);
		
		JButton Locker_Exit_Button=new JButton();//Locker 폴더 끄기 버튼
		Locker_Exit_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Locker_Exit_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Locker_Exit_Button.setFocusPainted(false);
		Locker_Exit_Button.setBounds(552, 131, 17, 15);	
		
		JButton Locker_File_Button=new JButton();//Locker 메모장 열기 버튼
		Locker_File_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Locker_File_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Locker_File_Button.setFocusPainted(false);
		Locker_File_Button.setBounds(287, 189, 45, 47);	
		
		JButton Developer_File_Button=new JButton();//Developer 메모장 열기 버튼
		Developer_File_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Developer_File_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Developer_File_Button.setFocusPainted(false);
		Developer_File_Button.setBounds(287, 189, 45, 47);	
		
		JButton Locker_File_Exit_Button=new JButton();//Locker 메모장 닫기 버튼
		Locker_File_Exit_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Locker_File_Exit_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Locker_File_Exit_Button.setFocusPainted(false);
		Locker_File_Exit_Button.setBounds(531, 136, 17, 15);	
		
		JButton Developer_File_Exit_Button=new JButton();//Developer 메모장 닫기 버튼
		Developer_File_Exit_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Developer_File_Exit_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Developer_File_Exit_Button.setFocusPainted(false);
		Developer_File_Exit_Button.setBounds(531, 136, 17, 15);	
		
		JButton MyPc_Back_Button=new JButton();//내컴퓨터로 이동 버틍 
		MyPc_Back_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		MyPc_Back_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		MyPc_Back_Button.setFocusPainted(false);
		MyPc_Back_Button.setBounds(236, 183, 39, 15);
		/************************************************************************************
		 *								  전 화면 이동 버튼				
		 ************************************************************************************/	
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//제작 이미지 뒤로가기 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);	
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Computer_Power_Button,Class811_Computer};//이미지 업데이트
		EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		/************************************************************************************
		 *								  컴퓨터 관련 이벤트			
		 ************************************************************************************/
		Computer_Power_Button.addActionListener(new ActionListener() {//컴퓨터 전원버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Button,Class811_Computer_Home};
					EscapeM.Map_Move(EscapeM.object);
					
					 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Windows(로그인 성공).wav");
				     System.out.println(file.exists()); //true     
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				        clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {
				         
				         e.printStackTrace();
				     }	    
			}	
		});
		
		MyPc_Button.addActionListener(new ActionListener() {//컴퓨터 내PC 아이콘 클릭시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Exit_Button,Locker_Button,Developer_Button,Class811_Computer_MyPc};
				EscapeM.Map_Move(EscapeM.object);
			
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true	     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		MyPc_Exit_Button.addActionListener(new ActionListener() {//컴퓨터 내PC 폴더 끄기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Button,Class811_Computer_Home};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		Locker_Button.addActionListener(new ActionListener() {//Locker 폴더 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Locker_Exit_Button,Locker_File_Button,MyPc_Back_Button,Class811_Computer_Locker};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		Locker_Exit_Button.addActionListener(new ActionListener() {//Locker 폴더 끄기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Button,Class811_Computer_Home};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		Locker_File_Button.addActionListener(new ActionListener() {//Locker 메모장 열기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Locker_File_Exit_Button,Class811_Computer_Locker_File};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		Locker_File_Exit_Button.addActionListener(new ActionListener() {//Locker 메모장 닫기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Locker_Exit_Button,Locker_File_Button,MyPc_Back_Button,Class811_Computer_Locker};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});		
		
		MyPc_Back_Button.addActionListener(new ActionListener() {//내컴퓨터로 돌아가는 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Exit_Button,Locker_Button,Developer_Button,Class811_Computer_MyPc};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});		
		
		Developer_Button.addActionListener(new ActionListener() {//Developer 폴더 이동 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,MyPc_Back_Button,Locker_Exit_Button,Developer_File_Button,Class811_Computer_Developer};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});		
		
		Developer_File_Button.addActionListener(new ActionListener() {//Developer 메모장 열기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Locker_File_Exit_Button,Developer_File_Exit_Button,Class811_Computer_Developer_File};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});	
		
		Developer_File_Exit_Button.addActionListener(new ActionListener() {//Developer 메모장 닫기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Locker_Exit_Button,Developer_File_Button,MyPc_Back_Button,Class811_Computer_Developer};
				EscapeM.Map_Move(EscapeM.object);
				
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Mouse_Click(아이콘 클릭시).wav");
			     System.out.println(file.exists()); //true     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	  
			}	
		});		
		/************************************************************************************
		 *								  컴퓨터 전 화면 이동			
		 ************************************************************************************/
		BackButton.addActionListener(new ActionListener() {//811호 화면으로 이동
			public void actionPerformed(ActionEvent arg0) {
				new C811();
			}	
		});	
	}
}

/************************************************************************************************************
* 							                     	엘리베이터
* ***********************************************************************************************************/

class Elevator{
	static  Clip clip ;
	ImagePanel Floor8_In_Elevator=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor8_In_Elevator.png").getImage());//8층 엘리베이터 안 이미지
	ImagePanel Floor1_In_Elevator=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor1_In_Elevator.png").getImage());//1층 엘리베이터 안 이미지
	ImagePanel Elevator_Number_Plate=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Elevator_Number_Plate.png").getImage());//엘리베이터 번호판
	
	Elevator(Boolean Change){
		/************************************************************************************
		 *								  8층 엘리베이터 관련 버튼					
		 ************************************************************************************/
		JButton Floor8_Elevator_Out_Button=new JButton();//8층 엘리베이터 나가는 버튼 
		Floor8_Elevator_Out_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor8_Elevator_Out_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor8_Elevator_Out_Button.setFocusPainted(false);
		Floor8_Elevator_Out_Button.setBounds(297, 80, 187, 338);
		
		JButton Floor1_Elevator_Out_Button=new JButton();//1층 엘리베이터 나가는 버튼 
		Floor1_Elevator_Out_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor1_Elevator_Out_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor1_Elevator_Out_Button.setFocusPainted(false);
		Floor1_Elevator_Out_Button.setBounds(297, 80, 187, 338);
		
		JButton Elevator_Number_Plate_Button=new JButton();//엘리베이터 번호판 화면으로 이동하는 버튼
		Elevator_Number_Plate_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Elevator_Number_Plate_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Elevator_Number_Plate_Button.setFocusPainted(false);
		Elevator_Number_Plate_Button.setBounds(564, 109, 67, 187);
		
		JButton Elevator_Floor8_Plate_Button=new JButton();//엘리베이터 번호판 8층 이동하는 버튼
		Elevator_Floor8_Plate_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Elevator_Floor8_Plate_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Elevator_Floor8_Plate_Button.setFocusPainted(false);
		Elevator_Floor8_Plate_Button.setBounds(410, 260, 61, 36);
		
		JButton Elevator_Floor1_Plate_Button=new JButton();//엘리베이터 번호판 1층 이동하는 버튼
		Elevator_Floor1_Plate_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Elevator_Floor1_Plate_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Elevator_Floor1_Plate_Button.setFocusPainted(false);
		Elevator_Floor1_Plate_Button.setBounds(332, 442, 61, 36);
		/************************************************************************************
		 *								  전 화면 이동 버튼				
		 ************************************************************************************/
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//제작 이미지 뒤로가기 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		if(Change==true) {
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor8_In_Elevator};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		
		}
		else if(Change==false) {
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor1_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor1_In_Elevator};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
			Floor1_Elevator_Out_Button.addActionListener(new ActionListener() {//1층 엘리베이터 나가기 이벤트
				public void actionPerformed(ActionEvent arg0) {
					new Floor1_Hallway();
				}	
			});	
			Elevator_Number_Plate_Button.addActionListener(new ActionListener() {//번호판 누를시 이벤트
				public void actionPerformed(ActionEvent arg0) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Elevator_Floor8_Plate_Button,Elevator_Floor1_Plate_Button,Elevator_Number_Plate};
					EscapeM.Map_Move(EscapeM.object);
					
					BackButton.addActionListener(new ActionListener() {//번호판 나가기 버튼 이벤트
						public void actionPerformed(ActionEvent arg0) {
							EscapeM.object=null;
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor8_In_Elevator};
							EscapeM.Map_Move(EscapeM.object);
						}				
					});	
					Elevator_Floor8_Plate_Button.addActionListener(new ActionListener() {//엘리베이터 8층 이동하는 버튼 이벤트
						public void actionPerformed(ActionEvent arg0) {
							EscapeM.object=null;
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor8_In_Elevator};
							EscapeM.Map_Move(EscapeM.object);
							
							 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 도착 소리.wav");//엘리베이터 도착 소리
						     System.out.println(file.exists()); //true
						     
						     try {
						         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
						        clip= AudioSystem.getClip();
						         clip.open(stream);
						         clip.start();       
						     } catch(Exception e) {
						         
						         e.printStackTrace();
						     }	     
						}				
					});	
					Elevator_Floor1_Plate_Button.addActionListener(new ActionListener() {//엘리베이터 1층 이동하는 버튼 이벤트
						public void actionPerformed(ActionEvent arg0) {
							EscapeM.object=null;
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor1_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor1_In_Elevator};
							EscapeM.Map_Move(EscapeM.object);
							
							 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 도착 소리.wav");//엘리베이터 도착 소리
						     System.out.println(file.exists()); //true
						     
						     try {
						         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
						        clip= AudioSystem.getClip();
						         clip.open(stream);
						         clip.start();       
						     } catch(Exception e) {
						         
						         e.printStackTrace();
						     }	     
						}								
					});	
				}		
			});		
		}
		/************************************************************************************
		 *								  엘리이베이터 이동 및 나가기 관련					
		 ************************************************************************************/
		Floor8_Elevator_Out_Button.addActionListener(new ActionListener() {//8층 엘리베이터 나가기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Floor8_Hallway(false,true);
			}		
		});	
		Floor1_Elevator_Out_Button.addActionListener(new ActionListener() {//1층 엘리베이터 나가기 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Floor1_Hallway();
			}	
		});	
		
		Elevator_Number_Plate_Button.addActionListener(new ActionListener() {//번호판 누를시 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Elevator_Floor8_Plate_Button,Elevator_Floor1_Plate_Button,Elevator_Number_Plate};
				EscapeM.Map_Move(EscapeM.object);
				
				BackButton.addActionListener(new ActionListener() {//번호판 나가기 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor8_In_Elevator};
						EscapeM.Map_Move(EscapeM.object);
					}				
				});	
				Elevator_Floor8_Plate_Button.addActionListener(new ActionListener() {//엘리베이터 8층 이동하는 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor8_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor8_In_Elevator};
						EscapeM.Map_Move(EscapeM.object);
						
						 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 도착 소리.wav");//엘리베이터 도착 소리
					     System.out.println(file.exists()); //true
					     
					     try {
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					        clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {
					         
					         e.printStackTrace();
					     }	     
					}				
				});	
				Elevator_Floor1_Plate_Button.addActionListener(new ActionListener() {//엘리베이터 1층 이동하는 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor1_Elevator_Out_Button,Elevator_Number_Plate_Button,Floor1_In_Elevator};
						EscapeM.Map_Move(EscapeM.object);
						
						 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 도착 소리.wav");//엘리베이터 도착 소리
					     System.out.println(file.exists()); //true
					     
					     try {
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					        clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {
					         
					         e.printStackTrace();
					     }	     
					}								
				});	
			}		
		});	
	}
}

/************************************************************************************************************
* 							                     	1층
* ***********************************************************************************************************/

class Floor1_Hallway{
	Clip clip;
	static int Back=0;//화면 전환 
	ImagePanel Floor1_Elevator=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor1_Elevator.png").getImage());//1층 엘리베이터 이미지
	ImagePanel Floor1_Hallway=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor1_Hallway.png").getImage());//1층 복도 이미지
	ImagePanel Floor1_Gate=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor1_Gate.png").getImage());//1층 정문 이미지
	ImagePanel Floor1_Desk=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor1_Desk.png").getImage());//1층 책상 이미지
	static JButton Vault_Password_Hint1_Desk_Button2=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Vault_Password_Hint1.png"));//종이 
	static int get_hint1=0;
	Floor1_Hallway(){
	      new Inven_event2();
		/************************************************************************************
		 *								  8층 엘리베이터 관련 버튼					
		 ************************************************************************************/
		JButton Floor1_Elevator_Button=new JButton();//엘리베이터 안으로 이동하는 버튼
		Floor1_Elevator_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor1_Elevator_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor1_Elevator_Button.setFocusPainted(false);
		Floor1_Elevator_Button.setBounds(510, 133, 188, 308);
		
		Vault_Password_Hint1_Desk_Button2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Vault_Password_Hint1_Desk_Button2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Vault_Password_Hint1_Desk_Button2.setFocusPainted(false);
		/************************************************************************************
		 *								  1층 복도 이동 관련 버튼			
		 ************************************************************************************/
		JButton Floor1_Hallway_Button=new JButton();//1층 정문 이동 버튼
		Floor1_Hallway_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor1_Hallway_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor1_Hallway_Button.setFocusPainted(false);
		Floor1_Hallway_Button.setBounds(315, 120, 209, 225);
		/************************************************************************************
		 *								  1층 아이템	
		 ************************************************************************************/
		JButton Vault_Password_Hint1_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Vault_Password_Hint1.png"));//책상위 종이 
		Vault_Password_Hint1_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Vault_Password_Hint1_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Vault_Password_Hint1_Button.setFocusPainted(false);
		Vault_Password_Hint1_Button.setBounds(484, 294, 29, 27);
		
		JButton Vault_Password_Hint1_Desk_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Vault_Password_Hint1_Desk.png"));//종이 
		Vault_Password_Hint1_Desk_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Vault_Password_Hint1_Desk_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Vault_Password_Hint1_Desk_Button.setFocusPainted(false);
		Vault_Password_Hint1_Desk_Button.setBounds(306, 208, 143, 149);
		
		JButton IronBar_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\IronBar.png"));//빠루 
		IronBar_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		IronBar_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		IronBar_Button.setFocusPainted(false);
		IronBar_Button.setBounds(738, 305, 22, 40);
		/************************************************************************************
		 *								  전 화면 이동 버튼				
		 ************************************************************************************/
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//제작 이미지 뒤로가기 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);
		
		JButton Left_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//1층 복도 뒤로 가는 버튼
		Left_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Left_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Left_Shifting_Button.setFocusPainted(false);
		Left_Shifting_Button.setBounds(22, 518, 61, 17);
		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor1_Elevator_Button,Floor1_Elevator};//이미지 업데이트
		EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		/************************************************************************************
		 *								  엘리이베이터 이동 					
		 ************************************************************************************/
		Floor1_Elevator_Button.addActionListener(new ActionListener() {//1층 엘리베이터 들어가는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\엘리베이터 열리는 소리.wav");//엘리베이터 열리는 소리
			     System.out.println(file.exists()); //true
			     
			     try {
			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			        clip= AudioSystem.getClip();
			         clip.open(stream);
			         clip.start();       
			     } catch(Exception e) {
			         
			         e.printStackTrace();
			     }	     
			     
				new Elevator(false);
			}
		});
		/************************************************************************************
		 *								  1층 복도					
		 ************************************************************************************/
		Floor1_Hallway_Button.addActionListener(new ActionListener() {//1층 정문으로 가는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				EscapeM.object=null;
				if(get_hint1==0) {
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Vault_Password_Hint1_Button,IronBar_Button,Floor1_Gate};
				}
				else	
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,IronBar_Button,Floor1_Gate};
				EscapeM.Map_Move(EscapeM.object);
				Back=0;
						
				Vault_Password_Hint1_Button.addActionListener(new ActionListener() {//책상위 종이버튼 누를시 화면전환 이벤트 
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						if(get_hint1==0) {
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Vault_Password_Hint1_Desk_Button,Floor1_Desk};
						}
						else
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Floor1_Desk};
						EscapeM.Map_Move(EscapeM.object);
					}
				});	
				Vault_Password_Hint1_Desk_Button.addActionListener(new ActionListener() {//종이 누를시 인벤토리내 아이템 획득 이벤트 
					public void actionPerformed(ActionEvent arg0) {
						File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
					     System.out.println(file.exists()); //true
					     
					     try {
					    	 get_hint1=1;
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					         clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {	         
					         e.printStackTrace();
					     }	  
						new setInventory(Vault_Password_Hint1_Desk_Button2);
						EscapeM.frame.getContentPane().remove(Vault_Password_Hint1_Desk_Button);
						EscapeM.frame.getContentPane().repaint();
						
					}
				});	
				IronBar_Button.addActionListener(new ActionListener() {//빠루 누를시 인벤토리내 아이템 획득 이벤트
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				BackButton.addActionListener(new ActionListener() {//뒤로 가기 버튼
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						if(get_hint1==0)
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Vault_Password_Hint1_Button,IronBar_Button,Floor1_Gate};
						else
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,IronBar_Button,Floor1_Gate};
						EscapeM.Map_Move(EscapeM.object);
						Back=0;
					}
				});
			}
		});
		Left_Shifting_Button.addActionListener(new ActionListener() {//1층 복도로 가는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				if(Back==0) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor1_Hallway_Button,Floor1_Hallway};
					EscapeM.Map_Move(EscapeM.object);
					Back=1;
				}
				else if(Back==1) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor1_Elevator_Button,Floor1_Elevator};
					EscapeM.Map_Move(EscapeM.object);
					Back=0;
				}
			}
		});	
	}
}

/************************************************************************************************************
* 							                     	4층
* ***********************************************************************************************************/

class Floor4_Hallway{
	static  Clip clip ;
	static int Back=0;//화면 전환 
	Boolean Change;
	ImagePanel Floor4_Gate=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Gate.png").getImage());//4층 복도 이미지
	ImagePanel Floor4_Stairs=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Stairs.png").getImage());//8층 가는 계단 이미지
	ImagePanel Floor4_Hallway_Right=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Hallway_Right.png").getImage());//4층 오른쪽 복도 이미지
	ImagePanel Floor4_Toilet_Entrance=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Toilet_Entrance.png").getImage());//4층 화장실 들어가는 입구 이미지
	ImagePanel GarbageBox=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/GarbageBox.png").getImage());//쓰레기 상자 이미지
	static JButton Vault_Password_Hint2_1=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Inventory_Vault_Password_Hint2.png"));//제작 이미지 뒤로가기 버튼
	static int get_hint2=0;
	Floor4_Hallway(Boolean Change){
	new Inven_event3();
		/************************************************************************************
		 *								  4층 중앙 복도 관련 버튼							
		 ************************************************************************************/
		JButton Left_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));//8층으로 이동하는 계단으로 가는 버튼 이미지
		Left_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Left_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Left_Shifting_Button.setFocusPainted(false);
		Left_Shifting_Button.setBounds(22, 518, 61, 17);
		Vault_Password_Hint2_1.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Vault_Password_Hint2_1.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Vault_Password_Hint2_1.setFocusPainted(false);
		JButton Right_Shifting_Button=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Right_Shifting_Button.png"));//4층 오른쪽 복도로 이동하는 버튼 이미지
		Right_Shifting_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Right_Shifting_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Right_Shifting_Button.setFocusPainted(false);
		Right_Shifting_Button.setBounds(699, 518, 61, 17);
		
		JButton Floor4_Gate_Lock_Button=new JButton();//4층 정문 이동 버튼 
		Floor4_Gate_Lock_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor4_Gate_Lock_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor4_Gate_Lock_Button.setFocusPainted(false);
		Floor4_Gate_Lock_Button.setBounds(225, 181, 165, 174);
		
		JButton Floor4_Stairs_Button=new JButton();//8층 이동 버튼
		Floor4_Stairs_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor4_Stairs_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor4_Stairs_Button.setFocusPainted(false);
		Floor4_Stairs_Button.setBounds(33, 211, 416, 197);
		/************************************************************************************
		 *								  4층 오른쪽 복도 관련 버튼					
		 ************************************************************************************/
		JButton Floor4_Toilet_Entrance_Button=new JButton();//8층 이동 버튼
		Floor4_Toilet_Entrance_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor4_Toilet_Entrance_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor4_Toilet_Entrance_Button.setFocusPainted(false);
		Floor4_Toilet_Entrance_Button.setBounds(645, 158, 82, 270);
		
		JButton GarbageBox_Button=new JButton();//쓰레기 상지 이동 버튼 
		GarbageBox_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		GarbageBox_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		GarbageBox_Button.setFocusPainted(false);
		GarbageBox_Button.setBounds(279, 388, 67, 63);
		
		JButton Floor4_Toilet_In_Button=new JButton();//화장실 이동 버튼 
		Floor4_Toilet_In_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor4_Toilet_In_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor4_Toilet_In_Button.setFocusPainted(false);
		Floor4_Toilet_In_Button.setBounds(359, 223, 51, 141);
		/************************************************************************************
		 *								  전화면 이동 버튼					
		 ************************************************************************************/
		JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//제작 이미지 뒤로가기 버튼
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(665, 504, 165, 57);
		/************************************************************************************
		 *								  아이템 버튼					
		 ************************************************************************************/
		JButton Vault_Password_Hint2=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Vault_Password_Hint2.png"));//제작 이미지 뒤로가기 버튼
		Vault_Password_Hint2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Vault_Password_Hint2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Vault_Password_Hint2.setFocusPainted(false);
		Vault_Password_Hint2.setBounds(252, 254, 51, 63);
		Vault_Password_Hint2.addActionListener(new ActionListener() {//빠루 누를시 인벤토리내 아이템 획득 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new setInventory(Vault_Password_Hint2_1);
				EscapeM.frame.getContentPane().remove(Vault_Password_Hint2);
				EscapeM.frame.getContentPane().repaint();
				
			}
		});

		/************************************************************************************
		 *								  이미지 업데이트						
		 ************************************************************************************/
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		if(Change==true) {//8층에서 4층 이동시 이미지 업데이트
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Right_Shifting_Button,Floor4_Gate_Lock_Button,Floor4_Gate};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		}
		else if(Change==false) {//화장실에서 화장실 입구 이동시 이미지 업데이트
			Back=2;
			Floor4_Toilet_Entrance.add(Left_Shifting_Button);
			Floor4_Toilet_Entrance.add(GarbageBox_Button);
			Floor4_Toilet_Entrance.add(Floor4_Toilet_In_Button);
			
			EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor4_Toilet_Entrance};//이미지 업데이트
			EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
			
			Floor4_Toilet_Entrance_Button.addActionListener(new ActionListener() {//4층 화장실 입구로 이동하는 버튼 이벤트
				public void actionPerformed(ActionEvent arg0) {
					Back=2;
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
					EscapeM.Map_Move(EscapeM.object);
					}
				});
			GarbageBox_Button.addActionListener(new ActionListener() {//쓰레기 박스 버튼 이벤트 
				public void actionPerformed(ActionEvent arg0) {
					EscapeM.object=null;
					if(get_hint2==0) {
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Vault_Password_Hint2,GarbageBox};
					get_hint2=1;
					}
					else
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,GarbageBox};
					EscapeM.Map_Move(EscapeM.object);
					
					}
				});
			BackButton.addActionListener(new ActionListener() {//쓰레기 박스 뒤로 가기 버튼 이벤트
				public void actionPerformed(ActionEvent arg0) {
					EscapeM.object=null;
					if(get_hint2==0)
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Vault_Password_Hint2,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
					else
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
					EscapeM.Map_Move(EscapeM.object);
					}
				});
			Floor4_Toilet_In_Button.addActionListener(new ActionListener() {//화장실 안으로 이동하는 버튼 이벤트
				public void actionPerformed(ActionEvent arg0) {
					new Toilet();		
					}
				});	
		}			
		/************************************************************************************
		 *								  4층 중앙 복도 및 8층 올라가는 계단						
		 ************************************************************************************/
		Left_Shifting_Button.addActionListener(new ActionListener() {//8층 가는 계단 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				if(Back==0) {
					EscapeM.object=null;
				    EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor4_Stairs_Button,Floor4_Stairs};
				    EscapeM.Map_Move(EscapeM.object);
				    Back=1;
				}
				else if(Back==1) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Right_Shifting_Button,Floor4_Gate,Floor4_Gate_Lock_Button};
					EscapeM.Map_Move(EscapeM.object);
				    Back=0;
				}	
				else if(Back==2) {
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor4_Toilet_Entrance_Button,Floor4_Hallway_Right};
					EscapeM.Map_Move(EscapeM.object);
				    Back=1;
				}	
				Floor4_Stairs_Button.addActionListener(new ActionListener() {//8층으로 이동하는  버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\계단소리.wav");//8층 올라가는 계단소리 추가
					     System.out.println(file.exists()); //true
					     
					     try {
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					        clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {
					         
					         e.printStackTrace();
					     }	     
						new Floor8_Hallway(true,true);//8층으로 이동
						}
					});
			}
		});
		/************************************************************************************
		 *								  4층 오른쪽 복도					
		 ************************************************************************************/
		Right_Shifting_Button.addActionListener(new ActionListener() {//4층 오른쪽 복도로 이동하는 버튼
			public void actionPerformed(ActionEvent arg0) {
				Back=1;
				EscapeM.object=null;
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,Floor4_Toilet_Entrance_Button,Floor4_Hallway_Right};
				EscapeM.Map_Move(EscapeM.object);
				
				Floor4_Toilet_Entrance_Button.addActionListener(new ActionListener() {//4층 화장실 입구로 이동하는 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						Back=2;
						EscapeM.object=null;
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
						EscapeM.Map_Move(EscapeM.object);
						}
					});
				GarbageBox_Button.addActionListener(new ActionListener() {//쓰레기 박스 버튼 이벤트 
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						if(get_hint2==0) {
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,Vault_Password_Hint2,GarbageBox};
						}
						else
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,BackButton,GarbageBox};
						EscapeM.Map_Move(EscapeM.object);
						}
					});
				Vault_Password_Hint2.addActionListener(new ActionListener() {//종이 누를시 아이템 획득 이벤트
					public void actionPerformed(ActionEvent arg0) {
						File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
					     System.out.println(file.exists()); //true
					     
					     try {
					    	 get_hint2=1;
					         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					         clip= AudioSystem.getClip();
					         clip.open(stream);
					         clip.start();       
					     } catch(Exception e) {	         
					         e.printStackTrace();
					     }	  
					
						}
					});
				BackButton.addActionListener(new ActionListener() {//쓰레기 박스 뒤로 가기 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						EscapeM.object=null;
						if(get_hint2==0) {
						EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Vault_Password_Hint2,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
						}
						else 
						{
							EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
									,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Left_Shifting_Button,GarbageBox_Button,Floor4_Toilet_In_Button,Floor4_Toilet_Entrance};
						}
							
						EscapeM.Map_Move(EscapeM.object);
						}
					});
				Floor4_Toilet_In_Button.addActionListener(new ActionListener() {//화장실 안으로 이동하는 버튼 이벤트
					public void actionPerformed(ActionEvent arg0) {
						new Toilet();		
						}
					});
				}	
			});
		/************************************************************************************
		 *								  4층 정문 						
		 ************************************************************************************/
		Floor4_Gate_Lock_Button.addActionListener(new ActionListener() {//4층 정문 이동하는 버튼 이벤트
			public void actionPerformed(ActionEvent arg0) {
				new Floor4_Gate_Lock();
				}
			});
	}
}

/************************************************************************************************************
* 							                     	4층 정문 
* ***********************************************************************************************************/

class Floor4_Gate_Lock{
	ImagePanel Floor4_Gate_Lock=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Gate_Lock.png").getImage());//4층 잠긴 정문 이미지
    JButton end=new JButton();
    
	Floor4_Gate_Lock(){
	end.setBounds(310,240,150,150);
    end.addActionListener(new ActionListener() {//8층 오른쪽 복도 가는 버튼 누를시 이벤트 발생
		public void actionPerformed(ActionEvent arg0) {
			if(C817.END_KEY1==1&&C817.END_KEY2==1&&C817.END_KEY3==1)
			{
				new Ending();
			}
		}		
	});

		JButton Floor4_Gate_Lock_BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\BackButton.png"));//8층으로 이동하는 계단으로 가는 버튼 이미지
		Floor4_Gate_Lock_BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Floor4_Gate_Lock_BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Floor4_Gate_Lock_BackButton.setFocusPainted(false);
		end.setContentAreaFilled(false);//버튼 색 투명하게 하기
		end.setBorderPainted(false);//버튼 선 색 투명하게 하기
		end.setFocusPainted(false);
		Floor4_Gate_Lock_BackButton.setBounds(665, 504, 165, 57);
		
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		EscapeM.object =new Object[] {end,setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
				,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,Floor4_Gate_Lock_BackButton,Floor4_Gate_Lock};//이미지 업데이트
		EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
		
		Floor4_Gate_Lock_BackButton.addActionListener(new ActionListener() {//8층 오른쪽 복도 가는 버튼 누를시 이벤트 발생
			public void actionPerformed(ActionEvent arg0) {
				new Floor4_Hallway(true);
			}		
		});
		
	}	
	
}

/************************************************************************************************************
* 							                     	엔딩
* ***********************************************************************************************************/

class Ending{
	static Clip clip;
	ImagePanel []Ending= {
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending_Start.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending1.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending2.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending3.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending4.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending5.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending6.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending7.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending8.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending9.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending10.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending11.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending12.png").getImage()),new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Ending13.png").getImage()),
			new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/ClearTime.png").getImage())};
	
	Ending(){
		JButton Check_Button=new JButton();//메뉴 화면 이동 버튼
		Check_Button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Check_Button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Check_Button.setFocusPainted(false);
		Check_Button.setBounds(306, 280, 190, 41);
		
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
		
		 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\HYP-Release.wav");//엔딩 bmg 추가
	     System.out.println(file.exists()); //true
	     
	     try {
	         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         clip= AudioSystem.getClip();
	         clip.open(stream);
	         clip.start();       
	     } catch(Exception e) {   
	         e.printStackTrace();
	     }	     
	     Thread thread = new Thread(new Runnable(){
	    	 public void run() {
	    		 for(int i=0;i<15;i++) {	
	    			if(i<14) {	
	    				EscapeM.object=null;
	    			    EscapeM.object =new Object[] {Ending[i]};//이미지 업데이트
	    			    EscapeM.Map_Move(EscapeM.object);//이미지 업데이트	
	    			}
	    			else {
	    				 File file = new File("C:\\Escape_project\\Escape_Room\\sound\\Button_Sound.wav");
	    			     System.out.println(file.exists()); //true
	    			     
	    			     try {
	    			         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	    			         clip= AudioSystem.getClip();
	    			         clip.open(stream);
	    			         clip.start();       
	    			     } catch(Exception e) {   
	    			         e.printStackTrace();
	    			     }	  
		    		    EscapeM.object=null;
			    	    EscapeM.object =new Object[] {Check_Button,Ending[i]};//이미지 업데이트
			    	    EscapeM.Map_Move(EscapeM.object);//이미지 업데이트		
		    		}
	    			try{
	    				Thread.sleep(4500);
	    			}catch(InterruptedException e){}
	    			}
	    		 }
	    	 });
	    	thread.start();		
	    	/************************************************************************************
			 *								  메뉴 이동 버튼 이벤트			
			 ************************************************************************************/	
	    	Check_Button.addActionListener(new ActionListener() {//4층 복도로 가는 버튼 이벤트 발생
				public void actionPerformed(ActionEvent arg0) {
				    EscapeM.sound("C:\\Escape_project\\Escape_Room\\sound\\Main_bgm.wav",true);
					new IN_GAME();
				}		
			});	  	
		}
}

/************************************************************************************************************
* 							                     	화장실
* ***********************************************************************************************************/

class Toilet {
	static	ImagePanel Toilet_In=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Toilet_In.png").getImage());//메인 화면 이미지 불러오기
	static	ImagePanel Toilet_Door=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Toilet_Door.png").getImage());//메인 화면 이미지 불러오기
	static	ImagePanel Floor4_Toilet=new ImagePanel(new ImageIcon("C:/Escape_project/Escape_Room/image/Floor4_Toilet.png").getImage());//메인 화면 이미지 불러오기
	JButton button=new JButton();
	JButton button2=new JButton();
	public  int f=2;
	static int c=-1;
	static Clip clip;
	JButton BackButton=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));
	JButton BackButt2=new JButton(new ImageIcon("C:\\Escape_project\\Escape_Room\\image\\Left_Shifting_Button.png"));
	static JButton phone=new JButton(new ImageIcon("C:/Escape_project/Escape_Room/image/Inventory_CellPhone.png"));
	static JButton phone2=new JButton(new ImageIcon("C:/Escape_project/Escape_Room/image/Inventory_CellPhone.png"));
	static JButton key1=new JButton(new ImageIcon("C:/Escape_project/Escape_Room/image/Gate_Key1.png"));
	static JButton Inven_key1=new JButton(new ImageIcon("C:/Escape_project/Escape_Room/image/Inventory_Gate_Key1.png"));
static int get_phone=0;
static int get_key=0;
	Toilet()
	{
		JButton button=new JButton();
		button.setBounds(337,250,38,90);
		button.setContentAreaFilled(false);//버튼 색 투명하게 하기
		button.setBorderPainted(false);//버튼 선 색 투명하게 하기
		button.setFocusPainted(false);
				
		phone2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		phone2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		phone2.setFocusPainted(false);
		Inven_key1.setContentAreaFilled(false);//버튼 색 투명하게 하기
		Inven_key1.setBorderPainted(false);//버튼 선 색 투명하게 하기
		Inven_key1.setFocusPainted(false);
		key1.setContentAreaFilled(false);//버튼 색 투명하게 하기
		key1.setBorderPainted(false);//버튼 선 색 투명하게 하기
		key1.setFocusPainted(false);
			
		JButton button2=new JButton();
		button2.setBounds(220,35,400,3700);
		button2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		button2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		button2.setFocusPainted(false);
			
		key1.setBounds(350,200,60,60);
		BackButton.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButton.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButton.setFocusPainted(false);
		BackButton.setBounds(-25, 510, 141, 38);
		BackButt2.setContentAreaFilled(false);//버튼 색 투명하게 하기
		BackButt2.setBorderPainted(false);//버튼 선 색 투명하게 하기
		BackButt2.setFocusPainted(false);
		BackButt2.setBounds(-25, 510, 141, 38);
	 
		EscapeM.frame.getContentPane().removeAll();
		EscapeM.frame.getContentPane().update( EscapeM.frame.getContentPane().getGraphics());
	    EscapeM.object =new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
					,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,button,BackButt2,Toilet_In};
		EscapeM.Map_Move(EscapeM.object);
		
		BackButt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Floor4_Hallway(false); 	
				}
			});
		
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(f==0) {	
					new Toilet();
		    		f=2;
		    	}
				else{
					EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
								,setInventory.sixth,setInventory.sventh,setInventory.eighth,C817.ItemPanel,button2,BackButton,Toilet_Door};
				    EscapeM.Map_Move(EscapeM.object);
	                f=0;             
	                }
				}
			});
		
		    button.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		EscapeM.object=null;
					EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,button2,C817.ItemPanel,BackButton,Toilet_Door};
					EscapeM.Map_Move(EscapeM.object);
					}
		    	});
		    
		   phone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new setInventory(phone2);
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
				     System.out.println(file.exists()); //true
		              get_phone=1;	
		              
				     try {
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	  
					EscapeM.frame.getContentPane().remove(phone);
					EscapeM.frame.getContentPane().repaint();
					
				}
		    });
		   
		   key1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new setInventory(Inven_key1);
					File file = new File("C:\\Escape_project\\Escape_Room\\sound\\아이템획득.wav");
				     System.out.println(file.exists()); //true
				     
				     try {
				    	 get_key=1;
				         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				         clip= AudioSystem.getClip();
				         clip.open(stream);
				         clip.start();       
				     } catch(Exception e) {	         
				         e.printStackTrace();
				     }	  
					C817.END_KEY2=1; 
					EscapeM.frame.getContentPane().remove(key1);
					EscapeM.frame.getContentPane().repaint();	
				}
		    });
		   
		   button2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				    EscapeM.object=null;
				    phone.setContentAreaFilled(false);//버튼 색 투명하게 하기
					phone.setBorderPainted(false);//버튼 선 색 투명하게 하기
					phone.setFocusPainted(false);
					phone.setBounds(390,190,60,60);
			if(get_phone==0) {
				    EscapeM.object=new Object[] {phone,setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
							,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,C817.ItemPanel,Floor4_Toilet};
				   
			}
			if(get_key==0) {
				EscapeM.object=new Object[] {key1,setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,C817.ItemPanel,Floor4_Toilet};
		
			}
			if(get_key==0&&get_phone==0)
			{
				EscapeM.object=new Object[] {phone,key1,setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,C817.ItemPanel,Floor4_Toilet};
			}
			if(get_key==1&&get_phone==1)
			{
				EscapeM.object=new Object[] {setInventory.first,setInventory.second,setInventory.third,setInventory.fourth,setInventory.fifth
						,setInventory.sixth,setInventory.sventh,setInventory.eighth,BackButton,C817.ItemPanel,Floor4_Toilet};
			}
				
					
			
			
				    EscapeM.Map_Move(EscapeM.object);
				 }
			  });
		   }
}