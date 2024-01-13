import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, cashWithdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pin;

    Transaction(String pinNumber) {

        this.pin = pinNumber;

        setSize(900, 700);
        setMinimumSize(new Dimension(900, 700));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        header.setBackground(Color.BLACK);
        header.setPreferredSize(new Dimension(0, 60));
        add(header, BorderLayout.NORTH);

        JLabel headerText = new JLabel("Welcome!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Osward", Font.BOLD, 28));
        header.add(headerText);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.BLACK);
        add(content, BorderLayout.CENTER);

        JLabel headerText2 = new JLabel("Please Select Your Transaction");
        headerText2.setFont(new Font("Osward", Font.BOLD, 20));
        headerText2.setForeground(Color.WHITE);
        headerText2.setHorizontalAlignment(SwingConstants.CENTER);
        headerText2.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        content.add(headerText2, BorderLayout.NORTH);

        JPanel buttonGroups = new JPanel();
        buttonGroups.setLayout(new GridBagLayout());
        buttonGroups.setBackground(Color.black);
        content.add(buttonGroups, BorderLayout.CENTER);

        GridBagConstraints gb = new GridBagConstraints();
        gb.anchor = GridBagConstraints.NORTHWEST;
        gb.insets = new Insets(0, 25, 25, 25);

        deposit = new JButton("Deposit");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        deposit.setFocusable(false);
        deposit.setFont(new Font("Raleway", Font.BOLD, 12));
        deposit.setPreferredSize(new Dimension(200, 50));
        deposit.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 0;
        buttonGroups.add(deposit, gb);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBackground(Color.BLACK);
        cashWithdrawal.setForeground(Color.white);
        cashWithdrawal.setFocusable(false);
        cashWithdrawal.setFont(new Font("Raleway", Font.BOLD, 12));
        cashWithdrawal.setPreferredSize(new Dimension(200, 50));
        cashWithdrawal.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 0;
        buttonGroups.add(cashWithdrawal, gb);

        fastCash = new JButton("Fast Cash");
        fastCash.setBackground(Color.BLACK);
        fastCash.setForeground(Color.white);
        fastCash.setFocusable(false);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 12));
        fastCash.setPreferredSize(new Dimension(200, 50));
        fastCash.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 1;
        buttonGroups.add(fastCash, gb);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setForeground(Color.white);
        miniStatement.setFocusable(false);
        miniStatement.setFont(new Font("Raleway", Font.BOLD, 12));
        miniStatement.setPreferredSize(new Dimension(200, 50));
        miniStatement.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 1;
        buttonGroups.add(miniStatement, gb);

        pinChange = new JButton("Pin Change");
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.white);
        pinChange.setFocusable(false);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 12));
        pinChange.setPreferredSize(new Dimension(200, 50));
        pinChange.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 2;
        buttonGroups.add(pinChange, gb);

        balanceEnquiry = new JButton("Balance Inquiry");
        balanceEnquiry.setBackground(Color.BLACK);
        balanceEnquiry.setForeground(Color.white);
        balanceEnquiry.setFocusable(false);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 12));
        balanceEnquiry.setPreferredSize(new Dimension(200, 50));
        balanceEnquiry.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 2;
        buttonGroups.add(balanceEnquiry, gb);

        exit = new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.white);
        exit.setFocusable(false);
        exit.setFont(new Font("Raleway", Font.BOLD, 12));
        exit.setPreferredSize(new Dimension(200, 50));
        exit.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 3;
        buttonGroups.add(exit, gb);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Transaction("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {

            setVisible(false);
            new Deposit(pin).setVisible(true);

        } else if (ae.getSource() == cashWithdrawal) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if (ae.getSource() == fastCash) {

        } else if (ae.getSource() == miniStatement) {

        } else if (ae.getSource() == pinChange) {

        } else if (ae.getSource() == balanceEnquiry) {

        }
    }
}
