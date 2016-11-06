package jsug.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//ログインフォーム画面表示処理
@Controller
public class LoginController {
    @RequestMapping("loginForm")
    String loginForm() {
        return "login/loginForm";
        ///loginFormにアクセスすると、classpath:/templates/login/loginForm.html がレンダリングされます。
    }
}