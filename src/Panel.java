import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
	static int xmouse;
	static int ymouse;
	
	public void paintComponent(Graphics g) {
		xmouse = MouseInfo.getPointerInfo().getLocation().x-getLocationOnScreen().x;
		ymouse = MouseInfo.getPointerInfo().getLocation().y-getLocationOnScreen().y;
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,getSize().width,getSize().height);
		for(int i=1;i<Frame.x;i++) {
			for(int j=1;j<Frame.y;j++) {
				if(Frame.Show[i][j] == false) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_unexplored.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);
				} else if(Frame.Cases[i][j] == 0) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_0.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);
				} else if(Frame.Cases[i][j] == -1) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_mine_hit.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 1) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_1.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 2) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_2.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 3) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_3.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 4) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_4.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 5) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_5.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 6) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_6.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 7) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_7.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				} else if(Frame.Cases[i][j] == 8) {
					g.drawImage(new ImageIcon("Minesweeper_LAZARUS_61x61_8.png").getImage(), (i-1)*Frame.Size, (j-1)*Frame.Size,Frame.Size,Frame.Size, null);					
				}
			}
		}
		if(Frame.CursorOnScreen) {
			g.setColor(new Color(0,0,0,50));
			g.fillRect(Frame.Cursor[0]*Frame.Size, Frame.Cursor[1]*Frame.Size, Frame.Size, Frame.Size);
		}
	}

}
