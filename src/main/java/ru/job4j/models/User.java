package ru.job4j.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class User.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 07.05.2020
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = {"id"})
public class User {

    private int id;
    private String name;
    private LocalDateTime expired;

    @Override
    public String toString() {
        return String.format("User: id %s, name %s, expired %s",
                id, name, expired.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }
}
