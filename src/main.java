import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

 
/**
 *
 * @author sqlitetutorial.net
 */
public class main extends JFrame implements ActionListener {
	
	int rect = 75;
	int x = 80;
	int y = 10;
	AudioInputStream inputStream;
	
	JLabel[] col = new JLabel[8];
	
	JButton[] btn = new JButton[60];
	
	JLabel[] day = new JLabel[5];
	
	JLabel[] time = new JLabel[7];
	
	JButton change = new JButton();
	
	JButton check = new JButton();
	
	JComboBox device;
	
	JLabel[] clock = new JLabel[3];
	
	clockThread ct;
	
	String device_index = new String();
	
	String[] inde;
	
	Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
	
	String day_list[] = {"월요일", "화요일", "수요일", "목요일", "금요일"};
	
	String time_list[] = {"8:40 ~ 9:30", "9:40 ~ 10:30", "10:40 ~ 11:30",
			"11:40 ~ 12:30", "13:30 ~ 14:20", "14:30 ~ 15:20", "15:40 ~ 16:30"};
	
	String alarm_list[] = {"08:20", "08:40", "09:30", "09:40", "10:30", "10:40", "11:30", "11:40", "12:30",
			"13:25", "13:30", "14:20", "14:30", "15:20", "15:40", "16:30"};
	
	static String[][] all = new String[5][7];
	
	public main()
	{
		super("시간표");
		setLayout(null);
		
		col[0] = new JLabel("요일");
		col[0].setFont(new Font("메이플스토리", Font.BOLD, 20));
		col[0].setBounds(35, y, rect+50, rect);
		add(col[0]);
		
		for(int i = 1; i < 8; i++) {
			col[i] = new JLabel(i + "교시");
			col[i].setFont(new Font("메이플스토리", Font.BOLD, 20));
			col[i].setBounds(i * rect + (i + 1) * x - 70, y, rect+50, rect);
			add(col[i]);
		}
		
		for(int i = 0; i < 7; i++) {
			time[i] = new JLabel(time_list[i]);
			time[i].setFont(new Font("메이플스토리", Font.BOLD, 15));
			time[i].setBounds(i * rect + (i + 2) * x-18, y+35, rect+50, rect);
			add(time[i]);
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				if(j == 0) {
					day[i] = new JLabel(day_list[i]);
					day[i].setFont(new Font("메이플스토리", Font.BOLD, 20));
					day[i].setBounds(30, i * rect + (i + 1) * y + 100, rect+50, rect);
					add(day[i]);
				}else {
					btn[10 * i + j] = new JButton();
					btn[10 * i + j].setFont(new Font("메이플스토리", Font.PLAIN, 22));
					btn[10 * i + j].setBackground(Color.WHITE);
					btn[10 * i + j].setForeground(Color.BLACK);
					btn[10 * i + j].setBounds(j * rect + (j + 1) * x - 120, i * rect + (i + 1) * y + 100, rect+75, rect);
					btn[10 * i + j].addActionListener(this);
					add(btn[10 * i + j]);
				}
			}
		}
		for(int i = 0; i < mixerInfo.length; i++) {
			Mixer.Info info = mixerInfo[i];
			if(!(info.getName().contains("Port")) && info.getName().contains("스피커")) {
				device_index = device_index +  i + "/";
			}
		}
		inde = device_index.split("/");
		String[] device_arr = new String[inde.length];
		for(int i = 0; i < inde.length; i++) {
			Mixer.Info info = mixerInfo[Integer.parseInt(inde[i])];
			device_arr[i] = info.getName();
		}
		device = new JComboBox(device_arr);
		device.setFont(new Font("메이플스토리", Font.BOLD, 15));
		device.setBackground(Color.WHITE);
		device.setForeground(Color.BLACK);
		device.setBounds(100, 550, 500, 50);
		add(device);
		
		for(int i = 0; i < 3; i++) {
			clock[i] = new JLabel();
			clock[i].setFont(new Font("메이플스토리", Font.BOLD, 50));
			clock[i].setBackground(Color.WHITE);
			clock[i].setForeground(Color.BLACK);
			clock[i].setBounds(750 + i * 80, 535, 75, 75);
			add(clock[i]);
		}
		ct = new clockThread(this);
		
		change.setText("시간표 변경");
		change.setFont(new Font("메이플스토리", Font.BOLD, 15));
		change.setBackground(Color.WHITE);
		change.setForeground(Color.BLACK);
		change.setBounds(1100, 550, 120, 50);
		change.addActionListener(this);
		add(change);
		
		check.setText("<html>스피커<br>테스트</html>");
		check.setFont(new Font("메이플스토리", Font.BOLD, 12));
		check.setBackground(Color.WHITE);
		check.setForeground(Color.BLACK);
		check.setBounds(10, 550, 80, 50);
		check.addActionListener(this);
		add(check);
		
		setSize(1250, 650);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
 
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS subjects (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    day text NOT NULL,\n"
                + "    one text NOT NULL,\n"
                + "    two text NOT NULL,\n"
                + "    three text NOT NULL,\n"
                + "    four text NOT NULL,\n"
                + "    five text NOT NULL,\n"
                + "    six text NOT NULL,\n"
                + "    seven text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	createNewTable();
    	sql app = new sql();
    	all = app.selectAll();
    	main m = new main();
    	for(int i = 0; i < 5; i++) {
        	for(int j = 1; j < 8; j++) {
        		m.btn[10 * i + j].setText(all[i][j-1]);
        	}
        }
    	
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton act = (JButton) e.getSource();
		if (e.getSource() == change) {
			new newWindow();
			dispose();
		}else if(e.getSource() == check) {
			Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
			try {
				inputStream = AudioSystem.getAudioInputStream(new File("C:\\1.wav"));
			} catch (UnsupportedAudioFileException e1) {} catch (IOException e1) {}
			int mixer_index = Integer.parseInt(inde[device.getSelectedIndex()]);
			Mixer.Info info = mixerInfo[mixer_index];
			Clip clip;
			try {
				clip = AudioSystem.getClip(info);
				
				clip.open(inputStream);
		        clip.start();
			} catch (LineUnavailableException e1) {} catch (IOException e1) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {}
		}else{
			execute execute = new execute();
			execute.exe(act.getText());
		}
	}
}

class newWindow extends JFrame{
	String[] subject={"없음", "경제수학a", "경제수학b", "교육학", "기하 a", "기하 b", "논술", "독서a", "독서b", "독서c", "독서d", "동아리",
			"물리학 실험", "보건", "사회문화", "생명과학실험", "생활과 윤리A", "생활과 윤리B", "스포츠", "실용국어", "영어", "자율",
			"지구과학실험", "진로", "창체", "한국사", "한국지리", "화법과 작문", "화학실험"};
	
	int rect = 75;
	int x = 80;
	int y = 10;
	
	JLabel[] col = new JLabel[8];
	
	JComboBox[] btn = new JComboBox[60];
	
	JLabel[] day = new JLabel[5];
	
	JButton change = new JButton();
	
	String day_list[] = {"월요일", "화요일", "수요일", "목요일", "금요일"};
	
	String[][] su = new String[5][7];
	
	static String[][] all = new String[5][7];
	
    public newWindow() {
        super("시간표 변경");
        setLayout(null);
        // 주의, 여기서 setDefaultCloseOperation() 정의를 하지 말아야 한다
        // 정의하게 되면 새 창을 닫으면 모든 창과 프로그램이 동시에 꺼진다
        
        col[0] = new JLabel("요일");
		col[0].setFont(new Font("메이플스토리", Font.BOLD, 20));
		col[0].setBounds(35, y+20, rect+50, rect);
		add(col[0]);
		
		for(int i = 1; i < 8; i++) {
			col[i] = new JLabel(i + "교시");
			col[i].setFont(new Font("메이플스토리", Font.BOLD, 20));
			col[i].setBounds(i * rect + (i + 1) * x - 70, y + 20, rect+50, rect);
			add(col[i]);
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				if(j == 0) {
					day[i] = new JLabel(day_list[i]);
					day[i].setFont(new Font("메이플스토리", Font.BOLD, 20));
					day[i].setBounds(30, i * rect + (i + 1) * y + 100, rect+50, rect);
					add(day[i]);
				}else {
					btn[10 * i + j] = new JComboBox(subject);
					btn[10 * i + j].setFont(new Font("메이플스토리", Font.PLAIN, 20));
					btn[10 * i + j].setBackground(Color.WHITE);
					btn[10 * i + j].setForeground(Color.BLACK);
					btn[10 * i + j].setBounds(j * rect + (j + 1) * x - 120, i * rect + (i + 1) * y + 100, rect+75, rect);
					add(btn[10 * i + j]);
				}
			}
		}
		sql app = new sql();
		
		all = app.selectAll();
		for(int i = 0; i < 5; i++) {
        	for(int j = 1; j < 8; j++) {
        		btn[10 * i + j].setSelectedItem(all[i][j-1]);
        	}
        }
		
		change.setText("변경 완료");
		change.setFont(new Font("메이플스토리", Font.BOLD, 15));
		change.setBackground(Color.WHITE);
		change.setForeground(Color.BLACK);
		change.setBounds(1100, 550, 120, 50);
		change.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String curr_day[] = app.selectday();
		        for(int i = 0; i < 5; i++) {
		        	for(int j = 1; j < 8; j++) {
		        		su[i][j-1] = btn[10*i + j].getSelectedItem().toString();
		        	}
		        }
		        if(Arrays.equals(curr_day, day_list)) {
		        	for(int i = 0; i < 5; i++) {
			        	app.update(day_list[i], su[i][0], su[i][1], su[i][2], su[i][3], su[i][4], su[i][5], su[i][6]);
			        }
		        }else {
		        	for(int i = 0; i < 5; i++) {
			        	app.insert(day_list[i], su[i][0], su[i][1], su[i][2], su[i][3], su[i][4], su[i][5], su[i][6]);
			        }
		        }
		        String[][] all = app.selectAll();
		        main m = new main();
		        for(int i = 0; i < 5; i++) {
		        	for(int j = 1; j < 8; j++) {
		        		m.btn[10 * i + j].setText(all[i][j-1]);
		        		System.out.print(all[i][j-1] + "\t");
		        	}
		        	System.out.println("");
		        }
				dispose();
			}
		});
		add(change);
        
        setSize(1250,650);
        setResizable(false);
        setVisible(true);
    }
}
