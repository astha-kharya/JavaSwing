import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ToolBar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    public MainFrame(){
        super("Hi");
        setLayout(new BorderLayout());
        toolbar=new ToolBar();
        textPanel=new TextPanel();
        formPanel=new FormPanel();
        setJMenuBar(createMenuBar());
        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });
        formPanel.setFormListener(new FormListener(){
           public void formEventOccured(FormEvent e){
               String name=e.getName();
               String occupation=e.getOccupation();
               int age=e.getAgeCategory();
               String empCat=e.getEmpCat();
               String gender=e.getGender();
               textPanel.appendText(name+":"+occupation+":"+age+"."+empCat+":"+gender+"\n");
           }
        });
        add(formPanel,BorderLayout.WEST);
        add(toolbar,BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
         private JMenuBar createMenuBar(){
             JMenuBar menuBar=new JMenuBar();

             JMenu fileMenu=new JMenu("File");
             JMenuItem exportDataItem=new JMenuItem("Export Data....");
             JMenuItem importDataItem=new JMenuItem("Import Data....");
             JMenuItem exitItem=new JMenuItem("Exit");

             fileMenu.add(exportDataItem);
             fileMenu.add(importDataItem);
             fileMenu.addSeparator();
             fileMenu.add(exitItem);

             JMenu windowMenu=new JMenu("Window");
             JMenu showMenu=new JMenu("Show");

             JCheckBoxMenuItem showFormItem=new JCheckBoxMenuItem("Person Menu");
             showFormItem.setSelected(true);

             showMenu.add(showFormItem);
             windowMenu.add(showMenu);

             menuBar.add(fileMenu);
             menuBar.add(windowMenu);

             showFormItem.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent ev) {
                            JCheckBoxMenuItem menuItem=(JCheckBoxMenuItem)ev.getSource();
                            formPanel.setVisible(menuItem.isSelected());
                 }
             });

             return menuBar;
         }
}
