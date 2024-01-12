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
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        header.setBackground(Color.white);
        add(header, BorderLayout.NORTH);

        ImageIcon i1 = new ImageIcon("bankIcon.png");
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 10, 100, 100);
        header.add(image);

        JLabel heading = new JLabel("Welcome to ATM");
        heading.setBounds(250, 40, 400, 40);
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        header.add(heading);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setBackground(Color.white);
        add(content, BorderLayout.CENTER);

        //----------------------------------------------------
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets = new Insets(0, 10, 30, 20);

        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.anchor = GridBagConstraints.WEST;
        gbcField.insets = new Insets(0, 10, 30, 10);
        gbcField.gridwidth = GridBagConstraints.REMAINDER;
        //-----------------------------------------------------

        JLabel cardNumber = new JLabel("Card No:");
        cardNumber.setBackground(Color.white);
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        content.add(cardNumber, gbcLabel);

        cardTextField = new JTextField(15);
        cardTextField.setBackground(Color.white);
        cardTextField.setFont(new Font("Raleway", Font.ITALIC, 20));
        content.add(cardTextField, gbcField);

        JLabel pin = new JLabel("Pin No:");
        pin.setBackground(Color.white);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        content.add(pin, gbcLabel);

        cardPin = new JPasswordField(15);
        cardPin.setBackground(Color.white);
        cardPin.setFont(new Font("Raleway", Font.ITALIC, 20));
        content.add(cardPin, gbcField);

        login = new JButton("Sign In");
        login.setFocusable(false);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        content.add(login, gbcLabel);

        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        content.add(clear, gbcLabel);

        register = new JButton("Register");
        register.setFocusable(false);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
        register.addActionListener(this);
        content.add(register, gbcField);

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
            //call logIn page
        } else {

        }
    }
}
