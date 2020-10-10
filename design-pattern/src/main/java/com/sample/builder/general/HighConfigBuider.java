package com.sample.builder.general;

/**
 * 高配版的电脑
 *
 * @author zhengy
 * @date 20/10/10下午9:23
 */
public class HighConfigBuider implements ComputerConfigBuilder {

    private Computer mComputer;

    public HighConfigBuider() {
        this.mComputer = new Computer();
    }

    @Override
    public void setCPU() {
        mComputer.setCPU("i7");
    }

    @Override
    public void setMemery() {
        mComputer.setMemory("16G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("1T");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("机械键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("无线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}