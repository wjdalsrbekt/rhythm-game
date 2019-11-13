package the_beat;

public class Judge {

	static int perfect;
	static int awesome;
	static int great;
	static int good;
	static int miss;
	static int noteCnt;
	static int score;

	final String[] grade = new String[] { "S", "A", "B", "C", "F" };

	public Judge(int noteCnt) {
		perfect = 0;
		awesome = 0;
		great = 0;
		good = 0;
		miss = 0;
		score = 0;
		this.noteCnt = noteCnt;
	}

	public String[] getGrade() {
		return grade;
	}

	public void plusScore(String score){
		String s = score.toLowerCase();

		if(s.equals("perfect")){
			perfect++;
			this.score +=50;
		}
		else if(s.equals("awesome")){
			awesome++;
			this.score +=40;
		}
		else if(s.equals("great")){
			great++;
			this.score +=30;
		}

		else if(s.equals("good")){
			good++;
			this.score +=5;
		}
		else if(s.equals("miss")){
			miss++;
		}


	}


	public String calculateGrade(){
		int max = (int)((perfect*1 + awesome*0.8 + great*0.6+good*0.3 + miss*0)/noteCnt*100);

		System.out.println("노트개수:"+noteCnt+" ,PERFECT:"+perfect+", AWESOME: "+ awesome+" , GREAT: "+great+", GOOD: "+good+" ,MISS: "+miss);

		if(max == 100) {
			return grade[0];
		} else if(max >=70) {
			return grade[1];
		} else if(max >=50) {
			return grade[2];
		} else if(max>=30) {
			return grade[3];
		} else {
			return grade[4];
		}
	}



}