package multiply;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainApp {

	private JFrame frame;
	private Random random;
	private static int a;
	private static int b;
	private static StringBuilder answer;
	private static JLabel leftNum;
	private static JLabel rightNum;
	private static JLabel answerLabel;
	private static JLabel messageLabel;
	private static JLabel scoreCount;
	private static JLabel correctCount;
	private static JLabel incorrectCount;
	private static JButton startButton;
	private static int maxNum = 2;
	private static int scoreNum = 0;
	private static int correctNum = 0;
	private static int incorrectNum = 0;
	private final static String correctMessage = "ВЕРНО!";
	private final static String incorrectMessage = "НЕВЕРНО!";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
		frame = new JFrame("ТРЕНИРОВКА УМНОЖЕНИЯ");
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 57, 564, 393);
		frame.getContentPane().add(tabbedPane);
		
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
		signLabel.setBounds(121, 30, 52, 52);
		panel.add(signLabel);
		
		rightNum = new JLabel("");
		rightNum.setHorizontalAlignment(SwingConstants.CENTER);
		rightNum.setFont(new Font("Tahoma", Font.PLAIN, 60));
		rightNum.setBounds(193, 11, 88, 83);
		panel.add(rightNum);
		
		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		equalsLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		equalsLabel.setBounds(279, 30, 52, 52);
		panel.add(equalsLabel);
		
		answerLabel = new JLabel("");
		answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		answerLabel.setBounds(347, 11, 88, 83);
		panel.add(answerLabel);
		
		startButton = new JButton("СТАРТ");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setVisible(false);
				messageLabel.setText("");
				startGame();
			}
		});
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startButton.setBounds(431, 30, 101, 52);
		panel.add(startButton);
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("9");
			}
		});
		nineButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nineButton.setBounds(480, 105, 50, 50);
		panel.add(nineButton);
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("8");
			}
		});
		eightButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		eightButton.setBounds(420, 105, 50, 50);
		panel.add(eightButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("7");
			}
		});
		sevenButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sevenButton.setBounds(360, 105, 50, 50);
		panel.add(sevenButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("6");
			}
		});
		sixButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sixButton.setBounds(480, 166, 50, 50);
		panel.add(sixButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("5");
			}
		});
		fiveButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fiveButton.setBounds(420, 166, 50, 50);
		panel.add(fiveButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("4");
			}
		});
		fourButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fourButton.setBounds(360, 166, 50, 50);
		panel.add(fourButton);
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("3");
			}
		});
		threeButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		threeButton.setBounds(480, 226, 50, 50);
		panel.add(threeButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("2");
			}
		});
		twoButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		twoButton.setBounds(420, 227, 50, 50);
		panel.add(twoButton);
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer("1");
			}
		});
		oneButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		oneButton.setBounds(360, 227, 50, 50);
		panel.add(oneButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answer.length() != 0) {
					setAnswer("0");
				}
			}
		});
		zeroButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		zeroButton.setBounds(360, 288, 50, 50);
		panel.add(zeroButton);
		
		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answer.length() == 0) return;
				startButton.setVisible(true);
				checkAnswer();
			}
		});
		equalsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		equalsButton.setBounds(480, 287, 50, 50);
		panel.add(equalsButton);
		
		JButton deleteButton = new JButton("<");
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
		deleteButton.setBounds(420, 288, 50, 50);
		panel.add(deleteButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(265, 105, 78, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Максимальный множитель");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 105, 222, 22);
		panel.add(lblNewLabel);
		
		messageLabel = new JLabel();
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		messageLabel.setBounds(50, 153, 281, 41);
		panel.add(messageLabel);
		
		JLabel scoreLabel = new JLabel("Счёт:");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scoreLabel.setBounds(33, 205, 78, 22);
		panel.add(scoreLabel);
		
		JLabel totalCountLabel = new JLabel("- всего примеров");
		totalCountLabel.setBounds(73, 248, 140, 22);
		panel.add(totalCountLabel);
		
		JLabel correctCountLabel = new JLabel("- верные решения");
		correctCountLabel.setBounds(73, 281, 140, 22);
		panel.add(correctCountLabel);
		
		JLabel incorrectCountLabel = new JLabel("- неверные решения");
		incorrectCountLabel.setBounds(73, 316, 140, 22);
		panel.add(incorrectCountLabel);
		
		scoreCount = new JLabel("0");
		scoreCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scoreCount.setHorizontalAlignment(SwingConstants.TRAILING);
		scoreCount.setBounds(23, 247, 40, 24);
		panel.add(scoreCount);
		
		correctCount = new JLabel("0");
		correctCount.setHorizontalAlignment(SwingConstants.TRAILING);
		correctCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		correctCount.setBounds(23, 281, 40, 24);
		panel.add(correctCount);
		
		incorrectCount = new JLabel("0");
		incorrectCount.setHorizontalAlignment(SwingConstants.TRAILING);
		incorrectCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		incorrectCount.setBounds(23, 314, 40, 24);
		panel.add(incorrectCount);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				maxNum = Integer.parseInt((String) comboBox.getSelectedItem());
			}
		});
	}
	
	private int getRandomNum() {
		int result = random.nextInt(maxNum) + 1;
		return result;
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
	private void setAnswer(String digit) {
		if(answer.length() < 2) {
			answer.append(digit);
			answerLabel.setText(answer.toString());
			System.out.println("Answer: " + answer);
			System.out.println("Answer length: " + answer.length());
		}
	}
	private void checkAnswer() {
		int c = Integer.parseInt(answer.toString());
		System.out.printf("%d + %d = %d\n", a, b, c);
		if ((a * b) == c) {
			messageLabel.setText(correctMessage);
			scoreNum++;
			correctNum++;
			updateScore();
		} else {
			messageLabel.setText(incorrectMessage);
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
	private void startGame() {
		answer.setLength(0);;
		setLeftNum();
		setRightNum();
		answerLabel.setText("");
	}
}
