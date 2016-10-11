package utils;

/**
 * Created by Adam Piech on 2016-10-11.
 */
public class Info {

    private String fileName;
    private String successString;
    private String failureString;
    private boolean isSuccess;

    public Info(String fileName, String successString, String failureString, boolean isSuccess) {
        this.fileName = fileName;
        this.successString = successString;
        this.failureString = failureString;
        this.isSuccess = isSuccess;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuccessString() {
        return successString;
    }

    public void setSuccessString(String successString) {
        this.successString = successString;
    }

    public String getFailureString() {
        return failureString;
    }

    public void setFailureString(String failureString) {
        this.failureString = failureString;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
