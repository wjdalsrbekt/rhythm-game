package the_beat;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Note extends Thread{

	private Image notebasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage(); 
	private int x, y=580-(1000/Main.SLEEP_TIME* Main.NOTE_SPEED) * Main.REACH_TIME; //-120 y 1ÃÊ¿¡ 580  
	private String noteType;
	static int count=0;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space"))
		{
			g.drawImage(notebasicImage, x, y, null);
			g.drawImage(notebasicImage,x + 100,y,null);
		}
		else 
		{
			g.drawImage(notebasicImage, x, y,null);
			
			
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;	
		if( y>620 ) {
			System.out.println("Miss");
			count++;
			close();
		}
		
	}
	
	@Override
	public void run() {
		try {
			while(true) { //1ÃÊ¿¡ 700ÇÈ¼¿ ¸¸Å­ ¾Æ·¡ÂÊÀ¸·Î ¶³¾îÁü 
				drop();
				if(count==Game.notesize) {
					Game.gameEnd();
					count = 0;
				}
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public String judge() {
		if(y>= 620) {
			count++;
			close();
			return "Miss";
		}
		else if( y>=610) {
			System.out.println("Good");
			count++;
			close();
			return "Good";

		}
		else if( y>=590) {
			System.out.println("Great");
			count++;
			close();
			return "Great";

		}
		else if( y>=580) {
			System.out.println("Perfect");
			count++;
			close();
			return "Perfect";

		}
		else if( y>=560) {
			System.out.println("Awesome");
			count++;
			close();
			return "Awesome";

		}
		
		return "None";
	}
	public int getY() {
		return y;
	}
}
