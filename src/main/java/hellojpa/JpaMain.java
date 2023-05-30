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
            //생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB"); //---d여기까지는 비영속 상태

//            em.persist(member); //----여기서부터 영속상태

//            //찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            //            찾기
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //영속성 및 1차캐시 검증-1
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            System.out.println("+++BEFORE+++");
//            em.persist(member);
//            System.out.println("+++AFTER+++");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id= " + findMember.getId());
//            System.out.println("findMember.name= " + findMember.getName());

            //영속성 1차캐시검증-2 (쿼리 조회후 이후부터는 캐시조회테스트) 및 동일성 보장
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember1 == findMember2));


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
