package hust.soict.ict.aims.screen.manager;

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
import java.util.Objects;

public class AddItemToStoreScreen extends JFrame {
    private Store store;
    private JTextField tfInput =  new JTextField(30);

    private JButton btnConfirm;
    private Container frame;
    private String item_title = "";
    private int item_cost = 0;
    private String item_category="";
    public AddItemToStoreScreen(Store store){
        this.store =store;
        System.out.println(store.getItemsInStore().size());
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
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
            System.out.println(store.getItemsInStore().size());
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
        center.setLayout(new GridLayout(4,3,2,2));

        center.add(new JLabel("Please enter the title:"));
        tfInput =  new JTextField(30);
        center.add(tfInput);
        tfInput.addActionListener(new TitleInput_Listener());

        center.add(new JLabel("Please enter the category:"));
        tfInput =  new JTextField(30);
        center.add(tfInput);
        tfInput.addActionListener(new CatInput_Listener());

        center.add(new JLabel("Please enter the cost:"));
        tfInput =  new JTextField(30);
        center.add(tfInput);
        tfInput.addActionListener(new CostInput_Listener());

        btnConfirm =  new JButton("Add");
        center.add(btnConfirm);
        btnConfirm.addActionListener(new ButtonListener());
        return center;
    }
    public static void main(String[] arsg){
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
        AddItemToStoreScreen sms = new AddItemToStoreScreen(mediae);

    }
    private class TitleInput_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            item_title = tfInput.getText();
        }
    }
    private class CatInput_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            item_category = tfInput.getText();
        }
    }
    private class CostInput_Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            item_cost = Integer.parseInt(tfInput.getText());
        }

    }
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){

            add_new_media();
            System.out.println("Added successfully");
            tfInput.setText("");
        }
    }
    public void add_new_media(){
        Media media = new Media();
        media.setTitle(item_title);
        media.setCost(item_cost);
        media.setCategory(item_category);
        this.store.addMedia(media);
    }

    public Store getStore() {
        return store;
    }
}
