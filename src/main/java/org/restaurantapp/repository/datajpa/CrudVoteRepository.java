package org.restaurantapp.repository.datajpa;

import org.restaurantapp.model.Vote;
import org.restaurantapp.to.VoteTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date =:date")
    Vote get(@Param("userId") int userId, @Param("date") LocalDate date);

    @Query("SELECT new org.restaurantapp.to.VoteTo(r.id,r.name,count (v)) " +
            "FROM Restaurant r " +
            "LEFT JOIN r.votes v " +
            "WHERE v.date =:date " +
            "GROUP BY r.id, r.name ")
    List<VoteTo> getNumberOfVotesForRestaurantsByDate(@Param("date") LocalDate date);

    @Query("SELECT new org.restaurantapp.to.VoteTo(r.id,r.name,count (v)) " +
            "FROM Restaurant r " +
            "LEFT JOIN r.votes v " +
            "WHERE v.date =:date " +
            "GROUP BY r.id, r.name " +
            "ORDER BY count (v) DESC")
    List<VoteTo> getResultByDate(@Param("date") LocalDate date);
}
