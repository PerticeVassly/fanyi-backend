package org.fanyi.fanyibackend.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fanyi.fanyibackend.po.*;
import org.fanyi.fanyibackend.vo.*;
import javax.persistence.*;

public class UserVO {

    private String name;

    private String phone;

    public UserVO(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }
}