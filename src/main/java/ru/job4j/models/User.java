package ru.job4j.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class User.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 07.05.2020
 */
public class User {

    private int id;
    private String name;
    private LocalDateTime expired;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpired() {
        return expired;
    }

    public void setExpired(LocalDateTime expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return String.format("User: id %s, name %s, expired %s",
                id, name, expired.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }
}
