package errors_handlers;


import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private int status;
    private Long timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorResponse() {
    }
}
