
package Task06_3;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame implements Observer {

    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or passwork!");

    private JLabel firstNumber = new JLabel();
    private JLabel secondNumber = new JLabel();
    private JLabel additionLabel = new JLabel("+");
    //private JTextField secondNumber = new JTextField(10);
    private JButton nextButton = new JButton("Next");
    private JButton quitButton = new JButton("Quit");
    private JButton loginButton = new JButton("Log in");

    public JLabel message = new JLabel("Welcome!", JLabel.CENTER);
    public JTextField calcSolution = new JTextField(10);

    private boolean started = false; // To identify if the game part starts.

    /**
     * Step 1: The constructor initializes the frame window as well as the login
     * interface.
     *
     * Note: We need to define the events of ActionListener in the Controller
     * class. Go to Model.java for Step 2.
     */
    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.
        this.userPanel.add(uName);
        this.userPanel.add(unInput);
        this.userPanel.add(pWord);
        this.userPanel.add(pwInput);
        this.userPanel.add(loginButton);
        this.add(this.message, BorderLayout.SOUTH);
        this.add(userPanel);
        this.setVisible(true);
    }

    public void startQuiz() {
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);

        calcPanel.add(calcSolution);
        calcPanel.add(nextButton);
        calcPanel.add(quitButton);

        this.getContentPane().removeAll();
        calcPanel.setVisible(true);
        this.add(calcPanel);
        this.revalidate();
        this.repaint();

    }

    public void setQuestion(int num1, int num2) {
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        calcSolution.setText("");
        calcPanel.repaint();
    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.nextButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }

    private void quitGame(int score) {
        JPanel quitPanel = new JPanel();
        JLabel scoreLabel = new JLabel("Your score: " + score);
        quitPanel.add(scoreLabel);
        this.getContentPane().removeAll();
        //calcPanel.setVisible(true);
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Step 7: Define the event when model has been modified.
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg; // Obtain the instance of data.
        if (!data.loginFlag) { // If loginFlage is false, then ask the user to input again.
            this.unInput.setText("");
            this.pwInput.setText("");
            this.message.setText("Invalid username or password.");
        } else if (!this.started) { // If the game has not started, then start the game.
            this.startQuiz(); // Change the interface of the frame.
            this.started = true;
            this.setQuestion(data.num1, data.num2); // Show the question on the interface.
            /**
             * You need to define ActionEvent for the next and the quit buttons
             * in the Controller.java. Back to Controller.java for Step 8.
             *
             * After you finish Step 9, complete last two conditions.
             */
        } else if (data.quitFlag) { // If user quits the game, display user's current score.
            this.quitGame(data.currentScore);
        } else { // Otherwise, update a new question for the user.
            this.setQuestion(data.num1, data.num2);
        }
    }

}
