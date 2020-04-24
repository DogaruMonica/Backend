package iss.sirius.Repository;

import iss.sirius.Model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Modifying
    @Query(value = "INSERT into Teacher_Subject(teacherid, subjectid) VALUES (:teacherid, :subjectid)", nativeQuery = true)
    @Transactional
    void attachTeacherToSubject(@Param("teacherid") int teacherid, @Param("subjectid") int subjectid);
}
