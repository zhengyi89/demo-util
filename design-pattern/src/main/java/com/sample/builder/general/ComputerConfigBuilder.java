package com.sample.builder.general;

/**
 * 抽象的电脑组装过程的Builder类
 *
 * @author zhengy
 * @date 20/10/10下午9:21
 */
public interface ComputerConfigBuilder {
    void setCPU();

    void setMemery();

    void setHardDisk();

    void setKeyboard();

    void setMouse();

    Computer getComputer();
}