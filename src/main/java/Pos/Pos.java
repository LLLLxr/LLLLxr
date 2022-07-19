package Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pos {
    HashMap<String,Item> database = new HashMap<String, Item>();
    public List<String> generateReceipt(HashMap<String,Item> database,List<String> orders){
        List<String> receipts = new ArrayList<>();
        List<String> unFinishingReceipts = generateOrders(orders);
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

    public List<String> generateOrders(List<String> orders){
        List<String> receipts = null;
        return receipts;
    }

    public String generateTotalPrice(HashMap<String,Item> database,List<String> finishingOrders){
        String totalPrice = null;

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
        return price;
    }
}
