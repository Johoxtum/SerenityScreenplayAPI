package models.headers;

public enum HeadersValueModel {

    CONTENT_TYPE("content-type","application/json"),
    COOKIE("Cookie","token=abc123");

    public String getHeader() {
        return header;
    }

    public String getValue() {
        return value;
    }

    private final String header;
    private final String value;
    private HeadersValueModel(String header, String value) {
        this.header = header;
        this.value = value;
    }
}
