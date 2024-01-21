package cc.william.bigevent.pojo.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static Result success() {
        return new Result(200, "success", null);
    }

    public static Result error(String message) {
        return new Result(500, message, null);
    }
    
}
