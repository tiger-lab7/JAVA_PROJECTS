import java.util.Map;

public class Main {

    public static void main(String... args) {

        TreeMapHM<Integer, String> treeMapHM = new TreeMapHM<>();

        for(int i = 0; i < 100; i++) {
            treeMapHM.put((int) (Math.random() * 1000), "CAT");
        }

        //treeMapHM.treeTraversal(treeMapHM.firstNode);

        //treeMapHM.mapEntries.forEach(entry -> System.out.println(entry.key + " " + entry.value));

        System.out.println("MAP SIZE: " + treeMapHM.size());

        treeMapHM.put(3, "FIND!");

        System.out.println("FIND KEY 3: " + treeMapHM.get(3));

        //System.out.println("FIND KEY 777: " + treeMapHM.get(777));

       // treeMapHM.entrySet().forEach(entry ->
        //        System.out.println(entry.getKey() + " " + entry.getValue()));

        for(Map.Entry<Integer, String> me : treeMapHM.entrySet()) {
            System.out.println(me.getKey() + " " + me.getValue());
        }

    }
}
