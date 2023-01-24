package kt.carpool.domain;

public enum Gender {
    MALE("MALE", "남"),
    FEMALE("FEMALE", "여");


    private String code;
    private String value;

    Gender(String code, String value) {
        this.code = code;
        this.value = value;
    }
    public String getCode() {
        return code;
    }
    public String getValue() {
        return value;
    }
}
