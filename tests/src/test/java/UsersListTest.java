import io.restassured.RestAssured;
import models.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersListTest extends TestBase{
    @Test
    public void shouldVerifySingleUserInTheList(){
        User expected = selectRandomUser();
        User actual = getUserWithIdFromApi(expected.id);
        System.out.printf("%s, %s, %s, %s\n", expected.firstName, expected.lastName, expected.age, expected.phone);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void shouldVerifyAllUsersInTheDatabase(){
        List<User> expectedList = ALL_USERS;
        List<User> actualList = getAllUsersInApi();
        assertUserListsHaveSameElements(actualList, expectedList);
    }

    private User selectRandomUser(){
        int len = ALL_USERS.size();
        return ALL_USERS.get(new Random().nextInt(len));
    }

    private User getUserWithIdFromApi(int id){
        return RestAssured.when().get("/users/"+id).as(User.class);
    }

    private List<User> getAllUsersInApi(){
        return new ArrayList<>(RestAssured.when().get("/users").body().jsonPath().getList("", User.class));
    }

    private void assertUserListsHaveSameElements(List<User> actual, List<User> expected){
        expected.sort(Comparator.comparing(User::getId));
        actual.sort(Comparator.comparing(User::getId));
        for (int i = 0; i < expected.size(); i++) {
            System.out.println("Comparing users with ID: " + expected.get(i).getId());
            System.out.printf("%s, %s, %s, %s\n", expected.get(i).firstName, expected.get(i).lastName, expected.get(i).age, expected.get(i).phone);
            assertThat(actual.get(i)).isEqualToComparingFieldByField(expected.get(i));
        }
    }
}
