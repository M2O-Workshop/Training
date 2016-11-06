package jsug.app.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jsug.domain.model.Cart;
import jsug.domain.model.Order;
import jsug.domain.service.order.OrderService;
import jsug.domain.service.userdetails.ShopUserDetails;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    Cart cart;

    // 注文確認画面処理
    // @AuthenticationPrincipalアノテーションでログイン中の認証ユーザー情報を取得できます。
    // accountプロパティに、ユーザーの住所などが含まれており、Modelに渡して画面で表示します。

    @RequestMapping(method = RequestMethod.GET, params = "confirm")
    String confirm(@AuthenticationPrincipal ShopUserDetails userDetails /* (1) */, Model model) {
        model.addAttribute("orderLines", cart.getOrderLines());
        if (cart.isEmpty()) {
            model.addAttribute("error", "買い物カゴが空です");
            return "cart/viewCart";
        }
        // 注文確認画面で確認したカートの状態と実際に注文した際の状態に違いがないように署名データを埋め込みます。
        model.addAttribute("account", userDetails.getAccount());
        model.addAttribute("signature", orderService.calcSignature(cart)); // (2)
        return "order/confirm";
    }

    // 注文処理
    @RequestMapping(method = RequestMethod.POST)
    String order(@AuthenticationPrincipal ShopUserDetails userDetails,
                 @RequestParam String signature, RedirectAttributes attributes) {
        Order order = orderService.purchase(userDetails.getAccount(), cart, signature);
        attributes.addFlashAttribute(order);
        return "redirect:/order?finish";
    }

    // 注文完了画面表示処理
    @RequestMapping(method = RequestMethod.GET, params = "finish")
    String finish() {
        return "order/finish";
    }
}