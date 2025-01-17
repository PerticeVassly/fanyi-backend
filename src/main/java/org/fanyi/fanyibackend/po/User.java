package org.fanyi.fanyibackend.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fanyi.fanyibackend.po.*;
import org.fanyi.fanyibackend.vo.*;
import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    public User(String phone, String pwd) {
        this.pwd = pwd;
        this.phone = phone;
    }

    public UserVO toVO() {
        return new UserVO(name, phone, pwd);
    }
}
