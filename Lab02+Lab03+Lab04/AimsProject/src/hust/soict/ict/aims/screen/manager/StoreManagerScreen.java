package hust.soict.ict.aims.screen.manager;

import com.sun.glass.ui.View;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame.*;
import static com.sun.glass.ui.Cursor.*;

public class StoreManagerScreen extends JFrame{
    private Store store;
    private Container frame;
    public StoreManagerScreen(Store store){
        this.store =store;
        Container cp = getContentPane();
        this.frame =cp;
        this.frame.setLayout(new BorderLayout());
        this.frame.add(createNorth(),BorderLayout.NORTH);
        this.frame.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void deleteFrame(){
        dispose();
    }
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenuItem view_store =  new JMenuItem("View Store");
        menu.add(view_store);
        view_store.addActionListener(new View_Store_Listener());

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook =  new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new Add_Book_Listener());


        JMenuItem addCD =  new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new Add_CD_Listener());

        JMenuItem addDVD =  new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new Add_DVD_Listener());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        menuBar.add(smUpdateStore);
        return menuBar;
    }
    private class View_Store_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){


            StoreManagerScreen new_sms =  new StoreManagerScreen(store);

        }
    }
    private class Add_Book_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            AddBookToStoreScreen new_frame =  new AddBookToStoreScreen(store);

        }
    }
    private class Add_CD_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            AddCompactDiscToStoreScreen new_frame =  new AddCompactDiscToStoreScreen(store);


        }
    }
    private class Add_DVD_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){

            AddDigitalVideoDiscToStoreScreen new_frame =  new AddDigitalVideoDiscToStoreScreen(store);

        }
    }
    JPanel createHeader(){
        JPanel header =  new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title =  new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6,3,2,2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i =0;i< mediaInStore.size();i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
    public static void main(String[] args){
        Store mediae = new Store();
        CompactDisc cd = new CompactDisc();
        cd.setTitle("The return of the King");
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        dvd.setTitle("Pe Xuan Mike");
        Book book = new Book();
        book.setTitle("Song of Ice and Fire");
        mediae.addMedia(cd);
        mediae.addMedia(dvd);
        mediae.addMedia(book);
        StoreManagerScreen sms = new StoreManagerScreen(mediae);
    }
}
