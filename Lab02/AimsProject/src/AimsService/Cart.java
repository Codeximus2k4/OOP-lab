package AimsService;

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
}
