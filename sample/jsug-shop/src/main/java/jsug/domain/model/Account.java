package jsug.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

// using "lombok" see https://projectlombok.org/
// and http://qiita.com/opengl-8080/items/671ffd4bf84fe5e32557
@Data
@Builder
public class Account implements Serializable {
    private String email;
    private String password;
    private String name;
    private LocalDate birthDay;
    private String zip;
    private String address;
}
