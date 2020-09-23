import java.awt.*;
import java .awt.event.*;

public class ButtonExample {
    public static void main(String[] args) {
        Frame f = new Frame("Button Example");
        final TextField tf = new TextField();
        Button b=new Button("Press Here");
        b.setBounds(100,150,80,30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              tf.setText("HII,ASTHA HERE");
            }
        });
        f.add(b);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }


}
