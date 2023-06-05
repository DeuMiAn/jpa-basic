package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team= new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam= findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());
            tx.commit();
//에러없이 완료시 커밋
        } catch (Exception e) {
            //에러발생시 롤백
            tx.rollback();

        } finally {
            //에러나든 완료되든 일단닫아
            em.close();
        }


        //code
        emf.close();
    }
}
