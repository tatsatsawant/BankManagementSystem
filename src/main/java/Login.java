import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton login, clear, register;
    JTextField cardTextField;
    JPasswordField cardPin;

    Login() {
        setTitle("Automated Teller Machine");
        setSize(800, 500);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("bankIcon.png");
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 10, 100, 100);
        add(image);

        JLabel heading = new JLabel("Welcome to ATM");
        heading.setBounds(250, 40, 400, 40);
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        add(heading);

        JLabel cardNumber = new JLabel("Card No:");
        cardNumber.setBounds(180, 150, 200, 40);
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardNumber);

        cardTextField = new JTextField();
        cardTextField.setBounds(320, 150, 250, 40);
        cardTextField.setFont(new Font("Raleway", Font.ITALIC, 20));
        add(cardTextField);

        JLabel pin = new JLabel("Pin No:");
        pin.setBounds(180, 200, 400, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);

        cardPin = new JPasswordField();
        cardPin.setBounds(320, 200, 250, 40);
        cardPin.setFont(new Font("Raleway", Font.ITALIC, 20));
        add(cardPin);

        login = new JButton("Sign In");
        login.setBounds(320, 250, 100, 30);
        login.setFocusable(false);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(470, 250, 100, 30);
        clear.setFocusable(false);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        register = new JButton("RegisterOne");
        register.setBounds(320, 300, 250, 30);
        register.setFocusable(false);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
        register.addActionListener(this);
        add(register);

        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardTextField.setText("");
            cardPin.setText("");
        } else if (e.getSource() == login) {

        } else {

        }
    }
}
