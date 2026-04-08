package com.example.shop.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 개별 회원 정보 상세 조회
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    // 모든 회원 리스트
    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public Member findByLoginId(String loginId){
        List<Member> result = em.createQuery(
                "SELECT m FROM Member m WHERE m.loginId = :loginId", Member.class
        ).setParameter("loginId", loginId).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    // 회원 등록
    public void save(Member member){
        em.persist(member);
    }

    //회원 삭제
    public void deleteById(Long id){
        Member member = em.find(Member.class, id);
        em.remove(member);
    }
}


