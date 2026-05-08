package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPositon;

public class main {
    public static void main(String[] args) {
        QLAccount.printAccounts();
        QLDepartment.printDepartments();
        QLPositon.printPositions();
    }
}
