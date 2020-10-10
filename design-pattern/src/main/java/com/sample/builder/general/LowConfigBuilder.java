package com.sample.builder.general;

/**
 * 低配版的电脑
 *
 * @author zhengy
 * @date 20/10/10下午9:22
 */
public class LowConfigBuilder implements ComputerConfigBuilder {

    private Computer mComputer;

    public LowConfigBuilder() {
        this.mComputer = new Computer();
    }

    @Override
    public void setCPU() {
        mComputer.setCPU("i5");
    }

    @Override
    public void setMemery() {
        mComputer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}