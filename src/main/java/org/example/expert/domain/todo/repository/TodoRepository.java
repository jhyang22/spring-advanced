package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * 과제 2 N+1 문제
     * Todo의 User가 Lazy 로딩으로 설정되어있기 때문에 Todo를 조회할 때마다 User가 조회되며 N+1문제가 발생한다
     * 기존의 코드는 이를 FETCH JOIN을 사용하여 즉시로딩되도록 설정함으로써 해결하고 있었다
     * 하지만 FETCH JOIN은 @OneToMany 연관관계에서는 페이징이 안되는 단점이 있다
     * 따라서 @EntityGraph를 사용하는 것으로 수정하였다
     * @param pageable
     * @return
     */
    @EntityGraph(attributePaths = "user")
//    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN FETCH t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

    int countById(Long todoId);
}
