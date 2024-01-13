import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterTwo extends JFrame implements ActionListener {

    String formNo;

    Connection connection = dataBase.getConnection();
    JTextField panNoText, aadharNoText;
    JComboBox<String> ageGroupText, religionText, categoryText, incomeText, educationText, occupationText;
    String existingAccount = null;
    JRadioButton yesExisting, noExisting;

    RegisterTwo(String formNumber) {

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

//        JLabel formNo = new JLabel("Application Form No. "+ formNumber);
        JLabel formNo = new JLabel("Application Form No. ");
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setForeground(Color.black);
        header.add(formNo);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        footer.setBackground(Color.white);
        add(footer, BorderLayout.SOUTH);

        JLabel pageNo = new JLabel("Page 2");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setForeground(Color.black);
        footer.add(pageNo);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.white);
        add(content, BorderLayout.CENTER);

        JPanel headerTwo = new JPanel();
        headerTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerTwo.setBackground(Color.white);
        content.add(headerTwo, BorderLayout.NORTH);

        JLabel personalDetails = new JLabel("Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBackground(Color.white);
        headerTwo.add(personalDetails);

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
        //-----------------------------------------------------
        JLabel religion = new JLabel("Religion:");
        religion.setBackground(Color.white);
        religion.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(religion, gbcLabel);

        String[] religionOptions = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionText = new JComboBox<>(religionOptions);
        religionText.setBackground(Color.white);
        religionText.setFont(new Font("Raleway", Font.ITALIC, 12));
        religionText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(religionText, gbcField);

        JLabel category = new JLabel("Category:");
        category.setBackground(Color.white);
        category.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(category, gbcLabel);

        String[] categoryOptions = {"General", "ST", "SC", "OBC", "Other"};
        categoryText = new JComboBox<>(categoryOptions);
        categoryText.setBackground(Color.white);
        categoryText.setFont(new Font("Raleway", Font.ITALIC, 12));
        categoryText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(categoryText, gbcField);

        JLabel income = new JLabel("Income:");
        income.setBackground(Color.white);
        income.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(income, gbcLabel);

        String[] incomeOptions = {"Null", "< 2,50,000", "<6,00,000", "<25,00,000", "Above 25,00,000"};
        incomeText = new JComboBox<>(incomeOptions);
        incomeText.setBackground(Color.white);
        incomeText.setFont(new Font("Raleway", Font.ITALIC, 12));
        incomeText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(incomeText, gbcField);

        JLabel ageGroup = new JLabel("Age Group:");
        ageGroup.setBackground(Color.white);
        ageGroup.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(ageGroup, gbcLabel);

        String[] ageGroupOptions = {"Under 18", "Adult", "Senior Citizen"};
        ageGroupText = new JComboBox<>(ageGroupOptions);
        ageGroupText.setBackground(Color.white);
        ageGroupText.setFont(new Font("Raleway", Font.ITALIC, 12));
        ageGroupText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(ageGroupText, gbcField);

        JLabel education = new JLabel("Education:");
        education.setBackground(Color.white);
        education.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(education, gbcLabel);

        String[] educationOptions = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationText = new JComboBox<>(educationOptions);
        educationText.setBackground(Color.white);
        educationText.setFont(new Font("Raleway", Font.ITALIC, 12));
        educationText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(educationText, gbcField);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBackground(Color.white);
        occupation.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(occupation, gbcLabel);

        String[] occupationOptions = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationText = new JComboBox<>(occupationOptions);
        occupationText.setBackground(Color.white);
        occupationText.setFont(new Font("Raleway", Font.ITALIC, 12));
        occupationText.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        contentTwo.add(occupationText, gbcField);

        JLabel panNo = new JLabel("PAN No:");
        panNo.setBackground(Color.white);
        panNo.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(panNo, gbcLabel);

        panNoText = new JTextField(20);
        panNoText.setBackground(Color.white);
        panNoText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(panNoText, gbcField);

        JLabel aadharNo = new JLabel("Aadhar No:");
        aadharNo.setBackground(Color.white);
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(aadharNo, gbcLabel);

        aadharNoText = new JTextField(20);
        aadharNoText.setBackground(Color.white);
        aadharNoText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(aadharNoText, gbcField);

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

        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BorderLayout());
        rightPane.setBackground(Color.white);
        rightPane.setPreferredSize(new Dimension(200, 200));
        add(rightPane, BorderLayout.EAST);

        JPanel rightTop = new JPanel();
        rightTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        rightTop.setBackground(Color.white);
        rightPane.setPreferredSize(new Dimension(150, 200));
        rightPane.add(rightTop, BorderLayout.NORTH);

        JButton next = new JButton("NEXT");
        next.setFocusable(false);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        rightTop.add(next);

        JPanel leftPane = new JPanel();
        leftPane.setLayout(new BorderLayout());
        leftPane.setBackground(Color.white);
        leftPane.setPreferredSize(new Dimension(200, 200));
        add(leftPane, BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterTwo("");
    }

    public void actionPerformed(ActionEvent ae) {

        String ageGroup = (String) ageGroupText.getSelectedItem();
        String religion = (String) religionText.getSelectedItem();
        String category = (String) categoryText.getSelectedItem();
        String income = (String) incomeText.getSelectedItem();
        String education = (String) educationText.getSelectedItem();
        String occupation = (String) occupationText.getSelectedItem();
        String panNo = panNoText.getText();
        String aadharNo = aadharNoText.getText();

        if (yesExisting.isSelected()) {
            existingAccount = "yes";
        } else if (noExisting.isSelected()) {
            existingAccount = "No";
        }

        if (panNo.isEmpty() || aadharNo.isEmpty()) {

            JOptionPane.showMessageDialog(this, "All fields are required. Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                String query = "INSERT INTO registration_data_2 " +
                        "(user_visible_form_no, religion, category, income, age_group, " +
                        "education, occupation, pan_no, aadhar_no, existing_account) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, formNo);
                preparedStatement.setString(2, religion);
                preparedStatement.setString(3, category);
                preparedStatement.setString(4, income);
                preparedStatement.setString(5, ageGroup);
                preparedStatement.setString(6, education);
                preparedStatement.setString(7, occupation);
                preparedStatement.setString(8, panNo);
                preparedStatement.setString(9, aadharNo);
                preparedStatement.setString(10, existingAccount);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User data added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    //call form 3
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add user data.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                preparedStatement.close();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while adding user data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


}
