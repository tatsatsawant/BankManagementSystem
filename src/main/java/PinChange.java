import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class PinChange extends JFrame implements ActionListener {

    JButton back, change;
    JPasswordField confirmPinText, newPinText;
    String pinNumber;

    PinChange(String pinChange) {

        this.pinNumber = pinChange;

        setSize(900, 700);
        setMinimumSize(new Dimension(900, 700));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        header.setBackground(Color.BLACK);
        header.setPreferredSize(new Dimension(0, 80));
        add(header, BorderLayout.NORTH);

        JLabel headerText = new JLabel("CHANGE YOUR PIN");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Osward", Font.BOLD, 35));
        header.add(headerText);


        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setBackground(Color.BLACK);
        add(content, BorderLayout.CENTER);


        GridBagConstraints gb = new GridBagConstraints();
        gb.anchor = GridBagConstraints.NORTHWEST;
        gb.insets = new Insets(0, 25, 25, 25);

        JLabel newPin = new JLabel("ENTER NEW PIN:");
        newPin.setFont(new Font("Osward", Font.BOLD, 30));
        newPin.setForeground(Color.WHITE);
        newPin.setHorizontalAlignment(SwingConstants.CENTER);
        newPin.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        gb.gridx = 0;
        gb.gridy = 0;
        content.add(newPin, gb);

        newPinText = new JPasswordField();
        newPinText.setSize(new Dimension(600, 100));
        newPinText.setPreferredSize(new Dimension(400, 75));
        newPinText.setForeground(Color.white);
        newPinText.setBackground(Color.black);
        newPinText.setHorizontalAlignment(SwingConstants.CENTER);
        newPinText.setMargin(new Insets(5, 10, 5, 10));
        newPinText.setFont(new Font("Osward", Font.BOLD, 35));
        gb.gridx = 1;
        gb.gridy = 0;
        content.add(newPinText, gb);

        JLabel confirmPin = new JLabel("RE-ENTER NEW PIN:");
        confirmPin.setFont(new Font("Osward", Font.BOLD, 30));
        confirmPin.setForeground(Color.WHITE);
        confirmPin.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPin.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        gb.gridx = 0;
        gb.gridy = 1;
        content.add(confirmPin, gb);

        confirmPinText = new JPasswordField();
        confirmPinText.setSize(new Dimension(600, 100));
        confirmPinText.setPreferredSize(new Dimension(400, 75));
        confirmPinText.setForeground(Color.white);
        confirmPinText.setBackground(Color.black);
        confirmPinText.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPinText.setMargin(new Insets(5, 10, 5, 10));
        confirmPinText.setFont(new Font("Osward", Font.BOLD, 35));
        gb.gridx = 1;
        gb.gridy = 1;
        content.add(confirmPinText, gb);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        footer.setBackground(Color.black);
        add(footer, BorderLayout.SOUTH);

        change = new JButton();
        change = new JButton("Change");
        change.setBackground(Color.BLACK);
        change.setForeground(Color.white);
        change.setPreferredSize(new Dimension(200, 50));
        change.setFocusable(false);
        change.setFont(new Font("Raleway", Font.BOLD, 24));
        change.addActionListener(this);
        footer.add(change);

        back = new JButton();
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.setFont(new Font("Raleway", Font.BOLD, 24));
        back.setPreferredSize(new Dimension(200, 50));
        back.addActionListener(this);
        footer.add(back);

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                char[] newPin = newPinText.getPassword();
                String nPin = new String(newPin);

                char[] conPin = newPinText.getPassword();
                String cPin = new String(conPin);

                if (!nPin.equals(cPin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match!");
                    return;
                }

                if (nPin.isEmpty() || cPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER PIN AND RE-ENTER PIN!");
                    return;
                }

                Connection connection = dataBase.getConnection();

                String query1 = "update bank set pin = '" + cPin + "' where pin ='" + pinNumber + "'";
                String query2 = "update login set pinnumber = '" + cPin + "' where pinnumber ='" + pinNumber + "'";
                String query3 = "update registration_data_3 set pinnumber = '" + cPin + "' where pinnumber ='" + pinNumber + "'";

                connection.createStatement().executeUpdate(query1);
                connection.createStatement().executeUpdate(query2);
                connection.createStatement().executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");
                setVisible(false);
                new Transaction(cPin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {

            setVisible(false);
            new Transaction("").setVisible(true);
        }
    }
}
