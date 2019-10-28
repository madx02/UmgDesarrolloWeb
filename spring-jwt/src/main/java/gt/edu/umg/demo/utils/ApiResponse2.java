package gt.edu.umg.demo.utils;

import java.util.List;

public class ApiResponse2 {

    private String status;
    private String message;
    private List<?> data;
    private String singleValue;


    public ApiResponse2(String status, String message, List<?> data) {
        this.status = status;
        this.message = message;
        this.data = data;
	}

    public ApiResponse2(){}

	public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return this.data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getSingleValue() {
        return this.singleValue;
    }

    public void setSingleValue(String singleValue) {
        this.singleValue = singleValue;
    }


}