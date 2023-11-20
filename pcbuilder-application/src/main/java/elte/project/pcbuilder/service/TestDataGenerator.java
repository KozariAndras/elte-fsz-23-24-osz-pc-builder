package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.GPU;
import elte.project.pcbuilder.domain.enums.GPUSeries;
import elte.project.pcbuilder.domain.enums.GPUType;
import elte.project.pcbuilder.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class TestDataGenerator {
    @Autowired
    private PCComponentRepository pcComponentRepository;

    @Transactional
    public void createTestTable(){
        createGPUs();
    }

    private void createGPUs() {
        pcComponentRepository.save(createGPU("Sapphire","SAPPHIRE PULSE AMD Radeon RX 6700 XT 12GB GDDR6 192bit",
                GPUSeries.RX6000,12,2622,new BigDecimal(140000),GPUType.AMD));
        pcComponentRepository.save(createGPU("Sapphire","SAPPHIRE Radeon RX 7800 XT NITRO 16G GDDR6",
                GPUSeries.RX7000,16,2565,new BigDecimal(250000),GPUType.AMD));
        pcComponentRepository.save(createGPU("Gigabyte","GIGABYTE Radeon RX 7800 XT GAMING OC 16G",
                GPUSeries.RX7000,16,2565,new BigDecimal(245000),GPUType.AMD));
        pcComponentRepository.save(createGPU("Asus","ASUS Dual GeForce RTX 4060 OC 8GB GDDR6",
                GPUSeries.RTX40,8,2535,new BigDecimal(140000),GPUType.NVIDIA));
        pcComponentRepository.save(createGPU("Gigabyte","GIGABYTE GeForce RTX 4070 WINDFORCE 12G GDDR6X OC",
                GPUSeries.RTX40,12,2490,new BigDecimal(300000),GPUType.NVIDIA));
        pcComponentRepository.save(createGPU("ZOTAC","GeForce Twin Edge RTX 3070 8GB GDDR6 256bit",
                GPUSeries.RTX30,8,1725,new BigDecimal(180000),GPUType.NVIDIA));
    }

    private GPU createGPU(String brand, String name,GPUSeries gpuSeries, int memorySize, int clockSpeed, BigDecimal price, GPUType gpuType) {
        GPU gpu = new GPU();
        gpu.setName(name);
        gpu.setBrand(brand);
        gpu.setGpuType(gpuType);
        gpu.setGpuSeries(gpuSeries);
        gpu.setClockSpeed(clockSpeed);
        gpu.setMemorySize(memorySize);
        gpu.setPrice(price);
        return gpu;
    }


}
