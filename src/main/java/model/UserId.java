package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@EqualsAndHashCode(of = "value")
@Setter
@Getter
public class UserId {
    private String value;

    public UserId() {
        this.value = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public UserId(String value) {
        this.value = value;
    }
}
