package Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pos {
//    HashMap<String,Item> database = new HashMap<String, Item>();
//    List<String> orders = new ArrayList<>();
//
//    public Pos(HashMap<String, Item> database, List<String> orders) {
//        this.database = database;
//        this.orders = orders;
//    }

    public List<String> generateReceipt(HashMap<String,Item> database, List<String> orders){
        List<String> receipts = new ArrayList<>();
        List<String> unFinishingReceipts = generateFinishingOrders(orders);
        List<String> otherLines= generateOtherLine();
        String totalPrice = generateTotalPrice(database,orders);
        receipts.add(otherLines.get(0));

        for (String receipt : unFinishingReceipts){
            receipts.add(receipt);
        }
        receipts.add(otherLines.get(1));
        receipts.add(totalPrice);
        receipts.add(otherLines.get(2));
        return receipts;
    }

    public List<String> generateFinishingOrders(List<String> orders){
        List<String> receipts = new ArrayList<>();
        HashMap<String,Integer>  finishingOrders = new HashMap<>();

        for(String itemName : orders){
            if (!finishingOrders.containsKey(itemName)) finishingOrders.put(itemName,1);
                else finishingOrders.put(itemName,finishingOrders.get(itemName) + 1);
        }



        return receipts;
    }

    public String generateTotalPrice(HashMap<String,Item> database,List<String> orders){
        int price = 0;
        for (int i = 0; i < orders.size(); i++) {
            price += caculateOrderPrice(database,orders.get(i));
        }
        String totalPrice = "Total: + " + price + " + (yuan)";
        return totalPrice;
    }

    public List<String> generateOtherLine(){
        List<String> otherLines = new ArrayList<>();
        otherLines.add("***<store earning no money>Receipt ***");
        otherLines.add("----------------------");
        otherLines.add("**********************");
        return otherLines;
    }

    public String generatereceipt(List<String> orders){
        String receipt = null;
        return receipt;
    }

    public int caculateOrderPrice(HashMap<String,Item> database,String order){
        int price = 0;
        price += database.get(order).price;
        return price;
    }

    public static void main(String[] args) {
        List<String> orders =
                Arrays.asList(
                "ITEM000000",
                "ITEM000000",
                "ITEM000000",
                "ITEM000000",
                "ITEM000000",
                "ITEM000001",
                "ITEM000001",
                "ITEM000004");
        HashMap<String,Item> database = new HashMap<String, Item>();

        database.put("ITEM000000",new Item( "ITEM000000","Coca-Cola",3));
        database.put("ITEM000001",new Item( "ITEM000001","Sprite",3));
        database.put("ITEM000002",new Item( "ITEM000002","Apple",5));
        database.put("ITEM000003",new Item( "ITEM000003","Litchi",15));
        database.put("ITEM000004",new Item( "ITEM000004","Battery",2));
        database.put("ITEM000005",new Item( "ITEM000005","Instant Noodles",4));

        Pos pos = new Pos();
        List<String> printReceipt = pos.generateReceipt(database,orders);
        for (String node : printReceipt) System.out.println(node);

    }
}
