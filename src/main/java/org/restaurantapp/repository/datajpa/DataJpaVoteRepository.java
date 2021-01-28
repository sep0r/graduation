package org.restaurantapp.repository.datajpa;


import org.restaurantapp.model.Vote;
import org.restaurantapp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Repository
public class DataJpaVoteRepository implements VoteRepository {

}
