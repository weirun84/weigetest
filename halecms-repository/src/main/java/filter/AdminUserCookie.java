package filter;

import lombok.Data;

@Data
public class AdminUserCookie {
    public String adminName;
    public String adminPwd;
    public String adminID;
    public String isSupperAdmin;
    public String adminPower;
    public String adminLogID;
    public String adminSalt;
}
