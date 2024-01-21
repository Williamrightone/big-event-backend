package cc.william.bigevent.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private String nickname;

    @Email
    private String email;

    private String userPic;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    
}
