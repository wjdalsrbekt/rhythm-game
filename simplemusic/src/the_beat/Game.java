package the_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private Image judgeImage;
	
	static int notesize = 0;
	static Note a ;
	private String titleName;
	private String musicTitle;
	private static Music gameMusic;
	private NoteBeat[] beats = null;
	static String result;

	private static Judge judge;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {

		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		
		
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(judgeImage, 560, 450, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			a=note;
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
				judge.plusScore("miss");
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		
		g.drawString(String.valueOf(Judge.score), 700, 702);

	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes();
		
	}
	public static void gameEnd() {
		Timer tm = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				next();
			}
		};
		tm.schedule(tt, 3000);
	}
	

	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public static  void next() {
		result = judge.calculateGrade();
		
		System.out.println("��" + result);
		gameMusic.close();
		//this.interrupt();
		Beat.resultMain();
	}
	

	public void dropNotes() {
		NoteBeat[] beats = null;
			if (titleName.equals("Simple Plan - Take my Hand")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 50;
			beats = new NoteBeat[370];
			for(int i =0; i<370;i++) {
				int j = (int) (Math.random()*10)%7;
				String key = null;
				switch(j) {
				case 0 : key = "S"; break;
				case 1 : key = "D"; break;
				case 2 : key = "F"; break;
				case 3 : key = "Space"; break;
				case 4 : key = "J"; break;
				case 5 : key = "K"; break;
				case 6 : key = "L"; break;
				}
				beats[i] = new NoteBeat(startTime +gap*4*i, key);
				
			}
			//beats = new NoteBeat[] { new NoteBeat(startTime + gap * 10, "K"), new NoteBeat(startTime + gap * 22, "F"),
			//		new NoteBeat(startTime + gap * 33, "J"), new NoteBeat(startTime + gap * 45, "D"),
			//		new NoteBeat(startTime + gap * 54, "J"), new NoteBeat(startTime + gap * 66, "K"),
			//		
//
//			};
			
			notesize=beats.length;
			System.out.println(notesize);
		

		}else if (titleName.equals("GIRLFRIEND - Time for the Moon Light")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 50;

			beats = new NoteBeat[700];
			for(int i =0; i<700;i++) {
				int j = (int) (Math.random()*10)%7;
				String key = null;
				switch(j) {
				case 0 : key = "S"; break;
				case 1 : key = "D"; break;
				case 2 : key = "F"; break;
				case 3 : key = "Space"; break;
				case 4 : key = "J"; break;
				case 5 : key = "K"; break;
				case 6 : key = "L"; break;
				}
				beats[i] = new NoteBeat(startTime +gap*4*i, key);
				
			}
			//beats = new NoteBeat[] { new NoteBeat(startTime + gap * 10, "K"), new NoteBeat(startTime + gap * 22, "F"),
			//		new NoteBeat(startTime + gap * 33, "J"), new NoteBeat(startTime + gap * 45, "D"),
			//		new NoteBeat(startTime + gap * 54, "J"), new NoteBeat(startTime + gap * 66, "K"),
			//};
			
			notesize=beats.length;
			System.out.println(notesize);
		}
		
		judge = new Judge(beats.length);
		gameMusic.start();
		int i = 0;
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;

			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = null;
				note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		i = 0;

	}//
	
	public void judge(String input) {

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				String s = "";
				judgeEvent(s = note.judge());
				judge.plusScore(s);
			
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/great.png")).getImage();
		}else if (judge.equals("Awesome")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/awesome.png")).getImage();
		} 
		else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
		}

	}
}
