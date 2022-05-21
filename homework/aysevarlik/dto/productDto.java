package aysevarlik.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class productDto {
    private long ProductId;
    private String ProductName;
    private String Category;
    private long ModelYear;
    private long ModelId;
    private Date CreatedDate;
}
