package exercises.a_b_database;

public class Person implements Human{

    private Long id;
    private String username;

    public Person(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
}