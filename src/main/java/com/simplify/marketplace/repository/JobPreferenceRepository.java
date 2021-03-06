package com.simplify.marketplace.repository;

import com.simplify.marketplace.domain.JobPreference;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the JobPreference entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobPreferenceRepository extends JpaRepository<JobPreference, Long> {}
