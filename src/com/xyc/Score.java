package com.xyc;

public class Score<E,S,T> { //T相当于 待定的类型参数
    E name;
    S id;
    //Object value;  //因为Object是所有类型的父类，因此既可以存放Integer也能存放String
    T value;
    //T会根据使用时提供的类型自动变成对应类型

    //这里T可以是任何类型，但是一旦确定，那么就不能修改了
  	public Score(E name, S id, T value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }
}

