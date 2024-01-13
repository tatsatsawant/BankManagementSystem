import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
public class RegisterThree extends JFrame {

    String formNo;

    Connection connection = dataBase.getConnection();

    JRadioButton yesExisting, noExisting;

    JButton submit, cancel;

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

        JLabel formNo = new JLabel("Application Form No. "+ formNumber);
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
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets = new Insets(10, 10, 10, 20);

        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.anchor = GridBagConstraints.WEST;
        gbcField.insets = new Insets(10, 10, 10, 10);
        gbcField.gridwidth = GridBagConstraints.REMAINDER;
        //--------------------Content Body---------------------------------

        JLabel isExistingAccount = new JLabel("Existing Account:");
        isExistingAccount.setBackground(Color.white);
        isExistingAccount.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(isExistingAccount, gbcLabel);

        ButtonGroup existingAccountGroup = new ButtonGroup();

        yesExisting = new JRadioButton("Yes");
        yesExisting.setBackground(null);
        yesExisting.setFocusable(false);
        existingAccountGroup.add(yesExisting);
        contentTwo.add(yesExisting, gbcLabel);

        noExisting = new JRadioButton("No");
        noExisting.setBackground(null);
        noExisting.setFocusable(false);
        noExisting.setSelected(true);
        existingAccountGroup.add(noExisting);
        contentTwo.add(noExisting, gbcLabel);

        //---------------------Content Footer--------------------------------
        JPanel footerTwo = new JPanel();
        footerTwo.setBackground(null);
        footerTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 30,10));
        content.add(footerTwo, BorderLayout.SOUTH);

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
//        submit.addActionListener(this);
        footerTwo.add(submit);

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
//        submit.addActionListener(this);
        footerTwo.add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterThree("");
    }

}
