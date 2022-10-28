package worktalk.com.user.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
@EqualsAndHashCode
public class Review implements Serializable{
	private Long rv_num;
	private Long r_num;
	private String review;
	private double grade;
	private Timestamp rv_date;
	private String img_name;
	private List<MultipartFile> multipartFile;	
	
}
