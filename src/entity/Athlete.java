package entity;

public class Athlete extends User {
    int personalId;

    public int getPersonalId() {
        return personalId;
    }

    public Athlete(String name, String email, int personalId) {
        super(name, email);
        this.personalId = personalId;
    }
}
