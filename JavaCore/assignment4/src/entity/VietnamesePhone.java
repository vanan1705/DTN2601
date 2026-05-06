package entity;

public class VietnamesePhone extends Phone{
    @Override
    public void insertContact(String name, String phone) {
        for (int i = 0; i < size; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                if (!contacts[i].getPhone().contains(phone)) {

                    contacts[i].setPhone(
                            contacts[i].getPhone() + " : " + phone
                    );
                }

                return;
            }
        }

        contacts[size] = new Contact(name, phone);
        size++;

        System.out.println("Them contact thanh cong!");
    }

    @Override
    public void removeContact(String name) {
        for (int i = 0; i < size; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                // Dich mang sang trai
                for (int j = i; j < size - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                contacts[size - 1] = null;
                size--;

                System.out.println("Xoa thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay contact!");
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (int i = 0; i < size; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                contacts[i].setPhone(newPhone);

                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay contact!");
    }

    @Override
    public void searchContact(String name) {
        for (int i = 0; i < size; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                System.out.println(contacts[i]);
                return;
            }
        }

        System.out.println("Khong tim thay contact!");
    }

    public void displayContacts() {

        for (int i = 0; i < size; i++) {
            System.out.println(contacts[i]);
        }
    }

}
