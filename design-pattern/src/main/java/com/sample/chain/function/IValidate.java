package com.sample.chain.function;

public interface IValidate<IN1, IN2> {
    void validate(IN1 req1, IN2 req2) throws RuntimeException;
}
