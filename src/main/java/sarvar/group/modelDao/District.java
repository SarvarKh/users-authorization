package sarvar.group.modelDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private Integer id;
    private String name;
    private Integer regionId;
}
