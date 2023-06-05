package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member();
            member1.setUsername("A");
            Member member2 = new Member();
            member2.setUsername("B");
            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("========================");

            //DB seq1
            //DB seq51
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("========================");

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
