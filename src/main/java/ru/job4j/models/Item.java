package ru.job4j.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class Item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 08.05.2020
 */
public class Item {

    private int id;
    private String desc;
    private LocalDateTime created;
    private LocalDateTime done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDone() {
        return done;
    }

    public void setDone(LocalDateTime done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format("User: id %s, desc %s, crated %s, done %s",
                id,
                desc,
                created.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")),
                done.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }
}
