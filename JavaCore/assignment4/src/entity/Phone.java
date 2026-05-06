package entity;

public abstract class Phone {

    protected Contact[] contacts = new Contact[100];

    protected int size = 0;

    public abstract void insertContact(String name, String phone);

    public abstract void removeContact(String name);

    public abstract void updateContact(String name, String newPhone);

    public abstract void searchContact(String name);
}
