package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ResumeId {
    private String value;

    public ResumeId() {
        this.value = UUID.randomUUID().toString().replaceAll("-", "");
    }
}
