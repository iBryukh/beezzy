package beezzy.domain.request.user;

/**
 * Created by Polomani on 08.04.2016.
 */
public class UserAuth {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
