import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class JSONPW {
    private static final ArrayList<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Object obj = new JSONParser().parse(new FileReader("input.txt"));
            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                orderList.add(new Order(
                        (long) jo.get("event_id"),
                        (long) jo.get("order_id"),
                        (long) jo.get("item_id"),
                        (long) jo.get("count"),
                        (long) jo.get("return_count"),
                        (String) jo.get("status")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        orderList.sort(new OrderComparator());

        Map<Long, ArrayList<Product>> resultOrders = new TreeMap<>();

        for (Order order : orderList) {

            boolean isOK = (order.status.equals("OK"));

            if (!resultOrders.containsKey(order.order_id)) { // Добавление нового заказа
                ArrayList<Product> currentProductList = new ArrayList<>();
                currentProductList.add(
                        new Product(order.item_id, order.count - order.return_count, isOK));
                resultOrders.put(order.order_id, currentProductList);
            } else { // Изменение и обновление списка продуктов в заказе
                ArrayList<Product> currentProductList = resultOrders.get(order.order_id);
                currentProductList.forEach((Product prod) -> {
                    if (prod.item_id == order.item_id) {
                        prod.count = order.count - order.return_count;
                        prod.isOK = isOK;
                    }
                });
            }
        }

        JSONArray commonJsonArray = new JSONArray();

        for (Map.Entry<Long, ArrayList<Product>> resultOrder : resultOrders.entrySet()) {

            JSONArray jsonArray = new JSONArray();
            ArrayList<Product> products = resultOrder.getValue();
            for (Product product : products) {
                if (product.count > 0 && product.isOK) {

                    JSONObject jsonProduct = new JSONObject();

                    jsonProduct.put("id", product.item_id);
                    jsonProduct.put("count", product.count);
                    jsonArray.add(jsonProduct);
                }
            }

            if (!jsonArray.isEmpty()) {

                JSONObject jsonOrder = new JSONObject();

                jsonOrder.put("id", resultOrder.getKey());
                jsonOrder.put("items", jsonArray);
                commonJsonArray.add(jsonOrder);
            }

        }

        String resultJsonString = commonJsonArray.toJSONString();
        //resultJsonString = resultJsonString.replaceAll("\\{}","");

        System.out.println(resultJsonString);

    }
}

class Order {
    public long event_id;
    public long order_id;
    public long item_id;
    public long count; // Итоговое количество единиц товара в заказе, запрошенное к отправке.
    public long return_count; // Итоговое количество единиц товара в заказе, отмененное к отправке.
    String status;// статус товара в заказе.

    public Order(long event_id, long order_id, long item_id, long count, long return_count, String status) {
        this.event_id = event_id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.count = count;
        this.return_count = return_count;
        this.status = status;
    }

}

class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.event_id > o2.event_id) return 1;
        else if (o1.event_id < o2.event_id) return -1;
        return 0;
    }
}

class Product {
    Long item_id;
    Long count;
    boolean isOK;

    public Product(Long item_id, Long count, boolean isOK) {
        this.item_id = item_id;
        this.count = count;
        this.isOK = isOK;
    }
}



