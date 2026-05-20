package org.example.backend.service.impl;

import org.example.backend.repository.IDeparmentRepository;
import org.example.backend.repository.impl.DeparmentRepositoryImpl;
import org.example.backend.service.IDeparmentService;
import org.example.dto.ImportError;
import org.example.entity.Department;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeparmentServiceImpl implements IDeparmentService {
    IDeparmentRepository deparmentRepository = new DeparmentRepositoryImpl();
    @Override
    public List<Department> findAll() {

        return deparmentRepository.findAll();
    }

    @Override
    public boolean create(String newName) {
        return deparmentRepository.create(newName);
    }

    @Override
    public boolean update(int id, String updateName) {
        return deparmentRepository.update(id, updateName);
    }

    @Override
    public boolean delete(int id) {
        return deparmentRepository.delete(id);
    }

    @Override
    public List<Department> findByIdAndName(int searchId, String searchName) {
        return deparmentRepository.findByIdAndName(searchId, searchName);
    }

    @Override
    public List<Department> getDeparmentWithMaxEmployee() {
        deparmentRepository.getDeparmentWithMaxEmployee();
        return null;
    }

    @Override
    public List<Department> getDeparmentWithMinEmployee() {
        deparmentRepository.getDeparmentWithMinEmployee();
        return null;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        return deparmentRepository.checkExistName(name, id);
    }

    @Override
    public String importDepartmentToCSV(String pathName) {
        // FileReader đọc file từ đường dẫn, đọc từng chữ cái
        //BufferedReader đọc theo từng dòng
        List<Department> departments = new ArrayList<>();
        List<ImportError> importErrors = new ArrayList<>();
        boolean firstLine = true;
        boolean checkImport = false;
        String message = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {

            String line;
            while ((line = br.readLine()) != null) {
                List<String> errors = new ArrayList<>();
                // bor qua dòng đầu tien vi day là header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] fields = line.split(",");
                String departmentName = fields[0];
                // validate dữ lieu
                if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
                    // Tên phòng ban không được để trống
                    errors.add("Tên phòng ban không được để trống");
                }
                // check xem tên phòng ban có bị trùng hay ko
                if (deparmentRepository.checkExistName(departmentName, null)) {
                    // Tên phòng ban đã tồn tại
                    errors.add("Tên phòng ban đã tồn tại");
                }
                if (errors.isEmpty()) {// nếu ko có lỗi thì thêm vào ds để lưu vào DB
                    Department dep = new Department(departmentName);
                    departments.add(dep);
                } else {// có lỗi thì xuất ra
                    importErrors.add(new ImportError(line, String.join(" | ", errors)));
                }
            }
            // xuất ra file lỗi list  importErrors  ra file csv  D:\output_department_error.csv
            String pathError = "D:\\output_department_error.csv";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathError))) {
                bw.write("depatment_name,message_error");
                bw.newLine();
                for (ImportError error : importErrors) {
                    bw.write(error.getLine() + "," + error.getMessage());
                    bw.newLine();
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }


            // insert vào DB
            if (!departments.isEmpty()) {
                checkImport = deparmentRepository.createDepartments(departments);
            }
        } catch (Exception e) {
//            message = "Import lỗi " + e.getMessage();
        }

        return checkImport ? "Import thành công" : "Import lỗi, đã xuất file ra D:\\output_department_error.csv";
    }


}
