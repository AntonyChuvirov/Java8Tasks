package java8Task1;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    User user1 = new User(18, "Jack", 55, false, "AQA");
    User user2 = new User(21, "Mike", 70, true, "Back-End");
    User user3 = new User(34, "Anton", 80, true, "Front-End");
    User user4 = new User(25, "Andrey", 70, true, "Manager");
    User user5 = new User(19, "Vadym", 60, true, "Designer");
    User user6 = new User(19, "Zhenya", 58, false, "BlockchainDev");
    User user7 = new User(20, "Lina", 42, false, "Back-End");
    User user8 = new User(24, "Sasha", 57, true, "Back-End");
    User user9 = new User(19, "Artem", 40, false, "Front-End");
    User user10 = new User(20, "Vanya", 40, false, "Front-End");
    User user11 = new User(22, "Olya", 57, true, "AQA");
    User user12 = new User(23, "Nicka", 40, false, "AQA");
    User user13 = new User(26, "Yuliya", 80, true, "ManualQA");
    User user14 = new User(20, "Jack", 42, true, "ScrumMaster");
    User user15 = new User(19, "Nikita", 55, false, "Designer");

    List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10,
            user11, user12, user13, user14, user15);

    @Test
    public void checkFiltrationByAge() {
        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() == 19;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getAge()).isEqualTo(19);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByName() {
        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getName().equals("Jack");
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getName()).isEqualTo("Jack");
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByWeight() {
        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getWeight() == 70;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getWeight()).isEqualTo(70);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationBySex() {
        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.isSex();
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.isSex()).isTrue();
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationBySpeciality() {
        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getSpeciality().equals("AQA");
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getSpeciality()).isEqualTo("AQA");
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByAllParam() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() == 23 && user.getName().equals("Nicka") && user.getWeight() == 40
                        && !user.isSex() && user.getSpeciality().equals("AQA");
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            softAssertions.assertThat(user)
                    .satisfies(userParam -> {
                        assertThat(userParam.getAge()).isEqualTo(23);
                        assertThat(userParam.getName()).isEqualTo("Nicka");
                        assertThat(userParam.getWeight()).isEqualTo(40);
                        assertThat(userParam.isSex()).isTrue();
                        assertThat(userParam.getSpeciality()).isEqualTo("AQA");
                    });
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByGreaterParam() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() > 23;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getAge()).isGreaterThan(23);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByLessParam() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() < 23;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getAge()).isLessThan(23);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByGreaterOrEqualParam() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() >= 23;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getAge()).isGreaterThanOrEqualTo(23);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationByLessOrEqualParam() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<User> result = IUserCheck.getCondition(userList, new IUserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() <= 23;
            }
        });

        assertThat(result).isNotNull();
        for (User user : result) {
            assertThat(user.getAge()).isLessThanOrEqualTo(23);
            System.out.println(user);
        }
    }
}
