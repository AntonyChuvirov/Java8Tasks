package java8Task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public interface IListsInList {
    List<List<Integer>> listOf(Vector<Integer> first, ArrayList<Integer> second, LinkedList<Integer> third);

    static IListsInList listsInListI(){
        return List::of;
    }
}
