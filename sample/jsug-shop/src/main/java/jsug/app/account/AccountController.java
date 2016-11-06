package jsug.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jsug.domain.model.Account;
import jsug.domain.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired // (1) AccountServiceをインジェクションして、主処理を委譲します。
    AccountService accountService;

    // アカウント作成フォーム画面表示処理
    @ModelAttribute // (2) 画面で使うフォームに対応したオブジェクトを初期化して、Modelに追加します。
    AccountForm setupForm() {
        return new AccountForm();
    }

    // (3) アカウント作成フォーム画面表示処理のためのリクエストマッピングを記述します。
    @RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
    String createForm() {
        return "account/createForm";
    }

    // アカウント作成処理
    // (4) アカウント作成処理のためのリクエストマッピングを記述します。
    @RequestMapping(value = "create", method = RequestMethod.POST)
    // (5) 入力されたフォームをバリデーションします。結果は隣の引数のBindingResultに格納されます。
    String create(@Validated AccountForm form /* (5) */, BindingResult bindingResult,
                  RedirectAttributes attributes) {

        // (6) バリデーションエラーがある場合は、フォーム画面に戻ります。
        if (bindingResult.hasErrors()) {
            return "account/createForm";
        }

        // (7) フォームオブジェクトからドメインオブジェクトを作成します。
        Account account = Account.builder()
                .name(form.getName())
                .email(form.getEmail())
                .birthDay(form.getBirthDay())
                .zip(form.getZip())
                .address(form.getAddress())
                .build();
        // (8) AccountServiceのアカウント登録処理を実行します。
        accountService.register(account, form.getPassword());

        // (9) 作成されたAccountオブジェクトをリダイレクト先で参照できるように
        //     フラッシュスコープに設定します。
        attributes.addFlashAttribute(account);
        // (10) アカウント作成完了画面へリダイレクトします。Post-Redirect-Get (PRG)パターンです。
        return "redirect:/account/create?finish";
    }

    // アカウント作成完了画面表示処理
    // (11) アカウント作成完了画面表示処理のためのリクエストマッピングを記述します。
    @RequestMapping(value = "create", params = "finish", method = RequestMethod.GET)
    String createFinish() {
        return "account/createFinish";
    }
}