package Controller;

public class Account {
    private static Account account = new Account();

    private Account() {}

    public static Account getInstance() {
        return account;
    }
}
