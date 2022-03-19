package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JButton button = new JButton();
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		SlotMachine slotmachine = new SlotMachine();
		slotmachine.run();
	}

	void run() {
		frame.setVisible(true);
		panel.add(button);
		frame.add(panel);
		frame.pack();
		spin();
		button.addActionListener(this);
	}

	void spin() {
		try {
			Random rand = new Random();
			boolean winner=true;
			int random = rand.nextInt(3);
			int lastNumber=random;
			for (int i = 0; i < 3; i++) {

				
				JLabel label;
				if (random == 0) {
					label = createLabelImage("Cherry.png");
				} else if (random == 1) {
					label = createLabelImage("orange.jpeg");
				} else {
					label = createLabelImage("seven.png");
				}
				panel.add(label);
				random = rand.nextInt(3);
				if(random!=lastNumber&&i<2) {
					winner=false;
				}
			}

			frame.pack();
			if(winner==true) {
	JOptionPane.showMessageDialog(null, "You win");
}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.remove(panel);
		panel = new JPanel();
		panel.add(button);
		frame.add(panel);
		spin();
	}

}
