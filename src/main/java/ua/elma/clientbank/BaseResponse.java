package ua.elma.clientbank;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BaseResponse {
    private String status;
    private Integer code;

    public BaseResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

}
