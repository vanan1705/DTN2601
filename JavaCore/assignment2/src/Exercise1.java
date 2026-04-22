public class Exercise1 {
    //Question 1:
    //Kiểm tra account thứ 2
    //Nếu không có phòng ban (tức là department == null) thì sẽ in ra text &quot;Nhân viên này chưa
    //có phòng ban
    //Nếu không thì sẽ in ra text &quot;Phòng ban của nhân viên này là …
    public static void question1(Account account){
        if (account.department == null ){
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là "+account.department.departmentName );
        }
    }

    //Question 2:
    //Kiểm tra account thứ 2
    //Nếu không có group thì sẽ in ra text &quot;Nhân viên này chưa có group&quot;
    //Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text &quot;Group của nhân viên này là Java
    //Fresher, C# Fresher
    //Nếu có mặt trong 3 Group thì sẽ in ra text &quot;Nhân viên này là người quan trọng, tham gia
    //nhiều group
    //Nếu có mặt trong 4 group trở lên thì sẽ in ra text &quot;Nhân viên này là người hóng chuyện,
    //tham gia tất cả các group
    public static void question2(Account account, Group[] groups){
        int joinedGroupCount = 0;
        String joinedGroupName="";

        if (groups.length<1){
            System.out.println("Nhóm bị trống");
        } else {
            for (Group group: groups){
                if (group.account == account){
                    joinedGroupCount +=1;
                    joinedGroupName = joinedGroupName + group.groupName + ", ";
                }
            }
            if (joinedGroupCount==0){
                System.out.println("Nhân viên này chưa có group");
            } else if (joinedGroupCount <= 2) {
                System.out.println("Group của nhân viên này là: "+joinedGroupName);
            } else if (joinedGroupCount == 3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            } else {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        }
    }

    //Question 3:
    //Sử dụng toán tử ternary để làm Question 1
    public static void question3(Account account){
        System.out.println((account.department == null)?"Nhân viên này chưa có phòng ban":("Phòng ban của nhân viên này là "+account.department.departmentName ));
    }

    //Question 4:
    //Sử dụng toán tử ternary để làm yêu cầu sau:
    //Kiểm tra Position của account thứ 1
    //Nếu Position = Dev thì in ra text &quot;Đây là Developer&quot;
    //Nếu không phải thì in ra text &quot;Người này không phải là Developer&quot;
    public static void question4(Account account){
        System.out.println((account.position.positionName == PositionEnum.DEV)?"Đây là Developer":"Người này không phải là Developer");
    }

    //Question 5:
    //Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
    //Nếu số lượng account = 1 thì in ra &quot;Nhóm có một thành viên&quot;
    //Nếu số lượng account = 2 thì in ra &quot;Nhóm có hai thành viên&quot;
    //Nếu số lượng account = 3 thì in ra &quot;Nhóm có ba thành viên&quot;
    //Còn lại in ra &quot;Nhóm có nhiều thành viên&quot;

    public static void question5(Group group, GroupAccount[] groupAccounts){
        int joinedGroupCount = 0;

        if (groupAccounts.length<1){
            System.out.println("Nhóm bị trống");
        } else {
            for (GroupAccount groupAccount: groupAccounts){
                if (groupAccount.group == group){
                    joinedGroupCount +=1;
                }
            }
            switch (joinedGroupCount){
                case 1:
                    System.out.println("Nhóm có một thành viên");
                    break;
                case 2:
                    System.out.println("Nhóm có hai thành viên");
                    break;
                case 3:
                    System.out.println("Nhóm có ba thành viên");
                    break;
                default:
                    System.out.println("Nhóm có nhiều thành viên");
            }
        }
    }

    //Question 6:
    //Sử dụng switch case để làm lại Question 2
    public static void question6(Account account, Group[] groups){
        int joinedGroupCount = 0;
        String joinedGroupName="";

        if (groups.length<1){
            System.out.println("Nhóm bị trống");
        } else {
            for (Group group: groups){
                if (group.account == account){
                    joinedGroupCount +=1;
                    joinedGroupName = joinedGroupName + group.groupName + ", ";
                }
            }
            if (joinedGroupCount==0){
                System.out.println("Nhân viên này chưa có group");
            } else if (joinedGroupCount <= 2) {
                System.out.println("Group của nhân viên này là: "+joinedGroupName);
            } else if (joinedGroupCount == 3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            } else {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }

            switch (joinedGroupCount){
                case 0:
                    System.out.println("Nhân viên này chưa có group");
                    break;
                case 1:
                    System.out.println("Group của nhân viên này là: "+joinedGroupName);
                    break;
                case 2:
                    System.out.println("Group của nhân viên này là: "+joinedGroupName);
                    break;
                case 3:
                    System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                    break;
                default:
                    System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        }
    }

    //Question 7:
    //Sử dụng switch case để làm lại Question 4
    public static void question7(Account account){
        switch (account.position.positionName){
            case DEV:
                System.out.println("PositionEnum.DEV");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }

    //Question 8:
    //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
    public static void question8(Account[] accounts){
        for(Account account:accounts){
            System.out.println("Email: "+account.email+", Full Name: "+account.fullName+", department: "+account.department.departmentName);
        }
    }

    //Question 9:
    //In ra thông tin các phòng ban bao gồm: id và name
    public static void question9(Department[] departments){
        for(Department department:departments){
            System.out.println("Department ID: "+department.departmentID+", department name: "+department.departmentName);
        }
    }

    //Question 10:
    //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
    //họ theo định dạng như sau:
    //Thông tin account thứ 1 là:
    //Email: NguyenVanA@gmail.com
    //Full name: Nguyễn Văn A
    //Phòng ban: Sale
    //Thông tin account thứ 2 là:
    //Email: NguyenVanB@gmail.com
    //Full name: Nguyễn Văn B
    //Phòng ban: Marketting
    public static void question10(Account[] accounts){
        for (int i=0; i<accounts.length;i++){
            System.out.println("Thông tin account thứ " + i + " là: ");
            System.out.println("Email: "+accounts[i].email);
            System.out.println("Full name: "+accounts[i].fullName);
            System.out.println("Phòng ban: "+accounts[i].department.departmentName);
        }
    }

    //Question 11:
    //In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
    //Thông tin department thứ 1 là:
    //Id: 1
    //Name: Sale
    //Thông tin department thứ 2 là:
    //Id: 2
    //Name: Marketing

    public static void question11(Department[] departments){
        for (int i=0; i<departments.length;i++){
            System.out.println("Thông tin department thứ " + i + " là: ");
            System.out.println("Id: "+departments[i].departmentID);
            System.out.println("Name: "+departments[i].departmentName);
        }
    }

    //Question 12:
    //Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
    public static void question12(Department[] departments){
        for (int i=0; i<2;i++){
            System.out.println("Thông tin department thứ " + i + " là: ");
            System.out.println("Id: "+departments[i].departmentID);
            System.out.println("Name: "+departments[i].departmentName);
        }
    }

    //Question 13:
    //In ra thông tin tất cả các account ngoại trừ account thứ 2
    public static void question13(Account[] accounts){
        for (int i=0; i<accounts.length;i++){
            if (i == 1){
                continue;
            }else {
                System.out.println("Thông tin account thứ " + i + " là: ");
                System.out.println("Email: " + accounts[i].email);
                System.out.println("Full name: " + accounts[i].fullName);
                System.out.println("Phòng ban: " + accounts[i].department.departmentName);
            }
        }
    }

    //Question 14:
    //In ra thông tin tất cả các account có id < 4
    public static void question14(Account[] accounts){
        for (int i=0; i<accounts.length;i++){
            if (accounts[i].accountID< 4){
                System.out.println("Thông tin account thứ " + i + " là: ");
                System.out.println("Email: " + accounts[i].email);
                System.out.println("Full name: " + accounts[i].fullName);
                System.out.println("Phòng ban: " + accounts[i].department.departmentName);
            }
        }
    }

    //Question 15:
    //In ra các số chẵn nhỏ hơn hoặc bằng 20
    public static void question15(){
        for (int i=0; i<=20;i=i+2){
            System.out.println(i);
        }
    }

    //Question 16:
    //Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
    //lệnh break, continue

    //Question 17:
    //Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
    //lệnh break, continue
}
