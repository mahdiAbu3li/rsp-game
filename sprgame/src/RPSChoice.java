/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Centrino
 */
import javax.swing.ImageIcon;

public enum RPSChoice {
    ROCK(new ImageIcon(RPSChoice.class.getResource("rock.png"))), 
    PAPER(new ImageIcon(RPSChoice.class.getResource("paper.png"))), 
    SCISSORS(new ImageIcon(RPSChoice.class.getResource("scissors.png")));

        private ImageIcon imgChoice;

        private RPSChoice(ImageIcon imgChoice) {
            this.imgChoice = imgChoice;
        }

        public ImageIcon getImageIcon(){
            return imgChoice;
        }

    public static void evaluate(){
        //TODO
    }

    public static RPSChoice randomChoice(){
        return values()[(int) (Math.random() * values().length)];
    }
}
