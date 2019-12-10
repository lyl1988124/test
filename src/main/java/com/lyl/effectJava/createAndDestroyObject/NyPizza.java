package com.lyl.effectJava.createAndDestroyObject;

import java.util.Objects;

/**
 * Created by lyl
 * Date 2019/12/9 21:44
 */
public class NyPizza extends Pizza {
    public enum Size{SMALL,MEDIUM,LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{

        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public NyPizza(NyPizza.Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
