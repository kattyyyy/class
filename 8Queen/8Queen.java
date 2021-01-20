import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EightQueen extends JFrame implements MouseListener, ActionListener {
	int[][] masu = new int[8][8];
	int oitaKazu;
	
	Container cPane;
	EQ_Panel panel;
	JPanel panelConsole;
	JLabel label;
	JButton button;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new EightQueen();
	}

	
	public EightQueen() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cPane = getContentPane();
		cPane.setLayout(new BorderLayout());
		panel = new EQ_Panel(masu);
		panel.addMouseListener( this );
		cPane.add(panel, BorderLayout.CENTER);

		panelConsole = new JPanel();
		button = new JButton("New");
		button.addActionListener( this );
		panelConsole.add(button);
		label = new JLabel();
		label.setText( (oitaKazu+1) + "個目を置いてください");
		panelConsole.add(label);
		cPane.add(panelConsole, BorderLayout.SOUTH);
		
		this.setSize(265,330);
		this.setVisible(true);
	}

	public void allCheck(int x, int y) {
		check( x, y,  1,  0 );	// 右
		check( x, y,  0,  1 );	// 下
		check( x, y, -1,  0 );	// 左
		check( x, y,  0, -1 );	// 上
		check( x, y,  1, -1 );	// 右上
		check( x, y,  1,  1 );	// 右下
		check( x, y, -1,  1 );	// 左下
		check( x, y, -1, -1 );	// 左上
	}
	
	public void check(int x, int y, int dx, int dy) {
		int wx, wy;
		
		wx = x + dx;		wy = y + dy;
		while( wx >= 0 && wx <= 7 && wy >= 0 && wy <= 7 ) {
			masu[wx][wy] = 2;
			wx = wx + dx;	wy = wy + dy;
		}		
	}

	public void newGame() {
		for (int y = 0; y < 8; ++y) {
			for (int x = 0; x < 8; ++x) {
				masu[x][y] = 0;
			}
		}
		oitaKazu = 0;
		label.setText( (oitaKazu+1) + "個目を置いてください");
		repaint();
	}

	public boolean owariCheck() {
		boolean kekka;

		kekka = true;
		for (int y = 0; y < 8; ++y) {
			for (int x = 0; x < 8; ++x) {
				if ( masu[x][y] == 0 )
					kekka = false;
			}
		}
		return kekka;
	}
	
	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}
	public void mouseClicked(MouseEvent evt) {}
	public void mousePressed(MouseEvent evt) {}
	public void mouseReleased(MouseEvent evt) {
		int x, y;
		
		x = ( evt.getX() ) / 32;
		y = ( evt.getY() ) / 32;
		setTitle("(" + x + "," + y + ")");
		if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			if ( masu[x][y] == 0 ) {
				masu[x][y] = 1;
				allCheck(x, y);
				oitaKazu++;
				repaint();
			}
			label.setText( (oitaKazu+1) + "個目を置いてください");
		}
		
		if ( owariCheck() ) {
			if ( oitaKazu == 8 )
				label.setText( "おめでとう！正解の一つです。");
			else
				label.setText( oitaKazu + "個 置けました");			
		}
	}

	public void actionPerformed(ActionEvent evt) {
		if ( evt.getSource() == button ) {
			newGame();
		}
	}
}

class EQ_Panel extends JPanel {
	int [][] masu;

	Font qFont = new Font("Century", Font.PLAIN, 24); 

	public EQ_Panel(int[][] masu) {
		this.masu = masu;
	}
	
	public void paint(Graphics g) {
		for (int y = 0; y < 8; ++y) {
			for (int x = 0; x < 8; ++x) {
				if ( masu[x][y] == 0 ) {			// 空欄
					;
				}
				else if ( masu[x][y] == 1 ) {		// Queen
					g.setColor( Color.GRAY );
					g.fillRect(32*x, 32*y, 32, 32);
					g.setColor( Color.YELLOW );
					g.setFont( qFont ); 
					g.drawString("Q", 32*x+7, 32*y+25);
					g.setColor( Color.BLACK );
				}
				else if ( masu[x][y] == 2 ) {		// 置けなくなった場所
					g.setColor( Color.RED );
					g.fillRect(32*x, 32*y, 32, 32);
					g.setColor( Color.BLACK );
				}

				g.drawRect(32*x, 32*y, 32, 32);
			}
		}
	}
}