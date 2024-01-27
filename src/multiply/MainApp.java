package multiply;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;

public class MainApp {

	private JFrame frame;
	private Random random;
	private static int a;
	private static int b;
	static StringBuilder answer;
	private static JLabel leftNum;
	private static JLabel rightNum;
	private static JLabel leftNum_1;
	private static JLabel rightNum_1;
	static JLabel answerLabel;
	private static JLabel messageLabel;
	private static JLabel scoreCount;
	private static JLabel correctCount;
	private static JLabel incorrectCount;
	static JLabel simonImageLabel;
	static JTabbedPane tabbedPane;
	static JButton startButton;
	private static JButton stopButton;
	private static int maxNum = 2;
	private static int scoreNum = 0;
	private static int correctNum = 0;
	private static int incorrectNum = 0;
	private final static String CORRECT_MESSAGE = "ВЕРНО!";
	private final static String INCORRECT_MESSAGE = "НЕВЕРНО!";
	private final static String NEXT_MESSAGE = "ДАЛЕЕ";
	private final static String START_MESSAGE = "СТАРТ";
	private ImageIcon simonThinkIcon;
	private ImageIcon simonHappyIcon;
	private ImageIcon simonSadIcon;
	
	static MainApp window;
	
	private final static int[] devisibleArray = {4, 6, 8, 9, 10, 12, 15, 16, 18, 
			20, 21, 24, 25, 27, 28, 
			30, 32, 35, 36, 
			40, 42, 45, 48, 49, 
			50, 54, 56, 
			60, 63, 64,
			70, 72, 80, 90, 100};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		random = new Random();
		answer = new StringBuilder();
		frame = new JFrame("КОШАЧЬЯ МАТЕМАТИКА");
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 736);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 57, 346, 217);
		frame.getContentPane().add(tabbedPane);
		
		// получаем текущую рабочую папку откуда запущена программа
        String cwd = System.getProperty("user.dir");
		
		BufferedImage imageThink = null;
		BufferedImage imageHappy = null;
		BufferedImage imageSad = null;
		try {
			imageThink = ImageIO.read(new File(cwd + "/images/simonThink.png"));
			imageHappy = ImageIO.read(new File(cwd + "/images/simonHappy.png"));
			imageSad = ImageIO.read(new File(cwd + "/images/simonSad.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		simonThinkIcon = new ImageIcon(imageThink);
		simonHappyIcon = new ImageIcon(imageHappy);
		simonSadIcon = new ImageIcon(imageSad);
		
		simonImageLabel = new JLabel("");
		simonImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		simonImageLabel.setBounds(31, 368, 310, 255);
		simonImageLabel.setIcon(simonThinkIcon);
		simonImageLabel.setVisible(false);
		frame.getContentPane().add(simonImageLabel);
		
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(tabbedPane.getSelectedIndex());
			}
		});
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Умножение", null, panel, null);
		panel.setLayout(null);
		
		leftNum = new JLabel("");
		leftNum.setFont(new Font("Tahoma", Font.PLAIN, 60));
		leftNum.setHorizontalAlignment(SwingConstants.CENTER);
		leftNum.setBounds(23, 11, 88, 83);
		panel.add(leftNum);
		
		JLabel signLabel = new JLabel("X");
		signLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		signLabel.setBounds(144, 30, 52, 52);
		panel.add(signLabel);
		
		rightNum = new JLabel("");
		rightNum.setHorizontalAlignment(SwingConstants.CENTER);
		rightNum.setFont(new Font("Tahoma", Font.PLAIN, 60));
		rightNum.setBounds(232, 11, 88, 83);
		panel.add(rightNum);
		
		JLabel scoreLabel = new JLabel("Счёт:");
		scoreLabel.setBounds(10, 505, 78, 22);
		panel.add(scoreLabel);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(242, 156, 78, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9"}));
		
		JLabel lblNewLabel = new JLabel("Максимальный множитель");
		lblNewLabel.setBounds(10, 154, 222, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 141, 296, 2);
		panel.add(separator);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				maxNum = Integer.parseInt((String) comboBox.getSelectedItem());
			}
		});
		
		JPanel dividePanel = new JPanel();
		dividePanel.setLayout(null);
		tabbedPane.addTab("Деление", null, dividePanel, null);
		tabbedPane.setEnabledAt(1, true);
		
		leftNum_1 = new JLabel("");
		leftNum_1.setHorizontalAlignment(SwingConstants.CENTER);
		leftNum_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		leftNum_1.setBounds(23, 11, 88, 83);
		dividePanel.add(leftNum_1);
		
		JLabel signLabel_1 = new JLabel(":");
		signLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		signLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		signLabel_1.setBounds(145, 30, 52, 52);
		dividePanel.add(signLabel_1);
		
		rightNum_1 = new JLabel("");
		rightNum_1.setHorizontalAlignment(SwingConstants.CENTER);
		rightNum_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		rightNum_1.setBounds(231, 11, 88, 83);
		dividePanel.add(rightNum_1);
		
		JLabel answerLabel_1 = new JLabel("");
		answerLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		answerLabel_1.setBounds(347, 11, 88, 83);
		dividePanel.add(answerLabel_1);
		
		JLabel totalCountLabel = new JLabel("всего примеров");
		totalCountLabel.setBounds(38, 634, 119, 22);
		frame.getContentPane().add(totalCountLabel);
		
		scoreCount = new JLabel("0");
		scoreCount.setBounds(48, 662, 74, 24);
		frame.getContentPane().add(scoreCount);
		scoreCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scoreCount.setHorizontalAlignment(SwingConstants.CENTER);
		
		correctCount = new JLabel("0");
		correctCount.setBounds(262, 662, 40, 24);
		frame.getContentPane().add(correctCount);
		correctCount.setHorizontalAlignment(SwingConstants.CENTER);
		correctCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel correctCountLabel = new JLabel("верные решения");
		correctCountLabel.setBounds(230, 634, 111, 22);
		frame.getContentPane().add(correctCountLabel);
		
		incorrectCount = new JLabel("0");
		incorrectCount.setBounds(461, 662, 40, 24);
		frame.getContentPane().add(incorrectCount);
		incorrectCount.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel incorrectCountLabel = new JLabel("неверные решения");
		incorrectCountLabel.setBounds(429, 634, 125, 22);
		frame.getContentPane().add(incorrectCountLabel);
		
		JPanel numPanel = new JPanel();
		numPanel.setBounds(381, 368, 193, 255);
		frame.getContentPane().add(numPanel);
		numPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		numPanel.setLayout(null);
		
		JButton nineButton = new JButton("9");
		nineButton.setBounds(130, 11, 50, 50);
		numPanel.add(nineButton);
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("9");
			}
		});
		nineButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton eightButton = new JButton("8");
		eightButton.setBounds(70, 11, 50, 50);
		numPanel.add(eightButton);
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("8");
			}
		});
		eightButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton sevenButton = new JButton("7");
		sevenButton.setBounds(10, 11, 50, 50);
		numPanel.add(sevenButton);
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("7");
			}
		});
		sevenButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton sixButton = new JButton("6");
		sixButton.setBounds(130, 72, 50, 50);
		numPanel.add(sixButton);
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("6");
			}
		});
		sixButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton fiveButton = new JButton("5");
		fiveButton.setBounds(70, 72, 50, 50);
		numPanel.add(fiveButton);
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("5");
			}
		});
		fiveButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton fourButton = new JButton("4");
		fourButton.setBounds(10, 72, 50, 50);
		numPanel.add(fourButton);
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("4");
			}
		});
		fourButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton threeButton = new JButton("3");
		threeButton.setBounds(130, 132, 50, 50);
		numPanel.add(threeButton);
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("3");
			}
		});
		threeButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton twoButton = new JButton("2");
		twoButton.setBounds(70, 133, 50, 50);
		numPanel.add(twoButton);
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("2");
			}
		});
		twoButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton oneButton = new JButton("1");
		oneButton.setBounds(10, 133, 50, 50);
		numPanel.add(oneButton);
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("1");
			}
		});
		oneButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton zeroButton = new JButton("0");
		zeroButton.setBounds(10, 194, 50, 50);
		numPanel.add(zeroButton);
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answer.length() != 0) {
					setAnswer("0");
				}
			}
		});
		zeroButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton equalsButton = new JButton("=");
		equalsButton.setBounds(130, 193, 50, 50);
		numPanel.add(equalsButton);
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answer.length() != 0) simonImageLabel.setVisible(false);
				if(tabbedPane.getSelectedIndex() == 0) {
					if (answer.length() == 0) return;
					startButton.setVisible(true);
					checkAnswerMultiply();
				} else if (tabbedPane.getSelectedIndex() == 1) {
					checkAnswerDevide();
					startButton.setVisible(true);
				}
			}
		});
		equalsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton deleteButton = new JButton("<");
		deleteButton.setBounds(70, 194, 50, 50);
		numPanel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answer.length() != 0) {
					answer.deleteCharAt(answer.length() - 1);
					answerLabel.setText(answer.toString());
					System.out.println("Answer length: " + answer.length());
				}
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		messageLabel = new JLabel();
		messageLabel.setBounds(153, 303, 287, 54);
		frame.getContentPane().add(messageLabel);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		startButton = new JButton("СТАРТ");
		startButton.setBounds(461, 303, 101, 52);
		frame.getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simonImageLabel.setIcon(simonThinkIcon);
				simonImageLabel.setVisible(true);
				if(tabbedPane.getSelectedIndex() == 0) {
					tabbedPane.setEnabledAt(1, false);
					startMultiplyGame();	
				} else if (tabbedPane.getSelectedIndex() == 1) {
					tabbedPane.setEnabledAt(0, false);
					startDevideGame();
				}
			}
		});
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		stopButton = new JButton("СТОП");
		stopButton.setBounds(21, 303, 101, 52);
		stopButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stopButton.setEnabled(false);
		frame.getContentPane().add(stopButton);
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setText(START_MESSAGE);
				stopButton.setEnabled(false);
				tabbedPane.setEnabledAt(0, true);
				tabbedPane.setEnabledAt(1, true);
				String finalMessage = "Правильных ответов " + correctNum + " из " + scoreNum;
				JOptionPane.showMessageDialog(frame, finalMessage, "Результаты игры", JOptionPane.NO_OPTION);
				startButton.setVisible(true);
				simonImageLabel.setVisible(false);
				resetGame();
			}
		});
		
		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setBounds(359, 112, 52, 52);
		frame.getContentPane().add(equalsLabel);
		equalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		equalsLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel answerPanel = new JPanel();
		answerPanel.setBounds(416, 77, 125, 114);
		frame.getContentPane().add(answerPanel);
		answerPanel.setLayout(null);
		
		answerLabel = new JLabel("");
		answerLabel.setBounds(18, 16, 88, 83);
		answerPanel.add(answerLabel);
		answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
	}
	
	private int getRandomNum() {
		int result = random.nextInt(maxNum) + 1;
		return result;
	}
	private int getRandomNumForDevide() {
		int result = random.nextInt(35);
		return devisibleArray[result];
	}
	
	private void setLeftNum() {
		a = getRandomNum();
		System.out.println("First num: " + a);
		leftNum.setText(Integer.toString(a));
	}
	private void setRightNum() {
		b = getRandomNum();
		System.out.println("Second num: " + b);
		rightNum.setText(Integer.toString(b));
	}
	public static void setAnswer(String digit) {
		if(answer.length() < 2) {
			answer.append(digit);
			answerLabel.setText(answer.toString());
			System.out.println("Answer: " + answer);
			System.out.println("Answer length: " + answer.length());
		}
	}
	void checkAnswerMultiply() {
		System.out.println("enter");
		int c = Integer.parseInt(answer.toString());
		System.out.printf("%d + %d = %d\n", a, b, c);
		if ((a * b) == c) {
			messageLabel.setText(CORRECT_MESSAGE);
			simonImageLabel.setIcon(simonHappyIcon);
			simonImageLabel.setVisible(true);
			scoreNum++;
			correctNum++;
			updateScore();
		} else {
			messageLabel.setText(INCORRECT_MESSAGE);
			simonImageLabel.setIcon(simonSadIcon);
			simonImageLabel.setVisible(true);
			scoreNum++;
			incorrectNum++;
			updateScore();
		}
	}
	void checkAnswerDevide() {
		int c = Integer.parseInt(answer.toString());
		if ((a / b) == c) {
			messageLabel.setText(CORRECT_MESSAGE);
			simonImageLabel.setIcon(simonHappyIcon);
			simonImageLabel.setVisible(true);
			scoreNum++;
			correctNum++;
			updateScore();
		} else {
			messageLabel.setText(INCORRECT_MESSAGE);
			simonImageLabel.setIcon(simonSadIcon);
			simonImageLabel.setVisible(true);
			scoreNum++;
			incorrectNum++;
			updateScore();
		}
	}
	private void updateScore() {
		scoreCount.setText(Integer.toString(scoreNum));
		correctCount.setText(Integer.toString(correctNum));
		incorrectCount.setText(Integer.toString(incorrectNum));
	}
	private void setDevide() {
		b = getRandomNum();
		boolean condition;
		do {
			a = getRandomNumForDevide();
			System.out.printf("%d / %d = %d\n", a, b, (a / b));
			condition = ((a % b) == 0) && (a / b < 10);
			System.out.println("Condition: " + condition);
		} while (!condition);
		leftNum_1.setText(Integer.toString(a));
		rightNum_1.setText(Integer.toString(b));
	}
	private void resetGame() {
		scoreNum = 0;
		correctNum= 0;
		incorrectNum= 0;
		scoreCount.setText(Integer.toString(scoreNum));;
		correctCount.setText(Integer.toString(correctNum));;
		incorrectCount.setText(Integer.toString(incorrectNum));;
		
		
	}
	private void startMultiplyGame() {
		startButton.setVisible(false);
		stopButton.setEnabled(true);
		startButton.setText(NEXT_MESSAGE);
		messageLabel.setText("");
		answer.setLength(0);;
		setLeftNum();
		setRightNum();
		answerLabel.setText("");
	}
	private void startDevideGame() {
		maxNum = 9;
		startButton.setVisible(false);
		stopButton.setEnabled(true);
		startButton.setText(NEXT_MESSAGE);
		messageLabel.setText("");
		answer.setLength(0);;
		setDevide();
		answerLabel.setText("");
	}
}
