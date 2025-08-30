package app.domain.model;

import java.util.List;

public class SpecialistInventory {
    private Long id;
    private List<Specialist> specialists;

    // Getters
    public Long getId() {
        return id;
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }
}



