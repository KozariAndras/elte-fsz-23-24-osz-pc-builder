package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.components.*;
import elte.project.pcbuilder.domain.enums.*;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.CredentialRepository;
import elte.project.pcbuilder.repository.PCComponentRepository;
import elte.project.pcbuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class TestDataGenerator {
    @Autowired
    private PCComponentRepository pcComponentRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    @Transactional
    public void createTestTable(){
        createGPUs();
        createCPUs();
        createCases();
        createMotherboards();
        createPSUs();
        createRAMs();
        createStorages();
        createCPUCoolers();
        createUsers();
    }

    private void createMotherboards() {
        pcComponentRepository.save(create("Asus","ASUS TUF GAMING B550M-PLUS",new BigDecimal(44000)
                ,"B550M",SizeType.ATX,RamSocketType.DDR4,CPUSocket.AM4));
        pcComponentRepository.save(create("MSI","MSI MAG B650 Tomahawk WIFI",new BigDecimal(82000)
                ,"B650",SizeType.ATX,RamSocketType.DDR5,CPUSocket.AM5));
        pcComponentRepository.save(create("Asus","ASUS TUF GAMING B760M-PLUS WIFI",new BigDecimal(58000)
                ,"B760M",SizeType.EATX,RamSocketType.DDR4,CPUSocket.LGA1700));
        pcComponentRepository.save(create("Asus","ASUS TUF GAMING Z690-PLUS",new BigDecimal(154000)
                ,"Z690",SizeType.ATX,RamSocketType.DDR5,CPUSocket.LGA1700));
    }

    private void createPSUs() {
        pcComponentRepository.save(create("Asus","Asus ROG Strix 850W Gold",new BigDecimal(55000),"GOLD",850));
        pcComponentRepository.save(create("Seasonic","Seasonic FOCUS GX-850W Gold",new BigDecimal(70000),"GOLD",850));
        pcComponentRepository.save(create("FSP","FSP Hydro K PRO 600W 80Plus Bronze",new BigDecimal(22000),"BRONZE",600));
    }

    private void createRAMs() {
        pcComponentRepository.save(create("Kingston","Kingston FURY Beast 16GB (2x8GB) DDR4 3200MHz",new BigDecimal(16000)
                ,"CL16",3200,16,RamSocketType.DDR4));
        pcComponentRepository.save(create("G.SKILL","Trident Z5 Neo RGB 32GB (2x16GB) DDR5 6000MHz",new BigDecimal(56000)
                ,"CL30",6000,32,RamSocketType.DDR5));
        pcComponentRepository.save(create("Kingston","Kingston FURY Renegade 32GB (2x16GB) DDR5 6000MHz",new BigDecimal(52000)
                ,"CL32",6000,32,RamSocketType.DDR5));
    }

    private void createStorages() {
        pcComponentRepository.save(create("Samsung","Samsung 980 1TB M.2 PCIe",new BigDecimal(28000)
                ,1000,3000,3500,StorageType.SSD));
        pcComponentRepository.save(create("Kingston","Kingston KC3000 1TB M 2 NVMe PCIe",new BigDecimal(26000)
                ,1000,6000,7000,StorageType.SSD));
        pcComponentRepository.save(create("Western Digital","Western Digital WD Red 3.5 4TB 5400rpm 256MB SATA3",new BigDecimal(41000)
                ,4000,750,750,StorageType.HDD));
    }

    private void createCases() {
        pcComponentRepository.save(create("NZXT","NZXT H7 Flow CM-H71FG",new BigDecimal(44000),SizeType.ATX));
        pcComponentRepository.save(create("Zalman","Zalman I3 Neo",new BigDecimal(19000),SizeType.EATX));
        pcComponentRepository.save(create("be quiet!","be quiet! Pure Base 500DX",new BigDecimal(40000),SizeType.ATX));
    }

    private void createCPUCoolers() {
        pcComponentRepository.save(create("ARCTIC","ARCTIC Liquid Freezer 360 II A-RGB",new BigDecimal(52000)
                ,23,120,1800,CoolerType.WATER));
        pcComponentRepository.save(create("Noctua","Noctua NH-D15",new BigDecimal(57000)
                ,25,140,1500,CoolerType.AIR));
        pcComponentRepository.save(create("Deepcool","Deepcool AK620",new BigDecimal(24600)
                ,28,120,1500,CoolerType.AIR));
    }

    private void createCPUs() {
        pcComponentRepository.save(create("AMD","AMD Ryzen 7 5800X3D 8-Core 3.4GHz"
                ,CPUType.AMD,8,16,3400,4500,CPUSocket.AM4,new BigDecimal(125000)));
        pcComponentRepository.save(create("AMD","AMD Ryzen 7 7800X3D 4.4GHz 8-Cores"
                ,CPUType.AMD,8,16,4200,5000,CPUSocket.AM5,new BigDecimal(160000)));
        pcComponentRepository.save(create("AMD","AMD Ryzen 7 5700X 8-Core 3.4 GHz"
                ,CPUType.AMD,8,16,3400,4600,CPUSocket.AM4,new BigDecimal(75000)));
        pcComponentRepository.save(create("Intel","Intel i5-12400F 6-Core 2.50GHz"
                ,CPUType.INTEL,6,12,2500,4400,CPUSocket.LGA1700,new BigDecimal(60000)));
        pcComponentRepository.save(create("Intel","Intel Core i7-14700K 3.4GHz"
                ,CPUType.INTEL,20,28,2500,5600,CPUSocket.LGA1700,new BigDecimal(180000)));
        pcComponentRepository.save(create("Intel","Intel Core i5-13600K 3.5GHz 14-Core"
                ,CPUType.INTEL,14,20,2600,5100,CPUSocket.LGA1700,new BigDecimal(135000)));
    }

    private void createGPUs() {
        pcComponentRepository.save(create("Sapphire","SAPPHIRE PULSE AMD Radeon RX 6700 XT 12GB GDDR6 192bit",
                GPUSeries.RX6000,12,2622,new BigDecimal(140000),GPUType.AMD));
        pcComponentRepository.save(create("Sapphire","SAPPHIRE Radeon RX 7800 XT NITRO 16G GDDR6",
                GPUSeries.RX7000,16,2565,new BigDecimal(250000),GPUType.AMD));
        pcComponentRepository.save(create("Gigabyte","GIGABYTE Radeon RX 7800 XT GAMING OC 16G",
                GPUSeries.RX7000,16,2565,new BigDecimal(245000),GPUType.AMD));
        pcComponentRepository.save(create("Asus","ASUS Dual GeForce RTX 4060 OC 8GB GDDR6",
                GPUSeries.RTX40,8,2535,new BigDecimal(140000),GPUType.NVIDIA));
        pcComponentRepository.save(create("Gigabyte","GIGABYTE GeForce RTX 4070 WINDFORCE 12G GDDR6X OC",
                GPUSeries.RTX40,12,2490,new BigDecimal(300000),GPUType.NVIDIA));
        pcComponentRepository.save(create("ZOTAC","GeForce Twin Edge RTX 3070 8GB GDDR6 256bit",
                GPUSeries.RTX30,8,1725,new BigDecimal(180000),GPUType.NVIDIA));
    }

    private GPU create(String brand, String name, GPUSeries gpuSeries, int memorySize, int clockSpeed, BigDecimal price, GPUType gpuType) {
        return new GPU(name, brand, price, clockSpeed, memorySize, gpuType, gpuSeries);
    }
    private CPU create(String brand, String name, CPUType cpuType, int cores, int threads, int coreSpeed, int maxCoreSpeed, CPUSocket cpuSocket,BigDecimal price){
        return new CPU(name, brand, price, cores, threads, coreSpeed, maxCoreSpeed, cpuSocket, cpuType);
    }
    private CPUCooler create(String brand, String name, BigDecimal price, int noise, int radius,int speed,CoolerType coolerType){
        return new CPUCooler(name,brand,price,noise,radius,speed,coolerType);
    }
    private PCCase create(String brand, String name, BigDecimal price, SizeType sizeType){
        return new PCCase(brand,name,price,sizeType);
    }
    private Motherboard create(String brand,String name,BigDecimal price,String chipset,SizeType size,RamSocketType ramSocket,CPUSocket cpuSocket){
        return new Motherboard(name,brand,price,chipset,size,ramSocket,cpuSocket);
    }
    private PSU create(String brand,String name,BigDecimal price,String rating,int performance){
        return new PSU(name, brand, price, rating, performance);
    }
    private RAM create(String brand,String name,BigDecimal price,String timings,int speed,int size,RamSocketType ramSocketType){
        return new RAM(name, brand, price, timings, speed, size, ramSocketType);
    }
    private Storage create(String brand,String name,BigDecimal price,int size,int writingSpeed,int readingSpeed,StorageType storageType){
        return new Storage(name, brand, price, size, writingSpeed, readingSpeed, storageType);
    }
    private void createUsers(){
        User user = new User();
        Credential credential = new Credential();
        credential.setUsername("admin");
        credential.setPassword("admin");
        credential.setUser(user);
        user.setCredential(credential);
        user.setRole(Role.ADMIN);
        user.setOrders(new ArrayList<>());
        credentialRepository.save(credential);
        userRepository.save(user);

        user = new User();
        credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("user12345");
        credential.setUser(user);
        user.setCredential(credential);
        user.setRole(Role.USER);
        user.setOrders(new ArrayList<>());
        credentialRepository.save(credential);
        userRepository.save(user);

    }





}
