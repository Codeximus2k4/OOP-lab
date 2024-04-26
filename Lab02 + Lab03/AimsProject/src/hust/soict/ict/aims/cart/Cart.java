package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED  =20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is full");
        }
    }
        public void removeDigitalVideoDisc(int removeindex)
        {
            for (int i=0, k=0; i<qtyOrdered-1;i++ ){
                if (i==removeindex){
                    k++;
                }
                else {
                    itemsOrdered[i]=itemsOrdered[k];
                }
            }
        }
        public float totalCost(){
        float totalcost=0;
        for (int i = 0 ; i<qtyOrdered;i++){
            totalcost+= itemsOrdered[i].getCost();
        }
        return totalcost;
        }
    public void print_cart(){
        System.out.println("*********************CART*******************");
        System.out.println("Ordered Items:");
        for (int i=0; i<qtyOrdered;i++){
            System.out.println(Integer.toString(i+1)+ ". DVD- "+ itemsOrdered[i].getTitle()+ " - "+ itemsOrdered[i].getCategory()+ " - "
            + itemsOrdered[i].getDirector()+ " - "+ Integer.toString(itemsOrdered[i].getLength())+ ": "+ Float.toString(itemsOrdered[i].getCost())+"$");
        }
        System.out.println("Total_cost: "+ Float.toString(this.totalCost()));
        System.out.println("********************************************");
    }
    public void search_by_id(int id){
        if (id<1 || id>qtyOrdered){
            System.out.println("No match is found");
        }
        else {
            System.out.println(Integer.toString(id)+ ". DVD- "+ itemsOrdered[id-1].getTitle()+ " - "+ itemsOrdered[id-1].getCategory()+ " - "
                    + itemsOrdered[id-1].getDirector()+ " - "+ Integer.toString(itemsOrdered[id-1].getLength())+ ": "+ Float.toString(itemsOrdered[id-1].getCost()));
        }
    }
    public void search_by_title(String title){
        boolean found= false;
        for (int i=0;i<qtyOrdered;i++){
            if (itemsOrdered[i].isMatch(title)){
                System.out.println(Integer.toString(i+1)+ ". DVD- "+ itemsOrdered[i].getTitle()+ " - "+ itemsOrdered[i].getCategory()+ " - "
                        + itemsOrdered[i].getDirector()+ " - "+ Integer.toString(itemsOrdered[i].getLength())+ ": "+ Float.toString(itemsOrdered[i].getCost())+"$");
                found = true;
            }
        }
        if (!found){
            System.out.println("No match is found");
        }

    }
}
