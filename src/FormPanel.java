import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okbutton;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;
    private JRadioButton boyRadio;
    private JRadioButton girlRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        nameLabel = new JLabel("NAME: ");
        occupationLabel = new JLabel("OCCUPATION: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();
        citizenCheck=new JCheckBox();
        taxField=new JTextField(10);
        taxLabel=new JLabel("Tax ID:  ");
        boyRadio=new JRadioButton("boy");
        girlRadio=new JRadioButton("girl");
        boyRadio.setActionCommand("boy");
        girlRadio.setActionCommand("girl");

        genderGroup=new ButtonGroup();

        boyRadio.setSelected(true);

        //set up gender radios//
        genderGroup.add(boyRadio);
        genderGroup.add(girlRadio);


              //set up tax ID//
        taxLabel.setEnabled(false);
        taxField.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked=citizenCheck.isSelected();
                taxLabel.setEnabled(isTicked);
                taxField.setEnabled(isTicked);
            }
        });

        //set up List Box//
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, " 65 or over"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);
        okbutton = new JButton("OKK");
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory age = (AgeCategory) ageList.getSelectedValue();
                String empCat=(String) empCombo.getSelectedItem();
                String taxID=taxField.getText();
                boolean Indian=citizenCheck.isSelected();
                String gender=genderGroup.getSelection().getActionCommand();
                FormEvent ev = new FormEvent(this, name, occupation, age.getId(),empCat,taxID,Indian,gender);
                if (formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }
        });
        Border innerBolder = BorderFactory.createTitledBorder("Add a Person");
        Border outerBolder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBolder, innerBolder));
        layoutComponents();
    }
     public void layoutComponents(){
            setLayout(new GridBagLayout());
            GridBagConstraints gb=new GridBagConstraints();
            gb.weightx=1;
            gb.weighty=1;
            ///////FIRST ROW/////////
            gb.gridy=0;
            gb.weightx=1;
            gb.weighty=0.1;
            gb.gridx=0;

            gb.anchor=GridBagConstraints.LINE_END;
            gb.fill=GridBagConstraints.NONE;
            gb.insets=new Insets(0,0,0,5);
            add(nameLabel,gb);
            gb.gridx=1;
            gb.gridy=0;
            gb.anchor=GridBagConstraints.LINE_START;
            gb.insets=new Insets(0,0,0,0);
            add(nameField,gb);
            ///////SECOND ROW/////////
            gb.gridy++;
            gb.weightx=1;
            gb.weighty=0.1;
            gb.gridx=0;

            gb.anchor=GridBagConstraints.LINE_END;
            gb.insets=new Insets(0,0,0,5);
            add(occupationLabel,gb);
            gb.insets=new Insets(0,0,0,0);
            gb.gridy=1;
            gb.gridx=1;
            gb.anchor=GridBagConstraints.LINE_START;
            add(occupationField,gb);
            ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.2;
         gb.gridx=0;
         gb.anchor=GridBagConstraints.FIRST_LINE_END;
         gb.insets=new Insets(0,0,0,5);
         add(new JLabel("Age:"),gb);

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(ageList,gb);
         ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.2;
         gb.gridx=0;
         gb.anchor=GridBagConstraints.FIRST_LINE_END;
         gb.insets=new Insets(0,0,0,5);
         add(new JLabel("Employment:"),gb);

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(empCombo,gb);

         ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.2;
         gb.gridx=0;
         gb.anchor=GridBagConstraints.FIRST_LINE_END;
         gb.insets=new Insets(0,0,0,5);
         add(new JLabel("Indian"),gb);

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(citizenCheck,gb);

         ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.2;
         gb.gridx=0;
         gb.anchor=GridBagConstraints.FIRST_LINE_END;
         gb.insets=new Insets(0,0,0,5);
         add(taxLabel,gb);

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(taxField,gb);

         ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.05;
         gb.gridx=0;
         gb.anchor=GridBagConstraints.LINE_END;
         gb.insets=new Insets(0,0,0,5);
         add(new JLabel("Gender: "),gb);

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(boyRadio,gb);

         ///////NEXT ROW/////////
         gb.gridy++;
         gb.weightx=1;
         gb.weighty=0.2;

         gb.gridx=1;
         gb.anchor=GridBagConstraints.FIRST_LINE_START;
         gb.insets=new Insets(0,0,0,0);
         add(girlRadio,gb);

            ///////NEXT ROW/////////
            gb.gridy++;
            gb.weightx=1;
            gb.weighty=2.0;
            gb.gridx=1;
            gb.anchor=GridBagConstraints.FIRST_LINE_START;
            gb.insets=new Insets(0,0,0,0);
            add(okbutton,gb);
        }
    public void setFormListener(FormListener listener){
        this.formListener=listener;
    }
}
class AgeCategory{
    private String text;
    private int id;
    public AgeCategory(int id,String text){
        this.id=id;
        this.text=text;

    }
    public String toString(){
        return text;
    }

    public int getId() {
        return id;
    }
}