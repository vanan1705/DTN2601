package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.IDeparmentRepository;
import org.example.backend.repository.IPositonRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.repository.impl.DeparmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.dto.ImportError;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements IAccountService {
    IAccountRepository accountRepository= new AccountRepositoryImpl();
    IDeparmentRepository deparmentRepository = new DeparmentRepositoryImpl();
    IPositonRepository positonRepository = new PositionRepositoryImpl();
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        return accountRepository.create(newEmail, newUserName,newFullName,newDepartmentId,newPositionId);
    }

    @Override
    public boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        return accountRepository.update(id, updateEmail, updateFullName, updateUserName, updateDepartmentId, updatePositionId);
    }

    @Override
    public boolean delete(int id) {
        return accountRepository.delete(id);
    }

    @Override
    public boolean checkExistUserName(String userName, Integer id) {
        return accountRepository.checkExistUserName(userName,id);
    }

    @Override
    public boolean checkExistEmail(String email, Integer id) {
        return accountRepository.checkExistEmail(email,id);
    }

    @Override
    public List<Account> findByIdAndName(int searchId, String searchUserName) {
        return accountRepository.findByIdAndName(searchId, searchUserName);
    }

    @Override
    public String importAccountToCSV(String pathName) {
        // FileReader đọc file từ đường dẫn, đọc từng chữ cái
        //BufferedReader đọc theo từng dòng
        List<Account> accounts = new ArrayList<>();
        List<ImportError> importErrors = new ArrayList<>();
        boolean firstLine = true;
        boolean checkImport = false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String message = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {

            String line;
            while ((line = br.readLine()) != null) {
                List<String> errors = new ArrayList<>();
                // bỏ qua dòng đầu tiên vì đây là header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] fields = line.split(",");

                String userName = fields[0];
                String fullName = fields[1];
                String email = fields[2];
                String departmentName = fields[3];
                String positionName = fields[4];

                // validate dữ lieu
                if (Objects.isNull(userName) || userName.trim().isEmpty()) {
                    errors.add("User Name không được để trống");
                }
                // check xem user name có bị trùng hay ko
                if (accountRepository.checkExistUserName(userName, null)) {
                    errors.add("UserName đã tồn tại");
                }
                if (Objects.isNull(email)
                        || email.trim().isEmpty()
                        || !email.matches(regex)) {
                    errors.add("Email không hợp lệ");
                }
                if (accountRepository.checkExistEmail(email, null)) {
                    errors.add("Email đã tồn tại");
                }
                List<Department> departments = deparmentRepository.findByName(departmentName);

                if (departments.isEmpty()) {
                    errors.add("Phòng ban không tồn tại");
                }

                List<Position> positions = positonRepository.findByName(positionName);

                if (positions.isEmpty()) {
                    errors.add("Chức vụ không tồn tại");
                }

                if (errors.isEmpty()) {// nếu ko có lỗi thì thêm vào ds để lưu vào DB
                    Account acc = new Account(email,userName,fullName,departments.get(0),positions.get(0));
                    accounts.add(acc);
                } else {// có lỗi thì xuất ra
                    importErrors.add(new ImportError(line, String.join(" | ", errors)));
                }
            }

            String pathError = "D:\\output_account_error.csv";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathError))) {
                bw.write("userName,message_error");
                bw.newLine();
                for (ImportError error : importErrors) {
                    bw.write(error.getLine() + "," + error.getMessage());
                    bw.newLine();
                }
            } catch (Exception e) {
               e.printStackTrace();
            }

            // insert vào DB
            if (!accounts.isEmpty()) {
                checkImport = accountRepository.createAccounts(accounts);
            }
        } catch (Exception e) {
//            message = "Import lỗi " + e.getMessage();
        }

        return checkImport ? "Import thành công" : "Import lỗi, đã xuất file ra D:\\output_account_error.csv";
    }
}
