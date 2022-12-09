package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingsWithDetailsDto {
	private String companyName;
	private String jobTitleName;
	private String cityName;
	private LocalDateTime publicationDate;
	private LocalDateTime applicationDeadline;
	private int availablePosition;
	private String jobDescription;
	

}
