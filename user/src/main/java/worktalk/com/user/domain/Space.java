package worktalk.com.user.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Space implements Serializable{
	
	private Long space_num;
	private String host;
	private String space_name;
	private String space_detail;
	private String postcode;
	private String address;
	private String detail_address;
	private Timestamp breaktime;
	private String reg_code;
	private int space_type;
	
}
