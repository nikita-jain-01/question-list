package ltr.org.questionlist.exception;

public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public DataNotFoundException(String msg) {
        this.msg = msg;
    }

    public DataNotFoundException() {
    }

    public static DataNotFoundExceptionBuilder builder() {
        return new DataNotFoundExceptionBuilder();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public static class DataNotFoundExceptionBuilder {
        private String msg;

        DataNotFoundExceptionBuilder() {
        }

        public DataNotFoundExceptionBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public DataNotFoundException build() {
            return new DataNotFoundException(this.msg);
        }

        public String toString() {
            return "DataNotFoundException.DataNotFoundExceptionBuilder(msg=" + this.msg + ")";
        }
    }
}
