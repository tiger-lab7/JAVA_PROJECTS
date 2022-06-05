public class TestObject {
    public int id;

    public TestObject(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
        //return 42;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObject to)) return false;
        return id == to.id;
    }
    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                '}';
    }
}
