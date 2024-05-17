package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media){
       this.media =  media;
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

       JLabel  title  = new JLabel(media.getTitle());
       title.setFont(new Font(title.getFont().getName(), Font.PLAIN,15));
       title.setAlignmentX(CENTER_ALIGNMENT);

       JLabel cost = new JLabel(""+media.getCost()+" $");
       cost.setAlignmentX(CENTER_ALIGNMENT);

       JPanel container =  new JPanel();
       container.setLayout(new FlowLayout(FlowLayout.CENTER));

       if (media instanceof Playable){
           JButton playButton = new JButton("Play");
           container.add(playButton);
           playButton.addActionListener(new ButtonListener());
       }
       this.add(Box.createVerticalGlue());
       this.add(title);
       this.add(cost);
       this.add(Box.createVerticalGlue());
       this.add(container);

       this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private class ButtonListener implements ActionListener {
        JFrame f;
        @Override
        public void actionPerformed(ActionEvent evt){
            String s =  evt.getActionCommand();
            if (s.equals("Play")){
                JDialog j =  new JDialog(f, "Media Play");
                j.setLayout(new FlowLayout());
                JButton b = new JButton ("OK");
                b.addActionListener ( new ActionListener()
                {
                    public void actionPerformed( ActionEvent e )
                    {
                        j.setVisible(false);
                    }
                });
                j.add( new JLabel ("Playing."));
                j.add(b);
                j.setSize(300,300);
                j.setVisible(true);

            }}
    }

}
