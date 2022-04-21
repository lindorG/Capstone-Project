
package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class TeamFormBean {

    private Integer id;

    @NotEmpty(message="Name is required")
    private String name;

    @NotEmpty(message="Height is required")
    private Integer pokHeight;

    @NotEmpty(message="Name is required")
    private Integer pokWeight;
}