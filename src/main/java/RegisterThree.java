import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class RegisterThree extends JFrame implements ActionListener {

    String formNo;

    JRadioButton savings, current, fixedDeposit, recurringDeposit;

    JButton submit, cancel;
    JCheckBox isATMRequired, isInternetBanking, isMobileBanking, isEmailAndSms, isChequeBook, isEStatement, declaration;

    RegisterThree(String formNumber) {

        this.formNo = formNumber;

        setSize(700, 800);
        setMinimumSize(new Dimension(900, 800));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        header.setBackground(Color.white);
        add(header, BorderLayout.NORTH);

        JLabel formNo = new JLabel("Application Form No. " + formNumber);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setForeground(Color.black);
        header.add(formNo);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        footer.setBackground(Color.white);
        add(footer, BorderLayout.SOUTH);

        JLabel pageNo = new JLabel("Page 3");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setForeground(Color.black);
        footer.add(pageNo);

        //--------------------Content Header---------------------------------
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.white);
        add(content, BorderLayout.CENTER);

        JPanel headerTwo = new JPanel();
        headerTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerTwo.setBackground(Color.white);
        content.add(headerTwo, BorderLayout.NORTH);

        JLabel personalDetails = new JLabel("Account Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBackground(Color.white);
        headerTwo.add(personalDetails);
        //-----------------------------------------------------

        JPanel contentTwo = new JPanel();
        contentTwo.setLayout(new GridBagLayout());
        contentTwo.setBackground(Color.white);
        content.add(contentTwo, BorderLayout.CENTER);

        //----------------------------------------------------
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 25, 0, 25);

        //--------------------Content Body---------------------------------

        JLabel accountType = new JLabel("Account Type");
        accountType.setBackground(Color.white);
        accountType.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentTwo.add(accountType, gbc);

        ButtonGroup groupAccount = new ButtonGroup();

        savings = new JRadioButton("Saving Account");
        savings.setFont(new Font("Raleway", Font.BOLD, 15));
        savings.setBackground(null);
        savings.setFocusable(false);
        savings.isSelected();
        groupAccount.add(savings);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentTwo.add(savings, gbc);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBackground(null);
        current.setFocusable(false);
        groupAccount.add(current);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentTwo.add(current, gbc);

        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
        fixedDeposit.setBackground(null);
        fixedDeposit.setFocusable(false);
        groupAccount.add(fixedDeposit);
        fixedDeposit.setMargin(new Insets(5, 0, 25, 0));
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentTwo.add(fixedDeposit, gbc);

        recurringDeposit = new JRadioButton("Recurring Deposit Account");
        recurringDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
        recurringDeposit.setBackground(null);
        recurringDeposit.setFocusable(false);
        recurringDeposit.setMargin(new Insets(0, 0, 25, 0));
        groupAccount.add(recurringDeposit);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentTwo.add(recurringDeposit, gbc);


        JLabel card = new JLabel("Card Number:");
        card.setBackground(Color.white);
        card.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentTwo.add(card, gbc);


        JLabel number = new JLabel("XXXX-XXXX-XXXX-6942");
        number.setBackground(Color.white);
        number.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentTwo.add(number, gbc);

        JLabel cardDetail = new JLabel("(Your 16 Digit Card Number)");
        cardDetail.setBackground(Color.white);
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentTwo.add(cardDetail, gbc);

        JPanel blank = new JPanel();
        blank.setPreferredSize(new Dimension(10, 25));
        blank.setBackground(null);
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentTwo.add(blank, gbc);

        JLabel pin = new JLabel("Pin Number:");
        pin.setBackground(Color.white);
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 6;
        contentTwo.add(pin, gbc);


        JLabel pnumber = new JLabel("XXXX");
        pnumber.setBackground(Color.white);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 1;
        gbc.gridy = 6;
        contentTwo.add(pnumber, gbc);

        JLabel pinDetail = new JLabel("(Your 4 Digit Password)");
        pinDetail.setBackground(Color.white);
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 7;
        contentTwo.add(pinDetail, gbc);

        JPanel blankTwo = new JPanel();
        blankTwo.setPreferredSize(new Dimension(10, 25));
        blankTwo.setBackground(null);
        gbc.gridx = 0;
        gbc.gridy = 8;
        contentTwo.add(blankTwo, gbc);

        JLabel service = new JLabel("Services Required ");
        service.setBackground(Color.white);
        service.setFont(new Font("Raleway", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 9;
        contentTwo.add(service, gbc);

        isATMRequired = new JCheckBox("ATM CARD");
        isATMRequired.setFont(new Font("Raleway", Font.BOLD, 15));
        isATMRequired.setBackground(null);
        isATMRequired.setFocusable(false);
        isATMRequired.setMargin(new Insets(10, 0, 10, 0));
        gbc.gridx = 0;
        gbc.gridy = 10;
        contentTwo.add(isATMRequired, gbc);

        isInternetBanking = new JCheckBox("Internet Banking");
        isInternetBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        isInternetBanking.setBackground(null);
        isInternetBanking.setFocusable(false);
        isInternetBanking.setMargin(new Insets(10, 0, 10, 0));
        gbc.gridx = 1;
        gbc.gridy = 10;
        contentTwo.add(isInternetBanking, gbc);

        isChequeBook = new JCheckBox("Cheque Book");
        isChequeBook.setFont(new Font("Raleway", Font.BOLD, 15));
        isChequeBook.setBackground(null);
        isChequeBook.setFocusable(false);
        isChequeBook.setMargin(new Insets(10, 0, 10, 0));
        gbc.gridx = 0;
        gbc.gridy = 11;
        contentTwo.add(isChequeBook, gbc);

        isEStatement = new JCheckBox("E-Statement");
        isEStatement.setFont(new Font("Raleway", Font.BOLD, 15));
        isEStatement.setBackground(null);
        isEStatement.setFocusable(false);
        isEStatement.setMargin(new Insets(10, 0, 10, 0));
        gbc.gridx = 1;
        gbc.gridy = 11;
        contentTwo.add(isEStatement, gbc);

        isEmailAndSms = new JCheckBox("Email & SMS");
        isEmailAndSms.setFont(new Font("Raleway", Font.BOLD, 15));
        isEmailAndSms.setBackground(null);
        isEmailAndSms.setFocusable(false);
        isEmailAndSms.setMargin(new Insets(10, 0, 0, 0));
        gbc.gridx = 0;
        gbc.gridy = 12;
        contentTwo.add(isEmailAndSms, gbc);

        isMobileBanking = new JCheckBox("Mobile Banking");
        isMobileBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        isMobileBanking.setBackground(null);
        isMobileBanking.setFocusable(false);
        isMobileBanking.setMargin(new Insets(10, 0, 0, 0));
        gbc.gridx = 1;
        gbc.gridy = 12;
        contentTwo.add(isMobileBanking, gbc);

        JPanel blankThree = new JPanel();
        blankThree.setPreferredSize(new Dimension(10, 25));
        blankThree.setBackground(null);
        gbc.gridx = 0;
        gbc.gridy = 13;
        contentTwo.add(blankThree, gbc);


        //---------------------Content Footer--------------------------------
        JPanel footerTwo = new JPanel();
        footerTwo.setBackground(null);
        footerTwo.setLayout(new BorderLayout());
        content.add(footerTwo, BorderLayout.SOUTH);

        JPanel footerTwoNorth = new JPanel();
        footerTwoNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        footerTwoNorth.setBackground(null);
        footerTwo.add(footerTwoNorth, BorderLayout.NORTH);

        declaration = new JCheckBox();
        declaration.setBackground(null);
        declaration.setFocusable(false);
        footerTwoNorth.add(declaration);

        JLabel declarationText = new JLabel("I hereby declare that above entered details are correct to best of my knowledge");
        declarationText.setBackground(null);
        declarationText.setFont(new Font("Raleway", Font.BOLD, 12));
        footerTwoNorth.add(declarationText);

        JPanel footerTwoSouth = new JPanel();
        footerTwoSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));
        footerTwoSouth.setBackground(null);
        footerTwo.add(footerTwoSouth, BorderLayout.SOUTH);

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        footerTwoSouth.add(submit);

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        footerTwoSouth.add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterThree("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String accountType = null;
            if (savings.isSelected()) {
                accountType = "Savings Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (fixedDeposit.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurringDeposit.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNo = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNo = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";

            if (isATMRequired.isSelected()) {
                facility += " ATM CARD";
            } else if (isChequeBook.isSelected()) {
                facility += " Cheque Book";
            } else if (isEStatement.isSelected()) {
                facility += " E-Statement";
            } else if (isEmailAndSms.isSelected()) {
                facility += " Email And SMS";
            } else if (isMobileBanking.isSelected()) {
                facility += " Mobile Banking";
            } else if (isInternetBanking.isSelected()) {
                facility += " Internet Banking";
            }

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(this, "Account Type is required.", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    Connection connection = dataBase.getConnection();

                    String query = "INSERT INTO registration_data_3 " +
                            "(user_visible_form_no, accountType, cardNumber, pinNumber, facility) " + "VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, formNo);
                    preparedStatement.setString(2, accountType);
                    preparedStatement.setString(3, cardNo);
                    preparedStatement.setString(4, pinNo);
                    preparedStatement.setString(5, facility);

                    String query2 = "INSERT INTO public.login(" +
                            "user_visible_form_no, cardnumber, pinnumber)" +
                            "VALUES (?, ?, ?);";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                    preparedStatement2.setString(1, formNo);
                    preparedStatement2.setString(2, cardNo);
                    preparedStatement2.setString(3, pinNo);

                    int rowsAffected = preparedStatement.executeUpdate();
                    int rowsAffected2 = preparedStatement2.executeUpdate();

                    if (rowsAffected > 0 & rowsAffected2 > 0) {
                        JOptionPane.showMessageDialog(this, "Your Card no: " + cardNo + "\n Your Pin No: " + pinNo, "Success", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new Login().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to add user data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    preparedStatement.close();
                    preparedStatement2.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            new Login().setVisible(true);
            setVisible(false);
        }
    }

}
