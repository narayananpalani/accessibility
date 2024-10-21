package com.inclusion.accessibility.repository;

import com.inclusion.accessibility.wcag.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}
