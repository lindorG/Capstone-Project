package lindor.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import lindor.casestudy.validation.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    @Pattern(regexp = "^[\\w]{3,15}$", message = "Your display name must be between 3 and 15 characters long and cannot contain special characters")
    @NotBlank(message = "Display Name is required")
    private String displayName;

    @EmailUnique(message = "Email already exists in database")
    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "You must enter a valid email address")
    private String email;

    @Length(min = 6, max = 16, message="Password must be between 3 and 15 characters long")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "You must confirm your password")
    private String confirmPassword;

    @NotBlank(message = "Region is required")
    private String region;

    @AssertTrue(message = "Checkbox is required")
    private boolean checkbox;

}
