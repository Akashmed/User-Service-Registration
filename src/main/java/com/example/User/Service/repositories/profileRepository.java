package com.example.User.Service.repositories;

import com.example.User.Service.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface profileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths = "user")
    @Query("select pf from Profile pf where pf.loyaltyPoints > :points order by pf.user.email")
    List<Profile> findProfilesByLoyaltyPointsOrderByEmail(@Param("points") int points);

    @Procedure("findProfiles")
    List<Profile> findProfiles(int loyaltyPoints);
}
