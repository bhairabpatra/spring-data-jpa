package springdatajpa.ErrorResponse;

import lombok.*;
import springdatajpa.dto.UserDto;
import springdatajpa.model.User;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessResponse {
    private String message;
    private Map<String, String> success = new HashMap<>();
    private UserDto user;
}
