package springdatajpa.ErrorResponse;

import lombok.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorEntity {
    private String message;
    private Map<String, String> errors = new HashMap<>();
}
