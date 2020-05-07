package ru.job4j.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class Item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 08.05.2020
 */
@Getter
@Setter
@Entity
@Table(name = "items")
@EqualsAndHashCode(of = {"id"})
public class Item {

    private int id;
    private String desc;
    private LocalDateTime created;
    private LocalDateTime done;

    @Override
    public String toString() {
        return String.format("User: id %s, desc %s, crated %s, done %s",
                id,
                desc,
                created.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")),
                done.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }
}
