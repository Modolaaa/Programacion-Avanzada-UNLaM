import java.util.List;
import java.util.ArrayList;

public class DosReliquias {

    public static List<Reliquia> dosReliquias(List<Reliquia> guardianes, List<Reliquia> conquistadores, int n){

        MaxHeap<Reliquia> myHeap = new MaxHeap<Reliquia>();

        for(Reliquia myReliquia : guardianes){
            myHeap.insert(new Tuple<>(myReliquia,1));
        }

        for(Reliquia myReliquia : conquistadores){
            myHeap.insert(new Tuple<>(myReliquia,2));
        }

        ArrayList<Reliquia> myAns = new ArrayList<>();
        int contador = 0;
        while(myHeap.peek() != null && contador<n){
            Tuple<Reliquia> max = myHeap.extractMax();
            myAns.add(max.dato);
            contador++;
        }
        return myAns;
    }



}


