package Controller;

public class RegisterAndLogin {
    private static RegisterAndLogin registerAndLogin = new RegisterAndLogin();

    private RegisterAndLogin() {}

    public static RegisterAndLogin getInstance() {
        return registerAndLogin;
    }
}
