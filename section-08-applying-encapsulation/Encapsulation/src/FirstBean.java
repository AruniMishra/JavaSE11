public class FirstBean {

    private String name;
    private int age;
    private boolean first;

    private int myOwnVariable;

    public FirstBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
    }

    public int getFieldAlias() {
        return myOwnVariable;
    }

    public void setFieldAlias(int fieldAlias) {
        this.myOwnVariable = fieldAlias;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}