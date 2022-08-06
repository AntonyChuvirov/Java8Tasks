package java8Task2;

import java.util.List;

@FunctionalInterface
public interface IRetain {
   boolean retainAll(List<Integer> firstList, List<Integer> secondList);

   static IRetain retainI() {
      return List::retainAll;
   }
}
