import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    public static void hallojavamitForEachMethode(){
    List<String> ausgeben = new ArrayList<>();
    ausgeben.add("wow");
    ausgeben.add("mega");

    for (int i = 0; i< ausgeben.size(); i++){
        System.out.println(ausgeben.get(i));
    }

    ausgeben.forEach(System.out::println);
    }


}
