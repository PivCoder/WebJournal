package model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Авторизация")
public class Authorization extends AbstractObject{

    @Column(name = "Логин")
    private String login;

    @Column(name = "Пароль")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Authorization(String login, String password, User user) {
        this.login = login;
        this.password = password;
        this.user = user;
    }
}
