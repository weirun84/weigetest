package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static javax.print.attribute.Size2DSyntax.MM;

@Data
@Accessors(chain = true)
public class CtmonAdminuserDto  {
    private Integer userId;

    private String userName;

    private String email;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLogin;

    private String lastIp;

    private String actionList;

    private String navList;

    private String langType;

    private Integer agencyId;

    private String todolist;

    private String salt;

    private String phone;
}
