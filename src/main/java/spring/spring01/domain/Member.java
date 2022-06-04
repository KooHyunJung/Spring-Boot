package spring.spring01.domain;

public class Member {

    private long id; // 시스템이 정하는 임의의 값
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
