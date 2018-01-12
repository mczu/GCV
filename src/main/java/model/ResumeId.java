package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@EqualsAndHashCode(of = "value")
@Setter
@Getter
public class ResumeId {
    private String value;

    public ResumeId() {
        this.value = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public ResumeId(String value) {
        this.value = value;
    }
}
