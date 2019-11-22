package com.recipes.api.recipeapi.utilities;

public class KeyValuePair<T,U> {

    private T _keyObject;
    private U _valueObject;

    public KeyValuePair(T keyObj, U valueObj){
        _keyObject = keyObj;
        _valueObject = valueObj;
    }

    public T getKey(){
        return _keyObject;
    }

    public U getValue() {
        return _valueObject;
    }

    public void setKey(T newKey){
        _keyObject = newKey;
    }

    public void setValue(U newValue){
        _valueObject = newValue;
    }

}
