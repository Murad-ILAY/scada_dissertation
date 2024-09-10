package az.spring.demo.scada.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;
    private int registerAddress;
    private int registerValue;
    private int bitAddress;
    private boolean highAlarm;

    public Device(String tagName, int registeAddress, int registerValue, int bitAddress, boolean b) {
        this.tagName = tagName;
        this.registerAddress = registeAddress;
        this.registerValue = registerValue;
        this.bitAddress = bitAddress;
        this.highAlarm = b;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(int registerAddress) {
        this.registerAddress = registerAddress;
    }

    public int getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(int registerValue) {
        this.registerValue = registerValue;
    }

    public int getBitAddress() {
        return bitAddress;
    }

    public void setBitAddress(int bitAddress) {
        this.bitAddress = bitAddress;
    }

    public boolean isHighAlarm() {
        return highAlarm;
    }

    public void setHighAlarm(boolean highAlarm) {
        this.highAlarm = highAlarm;
    }
}
