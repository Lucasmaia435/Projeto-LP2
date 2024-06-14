package entity;

public class Entity {
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Entity) obj).getId();
    }
}
