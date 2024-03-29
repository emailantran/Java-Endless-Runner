package obstacleAvoidanceGame.view;

import obstacleAvoidanceGame.Button;
import obstacleAvoidanceGame.message.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;


/**
 * This class will allow users to either start or quit the game, or switch to the power up menu
 * @author blues
 *
 */
public class StartScreen extends JPanel {

	BlockingQueue<Message> queue;

	Button startButton;
	Button difficultyButton;
	Button quitButton;

	/**
	 * Constructor that creates a frame with Start, Quit, and Powerup button.
	 */
	public StartScreen(BlockingQueue<Message> queue) {
		this.queue = queue;

		this.startButton = new Button("   Start   ", Color.GREEN, new Font(Font.SERIF, Font.PLAIN, 150));
		this.startButton.getButton().setPreferredSize(new Dimension(50, 200));
		this.startButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		this.difficultyButton = new Button("Difficulty", Color.CYAN, new Font(Font.SERIF, Font.PLAIN, 150));
		this.difficultyButton.getButton().setPreferredSize(new Dimension(50, 200));
		this.difficultyButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		this.quitButton = new Button("  Quit  ", Color.RED, new Font(Font.SERIF, Font.PLAIN, 150));
		this.quitButton.getButton().setPreferredSize(new Dimension(50, 200));
		this.quitButton.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);


		startButton.getButton().addActionListener(event -> {
			try {
				this.queue.put(new StartGameMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});

		quitButton.getButton().addActionListener(event -> {
			try {
				this.queue.put(new QuitGameMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});

		difficultyButton.getButton().addActionListener(event -> {
			try {
				this.queue.put(new DifficultyScreenMessage());
			} catch (InterruptedException exception) {
				//nothing
			}
		});


		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(difficultyButton.getButton());
		this.add(Box.createVerticalGlue());
		this.add(startButton.getButton());
		this.add(Box.createVerticalGlue());
		this.add(quitButton.getButton());
	}
}
