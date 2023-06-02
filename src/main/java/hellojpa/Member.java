package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity 꼭 넣어야지 JPA가 인식함
@Entity
//@Table(name = "USERS") 이렇게하면 USERS 테이블에 넣어짐
public class Member {

    //    JPA에게 프라이머리키를 알려줘야함
//    또한 ID와 비슷한 어노테이션이 많으면 javax.persistence를 선택할것
    @Id
    private Long id;
    private String name;

    public Member(long id, String name) {
        this.id=id;
        this.name=name;

    }

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
