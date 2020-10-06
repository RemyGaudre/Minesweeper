import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseListener implements MouseListener {
	
	public static boolean left = false;
	public static boolean right = false;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getButton() == 1) left = true;
		if(e.getButton() == 0) right = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
