package gabrielemarchione.entities;

import jakarta.persistence.*;

@Entity

public class Magazine extends Item {

    private String periodicity;

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
}

