package com.inclusion.accessibility.service;

import com.inclusion.accessibility.wcag.Rule;
import com.inclusion.accessibility.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {
    private final RuleRepository ruleRepository;

    @Autowired
    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public Optional<Rule> getRuleById(Long id) {
        return ruleRepository.findById(id);
    }

    public Rule saveRule(Rule task) {
        return ruleRepository.save(task);
    }

    public void deleteRuleById(Long id) {
        ruleRepository.deleteById(id);
    }
}
