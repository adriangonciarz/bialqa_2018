import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTest extends TestBase {
    @Test
    public void shouldCreateNewUser(){
        Faker faker = new Faker();
        User expected = new User(faker.name().firstName(), faker.name().lastName(), faker.random().nextInt(100), faker.random().nextLong(1000000));
        Integer createdUserId = RestAssured
                .given()
                    .body(expected)
                    .contentType(ContentType.JSON)
                .when()
                    .post("/users")
                    .jsonPath()
                    .getInt("id");

        expected.id = createdUserId;

        User actual = RestAssured.when().get("/users/"+createdUserId).as(User.class);

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
