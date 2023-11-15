package domain.classes;

import domain.enums.AmdGPUSeries;
import jakarta.persistence.Entity;

@Entity
public class AmdGPU extends GPU{

    private AmdGPUSeries amdGPUSeries;


    public AmdGPUSeries getAmdGPUSeries() {
        return amdGPUSeries;
    }

    public void setAmdGPUSeries(AmdGPUSeries amdGPUSeries) {
        this.amdGPUSeries = amdGPUSeries;
    }
}
