package com.inclusion.accessibility.controller;

import com.inclusion.accessibility.wcag.Rule;
import com.inclusion.accessibility.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @GetMapping
    public List<Rule> getAllRules() {
        return ruleService.getAllRules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rule> getRuleById(@PathVariable Long id) {
        Optional<Rule> rule = ruleService.getRuleById(id);
        if (rule.isPresent()) {
            return ResponseEntity.ok(rule.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        return ResponseEntity.ok(ruleService.saveRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rule> updateRule(@PathVariable Long id, @RequestBody Rule rule) {
        Optional<Rule> ruleOptional = ruleService.getRuleById(id);
        if (ruleOptional.isPresent()) {
            Rule updatedRule = ruleOptional.get();
            updatedRule.setDescription(rule.getDescription());
            updatedRule.setDueDate(rule.getDueDate());
            updatedRule.setCompleted(rule.getCompleted());
            updatedRule.setName(rule.getName());
            return ResponseEntity.ok(ruleService.saveRule(updatedRule));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rule> deleteRule(@PathVariable Long id) {
        ruleService.deleteRuleById(id);
        return ResponseEntity.noContent().build();
    }
}
