package jsug.app.account;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import jsug.domain.validation.Confirm;
import jsug.domain.validation.UnusedEmail;
import lombok.Data;

@Data
@Confirm(field = "password") // (1)
  // @Confirmアノテーションを使って、passwordフィールドとconfirmPasswordフィールドの値が等しいことを制約にします。
  // このアノテーションはカスタムルールです。バリデータの実装はjsug.domain.validation.ConfirmValidatorクラスを確認してください。
public class AccountForm implements Serializable {

    // @Emailアノテーションを使って、Email形式であることを制約にします。
    @Email // (2)
    @Size(min = 1, max = 100)
    @NotNull
    @UnusedEmail // (3)
    // @UnusedEmailアノテーションを使って、Emailアドレスが使用されていないことを制約にします。
    // このアノテーションはカスタムルールです。バリデータの実装はjsug.domain.validation.UnusedEmailValidatorクラスを確認してください。
    private String email;

    @Size(min = 6)
    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @Size(min = 1, max = 40)
    @NotNull
    private String name;
    //@DateTimeFormatアノテーションを使って、入力値の日付文字列をLocalDate型に変換する際のフォーマットを指定します。
    // このアノテーションはバリデーション用ではありません。

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // (4)
    @NotNull
    private LocalDate birthDay;

    @NotNull
    @Pattern(regexp = "[0-9]{7}")
    private String zip;

    @Size(min = 1, max = 100)
    @NotNull
    private String address;
}
