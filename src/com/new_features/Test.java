package com.new_features;

public interface Test {
    default void test(){
        System.out.println("我是test方法默认实现");
        this.inner();   //接口中方法的默认实现可以直接调用接口中的私有方法
    }
    
    private void inner(){   //声明一个私有方法
        System.out.println("我是接口中的私有方法！");
    }
}
