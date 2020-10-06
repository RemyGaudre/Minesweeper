import javax.swing.JFrame;

public class Frame extends JFrame{
	public static int Cursor[] = new int[2];
	public static boolean CursorOnScreen = false;
	public static int Cases[][]= new int[1000][1000];
	public static boolean Show[][] = new boolean[1000][1000];
	public static int x = 64;
	public static int y = 36;
	public static int Size = 0;
	static Panel panel = new Panel();
	static int FrameRate = 10;
	static mouseListener ml = new mouseListener();
	public Frame(String Title) {
		this.setVisible(true);
		this.setSize(64*20,37*20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Title);
		this.setLocationRelativeTo(null);
		this.setContentPane(panel);
		this.addMouseListener(ml);
		initCases();
		bombGeneration(x,y,20,16);
		numberGeneration();
		GameTrame();
	}
	
	public void afficherCases() {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(" "+Cases[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	public void initCases() {
		for(int i = 0; i<1000;i++)
			for(int j = 0; j<1000;j++) {
				Cases[i][j]=0;
				Show[i][j] = false;
			}
	}
	
	public void bombGeneration(int x,int y, int size, double percentage) {
		Size = size;
		for(int i=1;i<x;i++) {
			for(int j=1;j<y;j++) {
				if(Math.random()*100 < percentage) {
					Cases[i][j] = -1;
				}
			}
		}
	}
	
	public void numberGeneration() {
		for(int i=1;i<999;i++) {
			for(int j=1;j<999;j++) {
				if(Cases[i][j] != -1) {
					int sum = 0;
					for(int k=i-1; k<= i+1;k++) {
						for(int l=j-1;l<=j+1;l++) {
							if((k!=i || l!=j) && Cases[k][l] ==-1)
								sum+=1;
						}
					}
					Cases[i][j]=sum;
				}
			}
		}
		afficherCases();
	}
	
	public static void GameTrame(){
		while(true) {
			int buffer = TimerThread.MILLI;
			
			if(Panel.xmouse >0 && Panel.xmouse < x*Size && Panel.ymouse >0 && Panel.ymouse < y*Size) {
				Cursor[0] = Panel.xmouse / Size;
				Cursor[1] = Panel.ymouse / Size;
				CursorOnScreen = true;
				if(ml.left) {
					Show[Cursor[0]][Cursor[1]]=true;
				}
			}
			
			ml.left=false;
			ml.right=false;
			
			panel.repaint();
			if((TimerThread.MILLI - buffer < FrameRate)) {
				try {
					Thread.sleep(FrameRate - (TimerThread.MILLI - buffer));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
