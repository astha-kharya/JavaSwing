import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton newbutton;
    private JButton exitbutton;
    private StringListener textListener;

    public ToolBar() {
        setBorder(BorderFactory.createEtchedBorder());
        newbutton = new JButton("new");
        exitbutton = new JButton("exit");
        newbutton.addActionListener(this);
        exitbutton.addActionListener((ActionListener) this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(newbutton);
        add(exitbutton);

    }

    public void setStringListener(StringListener textListener) {
        this.textListener = textListener;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == newbutton) {
            if (textListener != null) {
                textListener.textEmitted("New\n");
            }
        } else {
            if (textListener != null) {
                textListener.textEmitted("Exit\n");
            }
        }
    }
}
