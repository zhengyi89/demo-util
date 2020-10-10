package com.sample.builder.general;

/**
 * 装机人员Director
 *
 * @author zhengy
 * @date 20/10/10下午9:25
 */
public class Director {
    private ComputerConfigBuilder mBuilder;

    public void setBuilder(ComputerConfigBuilder builder) {
        this.mBuilder = builder;
    }

    public void createComputer() {
        mBuilder.setCPU();
        mBuilder.setMemery();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }

    public Computer getComputer() {
        return mBuilder.getComputer();
    }
}