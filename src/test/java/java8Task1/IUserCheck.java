package java8Task1;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface IUserCheck {
    boolean checkConditions(User user);

    static List<User> getCondition(List<User> users, IUserCheck conditions){
        List<User> usersForFiltration = new ArrayList<>();
        for (User user : users){
            if (conditions.checkConditions(user)) {
                usersForFiltration.add(user);
            }
        }
        return usersForFiltration;
    }
}
