package ltr.org.questionlist.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse implements Serializable {
    private Integer status;
    private String message;
    private Object data;

    public static ServiceResponseBuilder builder() {
        return new ServiceResponseBuilder();
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ServiceResponse)) {
            return false;
        } else {
            ServiceResponse other = (ServiceResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                label55: {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if (this$data == null) {
                        if (other$data == null) {
                            break label55;
                        }
                    } else if (this$data.equals(other$data)) {
                        break label55;
                    }

                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ServiceResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        Integer var10000 = this.getStatus();
        return "ServiceResponse(status=" + var10000 + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }

    public ServiceResponse(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ServiceResponse() {
    }

    public static class ServiceResponseBuilder {
        private Integer status;
        private String message;
        private LocalDateTime timeStamp;
        private Object data;
        private String traceId;
        private Integer tenantId;

        ServiceResponseBuilder() {
        }

        public ServiceResponseBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ServiceResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ServiceResponseBuilder timeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public ServiceResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public ServiceResponseBuilder traceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public ServiceResponseBuilder tenantId(Integer tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ServiceResponse build() {
            return new ServiceResponse(this.status, this.message, this.data);
        }

        public String toString() {
            return "ServiceResponse.ServiceResponseBuilder(status=" + this.status + ", message=" + this.message + ", timeStamp=" + this.timeStamp + ", data=" + this.data + ", traceId=" + this.traceId + ", tenantId=" + this.tenantId + ")";
        }
    }
}