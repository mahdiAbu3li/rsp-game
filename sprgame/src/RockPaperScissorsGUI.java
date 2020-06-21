/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Centrino
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
 import java.awt.FlowLayout;
    import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

    public class RockPaperScissorsGUI extends JFrame {

        private JPanel contentPane;
        private JPanel humanDisplay = new JPanel();
        private JPanel computerDisplay = new JPanel();
        private JLabel winnerAnnouncement = new JLabel("Winner Shown Here");
        private JPanel choicePanel = new JPanel();

        private RPSChoice rock = RPSChoice.ROCK;
        private RPSChoice paper = RPSChoice.PAPER;
        private RPSChoice scissors = RPSChoice.SCISSORS;

        private RPSChoice randChoice;

        private final JPanel humOrCompPanel = new JPanel();
        private final JLabel lblHuman = new JLabel("Human");
        private final JLabel lblComputer = new JLabel("Computer");
        private JButton btnScissors = new JButton("Scissors");
        private JButton btnPaper = new JButton("Paper");
        private JButton btnRock = new JButton("Rock");

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        RockPaperScissorsGUI frame = new RockPaperScissorsGUI();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public RockPaperScissorsGUI() {
            setTitle("Rock, Paper, Scissors");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 544, 366);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            JPanel choicePanel = addPanels();

            addButtons(choicePanel, rock, btnRock);
            addButtons(choicePanel, paper, btnPaper);
            addButtons(choicePanel, scissors, btnScissors);
        }

        private JPanel addPanels() {
            contentPane.add(humanDisplay, BorderLayout.WEST);
            humanDisplay.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

            contentPane.add(computerDisplay, BorderLayout.EAST);

            winnerAnnouncement.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(winnerAnnouncement, BorderLayout.CENTER);

            contentPane.add(choicePanel, BorderLayout.NORTH);

            contentPane.add(humOrCompPanel, BorderLayout.SOUTH);
            humOrCompPanel.setLayout(new GridLayout(1, 0, 0, 0));
            lblHuman.setHorizontalAlignment(SwingConstants.CENTER);

            humOrCompPanel.add(lblHuman);
            lblComputer.setHorizontalAlignment(SwingConstants.CENTER);

            humOrCompPanel.add(lblComputer);

            return choicePanel;
        }

        private void addButtons(JPanel choicePanel, RPSChoice choice, JButton button ){
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    humanDisplay.removeAll();
                    humanDisplay.add(new JLabel(choice.getImageIcon()));

                    computerDisplay.removeAll();
                    randChoice = RPSChoice.randomChoice();
                    computerDisplay.add(new JLabel(randChoice.getImageIcon()));

                    choicePanel.repaint();
                    choicePanel.revalidate();

                }
            });
            choicePanel.add(button);
        }
    }