package com.campuscollab.api.repository;

import com.campuscollab.api.model.SkillPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillPostRepository extends JpaRepository<SkillPost, Long> {
}
