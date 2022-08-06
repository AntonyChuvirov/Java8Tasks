package java8Task2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Tests {

    @Test
    public void checkRemoveFirstEl() {
        List<Integer> firstLinkedList = new LinkedList<>();
        firstLinkedList.add(1);
        firstLinkedList.add(2);
        firstLinkedList.add(3);

        System.out.println(firstLinkedList);

        IRemove iRemoveLinked = () -> firstLinkedList.remove(0);

        iRemoveLinked.removeFirstEl();
        System.out.println(firstLinkedList);

        iRemoveLinked.removeFirstEl();
        System.out.println(firstLinkedList);
    }

    @Test
    public void checkRetainAll() {
        List<Integer> firstArrayList = new ArrayList<>();
        firstArrayList.add(1);
        firstArrayList.add(2);
        firstArrayList.add(3);

        List<Integer> secondArrayList = new ArrayList<>();
        secondArrayList.add(3);
        secondArrayList.add(4);
        secondArrayList.add(5);

        boolean actual = IRetain.retainI().retainAll(firstArrayList, secondArrayList);

        System.out.println(firstArrayList);

        Assert.assertTrue(actual);
    }

    @Test
    public void createListOfLists() {
        Vector<Integer> firstVector = new Vector<>();
        firstVector.add(1);
        firstVector.add(2);
        firstVector.add(3);

        ArrayList<Integer> secondArrayList = new ArrayList<>();
        secondArrayList.add(3);
        secondArrayList.add(4);
        secondArrayList.add(5);

        LinkedList<Integer> thirdLinkedList = new LinkedList<>();
        thirdLinkedList.add(7);
        thirdLinkedList.add(8);
        thirdLinkedList.add(9);

        List<List<Integer>> superList = IListsInList.listsInListI().listOf(firstVector, secondArrayList, thirdLinkedList);

        System.out.println(superList);
        Assert.assertEquals(superList.size(), 3);
    }
}
