import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Window extends JFrame{
	
	private static final int FRAMEWIDTH = 505;
	private static final int FRAMEHEIGHT = 350;
	
	private static JFrame frame;
	private static JLabel title;
	private static JLabel teamA;
	private static JLabel teamB;
	private static JLabel[][] statLabels;
	private static JTextField[][] stats;
	private static JButton submit;
	private static JButton clear;
	
	public Window()
	{
		//CREATE FRAME AND SET IMPORTANT PROPERTIES
		super("March Madness");
		frame = this;
		setLayout(null);
		setSize(FRAMEWIDTH, FRAMEHEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ADD LABELS AND TEXT FIELDS
		addTitleAndTeams();
		addTeamStats();
		addTextFields();
		
		//ADD SUBMIT BUTTON ONE MORE LABEL
		submit = new JButton("Submit");
		int subHeight = getSubmitHeight();
		Dimension subDim = submit.getPreferredSize();
		submit.setBounds((FRAMEWIDTH/2) - (subDim.width/2), subHeight, subDim.width, subDim.height);
		add(submit);	
		String impMsg = "IMPORTANT: Please be sure to update ALL text fields before pressing submit.";
		JLabel important = new JLabel(impMsg);
		Dimension impDim = important.getPreferredSize();
		important.setBounds((FRAMEWIDTH/2) -(impDim.width/2), 10 + subHeight + subDim.height, impDim.width, impDim.height);
		add(important);
		
		//ADD CLEAR BUTTON
		clear = new JButton("Clear");
		Dimension clearDim = clear.getPreferredSize();
		clear.setBounds(3*FRAMEWIDTH/4, subHeight, clearDim.width, clearDim.height);
		add(clear);
		
		Handler handle = new Handler();
		submit.addActionListener(handle);
		clear.addActionListener(handle);
	}
	
	private static void addTitleAndTeams()
	{
		//ADD MARCH MADNESS BABY TITLE LABLE
		title = new JLabel("MARCH MADNESS BABY!");
		Font currentFont = title.getFont();
		title.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 30));
		Dimension titleDim = title.getPreferredSize();
		title.setBounds((FRAMEWIDTH/2) - (titleDim.width/2), 20, titleDim.width, titleDim.height);
		frame.add(title);
		
		
		//ADD TEAM A LABEL
		teamA = new JLabel("Team A");
		currentFont = teamA.getFont();
		teamA.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 15));
		Dimension teamADim = teamA.getPreferredSize();
		teamA.setBounds((FRAMEWIDTH/4) - (teamADim.width/2), 40 + titleDim.height, teamADim.width, teamADim.height);
		frame.add(teamA);
		
		
		//ADD TEAM B LABEL
		teamB = new JLabel("Team B");
		currentFont = teamB.getFont();
		teamB.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 15));
		Dimension teamBDim = teamB.getPreferredSize();
		teamB.setBounds(((3*FRAMEWIDTH)/4) - (teamBDim.width/2), 40 + titleDim.height, teamBDim.width, teamBDim.height);
		frame.add(teamB);
	}
	
	private static void addTeamStats()
	{
		initLabels();
		
		int maxHeight = 0;
		int maxWidth = 0;
		
		for(int i = 0; i < statLabels[0].length; i++)
		{
			Dimension dim = statLabels[0][i].getPreferredSize();
			if(dim.height > maxHeight)
				maxHeight = dim.height;
			if(dim.width > maxWidth)
				maxWidth = dim.width;
		}
		
		Dimension titleDim = title.getPreferredSize();
		Dimension teamDim = teamA.getPreferredSize();		
		int boundedHeight = 50 + titleDim.height + teamDim.height;
		
		for(int i = 0; i < statLabels[0].length; i++)
		{
			statLabels[0][i].setBounds(14, boundedHeight, maxWidth, maxHeight);
			statLabels[1][i].setBounds(14 + 250, boundedHeight, maxWidth, maxHeight);
			frame.add(statLabels[0][i]);
			frame.add(statLabels[1][i]);
			boundedHeight += 25;
		}
	}
	
	private static void addTextFields()
	{
		initTextFields();
		Dimension titleDim = title.getPreferredSize();
		Dimension teamDim = teamA.getPreferredSize();		
		int boundedHeight = 50 + titleDim.height + teamDim.height;
		
		for(int i = 0; i < stats[0].length; i++)
		{
			stats[0][i].setBounds(190, boundedHeight, 50, 16);
			stats[1][i].setBounds(250 + 190, boundedHeight, 50, 16);
			frame.add(stats[0][i]);
			frame.add(stats[1][i]);
			boundedHeight += 25;
		}
	}
	
	private static void initTextFields()
	{
		stats = new JTextField[2][5];
		for(int i = 0; i < stats[0].length; i++)
		{
			stats[0][i] = new JTextField("");
			stats[0][i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
			stats[1][i] = new JTextField("");
			stats[1][i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
		}
	}
	
	private static void initLabels()
	{
		//CREATE LABELS WITH RESPECTIVE TEXT FIELDS
		statLabels = new JLabel[2][5];
		statLabels[0][0] = new JLabel("Name: ");
		statLabels[0][1] = new JLabel("Seed: ");
		statLabels[0][2] = new JLabel("Strength of Schedule: ");
		statLabels[0][3] = new JLabel("Points Per Game: ");
		//statLabels[0][4] = new JLabel("FG% Per Game: ");
		statLabels[0][4] = new JLabel("Points Allowed Per Game: ");
		//statLabels[0][6] = new JLabel("FG% Against Per Game: ");
		//statLabels[0][7] = new JLabel("Turnovers Per Game: ");
		//statLabels[0][8] = new JLabel("Rebounds Per Game: ");
		//statLabels[0][9] = new JLabel("Free Throw %: ");
		statLabels[1][0] = new JLabel("Name: ");
		statLabels[1][1] = new JLabel("Seed: ");
		statLabels[1][2] = new JLabel("Strength of Schedule: ");
		statLabels[1][3] = new JLabel("Points Per Game: ");
		//statLabels[1][4] = new JLabel("FG% Per Game: ");
		statLabels[1][4] = new JLabel("Points Allowed Per Game: ");
		//statLabels[1][6] = new JLabel("FG% Against Per Game: ");
		//statLabels[1][7] = new JLabel("Turnovers Per Game: ");
		//statLabels[1][8] = new JLabel("Rebounds Per Game: ");
		//statLabels[1][9] = new JLabel("Free Throw %: ");
		
		//RIGHT ALIGN ALL LABELS
		for(int i = 0; i < statLabels[0].length; i++)
		{
			statLabels[0][i].setHorizontalTextPosition(JLabel.RIGHT);
			statLabels[1][i].setHorizontalTextPosition(JLabel.RIGHT);
		}
	}
	
	/**
	 * Adds up the heights from all the other items on the frame
	 * to determine the height of the submit button.
	 * @return the height bound of the submit JButton
	 */
	private static int getSubmitHeight()
	{
		Dimension titleDim = title.getPreferredSize();
		Dimension teamADim = teamA.getPreferredSize();
		int result = 50 + titleDim.height + teamADim.height;
		for(int i = 0; i < stats[0].length; i++)
			result += 25;
		return result + 20;
	}
	
	private class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == clear)
			{
				for(int i = 0; i < stats[0].length; i++)
				{
					stats[0][i].setText("");
					stats[1][i].setText("");
				}
			}
			else
			{
				String msg = "";
				if(event.getSource() == submit)
				{
					String teamAName = stats[0][0].getText();
					String teamBName = stats[1][0].getText();
					float[][] results = getStats();
					int winner = getWinner(results);
					if(winner == 1)
						msg = teamAName + " will win!";
					else if(winner == 2)
						msg = teamBName + " will win!";
					else
						msg = " Can not compute a winner!";
				}
				JOptionPane.showMessageDialog(null, msg);
			}
				
		}
		
		private float[][] getStats()
		{
			float[][] result = new float[2][stats[0].length - 1];
			for(int i = 1; i < stats[0].length; i++)
			{
				result[0][i-1] = Float.valueOf(stats[0][i].getText());
				result[1][i-1] = Float.valueOf(stats[1][i].getText());
			}
			return result;
		}
		
		public int getWinner(float[][] results)
		{
			System.out.println("ppgA: " + results[0][2]);
			System.out.println("ppgB: " + results[1][2]);
			System.out.println("ppg Against A: " + results[0][3]);
			System.out.println("ppg Against B: " + results[1][3]);
			System.out.println("SOS A: " + results[0][1]);
			System.out.println("SOS B: " + results [1][1]);
			
			
			
			float asmA = results[0][2] - results[0][3];
			float asmB = results[1][2] - results[1][3];
			
			float sosA = results[0][1];
			float sosB = results[1][1];
			asmA = asmA - calcSOSWeight(sosA);
			asmB = asmB - calcSOSWeight(sosB);
			
			if(asmA > asmB)
				return 1;
			else if(asmA < asmB)
				return 2;
			else
			{
				if(results[0][0] > results[1][0])
					return 1;
				else if(results[0][0] < results[1][0])
					return 2;
				else
					return 0;
			}
		}
		
		private int calcSOSWeight(float SOS)
		{
			return (int) SOS/25;
		}
	}

}
