package com.inclusion.accessibility.wcag;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rule> rules;

    public void addRule(Rule rule) {
        rules.add(rule);
        rule.setProject(this);
    }

    public void removeRule(Rule rule) {
        rules.remove(rule);
        rule.setProject(null);
    }
}
