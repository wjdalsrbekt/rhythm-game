package the_beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Beat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;


	
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exit.png")); 
	//private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftbutton.png")); 
	//private static ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftbutton2.png")); 
	//private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightbutton.png"));
	//private static ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightbutton2.png"));  
	private static ImageIcon startButtonselectedImage = new ImageIcon(Main.class.getResource("../images/startbutton.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private static ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private static ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	private static ImageIcon enterButtonBasicImage = new ImageIcon(Main.class.getResource("../images/enterButton.png"));
	private ImageIcon enterButtonenterImage = new ImageIcon(Main.class.getResource("../images/enterButtonEnter.png"));
	
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private static ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private static ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));

	
	
	

	private static Image rank ;
	private static Image background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private static JButton leftButton = new JButton(leftButtonBasicImage);
	private static JButton rightButton = new JButton(rightButtonBasicImage);
	private static JButton musicstartButton = new JButton(startButtonselectedImage);
	private static JButton backButton = new JButton(backButtonBasicImage);
	private static JButton enterButton = new JButton(enterButtonBasicImage);
	private static JButton quitButton = new JButton(quitButtonBasicImage);
	private int mouseX, mouseY; 

	private static boolean isMainScreen = false; 
	private static boolean isGameScreen = false;
	private static boolean isResultScreen = false;

	static ArrayList<Track> trackList = new ArrayList<Track>();  //0618

	private static Image titleImage;
	private static Image selectedImage;
	private static Music selectedMusic; 
	private static Music introMusic =new Music("intro.mp3",true);
	private static int nowSelected = 0;

	public static Game game;

	public Beat() {
		trackList.add(new Track("TakemyHandTitleImage.png", "takemyhand startimage.png", 
				"takemyhand gameimage.png", "Takemyhand selected.mp3", 
				"Simple Plan Take my hand.mp3","Simple Plan - Take my Hand"));//3
		trackList.add(new Track("TimefortheMoonLightTitleImage.png", "Timeforthemoonlight startimage.png", 
				"Timeforthemoonlight gameimage.png", "Time for the moon light selected.mp3", 
				"GirlFriend Time for the moon light.mp3","GIRLFRIEND - Time for the Moon Light"));//4

		setUndecorated(true);
		setTitle("The Beats");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); 
		setLayout(null);
		setFocusable(true);


		addKeyListener (new KeyListener());


		introMusic.start();//

		exitButton.setBounds(1170, 0, 120, 60);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();

			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} 
				System.exit(0); 
			}
		});
		add(exitButton); 

		enterButton.setBounds(40, 260, 400, 100);
		enterButton.setBorderPainted(false);
		enterButton.setContentAreaFilled(false);
		enterButton.setFocusPainted(false);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterButton.setIcon(enterButtonenterImage);
				enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				enterButton.setIcon(enterButtonBasicImage);
				enterButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				enterMain();
			}
		});
		add(enterButton);
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		//
		/*leftButton.setVisible(false);
		leftButton.setBounds(200, 310, 120, 120); 
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();

			}
		});
		add(leftButton); 

		rightButton.setVisible(false);
		rightButton.setBounds(970, 310, 120, 120); 
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);*/

		musicstartButton.setVisible(false);
		musicstartButton.setBounds(1103, 540, 180, 180);
		musicstartButton.setBorderPainted(false);
		musicstartButton.setContentAreaFilled(false);
		musicstartButton.setFocusPainted(false);
		musicstartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				musicstartButton.setIcon(startButtonselectedImage);
				musicstartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				musicstartButton.setIcon(startButtonselectedImage);
				musicstartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected);
			}
		});
		add(musicstartButton);
		
		backButton.setVisible(false);
		backButton.setBounds(10, 10, 100, 100);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);
/*		backButton.setVisible(false);
		backButton.setBounds(10,10, 100, 100);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);*/
	}
	@Override
	public void paint(Graphics g) { 
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); 
		if(isMainScreen){
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 600, null);
			//setFocusable(false);
		}
		else if(isGameScreen) {
			game.screenDraw(g);
		}
		else if(isResultScreen) {
			g.drawImage(rank, 0, 100, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("PERFECT: "+String.valueOf(Judge.perfect), 750, 240);
			g.drawString("AWESOME: "+String.valueOf(Judge.awesome), 750, 300);
			g.drawString("GREAT: "+String.valueOf(Judge.great), 750, 360);
			g.drawString("GOOD: "+String.valueOf(Judge.good), 750, 420);
			g.drawString("MISS: "+String.valueOf(Judge.miss), 750, 480);
			g.drawString("SCORE : "+String.valueOf(Judge.score), 750, 550);

		}
		paintComponents(g);
		this.repaint();
	}  
	public static void selectTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() { 
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		} 
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		} 
		selectTrack(nowSelected);
	}

	public void gameStart(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		} 
		isMainScreen = false;
		backButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		musicstartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).gettitleName(),trackList.get(nowSelected).getGameMusic() );
		game.start();
		setFocusable(true);

	}
	public static void backMain() {
		game.close();
		isMainScreen =true;
		isResultScreen = false;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		musicstartButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;

		
		
	}

	public static void enterMain() {
		background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg"))
				.getImage(); 
		backButton.setVisible(false);
		enterButton.setVisible(false);
		quitButton.setVisible(false);
		isMainScreen = true; 
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		musicstartButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}

	public static void resultMain() {
		isGameScreen = false;
		isResultScreen = true;
		backButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/resultbackground.png"))
				.getImage(); 
		System.out.println(Judge.perfect);
		if(game.result=="S") {rank = new ImageIcon(Main.class.getResource("../images/rank0.png")).getImage();}
		else if(game.result=="A") {rank = new ImageIcon(Main.class.getResource("../images/rank1.png")).getImage();}
		else if(game.result=="B") {rank = new ImageIcon(Main.class.getResource("../images/rank2.png")).getImage();}
		else if(game.result=="C") {rank = new ImageIcon(Main.class.getResource("../images/rank3.png")).getImage();}
		else if(game.result=="F") {rank = new ImageIcon(Main.class.getResource("../images/rank4.png")).getImage();}
	game.close();
		
	}

}


