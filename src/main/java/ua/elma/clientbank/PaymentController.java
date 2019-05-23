package ua.elma.clientbank;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class PaymentController {
    private final String sharedKey = "SHARED_KEY";

    private  String SUCCESS_STATUS = "success";


    @GetMapping("/all")
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 1);
    }

}
